package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.AttachVolume;
import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.CustomerLogout;
import com.jamcracker.commonFunctions.customer.DetachAndTerminateVolume;
import com.jamcracker.commonFunctions.customer.DetachVolume;
import com.jamcracker.utilities.TestBase;

@Listeners(com.jamcracker.listeners.TestListener.class)

public class TC008VolumeAction extends TestBase {

	@BeforeClass
	@Parameters({ "browser","storeUrl" })
	public void setUp(String browser, String url) {
		init(browser, url);
	}

	@DataProvider(name = "VolumeData")
	public String[][] getInstanceData() {
		return getData("Iaas Stack Orders.xls", "Volumes");
	}

	@Test(dataProvider = "VolumeData")
	public void volumeAction(String executable, String action, String email, String Password, String instName,
			String volumeName, String volumeType, String size, String sizeType) {

		AttachVolume volumeObj1 = new AttachVolume();
		DetachVolume volumeObj2 = new DetachVolume();
		DetachAndTerminateVolume volumeObj3 = new DetachAndTerminateVolume();
		CustomerAdminLogin custLogin = new CustomerAdminLogin();

		if (executable.equalsIgnoreCase("y")) {
			custLogin.customerAdminLogin(email, Password);
			
			switch(action.toLowerCase()){
			case "attach volume" :
								volumeObj1.attachVolume(instName, volumeName, volumeType, size, sizeType);
								break;
			
			case "detach volume" :
				volumeObj2.detachVolume(instName, volumeName);
					break;
					
			case "terminate volume" :
				volumeObj3.deleteVolume(instName, volumeName);
				break;
			}
			CustomerLogout.logOut();
		}
	}
}
