package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class CmsDomainSettingsPage extends TestBase {
	
	public CmsDomainSettingsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSettingsPageTitle(String domain) {		
		String requiredXpath = "//h1[contains(text(),'Settings for needsSubstitution')]";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", domain)));		
	}
	
	@FindBy(xpath="//a[text()='Settings']")
	public WebElement domainSettingsLink;
	
	@FindBy(id="edit-site-name")
	public WebElement siteNameTextBox;
	
	@FindBy(id="edit-site-mail")
	public WebElement emailAddressTextBox;
	
	@FindBy(id="edit-site-frontpage")
	public WebElement siteFrontPageTextBox;
	
	@FindBy(id="edit-language-default")
	public WebElement defaultLangDropDown;
	
	@FindBy(id="edit-submit")
	public WebElement saveDomainSettingsButton;
	
	@FindBy(css="div.messages.status")
	public WebElement domainSettingsStatusMessage;

}
