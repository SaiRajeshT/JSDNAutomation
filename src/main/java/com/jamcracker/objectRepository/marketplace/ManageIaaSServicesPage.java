package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class ManageIaaSServicesPage extends TestBase {
	
	public ManageIaaSServicesPage() {		
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(linkText="Service Management")
	public WebElement getServiceManagementLink;
	
	@FindBy(id="simpleValue")
	public WebElement  getSearchServicesTextBox;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement getGoButton;
	
	@FindBy(xpath="//button[contains(text(),'Edit')]")
	public WebElement getEditButton;
	
	public WebElement getReviewLink(String stackName){		
		String requiredXpath = "//tr[td[@title='needsSubstitution']]/td/a[contains(text(),'Review')]";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", stackName)));		
	}
	
	@FindBy(xpath="//tr[td[table[tbody[tr[td[contains(text(),'Upload the SLA for this Service. (HTML format)')]]]]]]/td/table/tbody/tr/td/div/div/button[@class='sbButtonTextLink']")
	public WebElement getSLAAddButton;
	
	@FindBy(xpath="//div[span[contains(text(),'Stack')]]/input[@type='checkbox']")
	public WebElement getStackCheckBox;
	
	@FindBy(xpath="//button[contains(text(),'Save & Review')]")
	public WebElement getSaveReviewButton;
	
	@FindBy(linkText="Offers")
	public WebElement getOffersLink;
	
	@FindBy(xpath="//img[@title='Edit Offer']")
	public WebElement getEditOfferIcon;
	
	@FindBy(xpath="//span[contains(text(),'Pricing Information')]")
	public WebElement getPricingInformtionTab;
	
	@FindBy(name="unitPriceDescription")
	public WebElement getUnitPriceDecsTextBox;
	
	@FindBy(xpath="//tbody[tr[td[contains(text(),'Associate Tax')]]]/tr/td/table/tbody/tr/td/div/div/button[contains(text(),'Save & Exit')]")
	public WebElement getSaveExitButton;
	
	@FindBy(xpath="//button[contains(text(),'Next >>')]")
	public WebElement getNextButton;
	
	@FindBy(name="resell")
	public WebElement getResellCheckBox;
	
	@FindBy(name="requestQuote")
	public WebElement getRequestQuoteTextBox;
	
	@FindBy(name="saveNext")
	public WebElement getSaveNextButton;
	
	@FindBy(xpath="//button[text()='Finish']")
	public WebElement getFinishButton;
	
	@FindBy(xpath="//button[text()='Approve ']")
	public WebElement getApproveButton;
	
	public WebElement getServiceStatus(String stackName){		
		String requiredXpath = "//tr[td[@title='needsSubstitution']]/td[@title='Approved']";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", stackName)));		
	}
		
}
