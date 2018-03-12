package bg.framework.app.functional.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: !jithendb
 * Date: 06/02/12
 * Time: 13:08
 * To change this template use File | Settings | File Templates.
 */
public class RunQTP {
    public void runQTP(String vbsFile, String bP_Org_Number) {
        try {
            Process p = Runtime.getRuntime().exec("cscript.exe //NoLogo ../" + vbsFile + " " + bP_Org_Number);
            p.waitFor();
            InputStream is = p.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            is.close();
            input.close();
        } catch (Exception i) {
            System.err.println("" + i.toString());
        }

    }
}
