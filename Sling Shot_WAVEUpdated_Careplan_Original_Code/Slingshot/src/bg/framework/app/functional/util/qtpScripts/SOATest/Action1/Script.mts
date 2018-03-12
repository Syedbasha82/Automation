'bpnumber=TestArgs("BpOrgNumber")
'bpnumber ="2002097867"
bpnumber ="2000326658-600227960"
'Msgbox bpnumber
strSpli=split(bpnumber,"-")
bpnumber=strSpli(0)
accountnumber=strSpli(1)
'bpnumber="2001559653"
'accountnumber ="600544955"



SAPGuiUtil.CloseConnections

SAPGuiUtil.AutoLogon "QAS 04 ISU","300","g0000c","welcome8","EN"

	    Dim fso, f
		Set fso = createobject("Scripting.FileSystemObject")
		
		If (fso.FolderExists("C:\SAPSOAData")) Then
			   fso.DeleteFolder("C:\SAPSOAData")
		End If
			fso.CreateFolder("C:\SAPSOAData") 
			Set objFile =fso.CreateTextFile( "C:\SAPSOAData\StatementOfAccount.txt",True)

                  'Set objFile=Nothing


SAPGuiSession("Session").SAPGuiOKCode("okcSubmit").Set "/nfpl9"
SAPGuiSession("Session").SAPGuiButton("btnEnter").Click


SAPGuiSession("Session").SAPGuiWindow("wndAccountDisplay").SAPGuiCheckBox("ALV Grid").Set("ON")

SAPGuiSession("Session").SAPGuiWindow("wndAccountDisplay").SAPGuiEdit("edtContractAcct").Set accountnumber
SAPGuiSession("Session").SAPGuiWindow("wndAccountDisplay").SAPGuiButton("btnEnter").Click

SAPGuiSession("Session").SAPGuiWindow("wndResults").SAPGuiTabStrip("tabchro").Select "Chronology" 
SAPGuiSession("Session").SAPGuiWindow("wndResults").SAPGuiGrid("grdrecv").SelectColumn "Posting Date" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf35.xml_;_
SAPGuiSession("Session").SAPGuiWindow("wndResults").SAPGuiToolbar("GridToolbar").PressButton "&SORT_DSC" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf33.xml_;_
SAPGuiSession("Session").SAPGuiWindow("wndResults").SAPGuiToolbar("GridToolbar").PressButton "&SORT_DSC" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf33.xml_;_
SAPGuiSession("Session").SAPGuiWindow("Define sorting/subtotals").Close @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf39.xml_;_
 @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf43.xml_;_

strDocumentNo=SAPGuiSession("Session").SAPGuiWindow("wndResults").SAPGuiGrid("grdrecv").GetCellData(2,"document number")
strPostDate=SAPGuiSession("Session").SAPGuiWindow("wndResults").SAPGuiGrid("grdrecv").GetCellData(2,"entry date")
strNetDueDate=SAPGuiSession("Session").SAPGuiWindow("wndResults").SAPGuiGrid("grdrecv").GetCellData(2,"Net Due Date")
doubleAmt=SAPGuiSession("Session").SAPGuiWindow("wndResults").SAPGuiGrid("grdrecv").GetCellData(2,"Amount")
doubleCleared=SAPGuiSession("Session").SAPGuiWindow("wndResults").SAPGuiGrid("grdrecv").GetCellData(2,"Cleared")

If (doubleAmt=doubleCleared) Then
	StrpaidStatus="Paid"
	Else
	StrpaidStatus="Unpaid"
End If
SAPGuiSession("Session").SAPGuiWindow("wndResults").SAPGuiTabStrip("tabchro").Select "Receivables" 

intRow = SAPGuiSession("Session").SAPGuiWindow("wndResults").SAPGuiGrid("grdrecv").FindRowByCellContent ("document number",strDocumentNo)

strDesc=SAPGuiSession("Session").SAPGuiWindow("wndResults").SAPGuiGrid("grdrecv").GetCellData(intRow,"description")

SAPGuiSession("Session").SAPGuiOKCode("okcSubmit").Set "/n ecenv_bp"
SAPGuiSession("Session").SAPGuiButton("btnEnter").Click
SAPGuiSession("Session").SAPGuiWindow("Data Environment Business").SAPGuiEdit("edBusinessPartner").Set bpnumber
SAPGuiSession("Session").SAPGuiWindow("Data Environment Business").SAPGuiButton("Enter").Click

SAPGuiSession("Session").SAPGuiWindow("Data Environment on 22.11.2013").SAPGuiLabel("lblDevice").setFocus
SAPGuiSession("Session").SAPGuiWindow("Data Environment on 22.11.2013").SendKey F2
SAPGuiSession("Session").SAPGuiWindow("Display Material Serial").SAPGuiButton("Address").Click

strStreet=SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display").SAPGuiEdit("Street/House number").GetROProperty("value")
strPostal=SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display").SAPGuiEdit("Postal Code/City").GetROProperty("value")
strCountry=SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display").SAPGuiEdit("Country").GetROProperty("value")
strCity=SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display").SAPGuiEdit("Postal Code/City_2").GetROProperty("value")
strFuelType=SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display").SAPGuiEdit("Division").GetROProperty("value")
If SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display").SAPGuiEdit("Street2").Exist Then
strStree2=SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display").SAPGuiEdit("Street2").GetROProperty("value")
end if
If SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display").SAPGuiEdit("Street3").Exist Then
strStree3=SAPGuiSession("Session").SAPGuiWindow("Address maintenance: Display").SAPGuiEdit("Street3").GetROProperty("value")
end if
objFile.WriteLine "documentnumber" & ":" & strDocumentNo
objFile.WriteLine "SiteAddress" & ":" & strStreet &"," & strStree2 &"," & strStree3 & ","  & strCity
objFile.WriteLine "Postcode" & ":" & strPostal 
objFile.WriteLine "documentnumber" & ":" & strDocumentNo
objFile.WriteLine "Postingdate" & ":" & strPostDate
objFile.WriteLine "Transactiontype" & ":" & strDesc
objFile.WriteLine "Duedate" & ":" & strNetDueDate
objFile.WriteLine "Fueltype" & ":" &  strFuelType
objFile.WriteLine "Status" & ":" & StrpaidStatus
objFile.WriteLine "Amount" & ":" &  Replace(doubleAmt,",",".")
















 @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf33.xml_;_
 @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf33.xml_;_




















