
Dim accNumber, accBalance

accNumber = TestArgs("AccNumber")

InvokeSAP()
SAPLogin()
strBalance = getAccountBalance(accNumber)
TestArgs("AccBalance") = strBalance
SAPLogoff()


'#####################################################################################################################
' Function Name: InvokeSAP
' Description: Function to Invoke SAP
' Parameters: Environment  can be selected from CRAFT  Common datasheet
'Return Value    		: None
'Author				: Cognizant Technology Solutions (Karthigai Priyan P)
'Date Created			: 12/07/2011
'#####################################################################################################################
Function InvokeSAP()
   strSAPEnvironment = "BGR - RRB - ISU Test (ERP 6)"
   Systemutil.Run "Saplogon"
	If Dialog("text:=saplogon").WinButton("text:=OK").Exist(15) Then
		Dialog("text:=saplogon").WinButton("text:=OK").Click
	End If
	Dialog("text:=SAP Logon 710").WinTab("nativeclass:=SysTabControl32").Select "Systems     "
    intSAPItemsCount = Dialog("text:=SAP Logon 710").WinListView("nativeclass:=SysListView32").GetItemsCount
	For intCount = 0 to intSAPItemsCount-1
		strItemVal = Dialog("text:=SAP Logon 710").WinListView("nativeclass:=SysListView32").GetItem(intCount)
		If  UCase(Trim(Replace(strItemVal," ",""))) = UCase(Trim(Replace(strSAPEnvironment," ","")))Then
			Dialog("text:=SAP Logon 710").WinListView("nativeclass:=SysListView32").Select strItemVal
			Exit For
		End If
	Next
	Dialog("text:=SAP Logon 710").WinButton("text:=&Log On").Click
	wait 2
End Function

'#####################################################################################################################
' Function Name: SAPLogin
' Description: Function to login to SAP
' Parameters: User ID and Password can be taken from CRAFT  Common datasheet
'Return Value    		: None
'Author				: Cognizant Technology Solutions (Karthigai Priyan P)
'Date Created			: 12/07/2011
'#####################################################################################################################
Function SAPLogin()
   If SAPGuiSession("Session").SAPGuiWindow("SAP").Exist(10) Then
		SAPGuiSession("Session").SAPGuiWindow("SAP").Maximize
		SAPGuiSession("Session").SAPGuiWindow("SAP").SAPGuiEdit("User").Set "jithendb"
		SAPGuiSession("Session").SAPGuiWindow("SAP").SAPGuiEdit("Password").Set "jithendb"
		SAPGuiSession("Session").SAPGuiWindow("SAP").SAPGuiEdit("Password").SetFocus
		SAPGuiSession("Session").SAPGuiWindow("SAP").SendKey ENTER
	End If
	If SAPGuiSession("Session").SAPGuiWindow("License Information for").Exist(5) Then
		SAPGuiSession("Session").SAPGuiWindow("License Information for").SAPGuiRadioButton("Continue with this logon,").Set
		SAPGuiSession("Session").SAPGuiWindow("License Information for").SAPGuiRadioButton("Continue with this logon,").SetFocus
		SAPGuiSession("Session").SAPGuiWindow("License Information for").SAPGuiButton("Confirm Selection   (Enter)").Click
	End If

	If SAPGuiSession("Session").SAPGuiWindow("System Messages").Exist(5) Then
		SAPGuiSession("Session").SAPGuiWindow("System Messages").SAPGuiButton("Cancel   (F12)").Click
	End If
End Function

'#####################################################################################################################
' Function Name: SAPLogoff
' Description: Function to Log Off SAP
' Parameters: 
'Return Value    		: None
'Author				: Cognizant Technology Solutions (Karthigai Priyan P)
'Date Created			: 12/07/2011
'#####################################################################################################################
Function SAPLogoff()
	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SAPGuiButton("Log off   (Shift+F3)").Click
	SAPGuiSession("Session").SAPGuiWindow("Log Off").SAPGuiButton("Yes").Click
	While Dialog("text:=SAP Logon 710").Exist(2)
		Dialog("text:=SAP Logon 710").Close
	Wend
End Function

Function getAccountBalance(strAcNumber)
   strAc = strAcNumber
	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SAPGuiOKCode("OKCode").Set "/nzbov"
	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SendKey ENTER
	SAPGuiSession("Session").SAPGuiWindow("Billing Overview: Initial").SAPGuiEdit("Contract Account").Set strAcNumber
	SAPGuiSession("Session").SAPGuiWindow("Billing Overview: Initial").SendKey ENTER
	getAccountBalance = SAPGuiSession("Session").SAPGuiWindow("Billing Overview (Display)").SAPGuiEdit("Account Balance").GetROProperty("value")
	SAPGuiSession("Session").SAPGuiWindow("Billing Overview (Display)").SAPGuiButton("Exit   (Shift+F3)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf5.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Billing Overview: Initial").SAPGuiButton("Exit   (Shift+F3)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf6.xml_;_
End Function


 @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf1.xml_;_
