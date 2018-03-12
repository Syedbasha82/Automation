datatable("InitialStatus",1)=TestArgs("InitialStatus")
datatable("JI",1)=TestArgs("JI")
datatable("Contract_Acc",1)="'"&TestArgs("AccNumber1")

projectPath=TestArgs("Project_path")

If  TestArgs("AccNumber2")>0 Then

datatable.SetCurrentRow(2)

datatable("Contract_Acc",1)="'"&TestArgs("AccNumber2")

	datatable.SetCurrentRow(1)
End If

Systemutil.Run "Saplogon"
 wait 2
Set fso = createobject("scripting.filesystemobject")

SAPFileLocation=projectPath & "SAPFiles\SAPEnvironmentDetails.txt"

'SOFileLocation = projectPath &  "QTPFiles\SO.txt"
SOFileLocation = "C:\QTPFiles\SO.txt"



set txtfile = fso.createTextFile (SOFileLocation)
set saptxtfile = fso.OpenTextFile (SAPFileLocation,1,true)

SapServer=saptxtfile.ReadLine
userName=saptxtfile.ReadLine
password=saptxtfile.ReadLine

saptxtfile.Close

SapGuiUtil.AutoLogon SapServer,100,userName,password,"EN"


set txtfile1 = fso.CreateTextFile ( projectPath &  "QTPFiles\SONumber.txt",true,true)



If lcase(datatable("JI",1))  = lcase("Yes") Then
	If  instr (datatable("Contract_Acc",1),"'") > 0Then
		 aContractAccNo = split(datatable("Contract_Acc",1),"'")
		ContractAccNo = aContractAccNo(1)
		else
		ContractAccNo = datatable("Contract_Acc",1)
	End If

 	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiOKCode("OKCode").Set "/ncic0"
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SendKey ENTER	
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("Cont. Acct").Set ContractAccNo
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("Cont. Acct").SetFocus
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Find Partner").Click
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Confirm Partner").Click

	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiToolbar("ToolBarControl").PressContextButton "%_L1"
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiToolbar("ToolBarContoxrol").SelectMenuItem "Customer Overview (OP)"

	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("CoCode").SetFocus
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("CoCode").SetCaretPos 1
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SendKey F2
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("Contract number").Output CheckPoint("Contract number")
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Back   (F3)").Click
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiTabStrip("TABSTRIP101").Select "Gas"
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("CoCode").SetFocus
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("CoCode").SetCaretPos 1
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SendKey F2
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("Contract number").Output CheckPoint("Contract number_2")

	
	ContractNo1 =datatable("Contract_number_value_out",1)
	ContractNo2 = datatable("Contract_number_2_value_out",1)
	datatable("Contract_No",1)  = ContractNo1
	datatable.SetCurrentRow(2)
	'datatable("Contract_Acc",1) = ContractAccNo
	datatable("Contract_No",1)  = ContractNo2
	wait 1
	datatable.SetCurrentRow(1)
	wait 1
End If

'SO creation

Rowcnt = datatable.GetRowCount
AccCnt = 0

For i=1 to Rowcnt

	datatable.SetCurrentRow(i)
	'If  datatable("Contract_Acc",1) <>"" Then
	If  datatable("Contract_Acc",1) ="" Then
		Exit for
		else
		If instr(datatable("Contract_Acc",1),"'") > 0 Then
			aContractAccNo = split(datatable("Contract_Acc",1),"'")
			ContractAccNo = aContractAccNo(1)
			else 
			ContractAccNo = datatable("Contract_Acc",1)
		End If
	 
	AccCnt = AccCnt+1

	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiOKCode("OKCode").Set "/ncic0"
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SendKey ENTER
	
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("Cont. Acct").Set ContractAccNo
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("Cont. Acct").SetFocus
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Find Partner").Click
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Confirm Partner").Click
	
	ContractAccVal = datatable("Contract_Acc",1)
	If  datatable("Contract_No",1) ="" Then	
		wait 1
	'SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiTree("TableTreeControl").ActivateNode "RegExp:=Partner .*;RegExp:=Premise .*;RegExp:=Contract Account "&ContractAccVal&";RegExp:=Contract .*;RegExp:=Installation .* - Normal Meter"
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiTree("TableTreeControl").ActivateNode "RegExp:=Partner .*;RegExp:=Premise .*;RegExp:=Contract Account "&ContractAccNo&";RegExp:=Contract .*;RegExp:=Installation .* "
	else
	wait 1
	ContractNoVal = datatable("Contract_No",1)
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiTree("TableTreeControl").ActivateNode "RegExp:=Partner .*;RegExp:=Premise .*;RegExp:=Contract Account "&ContractAccNo&";RegExp:=Contract "&ContractNoVal&";RegExp:=Installation .* "
	End If
	If  SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("MPAN").Exist Then
		SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("MPAN").Output CheckPoint("MPAN")
		varMPAN = datatable("MPAN_value_out",1)
		MPANStatus = "MPAN"
	End If
	
	
	If  SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("MPR").Exist Then
		SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("MPR").Output CheckPoint("MPAN")
		varMPAN = datatable("MPAN_value_out",1)
		MPANStatus = "MPR"
	
	End If
	
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("Premise").Output CheckPoint("Premise")
	varPremise = datatable("Premise_value_out",1)
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("Premise").SetFocus
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SendKey F2
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiStatusBar("StatusBar").Sync
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("Connection Obj.").Output CheckPoint("Connection Obj.")
	varConnObj = datatable("Connection_Obj._value_out",1)
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Back   (F3)").Click
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Devices").Click
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiTable("Device data").Output CheckPoint("Device data")
	varDevice= datatable("Device_data_out",1)
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiTable("Device data").SelectCell 1,"Device"
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SendKey F2
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiTabStrip("TABSTRIP").Select "General"
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("ManufSerialNo.").Output CheckPoint("ManufSerialNo.")
	varSerialNo= datatable("ManufSerialNo._value_out",1)
	
	
	If  MPANStatus = "MPAN" Then
		txtfile.WriteLine varMPAN&","&varPremise&","&varConnObj&","&varDevice&","&varSerialNo&",SM,01,04,19,58,,,,,"
	
		elseif MPANStatus = "MPR" then
		txtfile.WriteLine varMPAN&","&varPremise&","&varConnObj&","&varDevice&","&varSerialNo&",SM,02,04,19,89,,,,,"
	
	End If
	
	
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Back   (F3)").Click
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Back   (F3)").Click
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Back   (F3)").Click
	wait 1
	
	End If
Next
txtfile.Close

SAPGuiSession("Session").SAPGuiWindow("GuiWindow").Maximize
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiOKCode("OKCode").Set "/nse38"
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SendKey ENTER
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("Program").Set "zintf_unplanned_serv_ord_mdr"
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SendKey F8

SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiRadioButton("Comma Separated File").Set
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("System Header Status").Set "test"

SAPGuiSession("Session").SAPGuiWindow("GuiWindow").Maximize
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("System Header Status").Set "test"
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiRadioButton("Comma Separated File").Set
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("File Name").SetFocus
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("File Name").Object.text = SOFileLocation
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("File Name").SetFocus

'wait 1
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiTabStrip("TABSTRIP_MDRTABS").Select "Technical Settings"

'wait 1
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("Label").Set "Test"
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiComboBox("Interval variant").Select "UNPLSRVORD : 100 intervals"
'wait 1

SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Execute   (F8)").Click

wait 1

SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiLabel("Finished").SetFocus
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiLabel("Finished").SetCaretPos 3
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SendKey F2
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Transform").Click

SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiGrid("GridViewCtrl").Output CheckPoint("GridViewCtrl_SO_Number")

'SAPGuiSession("Session_2").SAPGuiWindow("Creation of Unplanned").SAPGuiGrid("GridViewCtrl").Output CheckPoint("GridViewCtrl_3")
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiGrid("GridViewCtrl").Output CheckPoint("GridViewCtrl_SO_Message")

ServiceOrderNo =  datatable("SO_Number_out",1)

txtfile1.WriteLine "ServiceOrderNumber="& datatable("SO_Number_out",1)


txtfile1.WriteLine "Message ="& datatable("SO_Message_out",1)
txtfile1.Close

wait 2

'Script to change initial stsus of SO

datatable.SetCurrentRow(1)
InitialStatus = datatable("InitialStatus",1)
NumberOfAccount =  AccCnt

SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiOKCode("OKCode").Set "/niw32"
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SendKey ENTER
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("Order").Set ServiceOrderNo

 For k=1 to NumberOfAccount

SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SendKey ENTER
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiTabStrip("TS_1100").Select "Operations"
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiTable("SAPLCOVGTCTRL_3010").SelectRow (k)
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Opertn. status").Click

If SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Previous Page").GetROProperty("enabled") = true Then
Do while SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Previous Page").GetROProperty("enabled") = true
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Previous Page").Click
Loop
End If

SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("Stat").SetTOProperty "value",InitialStatus

Do

If  SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("Stat").Exist(2) Then
    	 TextId = SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("Stat").GetROProperty("id")
	 	TextLen = len(TextId)
	var  = cint(mid (TextId,TextLen-3,1))

	RadioId = ".*radJ_STMAINT-ANWS\["&var&",0\]"
	'RadioId = "/app/con[0]/ses[0]/wnd[0]/usr/tabsTABSTRIP_0300/tabpANWS/ssubSUBSCREEN:SAPLBSVA:0302/sub:SAPLBSVA:0302[1]/radJ_STMAINT-ANWS["&var&",0]"
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiRadioButton("StatusRadioButton").SetTOProperty "id",RadioId
	wait 1
	If SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiRadioButton("StatusRadioButton").exist(2) Then
		wait 1
		SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiRadioButton("StatusRadioButton").set	
		Exit do
	End If

	else 
	SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Next Page").Click

End If

Loop until SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Next Page").GetROProperty("enabled") =false


SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Back   (F3)").Click
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiButton("Save   (Ctrl+S)").Click
 Next


Set fso = nothing

SapGuiUtil.CloseConnections
SystemUtil.CloseProcessByName "saplogon.exe"


