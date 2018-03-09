Call InvokeSAP
Call SAPLogin
Call ReverseMaterReadInSAP
Call SAPLogoff
Function SAPLogin()
   If SAPGuiSession("Session").SAPGuiWindow("SAP").Exist(10) Then
		SAPGuiSession("Session").SAPGuiWindow("SAP").Maximize
		SAPGuiSession("Session").SAPGuiWindow("SAP").SAPGuiEdit("User").Set "majumda1"
		SAPGuiSession("Session").SAPGuiWindow("SAP").SAPGuiEdit("Password").Set "welcome"
		SAPGuiSession("Session").SAPGuiWindow("SAP").SAPGuiEdit("Password").SetFocus
		SAPGuiSession("Session").SAPGuiWindow("SAP").SendKey ENTER
	End If
	If SAPGuiSession("Session").SAPGuiWindow("License Information for").Exist(5) Then
		SAPGuiSession("Session").SAPGuiWindow("License Information for").SAPGuiRadioButton("Continue with this logon,").Set
		SAPGuiSession("Session").SAPGuiWindow("License Information for").SAPGuiRadioButton("Continue with this logon,").SetFocus
		SAPGuiSession("Session").SAPGuiWindow("License Information for").SAPGuiButton("Confirm Selection   (Enter)").Click
	End If

	If SAPGuiSession("Session").SAPGuiWindow("System Messages").Exist(2) Then
		SAPGuiSession("Session").SAPGuiWindow("System Messages").SAPGuiButton("Cancel   (F12)").Click
	End If
End Function

Function InvokeSAP()
   strEnteredDescription ="BGR - RQQ - ISU Test (ERP 6)"
	blnGotItem = False
   Systemutil.Run "Saplogon"
	If Dialog("text:=saplogon").WinButton("text:=OK").Exist(5) Then
		Dialog("text:=saplogon").WinButton("text:=OK").Click
	End If
	Dialog("text:=SAP Logon 710").WinTab("nativeclass:=SysTabControl32").Select "Systems     "
	intSAPItemsCount = Dialog("text:=SAP Logon 710").WinListView("nativeclass:=SysListView32").GetItemsCount
	For intCount = 0 to intSAPItemsCount-1
		strItemVal = Dialog("text:=SAP Logon 710").WinListView("nativeclass:=SysListView32").GetItem(intCount)
		strActualDescription =strItemVal
		'If  UCase(Trim(Replace(strItemVal," ",""))) = UCase(Trim(Replace(CRAFT_GetData("SAP_Description")," ","")))Then
		If  UCase(strActualDescription) = UCase(strEnteredDescription)Then
			Dialog("text:=SAP Logon 710").WinListView("nativeclass:=SysListView32").Select strItemVal
			blnGotItem = True
			Exit For
		End If
	Next
    
	
	Dialog("text:=SAP Logon 710").WinButton("text:=&Log On").Click
End Function

Function ReverseMaterReadInSAP()
   accnum=TestArgs("AccNumber")
   	Call SapNzbov(accnum)
	intMeterRead = SAPGuiSession("Session").SAPGuiWindow("Billing Overview").SAPGuiGrid("Meter Reading History").GetCellData(1,"Meter reading recorded")
	If  SAPGuiSession("Session").SAPGuiWindow("Billing Overview").Exist Then
		SAPGuiSession("Session").SAPGuiWindow("Billing Overview").SAPGuiGrid("Meter Reading History").SelectRow 1
		SAPGuiSession("Session").SAPGuiWindow("Billing Overview").SAPGuiGrid("Meter Reading History").SelectMenuItemById "MRREVERSE"
	End If
	If  SAPGuiSession("Session").SAPGuiWindow("Reverse Meter Reading").SAPGuiGrid("Reverse Meter Reading").Exist Then
		intRowCount = SAPGuiSession("Session").SAPGuiWindow("Reverse Meter Reading").SAPGuiGrid("Reverse Meter Reading").RowCount
		Dim intReverseRow
		intReverseRow = 1
		While intReverseRow<=intRowCount
			SAPGuiSession("Session").SAPGuiWindow("Reverse Meter Reading").SAPGuiGrid("Reverse Meter Reading").ClickCell intReverseRow,"Selected Line"
			intReverseRow=intReverseRow+1
		Wend
		SAPGuiSession("Session").SAPGuiWindow("Reverse Meter Reading").SAPGuiToolbar("GridToolbar").PressButton "CANC"
		If SAPGuiSession("Session").SAPGuiWindow("Display logs").Exist Then
			wait 2
			SAPGuiSession("Session").SAPGuiWindow("Display logs").Close
			If SAPGuiSession("Session").SAPGuiWindow("Cancel").SAPGuiButton("Exit").Exist(3) Then
				SAPGuiSession("Session").SAPGuiWindow("Cancel").SAPGuiButton("Exit").Click
				If SAPGuiSession("Session").SAPGuiWindow("Billing Overview").SAPGuiButton("Back   (F3)").Exist(3) Then
					SAPGuiSession("Session").SAPGuiWindow("Billing Overview").SAPGuiButton("Back   (F3)").Click
					If SAPGuiSession("Session").SAPGuiWindow("Billing Overview: Initial").SAPGuiButton("Back   (F3)").Exist(3) Then
						SAPGuiSession("Session").SAPGuiWindow("Billing Overview: Initial").SAPGuiButton("Back   (F3)").Click
					End If
				End If
			End If
		Else
			SAPGuiSession("Session").SAPGuiWindow("Reverse Meter Reading").Close
		End If
	Else
		SAPGuiSession("Session").SAPGuiWindow("Reverse Meter Reading").Close
	End If
End Function

'#######################################################################################################################
'Function Name   		:     SapNzbov
'Description     		: Function to invoke SAP window
'Input Parameters 		: None
'Return Value    		: None
'Author				: Cognizant (Karthigai Priyan P)
'Date Created			: 28/07/2011
''####################################################################################################################################
Function SapNzbov(strAccount)
	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SAPGuiOKCode("edtOKCode").Set "/nzbov"
	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SendKey ENTER 'SAPGuiButton("Enter").Click
	SAPGuiSession("Session").SAPGuiWindow("Billing Overview: Initial").SAPGuiEdit("edtContractAccount").Set strAccount
	SAPGuiSession("Session").SAPGuiWindow("Billing Overview: Initial").SendKey ENTER
End Function

Function SAPLogoff()   
   If SAPGuiSession("Session").Exist(1) Then
		SAPGuiSession("Session").Close
   End If	
	If Dialog("text:=saplogon").WinButton("text:=OK").Exist(5) Then
		Dialog("text:=saplogon").WinButton("text:=OK").Click
	End If
	If SAPGuiSession("Session").SAPGuiWindow("Log Off").Exist(2) Then
		Call fObjectClick(SAPGuiSession("Session").SAPGuiWindow("Log Off").SAPGuiButton("Yes"),"Button:Yes")
	End If	
''	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SAPGuiButton("Log off   (Shift+F3)").Click	
'	SAPGuiSession("Session").SAPGuiWindow("Log Off").SAPGuiButton("Yes").Click
	While Dialog("text:=SAP Logon 710").Exist(2)
		If Dialog("text:=saplogon").WinButton("text:=OK").Exist(5) Then
			Dialog("text:=saplogon").WinButton("text:=OK").Click
		End If
		Dialog("text:=SAP Logon 710").Close
	Wend
End Function

