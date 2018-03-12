'Set gobjFso = CreateObject("Scripting.FileSystemObject")
'Set gobjQtpApp = CreateObject("QuickTest.Application")
'
'
''Getting the current project path
'astrProjectPath = Split(Environment.value("TestDir"),"\BillGeneration")
'gstrProjectPath = astrProjectPath(0)
'
''Geting the systemdate time to create the report and log file with execution date and time
'gstrTimeStamp = "On" & "_" & Replace(Date(),"/","-") & "_" & Replace(Time(),":","-")
'
''Using the Project Path getting the path for all the support files
'strInputDataPath = gstrProjectPath&"\Input\InputData.xls"
'strSupportFunctions = gstrProjectPath&"\Library\SupportFunctions.vbs"
'strApplicationFunctions = gstrProjectPath&"\Library\ApplicationFunctions.vbs"
'strResult = gstrProjectPath&"\Output\Output_"&gstrTimeStamp&".xls"
'
'Set objExcel = CreateObject("Excel.Application")
'Set objInputWorkbook = objExcel.Workbooks.Open(strInputDataPath)
'Set gobjInputSheet = objInputWorkbook.Worksheets(1)
'Set gobjInputConfigSheet = objInputWorkbook.Worksheets(2)
'Set objWorkbook = objExcel.Workbooks.Add
'objWorkbook.Worksheets(2).Delete
'objWorkbook.Worksheets(2).Delete
'objWorkbook.Worksheets(1).Name = "Output"
'objWorkbook.SaveAs(strResult)
'objWorkbook.Close
'Set objOuputWorkbook = objExcel.Workbooks.Open(strResult)
'Set gobjOutputSheet = objOuputWorkbook.Worksheets(1)
'
'ExecuteFile strSupportFunctions
'ExecuteFile strApplicationFunctions
'AssociateRepositories
'
'strSAPEnvironment = Trim(gobjInputConfigSheet.cells(2,4).value)
'gsblUsername = Trim(gobjInputConfigSheet.cells(2,5).value)
'gsblPassword = Trim(gobjInputConfigSheet.cells(2,6).value)
'pstrPaymentOption = Trim(gobjInputConfigSheet.cells(2,7).value)
'gstrPaymentTillMonth = Trim(gobjInputConfigSheet.cells(2,8).value)

'ReportLog "Invoking SAP"
'InvokeSAP
'Reporter.ReportEvent micDone, "SAP Invoke", "SAP application invoked successfully"
'ReportLog "Loging in  SAP"
'SAPLogin
'Reporter.ReportEvent micDone, "SAP Login", "SAP application logged in  successfully"
'
'AddOuputParamaters


















'strPath = Environment.Value("TestDir")
'Datatable.Import(strPath&".xls")
'msgbox strPath
'msgbox Datatable.Import("D:\\BGBBillGeneration\\BillGeneration.xls")
For i=1 to 1
     
'	intInstalltion= (Datatable("Installation",dtglobalsheet))

'	If  intInstalltion <>""  Then
	  intInstalltion="2001624575"
	   msgbox intInstalltion
		Call checkReverseMeterRead(intInstalltion)
	    Call openMeterReadingWindow()
		dtmMeterReadingDate =  getMeterReadingDate(intInstalltion)
		dtmToday = Replace(FormatDateTime(Cdate(Date),0),"/",".")
		dtmDateCheck = fCompareDate(dtmMeterReadingDate,dtmToday)
		If dtmDateCheck="True" Then
			Call createOrder(intInstalltion, dtmMeterReadingDate)
			Call executeSingleQuery(intInstalltion)
			Call submitMeterReads()
			Call printBill()		
		Else
			Datatable("Result",dtglobalsheet)="MR date is lessthan 6 months"
		End If
	 'Else

'	End If

   Datatable.SetNextRow
Next

' Datatable.Export(strPath&".xls")
'SystemUtil.Run("C:\Saplogon1.vbs")
'SystemUtil.Run("C:\Saplogon1.vbs")


Function openMeterReadingWindow()
	SAPGuiSession("Session").Reset
	If  SAPGuiSession("Session").SAPGuiWindow("wndSAPEasyAccess").Exist (3) Then
		SAPGuiSession("Session").SAPGuiWindow("wndSAPEasyAccess").SAPGuiOKCode("okcOKCode").Set "/n el31"
		SAPGuiSession("Session").SAPGuiWindow("wndSAPEasyAccess").SendKey ENTER 
	End If

End Function

Function getMeterReadingDate(intInstalltion)

	If  SAPGuiSession("Session").SAPGuiWindow("wndMonitoringMeterReading").Exist Then 
		SAPGuiSession("Session").SAPGuiWindow("wndMonitoringMeterReading").SAPGuiButton("btnInstallation").Click 
		objWaitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndMonitoringMeterReading").SAPGuiEdit("edtInstallation"))
		SAPGuiSession("Session").SAPGuiWindow("wndMonitoringMeterReading").SAPGuiEdit("edtInstallation").Set intInstalltion
		objWaitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndMonitoringMeterReading").SAPGuiButton("btnMeterReadingResult"))
		SAPGuiSession("Session").SAPGuiWindow("wndMonitoringMeterReading").SAPGuiButton("btnMeterReadingResult").Click 
		SAPGuiSession("Session").SAPGuiWindow("wndMonitoringMeterReading").SAPGuiButton("btnExecute").Click 
		'objWaitForExistance ( SAPGuiSession("Session").SAPGuiWindow("wndMeterReadingResults"))
	End If

	If  SAPGuiSession("Session").SAPGuiWindow("wndMeterReadingResults").Exist(15) Then
		SAPGuiSession("Session").SAPGuiWindow("wndMeterReadingResults").SAPGuiGrid("grdGridViewCtrl").SelectColumn "Meter reading date" 
		dtmLastMeterReadingDate = SAPGuiSession("Session").SAPGuiWindow("wndMeterReadingResults").SAPGuiGrid("grdGridViewCtrl").GetCellData(1,"Meter reading date")
		SAPGuiSession("Session").Reset	
	Else
		Datatable("Result",dtglobalsheet)="Data is not valid"
		Datatable.Export(strPath&".xls")
		Reporter.ReportEvent micWarning,"Meter reading:","Meter Reading does not exist for "&intInstalltion
		ExitAction
	End If

	getMeterReadingDate = dtmLastMeterReadingDate	

End Function

Function createOrder(intInstalltion, dtmMeterReadingDate)
	SAPGuiSession("Session").Reset
   If SAPGuiSession("Session").SAPGuiWindow("wndSAPEasyAccess").Exist Then
		SAPGuiSession("Session").SAPGuiWindow("wndSAPEasyAccess").SAPGuiOKCode("okcOKCode").Set "/nel01" 
		SAPGuiSession("Session").SAPGuiWindow("wndSAPEasyAccess").SendKey ENTER 
		objWaitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndExecuteOrderCreation"))
		SAPGuiSession("Session").SAPGuiWindow("wndExecuteOrderCreation").SAPGuiRadioButton("rdbInstallation").Set 
		SAPGuiSession("Session").SAPGuiWindow("wndExecuteOrderCreation").SAPGuiEdit("edtInstallation").Set intInstalltion
		SAPGuiSession("Session").SAPGuiWindow("wndExecuteOrderCreation").SAPGuiEdit("edtMRRsn").Set "01" 
		SAPGuiSession("Session").SAPGuiWindow("wndExecuteOrderCreation").SAPGuiButton("btnExecute").Click 
		objWaitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndListScheduleRecords"))
   End If

	If SAPGuiSession("Session").SAPGuiWindow("wndListScheduleRecords").Exist Then
		'SAPGuiSession("Session").SAPGuiWindow("List of Schedule Records:").SAPGuiGrid("List of schedule records").SelectColumn "Sched. MR date"
		'SAPGuiSession("Session").SAPGuiWindow("List of Schedule Records:").SAPGuiGrid("List of schedule records").SelectColumn "Sched. MR date"		
		 dtmToday = Replace(FormatDateTime(Cdate(Date),0),"/",".")
		Call setFilterForSchedMRDateField(dtmMeterReadingDate,dtmToday)
		intNoOfRecords = SAPGuiSession("Session").SAPGuiWindow("wndListScheduleRecords").SAPGuiGrid("grdScheduleRecords").RowCount
		Reporter.ReportEvent micDone,"Number of records","Number of records: "&intNoOfRecords
		For inti=1 to intNoOfRecords
		dtmSchdMRDate = SAPGuiSession("Session").SAPGuiWindow("wndListScheduleRecords").SAPGuiGrid("grdScheduleRecords").GetCellData (inti,"Sched. MR date")
			'blnFunctCheck=fCompareDate(dtmMeterReadingDate,dtmSchdMRDate)
			'If  blnFunctCheck="True" Then
					Reporter.ReportEvent micDone,"Number of order created","Number of order created: "& inti
                 SAPGuiSession("Session").SAPGuiWindow("wndListScheduleRecords").SAPGuiGrid("grdScheduleRecords").ClickCell inti , "Sched. MR date"
				 objWaitForExistance (SAPGuiSession("Session").SAPGuiWindow("wndDisplayScheduleRecord:").SAPGuiButton("btnCreateOrder"))
				SAPGuiSession("Session").SAPGuiWindow("wndDisplayScheduleRecord:").SAPGuiButton("btnCreateOrder").Click
				wait 3
				If  SAPGuiSession("Session").SAPGuiWindow("wndExecuteOrderCreation").SAPGuiStatusBar("stbStatusBar").Exist Then
					strStatusMsg = SAPGuiSession("Session").SAPGuiWindow("wndExecuteOrderCreation").SAPGuiStatusBar("stbStatusBar").GetROProperty("text")
					If  inStr(strStatusMsg , "Meter reading orders and/or billing orders created for installation ")  Then
						Reporter.ReportEvent micPass, "Meter read order is creation status","Meter read order is created already"
					End If
				End If

				If  SAPGuiSession("Session").SAPGuiWindow("wndInformation").Exist Then
						SAPGuiSession("Session").SAPGuiWindow("wndInformation").SAPGuiButton("btnContinue").Click
				End If

				If  SAPGuiSession("Session").SAPGuiWindow("wndInformation").Exist Then
						SAPGuiSession("Session").SAPGuiWindow("wndInformation").SAPGuiButton("btnContinue").Click
						Datatable("Result",dtglobalsheet)="Data is not valid"
				End If

				If  SAPGuiSession("Session").SAPGuiWindow("wndExecuteOrderCreation").SAPGuiButton("btnExecute").Exist Then
					SAPGuiSession("Session").SAPGuiWindow("wndExecuteOrderCreation").SAPGuiButton("btnExecute").Click
					wait 2
				End If
								
			'End If
			Call setFilterForSchedMRDateField(dtmMeterReadingDate,dtmToday)
		Next

	End If

End Function

Function fCompareDate(dtmMeterReadingDate,dtmToday)
          flgClick="False"
           intYear=DateDiff("YYYY",Replace(dtmMeterReadingDate,".","/"),Replace(dtmToday,".","/"))
		   intMonth=DateDiff ("m",Replace(dtmMeterReadingDate,".","/"),Replace(dtmToday,".","/"))
		   intDay=DateDiff("d",Replace(dtmMeterReadingDate,".","/"),Replace(dtmToday,".","/"))  

          'dtmToday = Replace(FormatDateTime(Cdate(Date),0),"/",".")

'			intYear1=DateDiff("YYYY",Replace(dtmSchdMRDate,".","/"),Replace(dtmToday,".","/"))
'		   intMonth1=DateDiff ("m",Replace(dtmSchdMRDate,".","/"),Replace(dtmToday,".","/"))
'		   intDay1=DateDiff("d",Replace(dtmSchdMRDate,".","/"),Replace(dtmToday,".","/")) 

           If  intYear>= 0 and  intMonth>=6 Then  
			  ' If  intYear1>= 0 and  intMonth1>=0 and  intDay1>=0 Then
				'Reporter.ReportEvent micPass,"year is lesser than MRdate","MRScdDate: "& dtmSchdMRDate&"LastmeterReading date: "& dtmMeterReadingDate
				Reporter.ReportEvent micPass,"Bill created date ","Last meter reading date: "&dtmMeterReadingDate&"Sched MR Date:  "&dtmSchdMRDate
				flgClick="True"
			   'End If
			End If

    fCompareDate=flgClick

End Function

Function executeSingleQuery(intInstalltion) 
	SAPGuiSession("Session").Reset
	SAPGuiSession("Session").SAPGuiWindow("wndSAPEasyAccess").SAPGuiOKCode("okcOKCode").Set "/nel28"
	SAPGuiSession("Session").SAPGuiWindow("wndSAPEasyAccess").SendKey ENTER 
	SAPGuiSession("Session").SAPGuiWindow("wndExecuteSingleEntry").SAPGuiRadioButton("rdbInstallation").Set 
	SAPGuiSession("Session").SAPGuiWindow("wndExecuteSingleEntry").SAPGuiEdit("edtInstallation").Set intInstalltion
	SAPGuiSession("Session").SAPGuiWindow("wndExecuteSingleEntry").SendKey ENTER
	'objWaitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndPremisesWithMeterReading"))
End Function

Function submitMeterReads()
	
	If  SAPGuiSession("Session").SAPGuiWindow("wndPremisesWithMeterReading").Exist Then 
		SAPGuiSession("Session").SAPGuiWindow("wndPremisesWithMeterReading").SAPGuiButton("btnSelectAll").Click
		SAPGuiSession("Session").SAPGuiWindow("wndPremisesWithMeterReading").SAPGuiButton("btnApplySelection").Click
		objWaitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndSingleEntry"))
	
		Do while SAPGuiSession("Session").SAPGuiWindow("wndSingleEntry").Exist
			SAPGuiSession("Session").SAPGuiWindow("wndSingleEntry").SAPGuiButton("btnSelectAll").Click
			SAPGuiSession("Session").SAPGuiWindow("wndSingleEntry").SAPGuiButton("btnEstimate").Click
			objWaitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndSingleEntry").SAPGuiButton("btnSave"))
			SAPGuiSession("Session").SAPGuiWindow("wndSingleEntry").SAPGuiButton("btnSave").Click
		Loop
	End If
	
End Function
	
Function printBill()
	If  SAPGuiSession("Session").SAPGuiWindow("wndSingleEntry").Exist Then
			SAPGuiSession("Session").SAPGuiWindow("wndSingleEntry").SAPGuiButton("btnSelectAll").Click
			SAPGuiSession("Session").SAPGuiWindow("wndSingleEntry").SAPGuiButton("btnEstimate").Click
			objWaitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndSingleEntry").SAPGuiButton("btnSave"))
			SAPGuiSession("Session").SAPGuiWindow("wndSingleEntry").SAPGuiButton("btnSave").Click 
	End If
	SAPGuiSession("Session").SAPGuiWindow("wndExecuteSingleEntry").SAPGuiOKCode("okcOKCode").Set "/n easibi" 
	SAPGuiSession("Session").SAPGuiWindow("wndExecuteSingleEntry").SendKey ENTER
	SAPGuiSession("Session").SAPGuiWindow("wndIndividualBill").SAPGuiRadioButton("rdbPrintbill").Set 
	SAPGuiSession("Session").SAPGuiWindow("wndIndividualBill").SAPGuiRadioButton("rdbPrintbill").SetFocus
	SAPGuiSession("Session").SAPGuiWindow("wndIndividualBill").SAPGuiButton("btnExecute").Click
	
	If  SAPGuiSession("Session").SAPGuiWindow("WndCheckingReconciliation").SAPGuiButton("btnYes").Exist Then
		SAPGuiSession("Session").SAPGuiWindow("WndCheckingReconciliation").SAPGuiButton("btnYes").Click
		'Reporter.ReportEvent micFail,"Error exist ","Error exist while creating bills"
		'ExitAction
	End If
	
	'objWaitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndSelectBillingDocuments").SAPGuiButton("btnContinue"))
	
	If  SAPGuiSession("Session").SAPGuiWindow("wndSelectBillingDocuments").Exist Then	
		SAPGuiSession("Session").SAPGuiWindow("wndSelectBillingDocuments").SAPGuiButton("btnContinue").Click 
		objWaitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndChoosePrintParameter")) 
		SAPGuiSession("Session").SAPGuiWindow("wndChoosePrintParameter").SAPGuiEdit("btnOutputDevice").Set "Z_SPOOL_ONLY_1024_COL"
		SAPGuiSession("Session").SAPGuiWindow("wndChoosePrintParameter").SAPGuiButton("btnContinue").Click

		If  SAPGuiSession("Session").SAPGuiWindow("wndError").Exist Then
			SAPGuiSession("Session").SAPGuiWindow("wndError").SAPGuiButton("btnConfirm").Click
		End If

		Do WHILE SAPGuiSession("Session").SAPGuiWindow("wndChoosePrintParameter").SAPGuiEdit("btnOutputDevice").Exist
		SAPGuiSession("Session").SAPGuiWindow("wndChoosePrintParameter").SAPGuiButton("btnContinue").Click
		Loop
	
		Reporter.ReportEvent micPass,"Bill Generation is done","Bill is generated for "&intInstalltion
		DataTable ("Result",dtglobalSheet)="Bill is generated upto date!!!"
	End If

	objWaitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndIndividualBill").SAPGuiButton("btnLog"))
	SAPGuiSession("Session").SAPGuiWindow("wndIndividualBill").SAPGuiButton("btnLog").Click

End Function

Function setFilterForSchedMRDateField(dtmStartDate, dtmToDate)

	If  SAPGuiSession("Session").SAPGuiWindow("wndInformation").SAPGuiButton("btnContinue").Exist Then
		SAPGuiSession("Session").SAPGuiWindow("wndInformation").SAPGuiButton("btnContinue").Click
		ExitAction
	End If

	SAPGuiSession("Session").SAPGuiWindow("wndScheduleRecordsList").SAPGuiToolbar("tlbGridToolbar").PressContextButton "&MB_FILTER" 
	objWaitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndScheduleRecordsList").SAPGuiToolbar("tlbGridToolbar"))
	SAPGuiSession("Session").SAPGuiWindow("wndScheduleRecordsList").SAPGuiToolbar("tlbGridToolbar").SelectMenuItemById "&FILTER"
	objWaitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndDefineFilterCriteria").SAPGuiGrid("grdColumnSet"))
	intRowNumber = SAPGuiSession("Session").SAPGuiWindow("wndDefineFilterCriteria").SAPGuiGrid("grdColumnSet").FindRowByCellContent("Column Name","Sched. MR date") 
	SAPGuiSession("Session").SAPGuiWindow("wndDefineFilterCriteria").SAPGuiGrid("grdColumnSet").SelectRow intRowNumber
	SAPGuiSession("Session").SAPGuiWindow("wndDefineFilterCriteria").SAPGuiButton("btnAddFilterCriterion").Click
	SAPGuiSession("Session").SAPGuiWindow("wndDefineFilterCriteria").SAPGuiButton("btnFilterVals").Click 
	objWaitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndDetermineValuesFilter")) 
	SAPGuiSession("Session").SAPGuiWindow("wndDetermineValuesFilter").SAPGuiEdit("edtSchedMRDate").Set dtmStartDate 
	SAPGuiSession("Session").SAPGuiWindow("wndDetermineValuesFilter").SAPGuiEdit("edtTo").Set dtmToDate
	SAPGuiSession("Session").SAPGuiWindow("wndDetermineValuesFilter").SAPGuiButton("btnExecute").Click 
	objWaitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndScheduleRecordsList").SAPGuiGrid("grdScheduleRecordsList"))
	SAPGuiSession("Session").SAPGuiWindow("wndScheduleRecordsList").SAPGuiGrid("grdScheduleRecordsList").SelectColumn "Sched. MR date"
End Function

Function objWaitForExistance(obj)

	For inti = 1 to 20
		wait 2
		if obj.Exist then
			Exit For
		End if
	Next

End Function




Function checkReverseMeterRead(intInstalltion)
	SAPGuiSession("Session_3").Reset
	SAPGuiSession("Session").SAPGuiOKCode("okcOKCode").Set "/nel37"
	'SAPGuiSession("Session_3").SAPGuiWindow("SAP Easy Access").SAPGuiOKCode("OKCode").Set "/nel37" 
	SAPGuiSession("Session_3").SAPGuiWindow("SAP Easy Access").SAPGuiButton("Enter").Click 
	If SAPGuiSession("Session_3").SAPGuiWindow("Reverse Meter Reading").Exist Then
		SAPGuiSession("Session_3").SAPGuiWindow("Reverse Meter Reading").SAPGuiEdit("Installation").SetFocus
		SAPGuiSession("Session_3").SAPGuiWindow("Reverse Meter Reading").SAPGuiEdit("Installation").Set intInstalltion 
		SAPGuiSession("Session_3").SAPGuiWindow("Reverse Meter Reading").SAPGuiButton("Execute   (F8)").Click 
		objWaitForExistance(SAPGuiSession("Session_3").SAPGuiWindow("Reverse Meter Reading_2").SAPGuiToolbar("GridToolbar"))
		SAPGuiSession("Session_3").SAPGuiWindow("Reverse Meter Reading_2").SAPGuiToolbar("GridToolbar").PressButton "MARK" 
		SAPGuiSession("Session_3").SAPGuiWindow("Reverse Meter Reading_2").SAPGuiMenubar("mbar").Select "Edit;Select All" 
		SAPGuiSession("Session_3").SAPGuiWindow("Reverse Meter Reading_2").SAPGuiMenubar("mbar").Select "Edit;Reverse" 
		objWaitForExistance(SAPGuiSession("Session_3").SAPGuiWindow("Display logs"))
		If 	SAPGuiSession("Session_3").SAPGuiWindow("Display logs").Exist Then
			Reporter.ReportEvent micPass,"Meter read reverse status","Meter read reversed successfully"
		End If
	End If

	If  SAPGuiSession("Session_3").SAPGuiWindow("Information_2").Exist Then
		SAPGuiSession("Session_3").SAPGuiWindow("Information_2").SAPGuiButton("Continue   (Enter)").Click 
		Reporter.ReportEvent micPass,"Meter read reverse status","Meter read does not exist for this account"
	End If
End Function




