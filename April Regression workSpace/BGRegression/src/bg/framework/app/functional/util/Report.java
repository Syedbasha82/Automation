package bg.framework.app.functional.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import watij.runtime.ie.IE;
import bg.framework.app.functional.common.ApplicationConfig;
import bg.framework.app.functional.page.common.BasePage;
import bg.framework.common.functional.UIDriver;
import bg.framework.common.functional.UIOperation;
import bg.framework.common.functional.WebDriverProvider;

public class Report extends BasePage {

    public static String logPath;
    static int StepName;
    static String LogFileName;
    static String startDate;
    static String LogScreenShotFolder;
    static String summaryPath;
    static String strScenario;
    static String strtestCase;
    static boolean blnFailFlag;
    public static int intFailCount = 0;
    public static int intPassCount = 0;

    public static void createTestLogPath() {
        logPath = System.getProperty("user.dir");
        //logPath = "c:\\Workspace\\BGRegression";
        DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss");
        DateFormat dateFormat = new SimpleDateFormat("dMMMyyyyHHmmss");
        Date date = new Date();
        startDate = dateFormat2.format(date);
        logPath = logPath + "\\Results\\" + dateFormat.format(date);
        LogScreenShotFolder = logPath + "\\" + "Screenshots";
        summaryPath = logPath + "\\" + "Summary.html";
        new File(logPath).mkdir();
        new File(LogScreenShotFolder).mkdir();
        createSummaryHeader(summaryPath);
    }

    public static void createTestLogHeader(String Scenario, String testCase) {
        StepName = 1;
        strScenario = Scenario;
        strtestCase = testCase;
        blnFailFlag = false;
        DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss");
        DateFormat dateFormat = new SimpleDateFormat("d MMM yyyy HH.mm.ss");
        Date date = new Date();
        startDate = dateFormat2.format(date);
        String projectName = "Online";
        String iterationMode = "Run one";
        String reportName = "Selenium test run results";
        String headingColor = "#003366";
        String settingColor = "#003366";
        String bodyColor = "#CCCCCC";
        LogFileName = logPath + "\\" + Scenario + "_" + testCase + ".html";
        File testLogFile = new File(LogFileName);
        try {
            testLogFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream outputStream = null;
        PrintStream printStream = null;
        try {
            outputStream = new FileOutputStream(testLogFile);
            printStream = new PrintStream(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        String testLogHeader;
        testLogHeader = "<html>" +
                "<head>" +
                "<title>" +
                projectName + " - " + reportName +
                "</title>" +
                "</head>" +
                "<body>" +
                "<p align='center'>" +
                "<table border='1' bordercolor='#000000' bordercolorlight='#FFFFFF' cellspacing='0' id='table1' width='1200' height='100'>" +
                "<tr bgcolor='" + headingColor + "'>" +
                "<td colspan='5'>" +
                "<p align='center'><font color='" + bodyColor + "' size='4' face='Copperplate Gothic Bold'>" +
                projectName + " - " + reportName +
                "</font></p>" +
                "</td>" +
                "</tr>" +
                "<tr bgcolor='" + settingColor + "'>" +
                "<td colspan='3'>" +
                "<p align='justify'><b><font color='" + "#FFFFFF" + "' size='2' face='Verdana'>" +
                "DATE: " + dateFormat.format(date) + "		Iteration Mode: " + iterationMode +
                "</p></font></b>" +
                "</td>" +
                "<td colspan='2'>" +
                "<p align='justify'><b><font color='" + "#FFFFFF" + "' size='2' face='Verdana'>" +
                "Scenario: " + Scenario + "      " + "		Testcase: " + testCase +
                "</p></font></b>" +
                "</td>" +
                "</tr>" +
                "<tr bgcolor='" + settingColor + "'>" +
                "<td colspan='3'>" +
                "<p align='justify'><b><font color='" + "#FFFFFF" + "' size='2' face='Verdana'>" +
                "Start Iteration: " + "1" +
                "</p></font></b>" +
                "</td>" +
                "<td colspan='2'>" +
                "<p align='justify'><b><font color='" + "#FFFFFF" + "' size='2' face='Verdana'>" +
                "End Iteration: " + "1" +
                "</p></font></b>" +
                "</td>" +
                "</tr>" +
                "<tr bgcolor='" + headingColor + "'>" +
                "<td><b><font color='" + bodyColor + "' size='2' face='Verdana'>Step Name</font></b></td>" +
                "<td><b><font color='" + bodyColor + "' size='2' face='Verdana'>Description</font></b></td>" +
                "<td><b><font color='" + bodyColor + "' size='2' face='Verdana'>Status</font></b></td>" +
                "<td><b><font color='" + bodyColor + "' size='2' face='Verdana'>Time</font></b></td>" +
                "</tr>";
        printStream.println(testLogHeader);
        printStream.close();
    }

    public static void updateTestLog(String stepDescription, String stepStatus) {
        Boolean takeScreenshotFailedStep = true;
        Boolean takeScreenshotPassedStep = false;
        String stepName = Integer.toString(getStepName());
        String bodyColor = "#CCCCCC";
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getLogFileName(), true));
            String testStepRow = "<tr bgcolor='" + bodyColor + "'>" +
                    "<td>" + "Step " + stepName + "</td>" +
                    "<td>" + stepDescription + "</td>";
            if (stepStatus.toUpperCase().equals("FAIL")) {
                if (takeScreenshotFailedStep) {
                    blnFailFlag = true;
                    String path = takeScreenshot(getLogFileName(), stepName);
                    testStepRow += "<td>" +
                            "<a href='Screenshots\\" + path + "' target='about_blank'>" +
                            "<font color='red'><b>" + stepStatus.toUpperCase() + "</b></font>" +
                            "</a>" +
                            "</td>";
                    intFailCount = 1 + intFailCount;
                } else {
                    testStepRow += "<td>" +
                            "<font color='red'><b>" + stepStatus.toUpperCase() + "</b></font>" +
                            "</td>";
                    intFailCount = 1 + intFailCount;
                }
                System.out.println("The tests failed");
            } else if (stepStatus.toUpperCase().equals("PASS")) {
                if (takeScreenshotPassedStep) {
                    testStepRow += "<td>" +
                            "<a href='..\\Screenshots\\" + "" + "' target='about_blank'>" +
                            "<font color='green'><b>" + stepStatus.toUpperCase() + "</b></font>" +
                            "</a>" +
                            "</td>";
                    intPassCount = 1 + intPassCount;
                } else {
                    testStepRow += "<td>" +
                            "<font color='green'><b>" + stepStatus.toUpperCase() + "</b></font>" +
                            "<b>" +
                            "</td>";
                    intPassCount = 1 + intPassCount;
                }
            }else if (stepStatus.toUpperCase().equals("WARN")) {
                if (takeScreenshotFailedStep) {
                    String path = takeScreenshot(getLogFileName(), stepName);
                    testStepRow += "<td>" +
                            "<a href='Screenshots\\" + path + "' target='about_blank'>" +
                            "<font color='amber'><b>" + stepStatus.toUpperCase() + "</b></font>" +
                            "</a>" +
                            "</td>";
                    intPassCount = 1 + intPassCount;
                } else {
                    testStepRow += "<td>" +
                            "<font color='green'><b>" + stepStatus.toUpperCase() + "</b></font>" +
                            "<b>" +
                            "</td>";
                    intPassCount = 1 + intPassCount;
                }
            } else if (stepStatus.toUpperCase().equals("DONE")) {
                testStepRow += "<td>" +
                        "<font color='blue'><b>" + stepStatus.toUpperCase() + "</b></font>" +
                        "<b>" +
                        "</td>";
            } else {
                testStepRow += "<td>" +
                        "<b>" + stepStatus.toUpperCase() + "</b>" +
                        "</td>";
            }

            testStepRow += "<td>" +
                    dateFormat.format(date) +
                    "</td>" +
                    "</tr>";
            bufferedWriter.write(testStepRow);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setStepName();
    }

    private static void createSummaryHeader(String summaryPath) {
        File testSummaryFile = new File(summaryPath);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();
        try {
            testSummaryFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            //throw new CraftException("Error while creating HTML test log file");
        }
        FileOutputStream outputStream = null;
        PrintStream printStream = null;
        try {
            outputStream = new FileOutputStream(testSummaryFile);
            printStream = new PrintStream(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        String headingColor = "#003366";
        String settingColor = "#003366";
        String bodyColor = "#CCCCCC";

        String testLogHeader;
        testLogHeader = "<html>\n" +
                "<head>\n" +
                "<title> Automation Execution Results</title>\n" +
                "</head>\n" +
                "<body>" +
                "<p align = center>" +
                "<table border=1 bordercolor=#000000 id=table1 width=900 height=31 cellspacing=0 bordercolorlight=#FFFFFF>\n" +
                "<tr>\n" +
                "<tr bgcolor='" + headingColor + "'>" +
                "<td COLSPAN = '6'>" +
                "<p align=center><font color=#CCCCCC size=4 face= \"Copperplate Gothic Bold\">&nbsp;Automation Execution Results - Online Application</font><font face= \"Copperplate Gothic Bold\"></font> </p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td COLSPAN = 6 bgcolor =#003366>\n" +
                "<p align=center><font color=#CCCCCC=1 face= Verdana>&nbsp;Date: " + date + "</font><font face= \"Copperplate Gothic Bold\"></font> </p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr bgcolor=#003366>\n" +
                "<td width=600\n" +
                "<p align=center><b><font color = white face=Arial Narrow size=2>Scenario</b>\n" +
                "</td>\n" +
                "<td width=600\n" +
                "<p align=center><b><font color = white face=Arial Narrow size=2>Test Case Name</b>\n" +
                "</td>\n" +
                "<td width=400\n" +
                "<p align=center><b><font color = white face=Arial Narrow size=2>Status</b>\n" +
                "</td>\n" +
                "</tr>\n";

        printStream.println(testLogHeader);
        printStream.close();

    }

    private static void updateTestSummary() {
        boolean ResultStatus = blnFailFlag;
        String testStepRow = "";

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(summaryPath, true));
            if (ResultStatus == true) {
                testStepRow = "<tr bgcolor = #D9D9D9>\n" +
                        "<td width=600>\n" +
                        "<p align=center><font face=Verdana size=2>" + strScenario + "\n" +
                        "</td>\n" +
                        "<td width=600>\n" +
                        "<p align=center><a href=\'" + strScenario + "_" + strtestCase + ".html\'target=about_blank><b><font face=verdanasize=2>" + strtestCase + "</font></b></a></p>\n" +
                        "</td>\n" +

                        "<td width=400>\n" +
                        "<p align=center><b><font face=Verdana size=2 color=red>Fail</font></b>\n" +
                        "</td>\n" +
                        "</tr>\n";


            } else if (ResultStatus == false) {
                testStepRow = "<tr bgcolor = #D9D9D9>\n" +
                        "<td width=600>\n" +
                        "<p align=center><font face=Verdana size=2>" + strScenario + "\n" +
                        "</td>\n" +
                        "<td width=600>\n" +
                        "<p align=center><a href=\'" + strScenario + "_" + strtestCase + ".html\'target=about_blank><b><font face=verdanasize=2>" + strtestCase + "</font></b></a></p>\n" +
                        "</td>\n" +
                        "<td width=400>\n" +
                        "<p align=center><b><font face=Verdana size=2 color=#008000>Pass</font></b>\n" +
                        "</td>\n" +
                        "</tr>\n";
            }
            bufferedWriter.write(testStepRow);
            bufferedWriter.close();
            strScenario = "";
            strtestCase = "";
            blnFailFlag = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateFile(String path, String text) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));
            bufferedWriter.write(text + "\r\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void verificationPointCounts() {
        System.out.println("Number of Checkpoints Passed : " + intPassCount);
        System.out.println("Number of Checkpoints Failed : " + intFailCount);
        int intTotalChecks = intPassCount + intFailCount;
        System.out.println("Total Number of Checkpoints  : " + intTotalChecks);
    }

    public static void finalWrapUp() {
        int intTotalChecks = intPassCount + intFailCount;
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getLogFileName(), true));
            String testStepRow = "<table border=1 bordercolor=#000000 id=table1 width=1200 height=35 cellspacing=0 bordercolorlight=#FFFFFF>\n" +
                    "<tr bgcolor =#A6A6A6>\n" +
                    "<td colspan =1>\n" +
                    "<p align=justify><b><font color='black'  size=2 face= Verdana>&nbsp;No. Of Verification Points :&nbsp;&nbsp;" + intTotalChecks +
                    "&nbsp;" + "</td>\n" +
                    "<td colspan =1>\n" +
                    "<p align=justify><b><font color='green'  size=2 face= Verdana>&nbsp;Passed :&nbsp;&nbsp;" + intPassCount + "&nbsp;" +
                    "</td>\n" +
                    "<td colspan =1>\n" +
                    "<p align=justify><b><font color='red'  size=2 face= Verdana>&nbsp;Failed :&nbsp;&nbsp;" + intFailCount + "&nbsp;" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</blockquote>\n" +
                    "</body>\n" +
                    "</html>";
            bufferedWriter.write(testStepRow);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateTestSummary();
    }

    public static String takeScreenshot(String screenShotPath, String stepName) {
/*        UIDriver uiDriver = WebDriverProvider.getCurrentDriver();
        UIOperation browser;
        browser = new UIOperation(uiDriver);
        System.out.println(stepName);
        screenShotPath = screenShotPath.replace(".html", stepName);
        screenShotPath = screenShotPath.concat(".png");
        browser.captureScreen(screenShotPath);
        return "file:///" + screenShotPath;*/
    	
    	
    	//added for watij
    	
    	screenShotPath = screenShotPath.replace(".html", stepName);

        screenShotPath = screenShotPath.concat(".png");

        String[] aScreenShotPath = screenShotPath.split("\\\\");
        String screenShotName = aScreenShotPath[aScreenShotPath.length - 1];
        String newScreenshotPath = "";
        for (int i = 0; i < aScreenShotPath.length - 1; i++) {
            if (i == 0) {
                newScreenshotPath = aScreenShotPath[i];
            } else {
                newScreenshotPath = newScreenshotPath + "\\\\" + aScreenShotPath[i];
            }
        }

        System.out.print("screenShotName : " + screenShotName);
        System.out.print("New Screenshot Path : " + newScreenshotPath + "\\Screenshots\\" + screenShotName);
    	if(ApplicationConfig.Application_MakeAPayment.equalsIgnoreCase("True"))
    	{
    		
    		try
    		{
    		IE ie = new IE();
    		
            ie.screenCapture(newScreenshotPath + "\\Screenshots\\" + screenShotName);
            //return screenShotName;    		
    		}
    		catch(Exception ex)
    		{
    		  ex.printStackTrace();
    		}
    	}
    	else
    	{
    		
    		// end of added code for watij
    		
    		
        UIDriver uiDriver = WebDriverProvider.getCurrentDriver();
        UIOperation browser;
        browser = new UIOperation(uiDriver);
        /*System.out.println(stepName);
        System.out.println(screenShotPath);
        screenShotPath = screenShotPath.replace(".html", stepName);

        screenShotPath = screenShotPath.concat(".png");

        String[] aScreenShotPath = screenShotPath.split("\\\\");
        String screenShotName = aScreenShotPath[aScreenShotPath.length - 1];
        String newScreenshotPath = "";
        for (int i = 0; i < aScreenShotPath.length - 1; i++) {
            if (i == 0) {
                newScreenshotPath = aScreenShotPath[i];
            } else {
                newScreenshotPath = newScreenshotPath + "\\\\" + aScreenShotPath[i];
            }
        }

        System.out.print("screenShotName : " + screenShotName);
        System.out.print("New Screenshot Path : " + newScreenshotPath + "\\Screenshots\\" + screenShotName);*/
        browser.captureScreen(newScreenshotPath + "\\Screenshots\\" + screenShotName);
        
    	}
    	return screenShotName;
    }

    private static int getStepName() {
        return StepName;
    }

    private static void setStepName() {
        StepName = StepName + 1;
    }

    private static String getLogPath() {
        return logPath;
    }

    private static String getLogFileName() {
        return LogFileName;
    }

    public static String createTxtFile(String fileName) {
        String path = getLogPath() + "\\" + fileName + ".txt";
        File testNotesFile = new File(path);
        try {
            testNotesFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}