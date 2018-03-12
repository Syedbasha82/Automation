package bg.framework.app.functional.util;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.ProxyHTTP;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

public class Tunnel {
    public static void main(String[] args) {
        Tunnel t = new Tunnel();

        try {
            t.go();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void go() throws Exception {
        String host = "193.67.162.87";
        String user = "coguser";
        String password = "coguser";
        int port = 22;
        int tunnelLocalPort = 1525;
        String tunnelRemoteHost = "10.114.69.16";
        int tunnelRemotePort = 1525;
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, port);
        session.setPassword(password);
        localUserInfo lui = new localUserInfo();
        session.setUserInfo(lui);
        session.setProxy(getProxy());
        session.connect();
        session.setPortForwardingL(tunnelLocalPort, tunnelRemoteHost, tunnelRemotePort);
        System.out.println("Connected");
    }

    class localUserInfo implements UserInfo {
        String passwd;

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

    public ProxyHTTP getProxy() {
        ProxyHTTP proxy = new ProxyHTTP("proxy.uk.centricaplc.com", 80);
        proxy.setUserPasswd("jithendb", "keeran35");
        return proxy;
    }
}

