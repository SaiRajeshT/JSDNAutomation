package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jamcracker.utilities.TestBase;

public class MpIaaSConsolePage extends TestBase {
	
	public MpIaaSConsolePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void waitForMpIaaSConsolePage() {		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wrapper")));		
	}
	
	@FindBy(xpath="//button[contains(text(),'Create Stack Template')]")
	public WebElement getCreateStackTemplateButton;
	
	public WebElement getStackName(String stackName) {		
		String requiredXpath = "//td[@title='needsSubstitution']";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", stackName)));		
	}
	
	public WebElement getPublishLink(String stackName) {		
		String requiredXpath = "//tr[td[@title='needsSubstitution']]/td/a/img[@title='Publish']";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", stackName)));		
	}
	
	@FindBy(id="serviceName")
	public WebElement getServiceNameTextBox;
	
	@FindBy(xpath="//span[@id='cke_shortDescription']")
	public WebElement getShortDesc;
	
	@FindBy(id="cke_detailedDescription")
	public WebElement getDetailedDesc;
	
	@FindBy(xpath="//input[@type='file']")
	public WebElement getLogoUploadFile;
	
	@FindBy(id="serviceFinish")
	public WebElement getSaveAndFinishButton;
	
}
