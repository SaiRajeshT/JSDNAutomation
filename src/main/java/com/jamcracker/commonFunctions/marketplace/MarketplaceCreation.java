package com.jamcracker.commonFunctions.marketplace;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.superAdmin.SuperAdminMarktplacesPage;
import com.jamcracker.utilities.SwitchFrame;
import com.jamcracker.utilities.TestBase;
import com.jamcracker.utilities.WaitTillElementDisplayed;

public class MarketplaceCreation extends TestBase
{
	public void createMarketplace(String marketplaceURL, String companyAcronym, String CompanyName,String marketplaceAdminEmail, String marketplaceAdminPassword,String marketplaceFullName,String marketplaceShortName, String marketplaceAcronym)
	{
		try{
		SuperAdminMarktplacesPage superAdminMktPlacePage = new SuperAdminMarktplacesPage();
		System.out.println(getDriver().getTitle());
		superAdminMktPlacePage.addMarketplaceLink.click();
		Thread.sleep(3000);
		SwitchFrame.nameIdSwitch("_iframe-addmp");
		explicitWait(superAdminMktPlacePage.marketplaceUrlTextBox);
		superAdminMktPlacePage.marketplaceUrlTextBox.sendKeys(marketplaceURL);
		superAdminMktPlacePage.companyAcronymTextBox.sendKeys(companyAcronym);
		superAdminMktPlacePage.companyNameTextBox.sendKeys(CompanyName);
		superAdminMktPlacePage.rootUserIdTextBox.sendKeys(marketplaceAdminEmail);
		superAdminMktPlacePage.rootUserPasswordTextBox.sendKeys(marketplaceAdminPassword);
		superAdminMktPlacePage.confirmPasswordTextBox.sendKeys(marketplaceAdminPassword);
		superAdminMktPlacePage.marketplaceFNameTextBox.sendKeys(marketplaceFullName);
		superAdminMktPlacePage.marketPlaceSNameTextBox.sendKeys(marketplaceShortName);
		superAdminMktPlacePage.marketplaceAcronymTextBox.sendKeys(marketplaceAcronym);
		superAdminMktPlacePage.createMarketplaceButton.click();
		SwitchFrame.defaultSwitch();
		/*while(true){
		try{
			superAdminMktPlacePage.getMarketplaceName(CompanyName).isDisplayed();
			break;
			}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		*/
		if(WaitTillElementDisplayed.elementdisplayed(superAdminMktPlacePage.getMarketplaceName(CompanyName))==true){
		//explicitWaitToClickable(superAdminMktPlacePage.logOutLInk);
		Reporter.log("Marketplace creation is  successfull");}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Issue while creating Marketplace.Please look in to the issue");
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
			Assert.fail();
			
			
		}
	}

}
