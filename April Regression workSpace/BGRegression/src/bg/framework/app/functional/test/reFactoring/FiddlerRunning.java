package bg.framework.app.functional.test.reFactoring;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FiddlerRunning {
	
	
	public void runFiddlerAfter(String testCaseName) {
        try {
            ProcessBuilder pb = new ProcessBuilder("ExecAction.exe", "\"save " + testCaseName + ".zip\"");
            pb.directory(new File("D:\\Development_Avecto\\Fiddler"));
            File log = new File("log.txt");
            pb.redirectErrorStream(true);
            pb.redirectOutput(Redirect.appendTo(log));
            Process fiddlerProcess = pb.start();
            assert pb.redirectInput() == Redirect.PIPE;
            assert pb.redirectOutput().file() == log;
            assert fiddlerProcess.getInputStream().read() == -1;
            int returnStatus = fiddlerProcess.waitFor();
            if (returnStatus == 0) {
                System.out.println("Fiddler log dumped successfully");
            } else {
                System.out.println("There was some problem with fiddler");
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(FiddlerRunning.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
