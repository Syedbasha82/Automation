'msgbox "pr"
Dim fso, f
   Set fso = CreateObject("Scripting.FileSystemObject")
   If (fso.FolderExists("C:\SAPData")) Then
	   fso.DeleteFolder("C:\SAPData")
	   end if 
	   Set f = fso.CreateFolder("C:\SAPData")
	 	 
'x= TestArgs("AccNumber")
'
'msgbox x

Call GetmeterReadingSAP
'Call  GetPaymentdateAndamountSAP

Call GetAccountBalance

Call ChangeTarrif

Function ChangeTarrif()
   


	Dim strAccountNumber
		 Systemutil.Run "Saplogon"
		strAccountNumber= TestArgs("AccNumber")
 'strAccountNumber= "850022680336"

'         sapguiutil.AutoLogon "sapgui tisujqmqa 20,100,amritagr,welcome,EN"
   		' Dialog("Run").Activate
'Dialog("Run").WinEdit("Open:").Set "sapgui tisujqmqa 20"
'Dialog("Run").WinButton("OK").Click


		If Dialog("text:=saplogon").WinButton("text:=OK").Exist(5) Then
			Dialog("text:=saplogon").WinButton("text:=OK").Click
		End If
 
		Dialog("text:=SAP Logon 710").WinTab("nativeclass:=SysTabControl32").Select "Systems     "
	Dialog("text:=SAP Logon 710").WinListView("nativeclass:=SysListView32").Select "JQM_ETE16"
		Dialog("text:=SAP Logon 710").WinButton("text:=&Log On").Click

		 If SAPGuiSession("Session").SAPGuiWindow("SAP").Exist(10) Then
			SAPGuiSession("Session").SAPGuiWindow("SAP").Maximize
			Wait(6)
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
	'SAPGuiSession("Session").SAPGuiWindow("Call parameter: Change").SAPGuiEdit("edtContract Account").Set "850000031384"
    SAPGuiSession("Session").SAPGuiWindow("Call parameter: Change").SAPGuiButton("Execute   (F8)").Click

  

If SAPGuiSession("Session").SAPGuiWindow("Contracts").SAPGuiButton("Continue   (Enter)").Exist(3) Then
SAPGuiSession("Session").SAPGuiWindow("Contracts").SAPGuiButton("Continue   (Enter)").Click
End IF



	strTariffCode=SAPGuiSession("Session").SAPGuiWindow("Window").SAPGuiEdit("edttariffcode").GetROProperty("value")
    strTariffName=SAPGuiSession("Session").SAPGuiWindow("Window").SAPGuiEdit("edtTariff Name").GetROProperty("value")



     Set objFile = fso.CreateTextFile( "C:\SAPData\tarrif.txt",True)
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


End Function

''#####################################################################################################################
''Function Name                                 : SAPLogoff()
''Description                                        : This function helps to logout SAP
''Input Parameters                             : Account Number
''Return Value                                     : None
''Author                                                  : Cognizant Technology Solutions (Karthigai Priyan P)
''Date Created                                    : 12/07/2011 (DD/MM/YYYY)
''
''Modified Date                                  : 08/02/2012
''Modified By                                       : Cognizant Technology Solutions (Senthil Kumar)
''Modified Details                              : Single line explanation for the changes made
''#####################################################################################################################
Function SAPLogoff()   
	SAPGuiSession("Session").Close
	If Dialog("text:=saplogon").WinButton("text:=OK").Exist(5) Then
		Dialog("text:=saplogon").WinButton("text:=OK").Click
	End If
	If SAPGuiSession("Session").SAPGuiWindow("Log Off").Exist(2) Then
		Call fObjectClick(SAPGuiSession("Session").SAPGuiWindow("Log Off").SAPGuiButton("Yes"),"Button:Yes")
	End If
	
	While Dialog("text:=SAP Logon 710").Exist(2)
		If Dialog("text:=saplogon").WinButton("text:=OK").Exist(5) Then
			Dialog("text:=saplogon").WinButton("text:=OK").Click
		End If
		Dialog("text:=SAP Logon 710").Close
		wait(1)
	Wend
End Function

''#####################################################################################################################
''Function Name                                 : InvokeSAP()
''Description                                        : This function helps to Invoke SAP
''Input Parameters                             : NA
''Return Value                                     : None
''Author                                                  : Cognizant Technology Solutions (Karthigai Priyan P)
''Date Created                                    : 12/07/2011 (DD/MM/YYYY)
''
''Modified Date                                  : 08/02/2012
''Modified By                                       : Cognizant Technology Solutions (Senthil Kumar)
''Modified Details                              : Single line explanation for the changes made
''#####################################################################################################################
Function InvokeSAP()
	Dim strAccountNumber
		Systemutil.Run "Saplogon"
		strAccountNumber= TestArgs("AccNumber")
		'strAccountNumber= "850026029761"

		If Dialog("text:=saplogon").WinButton("text:=OK").Exist(5) Then
			Dialog("text:=saplogon").WinButton("text:=OK").Click
		End If

		Dialog("text:=SAP Logon 710").WinTab("nativeclass:=SysTabControl32").Select "Systems     "
	Dialog("text:=SAP Logon 710").WinListView("nativeclass:=SysListView32").Select "JQM_ETE16"
		'Dialog("text:=SAP Logon 710").WinListView("nativeclass:=SysListView32").Select strsapconfig
		Dialog("text:=SAP Logon 710").WinButton("text:=&Log On").Click
End Function

''#####################################################################################################################
''Function Name                                 : SAPLogin()
''Description                                        : This function helps to login into SAP
''Input Parameters                             : NA
''Return Value                                     : None
''Author                                                  : Cognizant Technology Solutions (Karthigai Priyan P)
''Date Created                                    : 12/07/2011 (DD/MM/YYYY)
''
''Modified Date                                  : 08/02/2012
''Modified By                                       : Cognizant Technology Solutions (Senthil Kumar)
''Modified Details                              : Single line explanation for the changes made
''#####################################################################################################################
Function SAPLogin()
  If SAPGuiSession("Session").SAPGuiWindow("SAP").Exist(10) Then
			SAPGuiSession("Session").SAPGuiWindow("SAP").Maximize
			Wait(6)
			SAPGuiSession("Session").SAPGuiWindow("SAP").SAPGuiEdit("User").Set "majumda1"
			SAPGuiSession("Session").SAPGuiWindow("SAP").SAPGuiEdit("Password").Set "welcome"
			SAPGuiSession("Session").SAPGuiWindow("SAP").SAPGuiEdit("Password").SetFocus
			SAPGuiSession("Session").SAPGuiWindow("SAP").SendKey ENTER
		 End If
   If SAPGuiSession("Session").SAPGuiWindow("SAP").Exist(10) Then
		SAPGuiSession("Session").SAPGuiWindow("SAP").Maximize
		Wait(6)
		SAPGuiSession("Session").SAPGuiWindow("SAP").SAPGuiEdit("User").Set "majumda1"
		SAPGuiSession("Session").SAPGuiWindow("SAP").SAPGuiEdit("Password").Set  "welcome"
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


'####################################################################################################################
'Function Name        		   : GetAccountBalance
'Description                   : Function to verify the account balance of the customer
'Input Parameters             : None
'Return Value                 : None
'Author                       : Cognizant Technology Solutions (NeethuSNair)
'Date Created                : 09/4/2012 (DD/MM/YYYY)
'#####################################################################################################################
Function GetAccountBalance
	Call InvokeSAP

		Call SAPLogin
strAccountNumber= TestArgs("AccNumber")
'strAccountNumber= "850026029761"

		'If craft_getdata("Switch_To_Acc_Type") <> "" Then
			'Call SapNzbov(Craft_GetData("Switch_To_Acc_Type"))	
			'else
	    SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SAPGuiOKCode("edtOKCode").Set "/nzbov"
	    SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SendKey ENTER
	   SAPGuiSession("Session").SAPGuiWindow("Billing Overview: Initial").SAPGuiEdit("edtContractAccount").Set strAccountNumber
 'SAPGuiSession("Session").SAPGuiWindow("Billing Overview: Initial").SAPGuiEdit("edtContractAccount").Set "850000034235"
	    SAPGuiSession("Session").SAPGuiWindow("Billing Overview: Initial").SendKey ENTER
		 'End If
		'strBillAmount = Browser("BritishGas").Page("AccountsSummary - British").WebElement("eleAccount summaryYour balance£37").GetROProperty("innertext")
		strSAPAccountBalance = SAPGuiSession("Session").SAPGuiWindow("Billing Overview").SAPGuiEdit("edtAccount Balance").GetROProperty("value")

		 Set objFile = fso.CreateTextFile( "C:\SAPData\balance.txt",True)
			objFile.WriteLine  strSAPAccountBalance
	'objFile.WriteLine  TestArgs("AccountBalance")
	
             			objFile.Close
		'call fCompareTwoValues(strBillAmount, strSAPAccountBalance,"The Account balance verification")
		Call SAPLogoff
	
End Function

''#####################################################################################################################
''Function Name                                 : SapNzbov()
''Description                                        : This function helps to login into SAP
''Input Parameters                             : Account Number
''Return Value                                     : None
''Author                                                  : Cognizant Technology Solutions (Karthigai Priyan P)
''Date Created                                    : 12/07/2011 (DD/MM/YYYY)
''
''Modified Date                                  : 08/02/2012
''Modified By                                       : Cognizant Technology Solutions (Senthil Kumar)
''Modified Details                              : Single line explanation for the changes made
''#####################################################################################################################
Function SapNzbov(strAccountNumber)
	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SAPGuiOKCode("edtOKCode").Set "/nzbov"
	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SendKey ENTER
	SAPGuiSession("Session").SAPGuiWindow("Billing Overview: Initial").SAPGuiEdit("edtContractAccount").Set strAccount
	SAPGuiSession("Session").SAPGuiWindow("Billing Overview: Initial").SendKey ENTER
End Function
'#####################################################################################################################
'Function Name        		   : verifyPaymentamountAnddate
'Description                   : Function to verify the last payment amount and the date on which the payment was made online
'Input Parameters             : None
'Return Value                 : None
'Author                       : Cognizant Technology Solutions (NeethuSNair)
'Date Created                : 14/3/2012 (DD/MM/YYYY)
'#####################################################################################################################
Function verifyPaymentamountAnddate
 	If Browser("BritishGas").Page("AccountsSummary - British").WebElement("eleNot Available").Exist(2)then
		Call fReportPass("Bill payment verification","This customer has not paid his bill!")
	Else
		Call GetPaymentdateAndamountSAP
		If instr(trim(strinnertextdirectdebit),trim(strLastPaymentAmt))> 0 Then 
			Call fReportPass("Last payment amount verification","The payment amount is successfully verified")
		else
			Call fReportFail("Last payment amount verification","The payment amount is Not as same as that in backend")			
		End if
		call fCompareTwoValues(strinnertextdirectdebit, strPaymentdate,"The payment date verification")
	End if
End Function

'#####################################################################################################################
'Function Name        		   : GetPaymentdateAndamountSAP
'Description                   : Function to fetch the payment date and last payment amount in nse37
'Input Parameters             : None
'Return Value                 : None
'Author                       : Cognizant Technology Solutions (NeethuSNair)
'Date Created                : 8/3/2012 (DD/MM/YYYY)
'#####################################################################################################################
Function GetPaymentdateAndamountSAP()
	strAccountNumber= TestArgs("AccNumber")
	Call InvokeSAP
	Call SAPLogin
	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SAPGuiOKCode("edtOKCode").Set "se37"
	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SendKey ENTER
	SAPGuiSession("Session").SAPGuiWindow("Function Builder: Initial").SAPGuiEdit("Function Module").Set "Z_FKK_GET_ACCOUNT_HISTORY"
	SAPGuiSession("Session").SAPGuiWindow("Function Builder: Initial").SAPGuiButton("Test/Execute   (F8)").Click

	If craft_getdata("Switch_To_Acc_Type") <> "" Then
		SAPGuiSession("Session").SAPGuiWindow("Structure Editor: Display").SAPGuiEdit("Test for function group").Set craft_getdata("Switch_To_Acc_Type")
	else
		SAPGuiSession("Session").SAPGuiWindow("Structure Editor: Display").SAPGuiEdit("Test for function group").Set strAccountNumber
	End If
	SAPGuiSession("Session").SAPGuiWindow("Structure Editor: Display").SAPGuiEdit("Test for function group_frmdate").Set craft_getdata("Paymentdate")

	SAPGuiSession("Session").SAPGuiWindow("Structure Editor: Display").SAPGuiButton("Execute   (F8)").Click

	SAPGuiSession("Session").SAPGuiWindow("Structure Editor: Display").SAPGuiLabel("Details View / Edit").SetFocus
	SAPGuiSession("Session").SAPGuiWindow("Structure Editor: Display").SAPGuiLabel("Details View / Edit").SetCaretPos 2
	SAPGuiSession("Session").SAPGuiWindow("Structure Editor: Display").SendKey F2
	strLastPaymentAmt = SAPGuiSession("Session").SAPGuiWindow("Structure Editor: Display").SAPGuiLabel("32.00").GetROProperty("content")
	strPaymentdate = SAPGuiSession("Session").SAPGuiWindow("Structure Editor: Display").SAPGuiLabel("29.06.2011").GetROProperty("content")
	
	strdummy = split(strPaymentdate,".")
	strmonth = monthName(strdummy(1),true)
	strPaymentdate = strdummy(0)&strmonth&strdummy(2)


TestArgs("PayDate")=strPaymentdate
TestArgs("PayAmount")=strLastPaymentAmt
'to write a xml content
       Set objFile = fso.CreateTextFile( "C:\SAPData\meterread1.txt",True)
	objFile.WriteLine  TestArgs("PayDate")
	'objFile.WriteLine "&"
	objFile.WriteLine	TestArgs("PayAmount")
             			objFile.Close


	Call SAPLogoff
End function

'#####################################################################################################################
'Function Name        		   : verifymeterReadingSAP
'Description                   : Function to verify the lmeter reading and the date on which the meter was read
'Input Parameters             : None
'Return Value                 : None
'Author                       : Cognizant Technology Solutions (NeethuSNair)
'Date Created                : 14/3/2012 (DD/MM/YYYY)
'#####################################################################################################################
Function verifymeterReadingSAP
   Call GetmeterReadingSAP
	strmeterreadings =Browser("BritishGas").Page("AccountsSummary - British").WebElement("eleYour meter readingsElectricity").GetROProperty("innertext")
	If instr(trim(strmeterreadings),trim(strActmeterRead))> 0  Then
		Call fReportPass("Meter readings verification","The meter reading is successfully verified")
	else
		Call fReportFail("Meter readings verification","The meter reading is NOT same as that in the backend")
	End If
	call fCompareTwoValues(strmeterreadings, strActDate,"Meter readings date verification")
End Function

'#####################################################################################################################
'Function Name        		   : GetmeterReadingSAP
'Description                   : Function to fetch the meter reading from metere reading history table of SAP
'Input Parameters             : None
'Return Value                 : None
'Author                       : Cognizant Technology Solutions (NeethuSNair)
'Date Created                : 8/3/2012 (DD/MM/YYYY)
'#####################################################################################################################
Function GetmeterReadingSAP

strAccountNumber= TestArgs("AccNumber")

   Call InvokeSAP
	Call SAPLogin
	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SAPGuiOKCode("edtOKCode").Set "/nzbov"
	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SendKey ENTER
	SAPGuiSession("Session").SAPGuiWindow("Billing Overview: Initial").SAPGuiEdit("edtContractAccount").Set strAccountNumber		
	SAPGuiSession("Session").SAPGuiWindow("Billing Overview: Initial").SAPGuiButton("Enter").Click

    If SAPGuiSession("Session").SAPGuiWindow("Billing Overview (Display)").SAPGuiGrid("Meter Reading History").Exist(2) = True Then
		SAPGuiSession("Session").SAPGuiWindow("Billing Overview (Display)").SAPGuiGrid("Meter Reading History").SelectCell 1,"Meter reading date"
	Elseif SAPGuiSession("Session").SAPGuiWindow("Billing Overview (Display)").SAPGuiGrid("Meter Reading History_2").Exist(2) = True Then
		SAPGuiSession("Session").SAPGuiWindow("Billing Overview (Display)").SAPGuiGrid("Meter Reading History_2").SelectCell 1,"Meter reading date"
	End If



	If SAPGuiSession("Session").SAPGuiWindow("Billing Overview (Display)").SAPGuiGrid("Meter Reading History").Exist(2) = True Then
		strmeterRead = SAPGuiSession("Session").SAPGuiWindow("Billing Overview (Display)").SAPGuiGrid("Meter Reading History").GetCellData(1,"Meter reading recorded")
		strmeterdate = SAPGuiSession("Session").SAPGuiWindow("Billing Overview (Display)").SAPGuiGrid("Meter Reading History").GetCellData(1,"Meter reading date")	
	Elseif SAPGuiSession("Session").SAPGuiWindow("Billing Overview (Display)").SAPGuiGrid("Meter Reading History_2").Exist(2) = True Then
		strmeterRead = SAPGuiSession("Session").SAPGuiWindow("Billing Overview (Display)").SAPGuiGrid("Meter Reading History_2").GetCellData(1,"Meter reading recorded")
		strmeterdate = SAPGuiSession("Session").SAPGuiWindow("Billing Overview (Display)").SAPGuiGrid("Meter Reading History_2").GetCellData(1,"Meter reading date")	
	End If

    

    If Instr(strmeterRead,",") <> 0 Then
		strmeterRead = replace(strmeterRead,",","")
	ElseIf Instr(strmeterRead,".") <> 0 Then
		strmeterRead = replace(strmeterRead,".","")
	End If
 '   Newstrdummyval = strdummy[0]&strdummy[1]

	If SAPGuiSession("Session").SAPGuiWindow("Billing Overview (Display)").SAPGuiGrid("Meter Reading History").Exist(2) = True Then
        strmeterdate = SAPGuiSession("Session").SAPGuiWindow("Billing Overview (Display)").SAPGuiGrid("Meter Reading History").GetCellData(1,"Meter reading date")	
	Elseif SAPGuiSession("Session").SAPGuiWindow("Billing Overview (Display)").SAPGuiGrid("Meter Reading History_2").Exist(2) = True Then
        strmeterdate = SAPGuiSession("Session").SAPGuiWindow("Billing Overview (Display)").SAPGuiGrid("Meter Reading History_2").GetCellData(1,"Meter reading date")	
	End If
	
    strdummy = split(strmeterdate,".")
	strmonth = monthName(strdummy(1),true)
	strActDate = strdummy(0)&strmonth&strdummy(2)


	TestArgs("AccMeterRead") = strmeterRead
	TestArgs("ActDate") = strActDate
    'msgbox strActmeterRead
	'msgbox strActDate
''to write a xml content
       Set objFile = fso.CreateTextFile( "C:\SAPData\meterread.txt",True)
	objFile.WriteLine  TestArgs("AccMeterRead")
	'objFile.WriteLine "&"
	objFile.WriteLine TestArgs("ActDate")
             			objFile.Close
				

	Call SAPLogoff

End function

'''''''''Support functions (Common functions)

''''************************************************************''*************************************************************
''''''Function Name    : fCompareTwoValues(strActualValue,strParameterValue,strFieldName)
''''''Purpose              : This re-usable function helps to check the entered parameter value with the applicaiton's displayed value or entered actual value
'''''''Created by       : Senthil 
'''''''Created date      : 06/30/2011
''''''Modified date      : 06/30/2011
''''************************************************************''*************************************************************
Public Function fCompareTwoValues(strActualValue,strParameterValue,strFieldName)
	If strParameterValue <> ""  Then   		
		strApplicationValue = fGetAlphaNumbericOnly(strActualValue)
		strExpectedValue = fGetAlphaNumbericOnly(strParameterValue)
		If Trim(Lcase(strApplicationValue)) =  Trim(Lcase(strExpectedValue)) Or Instr(Lcase(strApplicationValue),Lcase(strExpectedValue)) > 0 Then
			Call fReportPass("Verify the entered parameter value with the acutal value","'Expected value:"&strParameterValue&"'  is displayed in  '"&strFieldName&"'")			
		Else	
			Call fReportFail("Verify the entered parameter value with the acutal value","'Expected value:"&strParameterValue&"'  is NOT same as 'Actual value:"&strActualValue&"' '"&strFieldName&"'")			
		End If
	End If
End Function


 ''''************************************************************''*************************************************************
''''''Function Name    : fGetAlphaNumbericOnly(strActualValue)
''''''Purpose              : This re-usable function helps to generate the alphanumeric values alone from the enered parameter
'''''''Created by       : Senthil 
'''''''Created date      : 10/11/2010
''''''Modified date      : 
''''************************************************************''*************************************************************
Public Function fGetAlphaNumbericOnly(strActualValue)
	If strActualValue <> "" Then
		strLenght = len(strActualValue)
		For l_inti = 1 to strLenght
			strExpectedValue = Mid(strActualValue,l_inti,1)
		If (Asc(Ucase(strExpectedValue)) >=65 And Asc(Ucase(strExpectedValue)) <=90 ) Or (Asc(Ucase(strExpectedValue)) >=48 And Asc(Ucase(strExpectedValue)) <=57 )  Then
			strExpectedAlphaNumericValue = strExpectedAlphaNumericValue + strExpectedValue
		End If
		Next
		fGetAlphaNumbericOnly = strExpectedAlphaNumericValue
	End If
End Function

''''************************************************************''*************************************************************
''''''Function Name    : fReportPass(strReportStepName,strReportDetail)
''''''Purpose              : This re-usable function helps to update the pass report          
'''''''Created by       : Senthil 
'''''''Created date      : 10/11/2010
''''************************************************************''*************************************************************
Public Function fReportPass(strReportStepName,strReportDetail)
	CRAFT_ReportEvent Environment.Value("ReportedEventSheet"), strReportStepName,strReportDetail, "Pass"   
End Function
''''************************************************************''*************************************************************
''''''Function Name    : fReportFail(strReportStepName,strReportDetail)
''''''Purpose              : This re-usable function helps to update the fail report          
'''''''Created by       : Senthil 
'''''''Created date      : 10/11/2010
''''************************************************************''*************************************************************
Public Function fReportFail(strReportStepName,strReportDetail)
	CRAFT_ReportEvent Environment.Value("ReportedEventSheet"), strReportStepName,strReportDetail, "Fail"   
End Function

















































