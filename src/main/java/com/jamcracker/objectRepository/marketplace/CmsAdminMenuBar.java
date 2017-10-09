package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class CmsAdminMenuBar extends TestBase {
	
	public CmsAdminMenuBar() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Home']")
	public WebElement homeLink;
	
	@FindBy(linkText="Dashboard")
	public WebElement dashboardLink;
	
	@FindBy(linkText="Content")
	public WebElement contentLink;
	
	@FindBy(linkText="Structure")
	public WebElement structureLink;
	
	@FindBy(linkText="Appearance")
	public WebElement appearanceLink;
	
	@FindBy(linkText="People")
	public WebElement peopleLink;
	
	@FindBy(linkText="Modules")
	public WebElement modulesLink;
	
	@FindBy(linkText="Affiliated content")
	public WebElement affiliatedContentLink;
	
	@FindBy(linkText="Configuration")
	public WebElement configurationLink;
	
	@FindBy(linkText="Reports")
	public WebElement reportsLink;
	
	@FindBy(linkText="Help")
	public WebElement helpLink;
	
	@FindBy(linkText="Log out")
	public WebElement logoutLink;

}
