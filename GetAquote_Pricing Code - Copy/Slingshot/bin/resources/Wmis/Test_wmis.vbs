Set WshShell = CreateObject("Wscript.Shell")
	
WshShell.Run """C:\Program Files\Attachmate\EXTRA!\EXTRA.exe"""


Wscript.Sleep 10000

							
WshShell.SendKeys "C:\Documents and Settings\!raghavp2\Desktop\Banner\WMIS1.edp"

WshShell.SendKeys "{ENTER}"

Wscript.Sleep 15000


WshShell.SendKeys "%t"

Wscript.Sleep 5000

WshShell.SendKeys "m"

Wscript.Sleep 5000

WshShell.SendKeys "TestPrefSlot"

Wscript.Sleep 5000

WshShell.SendKeys "%r"

Set WshShell = Nothing
