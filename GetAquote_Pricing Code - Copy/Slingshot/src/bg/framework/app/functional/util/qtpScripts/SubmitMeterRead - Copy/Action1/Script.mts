bpnumber=TestArgs("BpOrgNumber")
'bpnumber ="2002097867-601268752"
'bpnumber ="2001435420-600486112"
'Msgbox bpnumber
strSpli=split(bpnumber,"-")
bpnumber=strSpli(0)
accountnumber=strSpli(1)
'accountnumber ="601237608"

'Call invokeSAP()
'Replace Logon
'strFilePath = "\\Vfipffil104\bgr_tech_test\Automation\Billing"
'strFileName = "Saplogon.ini"
'set oFSO = createobject("Scripting.FileSystemObject")
'oFSO.CopyFile strFilePath & "\" & strFileName, "C:\Windows\Saplogon.ini", True

'Replace Logon

SAPGuiUtil.AutoLogon "QAS 01 ISU","300","G0000c","welcome4","EN"

	    Dim fso, f
		Set fso = createobject("Scripting.FileSystemObject")
		
		If (fso.FolderExists("C:\SAPData")) Then
			   fso.DeleteFolder("C:\SAPData")
		End If
			fso.CreateFolder("C:\SAPData") 
			Set objFile = fso.CreateTextFile( "C:\SAPData\SubmitMeterReadTest.txt",True)
           Call getMeterReadDetails(accountnumber)

            Set objFile=Nothing

Function getMeterReadDetails(accountnumber)
	 If Not SAPGuiSession("Session").SAPGuiWindow("wndSAPEasyAccess").Exist(5) Then
		 Exit Function
	 End If
  waitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndSAPEasyAccess").SAPGuiOKCode("OKCode"))
	 SAPGuiSession("Session").SAPGuiWindow("wndSAPEasyAccess").SAPGuiOKCode("OKCode").Set  "/n ECENV_BP"
	 SAPGuiSession("Session").SAPGuiWindow("wndSAPEasyAccess").SendKey ENTER
     waitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndDataEnvironmentBusiness"))
	 waitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndDataEnvironmentBusiness").SAPGuiEdit("edtBusiness Partner"))
	 SAPGuiSession("Session").SAPGuiWindow("wndDataEnvironmentBusiness").SAPGuiEdit("edtBusiness Partner").Set bpnumber
	 SAPGuiSession("Session").SAPGuiWindow("wndDataEnvironmentBusiness").SendKey ENTER
   
     If Not SAPGuiSession("Session").SAPGuiWindow("wndDataEnvironment").Exist(4) Then
		 Exit Function
     End If
'	 Call expandAccountNumber(accountnumber)
     Call getNumberOfGuiLabels()
	' SAPGuiSession("Session").Close

End Function
'(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((
Function waitForExistance(waitfor)

   Set waitObj=waitfor
	   For i=1 to 10
			  Wait(2)
			  If waitObj.Exist Then

				  Exit Function

			  End If
	   Next

End Function


'((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((
Function createDirectDebitTextFile()

	If (fso.FolderExists("C:\SAPData")) Then
	   fso.DeleteFolder("C:\SAPData")
	End If
	fso.CreateFolder("C:\SAPData") 
	Set objFile = fso.CreateTextFile( "C:\SAPData\tarrif.txt",True)

End Function
'(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((
   
Function invokeSAP()
       strFunctionStatus="True"
	   If SAPGuiSession("Session").Exist Then
           SAPGuiUtil.CloseConnections
	   End If
	   'SAPGuiUtil.AutoLogon "SAPGUI","300","sundarg1","welcome123","EN"
		'SystemUtil.Run "saplogon.exe"
		'SAPGuiUtil.AutoLogon "sapgui sapireci 01", "100","sundarg1","welcome123","EN"
		'SAPGuiUtil.AutoLogon "BGR - LQ6 - CRM Test", "100","sundarg1","welcome123","EN"
		wait 6
		'SAPGuiUtil.AutoLogon "saplogon", "300","sundarg1","welcome123","EN"
		
			If Dialog("text:=saplogon").WinButton("text:=OK").Exist(5) Then
					Dialog("text:=saplogon").WinButton("text:=OK").Click
			 Else
'			        strFunctionStatus="False"
'					Exit Function
			End If
		 
'				Dialog("text:=SAP Logon 710").WinTab("nativeclass:=SysTabControl32").Select "Systems     "
'			    Dialog("text:=SAP Logon 710").WinListView("nativeclass:=SysListView32").Select "sapgui"
'				Dialog("text:=SAP Logon 710").WinButton("text:=&Log On").Click
		wait 5
		If SAPGuiSession("Session").SAPGuiWindow("SAP").SAPGuiEdit("User").Exist Then
				SAPGuiSession("Session").SAPGuiWindow("SAP").SAPGuiEdit("User").Set "sundarg1"
				wait(3)
				SAPGuiSession("Session").SAPGuiWindow("SAP").SAPGuiEdit("Password").Set "welcome123"
				wait 2
				'SAPGuiSession("Session_6").SAPGuiWindow("SAP").SAPGuiEdit("Password").SetFocus
				SAPGuiSession("Session").SAPGuiWindow("SAP").SendKey ENTER
				wait 10
		Else
'		        strFunctionStatus="False"
'				Exit Function
		End If

		If  SAPGuiSession("Session_6").SAPGuiWindow("License Information for").Exist then
				SAPGuiSession("Session_6").SAPGuiWindow("License Information for").SAPGuiRadioButton("Continue with this logon,").Set
				SAPGuiSession("Session_6").SAPGuiWindow("License Information for").SAPGuiRadioButton("Continue with this logon,").SetFocus
				SAPGuiSession("Session_6").SAPGuiWindow("License Information for").SAPGuiButton("Confirm Selection   (Enter)").Click
				'SAPGuiSession("Session_6").SAPGuiWindow("Information").SAPGuiButton("Continue   (Enter)").Click
		End if
		
'		invokeSAP=strFunctionStatus
End Function
'""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
Function getSiteAddress()
		'Site address and MR number in Device
		If Not  SAPGuiSession("Session").SAPGuiWindow("wndDataEnvironment").Exist(4) Then
			   objFile.WriteLine ("LastMeterReadingDate :Null")
               objFile.WriteLine ("LastMeterReadValue :Null")
               objFile.WriteLine ("Site Address : Null")
			   objFile.WriteLine ("MeterSerialNumber : Null")
		  End If
		 waitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndDataEnvironment"))
		 SAPGuiSession("Session").SAPGuiWindow("wndDataEnvironment").SAPGuiLabel("Device").SetFocus
         SAPGuiSession("Session").SAPGuiWindow("wndDataEnvironment").SendKey F2
		 waitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndDisplayMaterialSerial"))
		 SAPGuiSession("Session").SAPGuiWindow("wndDisplayMaterialSerial").SAPGuiTabStrip("TABSTRIP").Select "General"
		 strMrNumber=Trim(SAPGuiSession("Session").SAPGuiWindow("wndDisplayMaterialSerial").SAPGuiEdit("edtMrNumber").GetROProperty("value"))
		 objFile.WriteLine ("MeterSerialNumber :")&strMrNumber  	
		 waitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndDisplayMaterialSerial"))
		
		 SAPGuiSession("Session").SAPGuiWindow("wndDisplayMaterialSerial").SAPGuiTabStrip("TABSTRIP").Select "Location"
'		 strStreet=Trim(SAPGuiSession("Session").SAPGuiWindow("wndDisplayMaterialSerial").SAPGuiEdit("edtStreet").GetROProperty("value"))
'		 strLocation1=Trim(SAPGuiSession("Session").SAPGuiWindow("wndDisplayMaterialSerial").SAPGuiEdit("edtLocation1").GetROProperty("value"))
'		 strLocation2=Trim(SAPGuiSession("Session").SAPGuiWindow("wndDisplayMaterialSerial").SAPGuiEdit("edtLocation2").GetROProperty("value"))
'		 strLocation=strStreet&", "&strLocation1&", "&strLocation2
        SAPGuiSession("Session").SAPGuiWindow("wndDisplayMaterialSerial").SAPGuiButton("btnDisplay").Click
		waitForExistance(SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display"))
		loc1 = appendValues(SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display").SAPGuiEdit("edtHouse").GetROProperty("value"))	
		loc2 = appendValues(SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display").SAPGuiEdit("edtStreet").GetROProperty("value"))
	'	loc3=	appendValues(SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display").SAPGuiEdit("edtStreet3").GetROProperty("value"))		
		loc4=appendValues(SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display").SAPGuiEdit("edtCity").GetROProperty("value"))
        loc5=appendValues(SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display").SAPGuiEdit("edtPostcode").GetROProperty("value"))		
		loc6=appendValues(SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display").SAPGuiEdit("PO Box").GetROProperty("value"))		
		loc7=appendValues( SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display").SAPGuiEdit("Postal Code").GetROProperty("value"))	
		billAddr = loc1&loc2&loc4&loc5&loc6&loc7
		billAddr=Left(billAddr,len(billAddr)-2)
         SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display").SAPGuiButton("btnClose").Click
         waitForExistance(SAPGuiSession("Session"))
		 objFile.WriteLine ("Site Address:")&billAddr  		 

End Function
'Function appendValues(strValue)
'   strState = "False"
'   strChar = ","
'   If  strValue != "" Then
'		If  strState="True" Then
'			strState = "False"
'		Else
'			strState = "True"
'		End If
'		 strLocation =strValue&strChar
'   End If
'   
'
'End Function
''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
     Function getLastMeterReadValue()
          If Not  SAPGuiSession("Session").SAPGuiWindow("wndDataEnvironment").Exist(4) Then
			   objFile.WriteLine ("LastMeterReadingDate :Null")
               objFile.WriteLine ("LastMeterReadValue :Null")
               objFile.WriteLine ("Site Address : Null")
		  End If
		 'Last meter read date and Last meter read value in Installation
         SAPGuiSession("Session").SAPGuiWindow("wndDataEnvironment").SAPGuiLabel("IS-U Installation").SetFocus
         SAPGuiSession("Session").SAPGuiWindow("wndDataEnvironment").SendKey F2
         waitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndDisplayInstallation"))
         SAPGuiSession("Session").SAPGuiWindow("wndDisplayInstallation").SAPGuiButton("btnBillingPeriods").Click
         If Not SAPGuiSession("Session").SAPGuiWindow("wndBillingViewofInstallation").Exist(4) Then
			 Exit Function
		 End If
		 SAPGuiSession("Session").SAPGuiWindow("wndBillingViewofInstallation").SAPGuiTabStrip("tabMYTABSTRIP").Select "MR result"
         waitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndBillingViewofInstallation"))
		 strLastMrReadingDate=SAPGuiSession("Session").SAPGuiWindow("wndBillingViewofInstallation").SAPGuiGrid("grdBillingRelevantMeterReading").GetCellData(1,"Meter reading date")
		 objFile.WriteLine ("LastMeterReadingDate :")&strLastMrReadingDate

		 strLastMrReadValue=Trim(SAPGuiSession("Session").SAPGuiWindow("wndBillingViewofInstallation").SAPGuiGrid("grdBillingRelevantMeterReading").GetCellData(1,"Meter read. f. billing"))
		  If instr(strLastMrReadValue,".") Then
			 strLastMrReadValue=replace(strLastMrReadValue,".","")
			 If instr(strLastMrReadValue,",") Then
				 strsplit=split(strLastMrReadValue,",")
                 strLastMrReadValue=strsplit(0)
			 End If
		 End If
		 If strLastMrReadValue="" Then
			 strLastMrReadValue="Null"
		 End If
		 
		 objFile.WriteLine ("LastMeterReadValue :")&strLastMrReadValue
	     SAPGuiSession("Session").SAPGuiButton("btnBackButton").Click
		 SAPGuiSession("Session").SAPGuiButton("btnBackButton").Click
         
	 End Function
''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
Function expandAccountNumber(accountnumber)

		SAPGuiSession("Session").SAPGuiWindow("wndDataEnvironment_2").SAPGuiButton("Collapse subtree   (Ctrl+Shift").Click
		Wait(15)
		Set MyDescription=SAPGuiLabel	
		Set label = SAPGuiSession("Session").SAPGuiWindow("wndDataEnvironment").ChildObjects(MyDescription)     
		NoOfChildObjs = label.count 
		
		'Msgbox NoOfChildObjs
		Counts=0
		contractAccNumber =0
		For Counter=0 to NoOfChildObjs-1      
			   conditionContractno=label(Counter).getroproperty("content")
				If  Trim(conditionContractno) = Trim(accountnumber) Then
					SAPGuiSession("Session").SAPGuiWindow("wndDataEnvironment").SAPGuiLabel("content:="&conditionContractno).Setfocus
					Wait(10)
					SAPGuiSession("Session").SAPGuiWindow("wndDataEnvironment_2").SAPGuiButton("Expand subtree   (Ctrl+Shift+F").Click
					Wait(10)
					Exit For
				End If
	
		Next 
	
End Function

'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
Function getNumberOfGuiLabels()
	
	Set MyDescription=SAPGuiLabel
	
	'Set MyDescription="Contract Account"
	'MyDescription("content").Value = Contract Account
	Set label = SAPGuiSession("Session").SAPGuiWindow("wndDataEnvironment").ChildObjects(MyDescription) 
    
	NoOfChildObjs = label.count 
	
	'Msgbox NoOfChildObjs
	Counts=0
	contractAccNumber =0
	For Counter=0 to NoOfChildObjs-1      
		   conditionContractno=label(Counter).getroproperty("content")
			If  conditionContractno = "IS-U Installation" Then
				
				 Call getLastMeterReadValue()
		    End If
            If  conditionContractno ="Device" Then
				 
				 Call getSiteAddress()						
		   End If
	Next 
	
End Function		

Function appendValues(strValue)

   strState = "False"
   strChar = ", "
   If  strValue <> "" Then
		If  strState="True" Then
			strState = "False"
		Else
			strState = "True"
		End If
		 strValue =strValue&strChar
   End If   
	appendValues=strValue

End Function



















