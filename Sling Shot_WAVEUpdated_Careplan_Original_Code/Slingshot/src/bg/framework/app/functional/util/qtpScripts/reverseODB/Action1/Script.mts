 @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf1.xml_;_
bpNumber = "2002098004"
intDocNumber = getDOcNumber(bpNumber)
'msgbox intDocNumber
reverseInvoice(intDocNumber)
installationNumber = getInstallationNumber(bpNumber)
'msgbox installationNumber
reverseMeterRead(installationNumber)

Function getDOcNumber(bpNumber) @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf1.xml_;_
SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access  -  User").SAPGuiOKCode("OKCode").Set "/necenv_bp" @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf1.xml_;_
SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access  -  User").SendKey ENTER @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf2.xml_;_
SAPGuiSession("Session").SAPGuiWindow("Data Environment Business").SAPGuiEdit("Business Partner").Set bpNumber @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf2.xml_;_
SAPGuiSession("Session").SAPGuiWindow("Data Environment Business").SendKey ENTER @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf3.xml_;_
SAPGuiSession("Session").SAPGuiWindow("Data Environment on 20.11.2013").SAPGuiLabel("IS-U Installation").SetFocus @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf3.xml_;_
SAPGuiSession("Session").SAPGuiWindow("Data Environment on 20.11.2013").SAPGuiLabel("IS-U Installation").SetCaretPos 12 @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf3.xml_;_
SAPGuiSession("Session").SAPGuiWindow("Data Environment on 20.11.2013").SendKey F2 @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf4.xml_;_
SAPGuiSession("Session").SAPGuiWindow("Display Installation:").SAPGuiButton("Billing periods").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf5.xml_;_
SAPGuiSession("Session").SAPGuiWindow("Billing View of Installation").SAPGuiTabStrip("MYTABSTRIP").Select "Document" @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf5.xml_;_
SAPGuiSession("Session").SAPGuiWindow("Billing View of Installation").SAPGuiGrid("Billing Documents").SelectCell 1,"Document Number" @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf5.xml_;_
SAPGuiSession("Session").SAPGuiWindow("Billing View of Installation").SAPGuiGrid("Billing Documents").SelectRow 1 @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf5.xml_;_
SAPGuiSession("Session").SAPGuiWindow("Billing View of Installation").SAPGuiGrid("Billing Documents").ClickCell 1,"Document Number" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf6.xml_;_
SAPGuiSession("Session").SAPGuiWindow("Display Print Document:").SAPGuiEdit("Print document").SetFocus
docNumber = SAPGuiSession("Session").SAPGuiWindow("Display Print Document:").SAPGuiEdit("Print document").GetROProperty("value") @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf6.xml_;_
SAPGuiSession("Session").SAPGuiWindow("Display Print Document:").SAPGuiButton("Back   (F3)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf7.xml_;_
SAPGuiSession("Session").SAPGuiWindow("Billing View of Installation").SAPGuiButton("Back   (F3)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf8.xml_;_
SAPGuiSession("Session").SAPGuiWindow("Display Installation:").SAPGuiButton("Back   (F3)").Click
getDOcNumber = docNumber
End Function

Function reverseInvoice(intDocNumber) @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf9.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Data Environment on 20.11.2013").SAPGuiOKCode("OKCode").Set "/n ea13" @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf9.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Data Environment on 20.11.2013").SendKey ENTER @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf10.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Reversal of Print Document").SAPGuiEdit("Reason for reversal").Set "01" @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf10.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Reversal of Print Document").SAPGuiEdit("Print Document No.").Set intDocNumber @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf10.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Reversal of Print Document").SAPGuiEdit("Reason for reversal").SetFocus @@ hightlight id_;_3_;_script infofile_;_ZIP::ssf10.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Reversal of Print Document").SAPGuiButton("Execute   (F8)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf11.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Select billing documents").SAPGuiButton("Continue   (Enter)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf12.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Reversal of Print Document_2").SAPGuiButton("Back   (F3)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf13.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Reversal of Print Document").SAPGuiButton("Back   (F3)").Click
End Function

Function reverseMeterRead(installationNumber)
 @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf14.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access  -  User").SAPGuiOKCode("OKCode").Set "/nel37" @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf14.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access  -  User").SendKey ENTER @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf15.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Reverse Meter Reading").SAPGuiEdit("Installation").Set installationNumber @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf15.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Reverse Meter Reading").SAPGuiEdit("Installation").SetFocus @@ hightlight id_;_2_;_script infofile_;_ZIP::ssf15.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Reverse Meter Reading").SAPGuiButton("Execute   (F8)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf16.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Reverse Meter Reading_2").SAPGuiGrid("Reverse Meter Reading").SelectRow 1 @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf16.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Reverse Meter Reading_2").SAPGuiGrid("Reverse Meter Reading").ClickCell 1,"Selected Line" @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf17.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Reverse Meter Reading_2").SAPGuiToolbar("GridToolbar").PressButton "CANC"
	
End Function

Function getInstallationNumber(bpNumber) @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf18.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access  -  User").SAPGuiOKCode("OKCode").Set "/necenv_bp" @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf18.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("SAP Easy Access  -  User").SendKey ENTER @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf19.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Data Environment Business").SAPGuiEdit("Business Partner").Set bpNumber @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf2.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Data Environment Business").SendKey ENTER @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf3.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Data Environment on 20.11.2013").SAPGuiLabel("IS-U Installation").SetFocus @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf20.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Data Environment on 20.11.2013").SAPGuiLabel("IS-U Installation").SetCaretPos 12 @@ hightlight id_;_0_;_script infofile_;_ZIP::ssf20.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Data Environment on 20.11.2013").SendKey F2
	installation = SAPGuiSession("Session").SAPGuiWindow("Display Installation:").SAPGuiEdit("Installation").GetROProperty("value") @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf21.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Display Installation:").SAPGuiButton("Back   (F3)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf22.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Data Environment on 20.11.2013").SAPGuiButton("Back   (F3)").Click @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf23.xml_;_
	SAPGuiSession("Session").SAPGuiWindow("Data Environment Business").SAPGuiButton("Back   (F3)").Click
	getInstallationNumber = installation
End Function
