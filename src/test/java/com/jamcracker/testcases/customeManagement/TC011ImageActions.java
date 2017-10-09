package com.jamcracker.testcases.customeManagement;

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
	
	private String getURL() {
		return getData("TestData.xls", "URLSheet", "URL", 4);
	}
	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String browser)
	{
		init("chrome",getURL());
	}
	
	@DataProvider(name = "ImageData")
	public String[][] getInstanceData() {
	return getData("Iaas Stack Orders.xls", "Images");}
	
	@Test(dataProvider="ImageData")
	public void imageCreation(String executable, String action, String email, String Password, String instName,String imageName,String imageDesc)
	{
		CustomerAdminLogin custLogin = new CustomerAdminLogin();
		ImageCreation objImageCreation = new ImageCreation();
		DeleteImage objDeleteImage = new DeleteImage();
		if(executable.equalsIgnoreCase("y"))
		{
			if(action.equalsIgnoreCase("Image Creation"))
			{		
			
				custLogin.customerAdminLogin(email, Password);
				objImageCreation.imageCreation(instName, imageName,imageDesc);
			}
			
			if(action.equalsIgnoreCase("Delete Image"))
			{		
			
				custLogin.customerAdminLogin(email, Password);
				objDeleteImage.deleteImage(imageName);
			}
			
			CustomerLogout.logOut();
		
		}
	}
	
	
	
	

}
