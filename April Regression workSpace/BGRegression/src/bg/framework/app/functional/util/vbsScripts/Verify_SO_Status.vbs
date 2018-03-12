Dim AcNumber

Dim Test_path
Dim Project_path

ServiceOrderNumber= Wscript.Arguments.Item(0)

Dim qtApp 'As QuickTest.Application ' Declare the Application object variable

Dim qtResultsOpt 'QTP results Options

Dim qtTest 'As QuickTest.Test ' Declare a Test object variable

Dim objQtpParamDefns                'As QuickTest.ParameterDefinitions

Dim objQtpParams          'As QuickTest.Parameters

Dim objQtpParam            'As QuickTest.Parameter


Set qtApp = CreateObject("QuickTest.Application") ' Create the Application object

Set qtResultsOpt = CreateObject("QuickTest.RunResultsOptions")

qtApp.Launch ' Start QuickTest

qtApp.Visible = True ' Make the QuickTest application visible

' Set QuickTest run options


qtApp.Options.Run.RunMode = "Fast"





qtApp.Options.Run.ViewResults = False

qtResultsOpt.ResultsLocation = "C:\QTPResults"



dim gobjFso

Set gobjFso = CreateObject("Scripting.FileSystemObject")

gstrRelativePath = gobjFso.GetParentFolderName(WScript.ScriptFullName)

Test_path = Replace(gstrRelativePath,"vbsScripts","qtpScripts\Verify SO Status")
Project_path = Replace(gstrRelativePath,"\src\bg\framework\app\functional\util\vbsScripts","\")



qtApp.Open Test_path, True ' Open the test in read-only mode

' set run settings for the test

Set qtTest = qtApp.Test



Set objQtpParamDefns = qtTest.ParameterDefinitions



Set objQtpParams = objQtpParamDefns.GetParameters()



objQtpParams.Item("Project_path").Value = Project_path

objQtpParams.Item("ServiceOrderNumber").Value=ServiceOrderNumber

qtTest.Run qtResultsOpt, True , objQtpParams ' Run the test


qtTest.Close ' Close the test

qtApp.quit

Set qtTest = Nothing ' Release the Test object

Set qtApp = Nothing ' Release the Application object 

Set objQtpParamDefns = Nothing

Set objQtpParams = Nothing

Set objQtpParam = Nothing

Set qtResultsOpt = Nothing







