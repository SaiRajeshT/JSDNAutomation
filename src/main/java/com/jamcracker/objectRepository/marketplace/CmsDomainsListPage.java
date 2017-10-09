package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class CmsDomainsListPage extends TestBase {
	
	public CmsDomainsListPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Domains']")
	public WebElement domainsHeading;
	
	@FindBy(linkText="Create domain")
	public WebElement createDomainLink;
	
	@FindBy(css="li.active")
	public WebElement domainListLink;
	
	public WebElement getEditDomainLink(String name) {		
		String requiredXpath = "//tr[td[text()='needsSubstitution']]/td/a[text()='edit domain']";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", name)));		
	}

}
