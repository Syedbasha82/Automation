

         Dim strAccountNumber
		 Systemutil.Run "Saplogon"
		 strAccountNumber= TestArgs("AccNumber")


         
   Dim fso, f
   Set fso = CreateObject("Scripting.FileSystemObject")
   If (fso.FolderExists("C:\SAPData")) Then
	   fso.DeleteFolder("C:\SAPData")
	   end if 

	   Set f = fso.CreateFolder("C:\SAPData")



		If Dialog("text:=saplogon").WinButton("text:=OK").Exist(5) Then
			Dialog("text:=saplogon").WinButton("text:=OK").Click
		End If
 
		Dialog("text:=SAP Logon 710").WinTab("nativeclass:=SysTabControl32").Select "Systems     "
		Dialog("text:=SAP Logon 710").WinListView("nativeclass:=SysListView32").Select "BGR - ET - Test"
		Dialog("text:=SAP Logon 710").WinButton("text:=&Log On").Click

		 If SAPGuiSession("Session").SAPGuiWindow("SAP").Exist(10) Then
			SAPGuiSession("Session").SAPGuiWindow("SAP").Maximize
			Wait(6)
			SAPGuiSession("Session").SAPGuiWindow("SAP").SAPGuiEdit("User").Set "amritagr"
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

         wait(5)

        If SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access  -  User").SAPGuiOKCode("OKCode").Exist(5) Then
	    SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access  -  User").SAPGuiOKCode("OKCode").Set "/ncic0"
	    SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access  -  User").SAPGuiButton("Enter").Click

	    ElseIf  SAPGuiSession("Session").SAPGuiWindow("EnergySmart").SAPGuiOKCode("OKCode").Exist(2) Then
          SAPGuiSession("Session").SAPGuiWindow("EnergySmart").SAPGuiOKCode("OKCode").Set "/ncic0"
		  SAPGuiSession("Session").SAPGuiWindow("EnergySmart").SAPGuiButton("Enter").Click
	   End If


      If SAPGuiSession("Session").SAPGuiWindow("Select organization").SAPGuiLabel("JAM On-Shore Billing").Exist(3) Then
	  SAPGuiSession("Session").SAPGuiWindow("Select organization").SAPGuiLabel("JAM On-Shore Billing").SetFocus
	  SAPGuiSession("Session").SAPGuiWindow("Select organization").SAPGuiButton("Copy   (Enter)").Click
      End If



    SAPGuiSession("Session").SAPGuiWindow("Customer Interaction Center").SAPGuiToolbar("ToolBarControl").PressContextButton "%_R3B"

	SAPGuiSession("Session").SAPGuiWindow("Customer Interaction Center").SAPGuiToolbar("ToolBarControl").SelectMenuItem "CH Tariff (CHTR)"
    SAPGuiSession("Session").SAPGuiWindow("Call parameter: Change").SAPGuiEdit("edtContract Account").Set strAccountNumber
    SAPGuiSession("Session").SAPGuiWindow("Call parameter: Change").SAPGuiButton("Execute   (F8)").Click




	strTariffCode=SAPGuiSession("Session").SAPGuiWindow("Window").SAPGuiEdit("edttariffcode").GetROProperty("value")
    strTariffName=SAPGuiSession("Session").SAPGuiWindow("Window").SAPGuiEdit("edtTariff Name").GetROProperty("value")
     Set objFile = fso.CreateTextFile( "C:\SAPData\balance.txt",True)
			objFile.WriteLine  strTariffCode
	        objFile.WriteLine  strTariffName
            objFile.Close



	SAPGuiSession("Session").SAPGuiWindow("Window").Close



	
	If SAPGuiSession("Session").SAPGuiWindow("Log Off_2").SAPGuiButton("Yes").Exist(3) Then
	 SAPGuiSession("Session").SAPGuiWindow("Log Off_2").SAPGuiButton("Yes").Click
	End If


	
   While Dialog("text:=SAP Logon 710").Exist(2)
		If Dialog("text:=saplogon").WinButton("text:=OK").Exist(5) Then
			Dialog("text:=saplogon").WinButton("text:=OK").Click
		End If
		Dialog("text:=SAP Logon 710").Close
		wait(1)
	Wend

