package com.jamcracker.commonFunctions.customer;

import org.openqa.selenium.Keys;

import com.jamcracker.objectRepository.customer.ManageCatalogPage;
import com.jamcracker.utilities.TestBase;

public class ManageCatalog extends TestBase {

	public void manageCatalog(String serviceName, String offerName,String multiDept) throws Exception{
		ManageCatalogPage objManageCatalogPage = new ManageCatalogPage();
		
		objManageCatalogPage.manageLink.click();
		objManageCatalogPage.catalogLink.click();
		objManageCatalogPage.createCatalog.click();
		
		if(multiDept.equalsIgnoreCase("Y")){
		objManageCatalogPage.multiDeptRadioButton.click();
		
		try{
		explicitWait(objManageCatalogPage.searchTextBox);
		objManageCatalogPage.searchTextBox.click();
		objManageCatalogPage.searchTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"),serviceName);
		objManageCatalogPage.searchTextBox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
    	}
		catch(Exception e){
			objManageCatalogPage.searchTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"),serviceName);
			objManageCatalogPage.searchTextBox.sendKeys(Keys.ENTER);
			Thread.sleep(2000);	
		}
		objManageCatalogPage.selectServiceRadiobutton.click();
		objManageCatalogPage.saveAndNextButton.click();
		explicitWait(objManageCatalogPage.selectAllLink);
		objManageCatalogPage.selectAllLink.click();
		objManageCatalogPage.saveAndFinishButton.click();
		objManageCatalogPage.catalogTab.click();
		}
		
		else{
			objManageCatalogPage.singleDeptRadiobutton.click();
			try{
			objManageCatalogPage.selectAllLink.click();
			}
			catch(Exception e){
				objManageCatalogPage.selectAllLink.click();
			}
			objManageCatalogPage.saveAndNextButton.click();
			objManageCatalogPage.selectDeptRadioButton.click();
			objManageCatalogPage.saveAndFinishButton.click();
			objManageCatalogPage.catalogTab.click();
			
		}
	}	
}
