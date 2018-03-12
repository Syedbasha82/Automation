bpnumber=TestArgs("BpOrgNumber")
'bpnumber="2002098004"

SAPGuiUtil.AutoLogon "QAS 01","300","G0000c","welcome4","EN"
	'bpnumber="2002098004"
	'accountnumber="601268909"
	    Dim fso, f
		Set fso = createobject("Scripting.FileSystemObject")
		
		If (fso.FolderExists("D:\SAPData")) Then
			   fso.DeleteFolder("D:\SAPData")
		End If
			fso.CreateFolder("D:\SAPData") 
			Set objFile = fso.CreateTextFile( "D:\SAPData\OnDemandBilling.txt",True)
          
			Call getBillingAddress()
			Call getBalanceAmount(bpnumber)
            Set objFile=Nothing

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

Function getBalanceAmount(BpNumber)
	waitForExistance(SAPGuiSession("Session").SAPGuiWindow("wndSAPEasyAccess").SAPGuiOKCode("OKCode"))
	SAPGuiSession("Session").SAPGuiWindow("wndSAPEasyAccess").SAPGuiOKCode("OKCode").Set "/n fpl9" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf37.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("wndSAPEasyAccess").SendKey ENTER @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf37.xml_;_
	waitForExistance(SAPGuiSession("Session").SAPGuiWindow("Account Display: InitScrn").SAPGuiEdit("Business partn."))
	SAPGuiSession("Session").SAPGuiWindow("Account Display: InitScrn").SAPGuiEdit("Business partn.").Set BpNumber @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf38.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Account Display: InitScrn").SendKey ENTER @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf38.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic_2").SAPGuiTabStrip("TABSTRIP01").Select "Chronology" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf39.xml_;_
	
	intRow = SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic_2").SAPGuiGrid("Chronological Display").RowCount
	
	intCol = SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic_2").SAPGuiGrid("Chronological Display").ColumnCount
	
	expectedData = SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic_2").SAPGuiGrid("Chronological Display").GetCellData (intRow, "Amount")
	objFile.WriteLine ("Total balance: ")&expectedData  		 
	'SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic_2").SAPGuiButton("Back   (F3)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf41.xml_;_
 @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf42.xml_;_
End Function

Function getBillingAddress()
If not SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic_2").Exist(5) Then
objFile.WriteLine ("Billing address1: Null")	
objFile.WriteLine ("Billing address2: Null")   	
else
strAddr1 = SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic_2").SAPGuiEdit("FKKEPOSC-HEAD2").GetROProperty("value")
strAddr2 = SAPGuiSession("Session").SAPGuiWindow("Account Display: Basic_2").SAPGuiEdit("FKKEPOSC-HEAD3").GetROProperty("value")
objFile.WriteLine ("Billing address1: ") & strAddr1  	
objFile.WriteLine ("Billing address2: ") & strAddr2
end if
SAPGuiSession("Session").Close
End Function







