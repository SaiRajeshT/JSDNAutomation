package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class CmsDomainCreationPage extends TestBase {
	
	public CmsDomainCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="edit-subdomain")
	public WebElement domainTextBox;
	
	@FindBy(id="edit-sitename")
	public WebElement sitenameTextBox;
	
	@FindBy(id="edit-scheme-https")
	public WebElement httpsRadioButton;
	
	@FindBy(id="edit-is-store")
	public WebElement restrictPreLoginCheckBox;
	
	@FindBy(id="edit-ad-configure")
	public WebElement adConfiguredCheckBox;
	
	@FindBy(id="edit-submit")
	public WebElement saveDomainRecordButton;
	
	@FindBy(css="div#console div.messages.status")
	public WebElement domainStatusMessage;

}
