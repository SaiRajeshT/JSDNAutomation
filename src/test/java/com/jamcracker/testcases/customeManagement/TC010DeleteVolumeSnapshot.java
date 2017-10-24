package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.DeleteVolumeSnapshot;
import com.jamcracker.utilities.TestBase;

public class TC010DeleteVolumeSnapshot extends TestBase{
	
	private String getURL() {
		return getData("TestData.xls", "URLSheet", "URL", 4);
	}

	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String browser) {
		init("chrome", getURL());
	}

	@DataProvider(name = "VolumeData")
	public String[][] getInstanceData() {
		return getData("Iaas Stack Orders.xls", "Volumes");
	}

	@Test(dataProvider = "VolumeData")
	public void volumeAction(String executable, String action, String email, String Password, String instName,
			String volumeName, String volumeType, String size, String sizeType,String snapshotName, String snapshotDesc) {

		
		CustomerAdminLogin custLogin = new CustomerAdminLogin();
		DeleteVolumeSnapshot objVolSnapshot = new DeleteVolumeSnapshot();

		if (executable.equalsIgnoreCase("y")&& action.equalsIgnoreCase("delete snapshot")) {
			custLogin.customerAdminLogin(email, Password);
			objVolSnapshot.deleteVolSnapshot(snapshotName);
			
			
			//CustomerLogout.logOut();

			}
		}
	

}
