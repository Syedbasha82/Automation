SystemUtil.Run "C:\Program Files\SAP\FrontEnd\SAPgui\saplogon.exe"
wait 2
'SapGuiUtil.AutoLogon"BGR_DCMT TST - ETE18: JQP - ISU",100,"sayedn1","Capgemini@786","EN"
SapGuiUtil.AutoLogon"BGR_DCMT TST - ETE03: JQA - ISU",100,"pathakt1","tripti008","EN"

Set fso = createobject("scripting.filesystemobject")
set txtfile = fso.OpenTextFile ("C:\Documents and Settings\mathuric\Desktop\workspace\BGRegression\src\resources\bgmo_oab\booking\ServiceOrderNumber.txt",1)
ServiceOrderNumber = txtfile.ReadLine
aServiceOrderNo = split(ServiceOrderNumber,"=")
ServiceOrderNo = aServiceOrderNo(1)
NumberOfAccounts =  txtfile.ReadLine
aNumberOfAccounts = Split(NumberOfAccounts,"=")
NumberOfAccount = cint(aNumberOfAccounts(1))


SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiOKCode("OKCode").Set "/niw32" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf1.xml_;_
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SendKey ENTER @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf1.xml_;_
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("Order").Set ServiceOrderNo

 For k=1 to NumberOfAccount
 @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf9.xml_;_
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SendKey ENTER @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf9.xml_;_
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiTabStrip("TS_1100").Select "Operations" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf3.xml_;_
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiTable("SAPLCOVGTCTRL_3010").SelectRow (k)
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Opertn. status").Click

set parent = SAPGuiSession("Session").SAPGuiWindow("GuiWindow").ChildObjects()
a = parent.count
For i=0 to a
If parent(i).GetROProperty("type") =  "GuiRadioButton" Then
	If parent(i).GetROProperty("selected") = true then
		parent(i+1).set
'		 RadioId =  parent(i).GetROProperty("id")
'		
'		radioIdLen = len(RadioId)
'		var  = cint(mid (RadioId,radioIdLen-3,1))
'		var1 = var+1
'		str = replace(RadioId,"["&var&",0]","["&var1&",0]",1)
'		
		Exit for 
		
		end if
End If
Next

'set parent = SAPGuiSession("Session").SAPGuiWindow("Change Status").ChildObjects()
'a = parent.count
'For j=0 to a
'	If parent(j).GetROProperty("id") =  str Then
'		parent(j).set
'		Exit for
'		end if
'Next



SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Back   (F3)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf4.xml_;_
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Save   (Ctrl+S)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf5.xml_;_
 Next

SapGuiUtil.CloseConnections
SystemUtil.CloseProcessByName "saplogon.exe"











