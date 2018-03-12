bpnumber=TestArgs("BpOrgNumber")
'Msgbox bpnumber

Call invokeSAP()
'Call createDirectDebitTextFile()

Call getBankDetails()
'If  invokeSAP="True" Then
'     Call getBankDetails()
'End If


Function getBankDetails()

Dim fso, f
Set fso = CreateObject("Scripting.FileSystemObject")

If (fso.FolderExists("C:\SAPData")) Then
	   fso.DeleteFolder("C:\SAPData")
End If
	fso.CreateFolder("C:\SAPData") 
	Set objFile = fso.CreateTextFile( "C:\SAPData\DirectDebit.txt",True)



 SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SAPGuiOKCode("OKCode").Set  "/n fpp3"
 SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access").SendKey ENTER

   
If SAPGuiSession("Session").SAPGuiWindow("Open business partner").Exist(5) Then
    SAPGuiSession("Session").SAPGuiWindow("Open business partner").SAPGuiEdit("edtBusinessPartner").Set bpnumber
	SAPGuiSession("Session").SAPGuiWindow("Open business partner").SAPGuiButton("btnEnter").Click
'	SAPGuiSession("Session").SAPGuiWindow("Open business partner").SendKey ENTER
Else
     If not SAPGuiSession("Session").SAPGuiWindow("Display Organization:").Exist(3) Then
		   'Exit Function
	 Else
	        waitForExistance(SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SAPGuiComboBox("cboBusinessPartner"))
	        SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SAPGuiComboBox("cboBusinessPartner").Select "Business Partner"
            SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SAPGuiComboBox("cboByNumber").Select "Number"
            SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SAPGuiEdit("edtBusinessPartner").Set	bpnumber @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf1.xml_;_
			SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SAPGuiButton("btnStart").Click
			waitForExistance(SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SAPGuiGrid("grdBpActivate"))
            SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SAPGuiGrid("grdBpActivate").SelectRow 1 @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf9.xml_;_
			SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SAPGuiGrid("grdBpActivate").ActivateCell 1,"Business Partner"
			SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SendKey ENTER
	End if
	
End If
            SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SAPGuiTabStrip("tabPayment").Select "Payment Transactions"
			waitForExistance(SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SAPGuiTable("tblPayment"))
			rowcount=SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SAPGuiTable("tblPayment").RowCount
            countIn=0
			For i=1 to rowcount
                    If SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SAPGuiTable("tblPayment").GetCellData(i,"ID")<>"" Then
						countIn=countIn+1
					 Else
						Exit For
					End If
			Next
		   strSortcode=Trim(SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SAPGuiTable("tblPayment").GetCellData(countIn,"Bank Key"))
		   If strSortcode="" Then
			   strSortcode="Null"
		   End If
		   objFile.WriteLine ("Sortcode :")&strSortcode
		   waitForExistance(SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SAPGuiTable("tblPayment"))
		   strBankAcct=Trim(SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SAPGuiTable("tblPayment").GetCellData(countIn,"Bank acct"))
		    If strBankAcct="" Then
			   strBankAcct="Null"
		   End If
		   objFile.WriteLine ("Bank Account :")&strBankAcct
		   waitForExistance(SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SAPGuiTable("tblPayment"))
		   strbankAccountHolder=SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SAPGuiTable("tblPayment").GetCellData(countIn,"Account Holder")
		   If strbankAccountHolder="" Then
			   strbankAccountHolder="Null"
			End If
		   objFile.WriteLine ("Account Holder Name :")&strbankAccountHolder
          SAPGuiSession("Session").SAPGuiOKCode("OKCode").Set "/n"
		  SAPGuiSession("Session").SAPGuiWindow("Display Organization:").SendKey ENTER
           SAPGuiSession("Session").Close

		   Set objFile=Nothing		
		   Set fso=Nothing

End Function

Function waitForExistance(waitfor)

   Set waitObj=waitfor
	   For i=1 to 10
			  Wait(3)
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
	   If SAPGuiSession("title:=Sessio.*").Exist Then
           SAPGuiUtil.CloseConnections
	   End If
	   SAPGuiUtil.AutoLogon "SAPGUI","300","kesavanc","welcome3","EN"
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
		If SAPGuiSession("Session_6").SAPGuiWindow("SAP").SAPGuiEdit("User").Exist Then
				SAPGuiSession("Session_6").SAPGuiWindow("SAP").SAPGuiEdit("User").Set "sundarg1"
				wait(3)
				SAPGuiSession("Session_6").SAPGuiWindow("SAP").SAPGuiEdit("Password").Set "welcome123"
				wait 2
				'SAPGuiSession("Session_6").SAPGuiWindow("SAP").SAPGuiEdit("Password").SetFocus
				SAPGuiSession("Session_6").SAPGuiWindow("SAP").SendKey ENTER
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


