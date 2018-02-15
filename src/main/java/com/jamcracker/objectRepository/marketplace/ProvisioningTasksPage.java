package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class ProvisioningTasksPage extends TestBase {

	public ProvisioningTasksPage()
	{
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//a[contains(text(),'Provisioning Task')]")
	public WebElement ProvisioningTasksLink;

    @FindBy(xpath="//select[@id='selectFromList']")
	public WebElement ShowTasksDropdown;
    
    @FindBy(xpath="//input[@name='simpleValue']")
    public WebElement searchTextBox;
    
    @FindBy(xpath="//select[@name='simpleCriteria']")
    public WebElement selectDropDown;
    
    @FindBy(xpath="//option[contains(text(),'Organization Name')]")
    public WebElement selectOrganizationName;   
    
    @FindBy(xpath="//button[contains(text(),'Go')]")
    public WebElement goButton;
    
    public WebElement selectTaskType(String taskType){
    String requiredXpath ="//option[contains(text(),'needsSubstitution')]";
    return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", taskType)));
    }
    
    
    public WebElement checkbox(String offerCode){
    String requiredXpath ="//td[contains(text(),'needsSubstitution')]/..//input[@type='checkbox']";
    return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", offerCode)));
    }
  
    public WebElement buttonType(String buttonType){
    String requiredXpath ="//button[contains(text(),'needsSubstitution')]";
    return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", buttonType)));
    }
}
    
    

