package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CreateVolumeSnapshot;
import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.utilities.TestBase;

@Listeners(com.jamcracker.listeners.TestListener.class)

public class TC009CreateVolumeSnapshot extends TestBase {

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
		CreateVolumeSnapshot objVolSnapshot = new CreateVolumeSnapshot();

		if (executable.equalsIgnoreCase("y")&& action.equalsIgnoreCase("create snapshot")) {
			custLogin.customerAdminLogin(email, Password);
			objVolSnapshot.createVolumeSnapshot(instName, volumeName, snapshotName, snapshotDesc);
			
			
			//CustomerLogout.logOut();

			}
		}
	
}
