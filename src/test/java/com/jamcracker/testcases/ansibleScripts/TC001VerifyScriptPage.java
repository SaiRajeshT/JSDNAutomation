package com.jamcracker.testcases.ansibleScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.AddExecuteScript;
import com.jamcracker.commonFunctions.customer.AddSaveScript;
import com.jamcracker.commonFunctions.customer.ChangeTemplateAndExecute;
import com.jamcracker.commonFunctions.customer.DeleteScript;
import com.jamcracker.commonFunctions.customer.FailedScriptActions;
import com.jamcracker.commonFunctions.customer.SavedScriptActions;
import com.jamcracker.commonFunctions.customer.SuccessScriptActions;
import com.jamcracker.commonFunctions.customer.UpdateScript;
import com.jamcracker.commonFunctions.customer.UpdateScriptAndExecute;
import com.jamcracker.commonFunctions.customer.UpdateScriptName;
import com.jamcracker.commonFunctions.customer.VerifyManageScript;
import com.jamcracker.commonFunctions.customer.ViewScript;
import com.jamcracker.commonFunctions.customer.ViewScriptLog;
import com.jamcracker.utilities.TestBase;

public class TC001VerifyScriptPage extends TestBase
{
	private String getURL() {
		return getData("TestData.xls", "URLSheet", "URL", 4);
	}
	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String browser)
	{
		init(browser,getURL());
	}
	
	@DataProvider(name = "ScriptData")
	public String[][] getInstanceData() {
	return getData("AnsibleScript.xls", "Scripts");}
	


	@Test(dataProvider = "ScriptData")
	public void scriptPageScenarios(String executable,String scenario,String email, 
			String password,String scriptType,String provider,String resource,
			String template,String scriptName,String script)
	{ 	
		switch(scenario)
		{
			case "Verify Script Page" :
				VerifyManageScript.verifyScriptPage();
				break;
			
			case "Add and Save Script" :
				AddSaveScript.addScript(provider, resource, template, scriptName, script);
				break;
			case "Add and Execute Script" :
				AddExecuteScript.addExecuteScript(provider, resource, template, scriptName, script);
				break;
			case "Add and execute Invalid Script":
				AddExecuteScript.addExecuteScript(provider, resource, template, scriptName, script);
				break;
				
			case "Verify Actions for Success Script":
				SuccessScriptActions.verifySuccessScriptActions(scriptName);
				break;
				
			case "Verify Actions for Saved Script":
				SavedScriptActions.verifySavedScriptActions(scriptName);
				break;
				
			case "Verify Actions for Failed Script":
				FailedScriptActions.verifyFailedScriptActions(scriptName);
				break;
			case "Update Saved Script":
				UpdateScript.getScriptUpdate(scriptName, script);
				break;
			case "View script for Saved Script":
				ViewScript.viewScript(scriptName, script);
				break;
			case "View script for Success Script":
				ViewScript.viewScript(scriptName, script);
				break;
			case "View Log for Failed Script" :
					ViewScriptLog.getScriptLog(scriptName, script);
				break;
			
			case "View Log for Success Script" :
					ViewScriptLog.getScriptLog(scriptName, script);
				break;
			
			case "Update Failed Script":
				UpdateScript.getScriptUpdate(scriptName, script);
				break;
				
			case "Update and Execute Failed Script":
				UpdateScriptAndExecute.getScriptUpdateAndExecute(scriptName, script);
				break;
				
			case "Delete  Saved Script":
				DeleteScript.deleteScript(scriptName);
				break;
			case "Delete Failed Script" :
				DeleteScript.deleteScript(scriptName);
				break;
			case "Delete Success Script" :
				DeleteScript.deleteScript(scriptName);
				break;
				
			case "Update Script Name for Saved Template" :
				UpdateScriptName.getScriptNameUpdate(scriptName);
				break;
				
			case "Update and Execute Saved Script":
				UpdateScriptAndExecute.getScriptUpdateAndExecute(scriptName, script);
				break;
			
			case "Change template for Saved Script and Execute" :
				ChangeTemplateAndExecute.getTemplateUpdate(scriptName, template);
				break;
			
			case "Change template for failed script and Execute" :
			 ChangeTemplateAndExecute.getTemplateUpdate(scriptName, template);
			 break;
				
				
		}
	}
	

	

	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

	
	

}
