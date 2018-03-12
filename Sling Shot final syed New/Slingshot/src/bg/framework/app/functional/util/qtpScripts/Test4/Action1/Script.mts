SAPGuiUtil.AutoLogon "QAS 04 ISU","300","G0000c","welcome2","EN"
	bpnumber="2001624575"
	'accountnumber="601268909"
	    Dim fso, f
		Set fso = createobject("Scripting.FileSystemObject")
		
		If (fso.FolderExists("C:\SAPData")) Then
			   fso.DeleteFolder("C:\SAPData")
		End If
			fso.CreateFolder("C:\SAPData") 
			Set objFile = fso.CreateTextFile( "C:\SAPData\OnDemandBilling.txt",True)
			
			Call openAccountDisplay(bpnumber)
			Call getAddress()
			Call getTotalBillAmount()

            Set objFile=Nothing



Function getAddress()
	
	Set MyDescription=SAPGuiLabel
	
	Set label =   SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic").ChildObjects(MyDescription)
	NoOfChildObjs = label.count 
	Counts=1
	contractAccNumber =0
	For Counter=1 to NoOfChildObjs - 1     
		   relativeid=label(Counter).getroproperty("relativeid")	
			If  relativeid = "wnd[0]/usr/lbl[0,"& Counts &"]" Then
			Counts=Counts+1
			Addr1 = label(Counter).getroproperty("content")
			objFile.writeline  "Addr line" &Counts&": "&label(Counter).getroproperty("content")
		    End If

            If Counts=4 Then
				Exit for
			End If
	Next 
	
End Function		



Function openAccountDisplay(bpnumber)

	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access  -  User").Maximize @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf1.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access  -  User").SAPGuiOKCode("OKCode").Set "/n fpl9" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf1.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access  -  User").SendKey ENTER @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf1.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Account Display: InitScrn").SAPGuiEdit("Business partn.").Set bpnumber
	SAPGuiSession("Session").SAPGuiWindow("Account Display: InitScrn").SendKey ENTER @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf2.xml_;_
	
End Function


Function getTotalBillAmount()

	SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic").SendKey CTRL_SHIFT_F4 @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf3.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Change settings").SAPGuiCheckBox("Display ALV Grid List").Set "ON" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf4.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Change settings").SAPGuiCheckBox("Display ALV Grid List").SetFocus @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf4.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Change settings").SAPGuiButton("Continue   (Enter)").Click @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf4.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic_2").SAPGuiTabStrip("TABSTRIP01").Select "Chronology" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf5.xml_;_
	intTotalRows = SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic_2").SAPGuiGrid("Chronological Display").RowCount
	objFile.writeline "TotalAmount: "&SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic_2").SAPGuiGrid("Chronological Display").GetCellData (intTotalRows,"Amount") @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf6.xml_;_
	
End Function


