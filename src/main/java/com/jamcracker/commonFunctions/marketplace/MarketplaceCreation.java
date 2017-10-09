package com.jamcracker.commonFunctions.marketplace;

import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.superAdmin.SuperAdminMarktplacesPage;
import com.jamcracker.utilities.SwitchFrame;
import com.jamcracker.utilities.TestBase;

public class MarketplaceCreation extends TestBase
{
	public void createMarketplace(String marketplaceURL, String companyAcronym, String CompanyName,String marketplaceAdminEmail, String marketplaceAdminPassword,String marketplaceFullName,String marketplaceShortName, String marketplaceAcronym)
	{
		try{
		SuperAdminMarktplacesPage superAdminMktPlacePage = new SuperAdminMarktplacesPage();
		superAdminMktPlacePage.addMarketplaceLink.click();
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
		explicitWait(superAdminMktPlacePage.addMarketplaceLink);
		if(superAdminMktPlacePage.getMarketplaceName(CompanyName).isDisplayed()){
			Reporter.log("Marketplace creation is  successfull");
			
		}
		}
		
		catch(Exception e)
		{
			Reporter.log("Issue while creating Marketplace.Please look in to the issue");
			Assert.fail();
			e.printStackTrace();
			
		}
	}

}
