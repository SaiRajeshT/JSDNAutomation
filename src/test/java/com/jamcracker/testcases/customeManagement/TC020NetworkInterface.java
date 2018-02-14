package com.jamcracker.testcases.customeManagement;

import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CreateSecGrpRule;
import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.CustomerLogout;
import com.jamcracker.commonFunctions.customer.DeleteNic;
import com.jamcracker.commonFunctions.customer.DeleteSecGroupFromNic;
import com.jamcracker.commonFunctions.customer.NicCreation;
import com.jamcracker.commonFunctions.customer.UpdateNicAndCreateSec;
import com.jamcracker.commonFunctions.customer.UpdateNicName;
import com.jamcracker.entity.service.NicDetails;
import com.jamcracker.excel.reader.NicIntefaceExcelReader;
import com.jamcracker.utilities.TestBase;

@Listeners(com.jamcracker.listeners.TestListener.class)

public class TC020NetworkInterface extends TestBase {

	@DataProvider(name = "nicData")
	private NicDetails[] getInstOrderData() {
		NicIntefaceExcelReader readNicData = new NicIntefaceExcelReader("./Data/CustomerData.xls");
		return readNicData.getExcelData("NetworkInterface");
	}
	
	@BeforeClass
	@Parameters({ "browser", "storeUrl" })
	public void setUp(String browser, String url) {
		init(browser, url);
	}


	@Test(dataProvider = "nicData")
	public void nicActions(NicDetails nicDatainfo) {
		if (nicDatainfo.getExecutable().equalsIgnoreCase("y")) {
			CustomerAdminLogin custLogin = new CustomerAdminLogin();
			custLogin.customerAdminLogin(nicDatainfo.getEmail(), nicDatainfo.getPassword());
			NicCreation nicCreationObj = new NicCreation();
			UpdateNicName nicNameObj = new UpdateNicName();
			DeleteNic deletenicObj = new DeleteNic();
			UpdateNicAndCreateSec objcreateSec = new UpdateNicAndCreateSec();
			DeleteSecGroupFromNic deleteSec = new DeleteSecGroupFromNic();
			CreateSecGrpRule createrule = new CreateSecGrpRule();
			switch(nicDatainfo.getAction().toLowerCase())
			{
			case "add nic" : 
				nicCreationObj.nicCreation(nicDatainfo);
				break;
			case "update nic name" :
				nicNameObj.nicUpdate(nicDatainfo);
				break;
			
			case "delete nic" :
				deletenicObj.nicDelete(nicDatainfo);
				break;
			
			case "update nic and create sec group" :
				objcreateSec.updateNicAndCreateSec(nicDatainfo);
				break;
			
			case "delete sec group" :
				deleteSec.deleteSecGroup(nicDatainfo);
				break;
				
			case "create new sec rule" :
				createrule.createRule(nicDatainfo);
				break;
			}
		}

	}
	
	@AfterMethod
	public void aftermethod()
	{
		CustomerLogout.logOut();
	}

	@AfterClass
	public void afterclass() {
		//webDriversMap.remove(Thread.currentThread().getName());
	//	getDriver().quit();
	}

}
