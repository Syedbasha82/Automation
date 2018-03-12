package bg.framework.app.functional.util;

import bg.framework.app.functional.common.ApplicationConfig;
import com.jcraft.jsch.*;

import java.io.*;

public class ScpClient {
    private static final String user = "wl_fit";
    private static final String host = ApplicationConfig.SERVER_IP;
    private static final String passwd = "wl_fit";
    private static String prefix = null;
    private static FileOutputStream fos = null;
    private Session session;
    private Channel channel;

    public void getFile(String remotePath, String remoteFile, String localFile) {
        String lfile = "";
        if (localFile != "") {
            lfile = Report.logPath + "\\" + localFile;
        } else {
            lfile = Report.logPath + "\\" + remoteFile;
        }

        String rfile = remotePath + "/" + remoteFile;

        //System.out.println(rfile);
        //System.out.println(lfile);
        try {
            if (new File(lfile).isDirectory()) {
                prefix = lfile + File.separator;
            }
            JSch shell = new JSch();
            Session session = shell.getSession(user, host, 22);
            UserInfo ui = new MyUserInfo();
            session.setUserInfo(ui);
            session.connect();
            String command = "scp -f " + rfile;
            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);
            OutputStream out = channel.getOutputStream();
            InputStream in = channel.getInputStream();
            channel.connect();
            byte[] buf = new byte[1024];
            buf[0] = 0;
            out.write(buf, 0, 1);
            out.flush();
            while (true) {
                int c = checkAck(in);
                if (c != 'C') {
                    break;
                }
                in.read(buf, 0, 5);
                long filesize = 0L;
                while (true) {
                    if (in.read(buf, 0, 1) < 0) {
                        break;
                    }
                    if (buf[0] == ' ') break;
                    filesize = filesize * 10L + (long) (buf[0] - '0');
                }
                String file = null;
                for (int i = 0; ; i++) {
                    in.read(buf, i, 1);
                    if (buf[i] == (byte) 0x0a) {
                        file = new String(buf, 0, i);
                        break;
                    }
                }
                buf[0] = 0;
                out.write(buf, 0, 1);
                out.flush();
                fos = new FileOutputStream(prefix == null ? lfile : prefix + file);
                int foo;
                while (true) {
                    if (buf.length < filesize) foo = buf.length;
                    else foo = (int) filesize;
                    foo = in.read(buf, 0, foo);
                    if (foo < 0) {
                        break;
                    }
                    fos.write(buf, 0, foo);
                    filesize -= foo;
                    if (filesize == 0L) break;
                }
                fos.close();
                fos = null;
                if (checkAck(in) != 0) {
                    System.exit(0);
                }
                buf[0] = 0;
                out.write(buf, 0, 1);
                out.flush();
            }
            session.disconnect();
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            try {
                if (fos != null) fos.close();
            } catch (Exception ee) {
                e.printStackTrace();
            }
        }
    }


    static int checkAck(InputStream in) throws IOException {
        int b = in.read();
        if (b == 0) return b;
        if (b == -1) return b;
        if (b == 1 || b == 2) {
            StringBuffer sb = new StringBuffer();
            int c;
            do {
                c = in.read();
                sb.append((char) c);
            }
            while (c != '\n');
            if (b == 1) {
                System.out.print(sb.toString());
            }
            if (b == 2) {
                System.out.print(sb.toString());
            }
        }
        return b;
    }

    public static class MyUserInfo implements UserInfo {
        public String getPassword() {
            return passwd;
        }

        public boolean promptYesNo(String str) {
            return true;
        }

        public String getPassphrase() {
            return null;
        }

        public boolean promptPassphrase(String message) {
            return true;
        }

        public boolean promptPassword(String message) {
            return true;
        }

        public void showMessage(String message) {
        }
    }

    public boolean isConnected() {
        return (channel != null && channel.isConnected());
    }

    public void disconnect() {
        if (isConnected()) {
            channel.disconnect();
            session.disconnect();
        }
    }
}

