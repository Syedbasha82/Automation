package bg.framework.common.functional;

import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.util.Report;

import org.testng.IInvokedMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.internal.Utils;

import java.util.List;

public class CustomTestListener extends TestListenerAdapter {


    private static final String TEST_OUTPUT_DIR = ApplicationConfig.getConfigValue("test.report.dir");

    public void afterInvocation(IInvokedMethod method, ITestResult result) {

        Reporter.setCurrentTestResult(result);

        if (method.isTestMethod()) {

            List<Throwable> verificationFailures = Verify.getVerificationFailures();

            //if there are verification failures...
            if (verificationFailures.size() > 0) {

                //set the test to failed
                result.setStatus(ITestResult.FAILURE);
                System.out.println(result.getThrowable()+"\n\n\n.....");
                Report.updateTestLog("Exception form Test Listener:", "FAIL");
                //if there is an assertion failure add it to verificationFailures
                if (result.getThrowable() != null) {
                    verificationFailures.add(result.getThrowable());
                    
                }

                int size = verificationFailures.size();
                //if there's only one failure just set that
                if (size == 1) {
                    result.setThrowable(verificationFailures.get(0));
                } else {
                    //create a failure message with all failures and stack traces (except last failure)
                    StringBuffer failureMessage = new StringBuffer("Multiple failures (").append(size).append("):\n\n");
                    for (int i = 0; i < size - 1; i++) {
                        failureMessage.append("Failure ").append(i + 1).append(" of ").append(size).append(":\n");
                        Throwable t = verificationFailures.get(i);
                        String fullStackTrace = Utils.stackTrace(t, false)[1];
                        failureMessage.append(fullStackTrace).append("\n\n");
                    }

                    //final failure
                    Throwable last = verificationFailures.get(size - 1);
                    failureMessage.append("Failure ").append(size).append(" of ").append(size).append(":\n");
                    failureMessage.append(last.toString());

                    //set merged throwable
                    Throwable merged = new Throwable(failureMessage.toString());
                    merged.setStackTrace(last.getStackTrace());

                    result.setThrowable(merged);
                }
            }
        }
    }

    public void onTestFailure(org.testng.ITestResult tr) {
        UIDriver uiDriver = WebDriverProvider.getCurrentDriver();
        UIOperation browser = new UIOperation(uiDriver);
        browser.captureScreen("../BGFunctional/" + TEST_OUTPUT_DIR + "/error-screens/" + tr.getTestClass().getName() + "." + tr.getName() + ".jpg");
        Report.updateTestLog("Caught unhandled Exception: "+tr.getThrowable()+". while Executing Method: "+tr.getMethod(), "FAIL");
    }

}
