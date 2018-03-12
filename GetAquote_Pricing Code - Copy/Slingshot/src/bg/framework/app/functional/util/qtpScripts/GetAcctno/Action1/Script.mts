'bpnumber=TestArgs("BpOrgNumber")
bpnumber ="2001628798-600549907"
'bpnumber ="2000041137-600038253"
'bpnumber ="2001624702"
'Msgbox bpnumber
strSpli=split(bpnumber,"-")
bpnumber=strSpli(0)
accountnumber=strSpli(1)
'msgbox accountnumber
'accountnumber ="601237608"

SAPGuiUtil.CloseConnections 

SAPGuiUtil.AutoLogon "QAS 04 ISU","300","g0000c","welcome8","EN"

If SAPGuiSession("Session").SAPGuiWindow("License Information for").SAPGuiRadioButton("rdbcontinewiththislogon").Exist then
	SAPGuiSession("Session").SAPGuiWindow("License Information for").SAPGuiRadioButton("rdbcontinewiththislogon").Set
SAPGuiSession("Session").SAPGuiWindow("License Information for").SAPGuiButton("btnConfirmSelection").Click
End If

 wait(5)


    
              Dim fso, f
		Set fso = createobject("Scripting.FileSystemObject")
		
		If (fso.FolderExists("D:\BgbAcctnos")) Then
			   fso.DeleteFolder("D:\BgbAcctnos")
		End If
			fso.CreateFolder("D:\BgbAcctnos") 
			Set objFile =fso.CreateTextFile( "D:\BgbAcctnos\acctno.txt",True)             


 Call openbpnumber
 Call  getAcctno

   Function openbpnumber()

	If Not SAPGuiSession("Session").SAPGuiWindow("SAPEasyAccessUser").Exist(5) then
	Exit function
	end if

		waitForExistance(SAPGuiSession("Session").SAPGuiWindow("SAPEasyAccessUser").SAPGuiOKCode("OKCode"))
							SAPGuiSession("Session").SAPGuiWindow("SAPEasyAccessUser").SAPGuiOKCode("OKCode").Set "/n ECENV_BP"
							SAPGuiSession("Session").SAPGuiWindow("SAPEasyAccessUser").SendKey ENTER
		waitForExistance( SAPGuiSession("Session").SAPGuiWindow("Data Environment Business"))
		waitForExistance( SAPGuiSession("Session").SAPGuiWindow("Data Environment Business").SAPGuiEdit("Business Partner"))
							SAPGuiSession("Session").SAPGuiWindow("Data Environment Business").SAPGuiEdit("Business Partner").Set bpnumber
							 SAPGuiSession("Session").SAPGuiWindow("Data Environment Business").SendKey ENTER

							 if SAPGuiSession("Session").SAPGuiWindow("Information").SAPGuiElement("usr").Exist then
							SAPGuiSession("Session").SAPGuiWindow("Information").SAPGuiButton("Continue").Click
						End if
   End Function
Function waitForExistance(waitfor)

   Set waitObj=waitfor
	   For i=1 to 10
			  Wait(2)
			  If waitObj.Exist Then

				  Exit Function

			  End If
	   Next

End Function



Function  getAcctno()
   
   SAPGuiSession("Session").SAPGuiWindow("DataEnvironmenton").SAPGuiMenubar("Edit").Select "Edit;Collapse subtree" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf1.xml_;_
   
		Wait(15)
Set objChld=Description.Create()
Set objChild=SAPGuiLabel
Set objLabel=SAPGuiSession("Session").SAPGuiWindow("DataEnvironmenton").ChildObjects(objChild)

For intCount=0 to (objLabel.count)-1

	strData=objLabel(intCount).GetRoProperty("content")

	If Trim(strData)="ISU Account" Then
		intActNo=objLabel(intCount+2).GetRoProperty("content")
	'	print intActNo
		'objFile.WriteLine intActNo
		    objFile.WriteLine(intActNo)
	End If

Next


End Function



 @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf1.xml_;_
 @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf1.xml_;_






































