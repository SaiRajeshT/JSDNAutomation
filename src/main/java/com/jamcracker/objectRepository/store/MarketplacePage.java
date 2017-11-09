package com.jamcracker.objectRepository.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class MarketplacePage extends TestBase {


	public MarketplacePage() {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Marketplace")
	public WebElement marketplaceLink;
	
	@FindBy(id="serviceSearchValue")
	public WebElement globalSearchTextBox;
	
	@FindBy(xpath="//img[@alt='Search']")
	public WebElement searchIconTextBox;
	
	
	public WebElement getResellButton(String serviceName){
	String objxpath = "//div[table[tbody[tr[td[text()='<REPLACE>']]]]]//following-sibling::div//span[text()='Resell']//parent::a";
	objxpath = objxpath.replaceAll("<REPLACE>", serviceName);
	System.out.println(objxpath);
	return driver.findElement(By.xpath(objxpath));}
	
	@FindBy(linkText="Collapse")
	public WebElement collapseLink;
	
	@FindBy(xpath="//button[contains(text(),'Pending Resells')]")
	public WebElement pendingResellButton;
	
	@FindBy(xpath="//button[text()='Complete Resells']")
	public WebElement completeResellButton;
	
	@FindBy(xpath="//button[contains(text(),'Go to Catalog')]")
	public WebElement goToCatalogButton;
	
	public WebElement selectService(String serviceName)
	{
		String objxpath = "//td[text()='<REPLACE>']//preceding-sibling::td[2]//input";
		objxpath = objxpath.replaceAll("<REPLACE>", serviceName);
		return driver.findElement(By.xpath(objxpath));
	}
	

}
