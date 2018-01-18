package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.CustomerLogout;
import com.jamcracker.commonFunctions.customer.DeleteImage;
import com.jamcracker.commonFunctions.customer.ImageCreation;
import com.jamcracker.utilities.TestBase;

@Listeners(com.jamcracker.listeners.TestListener.class)

public class TC011ImageActions extends TestBase {
	
	@BeforeClass
	@Parameters({"browser","storeUrl"})
	public void setUp(String browser, String url)
	{
		init(browser,url);
	}
	
	@DataProvider(name = "ImageData")
	public String[][] getInstanceData() {
	return getData("CustomerData.xls", "Images");}
	
	@Test(dataProvider="ImageData")
	public void imageactions(String executable, String action, String email, String Password, String instName,
			String imageName,String imageDesc,String volumeName, String volumeSnapshotName)
	{
		CustomerAdminLogin custLogin = new CustomerAdminLogin();
		ImageCreation objImageCreation = new ImageCreation();
		DeleteImage objDeleteImage = new DeleteImage();
		
		
		if(executable.equalsIgnoreCase("y"))
		{
			
			switch(action.toLowerCase()){
			case "image creation" : 
				custLogin.customerAdminLogin(email, Password);
				objImageCreation.imageCreation(instName, imageName,imageDesc);
				break;
			
			case "delete image" :
				custLogin.customerAdminLogin(email, Password);
				objDeleteImage.deleteImage(imageName);
				break;
			case "image creation with volume" :
				custLogin.customerAdminLogin(email, Password);
				objImageCreation.imageCreationwithVolume(instName, imageName, imageDesc, volumeName, volumeSnapshotName);
				break;
			}
		}
	}
	
	@AfterMethod
	public void logout()
	{
		CustomerLogout.logOut();
	}
	@AfterClass
	public void close()
	{
		//closeBrowser();

	}

}
