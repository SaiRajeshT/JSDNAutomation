package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class ServiceManagementPage extends TestBase {
	public ServiceManagementPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//a[contains(text(),'Service Management')]")
	public WebElement serviceManagementLink;
	
	
	@FindBy(linkText="Offers")
	public WebElement offersTab;
	@FindBy(xpath="//input[@value='Approve Selected']")
	public WebElement ApproveButton;
	
	@FindBy(id="simpleValue")
	public WebElement searchTextBox;
	
	@FindBy(xpath="//button[text()='Go']")
	public WebElement goButton;
	
	@FindBy(xpath="//button[text()='Yes']")
	public WebElement yesButton;
	
	public WebElement EditService(String serviceName){
		return getDriver().findElement(By.xpath("//td[@title='"+serviceName+"']//following-sibling::td//a//img[@title='Edit Service']"));
	}

	public WebElement getSelectServiceCheckbox(String serviceName) {
		String objXPath = "//td[text()='<REPLACE>']//preceding-sibling::td[4]//input[@type='checkbox']";
		objXPath = objXPath.replaceAll("<REPLACE>", serviceName);
		return getDriver().findElement(By.xpath(objXPath));
	}

	 public WebElement  getServiceStatus(String serviceName)
	 {
		 String objPath="//td[text()='<REPLACE>']//following-sibling::td[text()='Approved']" ;
		 objPath = objPath.replaceAll("<REPLACE>", serviceName);
		 System.out.println(objPath);
		 return getDriver().findElement(By.xpath(objPath));
	 }
	 
	
}
