package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class CmsDomainThemePage extends TestBase {
	
	public CmsDomainThemePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Theme']")
	public WebElement themeLink;
	
	public WebElement getThemePageTitle(String domain) {		
		String requiredXpath = "//h1[contains(text(),'Theme for needsSubstitution')]";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", domain)));		
	}
	
	@FindBy(xpath="//tr[td[h3[contains(text(),'JSDN Default Theme')]]]/td/a[text()='configure']")
	public WebElement configureLink;
	
	@FindBy(id="edit-logo-upload")
	public WebElement uploadLogo;
	
	@FindBy(id="edit-submit")
	public WebElement saveConfigurationButton;
	
	@FindBy(xpath="//div[@class='messages status']")
	public WebElement successMsg;

}
