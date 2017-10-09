package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class SLAUploadPage extends TestBase {
	
	public SLAUploadPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='file']")
	public WebElement getSLALocationFile;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	public WebElement getSaveButton;
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	public WebElement getCancelButton;
	
	public void testSLAUpload() {
		getSLALocationFile.sendKeys(System.getProperty("user.dir") + "/Data/SlaAndPolicies/sla.html");
		getSaveButton.click();
	}

}
