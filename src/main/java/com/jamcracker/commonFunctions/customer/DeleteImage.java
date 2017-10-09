package com.jamcracker.commonFunctions.customer;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import com.jamcracker.constants.Constants;
import com.jamcracker.objectRepository.customer.Imagespage;
import com.jamcracker.utilities.TestBase;

public class DeleteImage extends TestBase {
	
	public void deleteImage(String imageName){
		Imagespage objImagePage = new Imagespage();
		try{objImagePage.manageLink.click();
		objImagePage.imageLink.click();
		explicitWait(objImagePage.showingText);
		objImagePage.getImageActionLink(imageName).click();
		explicitWait(objImagePage.deleteLink);
		objImagePage.deleteLink.click();
		explicitWait(objImagePage.deleteImageConfirmButton);
		objImagePage.deleteImageConfirmButton.click();
		if(Constants.IMAGE_DELETE_MESSAGE.concat(imageName).equalsIgnoreCase("Delete action is initiated for image "+ imageName)){
			Reporter.log("Image Delete action is performed");}
		else{
			Reporter.log("<p style='color:red'>Issue while deleting Image please look in to the issue.<p>");
		}
		
		boolean test = true;
		long startTime = (System.currentTimeMillis()) / 1000;
		while (test) {
			if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
				Reporter.log("<p style='color:red'>Waited for"+timeout+" Seconds.Image is not deleted.Please check the issue.<p>");
				Assert.fail();
				break;
			}
			
			objImagePage.searchTextBox.clear();
			objImagePage.searchTextBox.sendKeys(imageName);
			Thread.sleep(3000);
			objImagePage.searchTextBox.sendKeys(Keys.ENTER);
			explicitWait(objImagePage.showingText);
			
			try {
				if(objImagePage.getDeletingImage(imageName).isDisplayed()){
				}
				
			}
			
			catch(Exception e1)
			{
				test = false;
				Reporter.log("Image Deleted successfully.");

			}
			
			Thread.sleep(5000);
			
		}
	
	}
	
	catch (Exception e)
	{
		Reporter.log("<p style='color:red'>Issue while deleting Image please look in to the issue.<p>");
		
	}
		
	}

}
