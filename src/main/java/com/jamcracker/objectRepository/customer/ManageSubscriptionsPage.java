package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class ManageSubscriptionsPage extends TestBase {
	
	public ManageSubscriptionsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="mainWrapper")
	public WebElement manageSubscritpionsPage;
	
	public WebElement actionsLink(String offerCode) throws Exception {
		String offerId = ResultsFromDB.getOfferID(offerCode);
		String requiredXpath = "//tr[@id='needsSubstitution']/td/span";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", offerId)));		
	}
	
	@FindBy(linkText="View Details")
	public WebElement viewDetailsLink;
	
	@FindBy(linkText="Assign to Users")
	public WebElement assignToUsersLink;
	
	@FindBy(linkText="Unsubscribe")
	public WebElement unsubscribeLink;

}
