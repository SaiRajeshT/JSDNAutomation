package ansibleScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.VerifyManageScript;
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
		init("chrome",getURL());
	}
	
	@DataProvider(name = "ScriptData")
	public String[][] getInstanceData() {
	return getData("AnsibleScript.xls", "Scripts");}
	


	@Test(dataProvider = "ScriptData",priority=1)
	public void verifyScriptPage()
	{ 
		
		VerifyManageScript objVerifyScriptPage = new VerifyManageScript();
		objVerifyScriptPage.verifyScriptPage();
		
	}
	
	@Test(dataProvider = "ScriptData",priority=2)
	public void testAddScript() 
	{
		
		
	}
	
	@Test(dataProvider = "ScriptData",priority=3)
	public void testDeleteScript() 
	{
		
		
	}
	
	
	@Test(dataProvider = "ScriptData",priority=4)
	public void testUpdateScript() 
	{
		
		
	}
	
	@Test(dataProvider = "ScriptData",priority=5)
	public void testExecuteScript() 
	{
		
		
	}
	
	
	@Test(dataProvider = "ScriptData",priority=5)
	public void testCancelScript() 
	{
		
		
	}
	
	@Test(dataProvider = "ScriptData",priority=6)
	public void verifyActionLinks() 
	{
		
		
	}
	
	
	@Test(dataProvider = "ScriptData",priority=7)
	public void testSearchScript() 
	{
		
		
	}
	
	
	
	

	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

	
	

}
