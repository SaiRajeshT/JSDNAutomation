package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class CmsStructuresPage extends TestBase {
	
	public CmsStructuresPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Structure']")
	public WebElement structureHeading;
	
	@FindBy(linkText="Domains")
	public WebElement domainsLink;

}
