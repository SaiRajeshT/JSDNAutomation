	WinWaitActive("File Upload");
ControlFocus("File Upload","","ComboBox1");
ControlSetText("File Upload","","ComboBox1","C:\Users\pkumar\git\JSDNAutomation\Data\BudgetTemplate.xls");
ControlClick("File Upload","","Button1");