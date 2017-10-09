package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class CmsEditDomainPage extends TestBase {
	
	public CmsEditDomainPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getEditPageTitle(String domain) {		
		String requiredXpath = "//h1[contains(text(),'Edit needsSubstitution')]";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", domain)));		
	}

}
