strBPNumber= TestArgs("AccNumber")
'strBPNumber = "2001292562"
Set fso = CreateObject("Scripting.FileSystemObject")
If fso.FolderExists("C:\SAPData") then
	fso.DeleteFolder("C:\SAPData")
end if
	set f =fso.CreateFolder("C:\SAPData")
	Set addr = fso.CreateTextFile("C:\SAPData\Sample.txt", true)

call invokeSAP()
Call openDataEnvWindow()
Call getNumberOfGuiLabels()

Function openDataEnvWindow()

	If	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").Exist Then @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf1.xml_;_
		SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SAPGuiOKCode("OKCode").Set "/n ecenv_bp"
		wait 2
		SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SendKey ENTER @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf1.xml_;_
		wait 6
		End if
	
	If 	 SAPGuiSession("Session").SAPGuiWindow("Data Environment Business").SAPGuiEdit("Business Partner").Exist then @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf2.xml_;_
		SAPGuiSession("Session").SAPGuiWindow("Data Environment Business").SAPGuiEdit("Business Partner").SetFocus
		 SAPGuiSession("Session").SAPGuiWindow("Data Environment Business").SAPGuiEdit("Business Partner").Set strBPNumber		 
		 wait 2
		SAPGuiSession("Session").SAPGuiWindow("Data Environment Business").SendKey ENTER @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf5.xml_;_
		wait(5)
	End if
	
End Function

Function getNumberOfGuiLabels()
	
	Set MyDescription=SAPGuiLabel
	
	'Set MyDescription="Contract Account"
	'MyDescription("content").Value = Contract Account
	Set label = SAPGuiSession("Session").SAPGuiWindow("Data Environment on 07.02.2013").ChildObjects(MyDescription) 
	
	NoOfChildObjs = label.count 
	
	'Msgbox NoOfChildObjs
	Counts=0
	contractAccNumber =0
	For Counter=0 to NoOfChildObjs-1      
		   conditionContractno=label(Counter).getroproperty("content")
		   If  conditionContractno ="Contract Account" Then
				contractAccNumber =   getBillingPostCode(conditionContractno,Counter)							
				'msgbox contractAccNumber
		   End If
			If  conditionContractno = "Device" Then
				'Call openDataEnvWindow()
				 Call getSiteAddress(conditionContractno,Counter)
			End If
	Next 

	Call getAccountBalance(contractAccNumber)	
End Function

'Msgbox Counts
Function invokeSAP()

		'SystemUtil.Run "saplogon.exe"
		'SAPGuiUtil.AutoLogon "sapgui sapireci 01", "300","sundarg1","welcome123","EN"
		SAPGuiUtil.CloseConnections
		SAPGuiUtil.AutoLogon "Qas 02", "300","s0000k3","welcome5","EN"
		'SAPGuiUtil.AutoLogon "BGR - LQ6 - CRM Test", "100","sundarg1","welcome123","EN"
		wait 6 @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf10.xml_;_
		'SAPGuiUtil.AutoLogon "saplogon", "300","sundarg1","welcome123","EN"
		
			If Dialog("text:=saplogon").WinButton("text:=OK").Exist(5) Then @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf10.xml_;_
					Dialog("text:=saplogon").WinButton("text:=OK").Click
			End If
		 
'		If Dialog("text:=SAP Logon 710").WinTab("nativeclass:=SysTabControl32").Exist Then
'			Dialog("text:=SAP Logon 710").WinTab("nativeclass:=SysTabControl32").Select "Systems     "
'			Dialog("text:=SAP Logon 710").WinListView("nativeclass:=SysListView32").Select "sapgui"
'			Dialog("text:=SAP Logon 710").WinButton("text:=&Log On").Click
'			wait 10
'		End If

		If SAPGuiSession("Session_2").SAPGuiWindow("SAP").SAPGuiEdit("User").Exist Then
				SAPGuiSession("Session_2").SAPGuiWindow("SAP").SAPGuiEdit("User").Set "sundarg1"
				wait(3)
				SAPGuiSession("Session_2").SAPGuiWindow("SAP").SAPGuiEdit("Password").Set "welcome123" @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf10.xml_;_
				wait 2
				'SAPGuiSession("Session_2").SAPGuiWindow("SAP").SAPGuiEdit("Password").SetFocus @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf10.xml_;_
				SAPGuiSession("Session_2").SAPGuiWindow("SAP").SendKey ENTER @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf10.xml_;_
				wait 10
		End If
 @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf10.xml_;_
		If  SAPGuiSession("Session_2").SAPGuiWindow("License Information for").Exist then @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf13.xml_;_
				SAPGuiSession("Session_2").SAPGuiWindow("License Information for").SAPGuiRadioButton("Continue with this logon,").Set
				SAPGuiSession("Session_2").SAPGuiWindow("License Information for").SAPGuiRadioButton("Continue with this logon,").SetFocus @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf13.xml_;_
				SAPGuiSession("Session_2").SAPGuiWindow("License Information for").SAPGuiButton("Confirm Selection   (Enter)").Click @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf13.xml_;_
				'SAPGuiSession("Session_2").SAPGuiWindow("Information").SAPGuiButton("Continue   (Enter)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf14.xml_;_
		End if

End Function

Function getBillingPostCode(conditionContractno,Counter)

		  ' Counts=Counts+1			
			' label(Counter).SetFocus
			SAPGuiSession("Session").SAPGuiWindow("Data Environment on 07.02.2013").SAPGuiLabel("Contract Account").SetFocus @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf18.xml_;_
			SAPGuiSession("Session").SAPGuiWindow("Data Environment on 07.02.2013").SendKey F2
			SAPGuiSession("Session").SAPGuiWindow("Contract Account Display:").SAPGuiEdit("Contract Acct").SetFocus
			strAccountNumber = SAPGuiSession("Session").SAPGuiWindow("Contract Account Display:").SAPGuiEdit("Contract Acct").GetROProperty("value")
			SAPGuiSession("Session").SAPGuiWindow("Contract Account Display:").SAPGuiEdit("Hanson Building Products").SetFocus
			addr1 = SAPGuiSession("Session").SAPGuiWindow("Contract Account Display:").SAPGuiEdit("Hanson Building Products").GetROProperty("value")
			SAPGuiSession("Session").SAPGuiWindow("Contract Account Display:").SAPGuiButton("Back   (F3)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf47.xml_;_
			addr.WriteLine strAccountNumber

			'addr.WriteLine addr1
			'addrFinal = replace(addr1,"/",",");
			billingPostCode = split(addr1,"/")
			billingAddress1 =billingPostCode(0) 
			postCode = split(billingPostCode(1)," ")
			billingAddress2 = postCode(0) & ", " & postCode(1) 
			BillingAddr = billingAddress1&billingPostCode(1)
			billingPostCode = postCode(2)  & " "&postCode(3)
			'msgbox billingPostCode
			addr.WriteLine BillingAddr
			addr.WriteLine billingPostCode
			Wait 2
			getBillingPostCode = strAccountNumber
End Function


Function getSiteAddress(conditionContractno,Counter)
	If SAPGuiSession("Session").SAPGuiWindow("Data Environment on 07.02.2013").Exist Then
			 label(Counter).SetFocus
			 SAPGuiSession("Session").SAPGuiWindow("Data Environment on 07.02.2013").SAPGuiLabel("Device").SetFocus
			 SAPGuiSession("Session").SAPGuiWindow("Data Environment on 07.02.2013").SendKey F2
			 SAPGuiSession("Session").SAPGuiWindow("Display Material Serial").SAPGuiTabStrip("TABSTRIP").Select "Location" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf49.xml_;_
			 SAPGuiSession("Session").SAPGuiWindow("Display Material Serial").SAPGuiEdit("Street").SetFocus @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf50.xml_;_
			 strStreet = SAPGuiSession("Session").SAPGuiWindow("Display Material Serial").SAPGuiEdit("Street").GetROProperty("value")
			SAPGuiSession("Session").SAPGuiWindow("Display Material Serial").SAPGuiEdit("Location").SetFocus
			strSitePostCode = SAPGuiSession("Session").SAPGuiWindow("Display Material Serial").SAPGuiEdit("Location").GetROProperty("value")
			SAPGuiSession("Session").SAPGuiWindow("Display Material Serial").SAPGuiEdit("Location_2").SetFocus
			strLocation = 	SAPGuiSession("Session").SAPGuiWindow("Display Material Serial").SAPGuiEdit("Location_2").GetROProperty("value")
			SAPGuiSession("Session").SAPGuiWindow("Display Material Serial").SAPGuiButton("Back   (F3)").Click
			addr.WriteLine strStreet &", "&strLocation&", "&strSitePostCode
			addr.WriteLine strSitePostCode	
			wait 2
	End If
End Function

Function getAccountBalance(contractAccountNumber)

	SAPGuiSession("Session").Reset
	If	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").Exist Then
			SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SAPGuiOKCode("OKCode").Set "/n fpl9"
			wait 2
			SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SendKey ENTER @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf1.xml_;_
			wait 6
	End if
	
	If  SAPGuiSession("Session").SAPGuiWindow("Account Display: InitScrn").Exist Then
		SAPGuiSession("Session").SAPGuiWindow("Account Display: InitScrn").SAPGuiEdit("Business partn.").SetFocus
		SAPGuiSession("Session").SAPGuiWindow("Account Display: InitScrn").SAPGuiEdit("Business partn.").Set strBPNumber @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf55.xml_;_
		SAPGuiSession("Session").SAPGuiWindow("Account Display: InitScrn").SAPGuiEdit("Contract Acct").SetFocus
		SAPGuiSession("Session").SAPGuiWindow("Account Display: InitScrn").SAPGuiEdit("Contract Acct").Set contractAccountNumber @@ hightlight id_;_3_;_script infofile_;_ZIP::ssf55.xml_;_
		SAPGuiSession("Session").SAPGuiWindow("Account Display: InitScrn").SAPGuiCheckBox("ALV Grid").SetFocus @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf55.xml_;_
		SAPGuiSession("Session").SAPGuiWindow("Account Display: InitScrn").SAPGuiCheckBox("ALV Grid").Set "ON" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf55.xml_;_
		SAPGuiSession("Session").SAPGuiWindow("Account Display: InitScrn").SAPGuiButton("Enter").Click @@ hightlight id_;_4_;_script infofile_;_ZIP::ssf55.xml_;_
		SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic").SAPGuiTabStrip("TABSTRIP01").Select "Totals" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf56.xml_;_
		strTotalValueRow=SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic").SAPGuiGrid("Totals in Local Currency").FindRowByCellContent("Description of Criterion","Total")
		strAccountBalanace = SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic").SAPGuiGrid("Totals in Local Currency").GetCellData (strTotalValueRow,"Local Currency amnt")
		strAccountBalanace1 = replace(strAccountBalanace, ",",".")
		addr.WriteLine strAccountBalanace1
		'SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic").SAPGuiGrid("Totals in Local Currency").SelectRow 12 @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf57.xml_;_
		SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic").SAPGuiButton("Back   (F3)").Click @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf57.xml_;_
		SAPGuiSession("Session").SAPGuiWindow("Account Display: InitScrn").SAPGuiButton("Back   (F3)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf58.xml_;_
		wait 2
	End If

End Function

addr.Close
SAPGuiSession("Session").Close





