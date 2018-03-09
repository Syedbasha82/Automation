Dim qtp, ts, tres, op, oprun

set qtp = createobject("Quicktest.Application")

'set tres = createobject("QuickTest.RunResultsOptions")

qtp.Launch 'for launching QTP


qtp.Visible= true 'to make QTP visible

'set op = qtp.Options

'set oprun = op.Run

'oprun.ViewResults = true 'to view the results once script is executed



if qtp.GetStatus = "Ready" then

'qtp.Open "C:\Documents and Settings\sayedn1\Desktop\workspace\BGRegression\src\bg\framework\app\functional\util\qtpScripts\SO Creation",true 

qtp.Open "C:\Documents and Settings\mathuric\Desktop\workspace\BGRegression\src\bg\framework\app\functional\util\qtpScripts\SO Creation",true

set ts = qtp.Test

'tres.ResultsLocation = "C:\Documents and Settings\sayedn1\Desktop\softwares\workspace\BGRegression\src\bg\framework\app\functional\util\qtpScripts\SO Creation\Res" 

'ts.Run tres 'run the test
ts.Run  'run the test

ts.close

else

msgbox "QTP is not ready"

end if

qtp.Quit

set qtp = nothing
