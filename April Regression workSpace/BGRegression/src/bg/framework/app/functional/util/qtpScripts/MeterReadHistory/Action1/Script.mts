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

Call  lfMeterReadValidation


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
	
		strAccountNumber= TestArgs("AccNumber")
		'strAccountNumber= "850026029761"

	
		
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
   SAPGuiUtil.AutoLogon "ETE 03_ISU_JQA", "100", "arumugam", "password12", "EN"
 End Function

'============================================================================================
'Component Name:     SAP_ISU_ZBOV_MeterReadValidation
' ----------------------------------------------------------------------------------------------------------------------------------------------------------------
' Description:  This component is used for trancaction CIC0 for  HomeMove  Gas Electricity  balanceVerify
' ----------------------------------------------------------------------------------------------------------------------------------------------------------------
'Dependencies:N/A
' ----------------------------------------------------------------------------------------------------------------------------------------------------------------
' Created By: Cognizant
'Notes:
' -----------------------------------------------------------------------------------------------------------------------------------------------------------------
' Date: 08 thJul 2013
' ----------------------------------------------------------------------------------------------------------------------------------------------------------------
'Modification History’: N/A
'============================================================================================
Function lfMeterReadValidation()
'Forcing Variable Declarations
Option Explicit

'**************************************************************************
'Declarations
'**************************************************************************
Dim intAccRowCount , intAccIncremnter , intRegTypeCounter , intMRCounter , intDeviceRowCount , intInc,intMeterReadCount, intMeterInc
Dim strDivision, strValid, strDeviceName, strGasDeviceName, strmeterRead, strMeterDate, strElecDeviceName
Dim strmeterReadActual, strMeterDateActual,strDeviceActual
Dim fso, objNotepad




'Creates a Notepad for writing the Meter read
Set fso = CreateObject("Scripting.FileSystemObject")
Set objNotepad = fso.CreateTextFile("C:\SAPData\meterread1.txt",True)
objNotepad.WriteLine("Meter Read History " & vbcrlf)

Dim strAccountNumber = TestArgs("AccNumber")
   Call InvokeSAP
	Call SAPLogin

'Resets the SAPsession
SAPGuiSession("BGR_Session").Reset


SAPGuiSession("BGR_Session").SAPGuiWindow("wndSAPEasyAccess").Maximize
SAPGuiSession("BGR_Session").SAPGuiWindow("wndSAPEasyAccess").SAPGuiOKCode("okcOKCode").Set "zbov"
SAPGuiSession("BGR_Session").SAPGuiWindow("wndSAPEasyAccess").SendKey ENTER

SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingOverviewInitial").SAPGuiEdit("edtContractAccount").Set strAccountNumber
SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingOverviewInitial").SendKey ENTER

SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingOverview").Maximize
SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingOverview").Maximize
intAccRowCount = SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingOverview").SAPGuiGrid("GridViewCtrl").RowCount

'For JI the two rows are considered for processing if not will be processed only for one 
For intAccIncremnter = 1 TO intAccRowCount
	intRegTypeCounter = 0
	intMRCounter = 0
	strDivision = SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingOverview").SAPGuiGrid("GridViewCtrl").GetCellData(intAccIncremnter, "Division")
	SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingOverview").SAPGuiGrid("GridViewCtrl").SelectCell intAccIncremnter,"Customer Segment"
	SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingOverview").SAPGuiGrid("GridViewCtrl").SelectRow intAccIncremnter
	 
	SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingOverview").SAPGuiGrid("GridViewCtrl").SelectMenuItemById "INSTBV"
	SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingViewofInstallation").SAPGuiTabStrip("stpMYTABSTRIP").Select "Register"

	'Gets the Device names 
	intDeviceRowCount = SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingViewofInstallation").SAPGuiGrid("grdBilling-RelevantRegister").RowCount
	For intInc = 1 To intDeviceRowCount
		 strValid = SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingViewofInstallation").SAPGuiGrid("grdBilling-RelevantRegister").GetCellData( intInc,"Valid to")

		If  strValid = "31.12.9999" Then
			strDeviceName = SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingViewofInstallation").SAPGuiGrid("grdBilling-RelevantRegister").GetCellData( intInc,"Serial Number")
			intRegTypeCounter = Cint(intRegTypeCounter) + 1
		End If
	Next
	
	If  Instr(strDivision,"Gas") > 0 Then
		strGasDeviceName = strDeviceName
		strmeterRead = "Gas"
		strMeterDate = "Gas"
		objNotepad.WriteLine(vbcrlf & strmeterRead)
	ElseIf Instr(strDivision,"Electricity")> 0  Then
		strElecDeviceName = strDeviceName
		strmeterRead = "Electricity"
		strMeterDate = "Electricity"
		objNotepad.WriteLine(vbcrlf & strmeterRead)
	End If
	SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingViewofInstallation").SAPGuiButton("btnBack").Click


	'Gets the Meter REad Details 
	intMeterReadCount = SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingOverview").SAPGuiGrid("grdMeterReadingHistory").RowCount
	For intMeterInc = 1 To intMeterReadCount
		strDeviceActual = SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingOverview").SAPGuiGrid("grdMeterReadingHistory").GetCellData(intMeterInc,"Device")
		If  Instr(strDeviceName,strDeviceActual) >0 Then
			strmeterReadActual = SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingOverview").SAPGuiGrid("grdMeterReadingHistory").GetCellData(intMeterInc,"Meter reading recorded")

			'Gets the date and format that into dd MonthName yyyy
			strMeterDateActual = SAPGuiSession("BGR_Session").SAPGuiWindow("wndBillingOverview").SAPGuiGrid("grdMeterReadingHistory").GetCellData(intMeterInc,"Meter reading date")
			strMeterDateActual = Replace(strMeterDateActual,".","/")
			strMeterDateActual = Cdate(strMeterDateActual)
			strMeterDateActual= FormatDateTime(strMeterDateActual,1)
			arrMeterReadSplit = Split(strMeterDateActual," ")
			strMeterDateActual = arrMeterReadSplit(0) &" " & Left(arrMeterReadSplit(1),3) &" " & arrMeterReadSplit(2)

			'amends all the meter read date and meter read 
			strMeterDate = strMeterDate & ";" & strMeterDateActual
			strmeterRead = strmeterRead & ";" & strmeterReadActual
			
			intMRCounter = Cint(intMRCounter) +1 
		End If
		
		If  intMRCounter = (Cint(intRegTypeCounter) * 3) Then
			Exit For 
		End If
	
	Next
	objNotepad.WriteLine(strMeterDate & vbCrLf & strmeterRead)
Next


objNotepad.Close


Set objNotepad = Nothing
Set fso = Nothing


End Function

