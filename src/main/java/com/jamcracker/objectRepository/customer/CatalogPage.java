package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class CatalogPage extends TestBase {
	
	public CatalogPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Catalog")
	public WebElement catalogLink;
	
	@FindBy(id="search_api_views_fulltext")
	public WebElement searchTextBox;
	
/*	@FindBy(id="applicationSearchButton")
	public WebElement searchIconButton;*/
	
	@FindBy(xpath="//button[@id='applicationSearchButton']")
	public WebElement searchIconButton;
	
	@FindBy(xpath="//button[text()='Continue']")
	public WebElement continueButton;
	
	@FindBy(linkText="Launch")
	public WebElement launchButton;
	
	@FindBy(id="designerConsoleFrame")
	public WebElement launchstackFrame;
	
	@FindBy(id="dynamicParameterId_1_stackName")
	public WebElement stackNameTextBox;
	
	@FindBy(xpath="//button[@name='agree']")
	public WebElement  slaAgreeButton;
	
	
	public WebElement serviceNameText(String serviceName) {		
		String requiredXpath = "//div[@class='frontview views-fieldset']/h2/span[contains(text(),'needsSubstitution')]";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", serviceName)));		
	}
	
	public WebElement serviceViewOffersLink(String serviceName) {		
		String requiredXpath = "//div[@class='back views-fieldset'][h2[span[contains(text(),'needsSubstitution')]]]/div/span/a[text()='View Offers']";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", serviceName)));		
	}
	
	public WebElement addToCartButton(String offerName) {		
		String requiredXpath = "//div[div[h2[contains(text(),'needsSubstitution')]]]/div/div/a[text()='Add to Cart']";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", offerName)));		
	}
		
}
