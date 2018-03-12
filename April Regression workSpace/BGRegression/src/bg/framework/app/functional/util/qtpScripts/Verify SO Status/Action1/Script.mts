projectPath=TestArgs("Project_path")
ServiceOrderNo = TestArgs("ServiceOrderNumber")

'projectPath="C:\workspace\BGRegression\"


Systemutil.Run "Saplogon"
 wait 2
Set fso = createobject("scripting.filesystemobject")

SAPFileLocation=projectPath & "SAPFiles\SAPEnvironmentDetails.txt"
set saptxtfile = fso.OpenTextFile (SAPFileLocation,1,true)

SapGuiUtil.AutoLogon saptxtfile.ReadLine,100,saptxtfile.ReadLine,saptxtfile.ReadLine,"EN"

'soFilePath=projectPath &"QTPFiles\SONumber.txt"
''
'set txtfile = fso.OpenTextFile (soFilePath)
'ServiceOrderNumber = txtfile.ReadLine
'msgbox ServiceOrderNumber
'aServiceOrderNo = split(ServiceOrderNumber,"=")
'ServiceOrderNo = aServiceOrderNo(1)

set txtfile1 = fso.OpenTextFile (projectPath &"src\resources\bgmo_oab\booking\ServiceOrderStatus.properties",2)
'


SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiOKCode("OKCode").Set "/niw32"
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SendKey ENTER
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiEdit("Order").Set ServiceOrderNo

SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SendKey ENTER
 @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf1.xml_;_
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiTabStrip("TS_1103").Select "Enhancement"
 @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf2.xml_;_
SAPGuiSession("Session").SAPGuiWindow("GuiWindow").SAPGuiGrid("GridViewCtrl_2").Output CheckPoint("GridViewCtrl")

SoStatusVal = datatable("GridViewCtrl_Row_1_Col_6_out",1)

txtfile1.WriteLine "ServiceOrderStatus =" & SoStatusVal

SapGuiUtil.CloseConnections
SystemUtil.CloseProcessByName "saplogon.exe"






