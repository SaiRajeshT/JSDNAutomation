package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class ManageCatalogPage extends TestBase{
	public ManageCatalogPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(linkText="Manage")
	public WebElement manageLink;
	
	@FindBy(xpath="//h2[contains(text(),'My Company')]//following::a[7]")
	public WebElement catalogLink;
	
	@FindBy(id="createCatalog")
	public WebElement createCatalog;
	
	@FindBy(id="multiDept")
	public WebElement multiDeptRadioButton;
	
	@FindBy(id="singleDept")
	public WebElement singleDeptRadiobutton;
	
	@FindBy(id="UserInputTxtBox_popUp")
	public WebElement searchTextBox;
	
	@FindBy(id="UserInputTxtBox")
	public WebElement searchTextBox2;
	
	@FindBy(xpath = "//input[@name='chkService']")
	public WebElement selectServiceRadiobutton;
	
	@FindBy(xpath = "//span[contains(text(),'Save & Next')]")
	public WebElement saveAndNextButton;
	
	@FindBy(xpath = "//input[@name='UserInputTxtBox']")
	public WebElement searchDepartmentTextBox;
	
	@FindBy(linkText="Select all")
	public WebElement selectAllLink;
	
	@FindBy(xpath = "//span[contains(text(),'Save & Finish')]")
	public WebElement saveAndFinishButton;
	
	@FindBy(linkText="Catalog")
	public WebElement catalogTab;
	
	@FindBy(xpath = "//input[@name='deptRadio']")
	public WebElement selectDeptRadioButton;
	
	public WebElement selectApp(String serviceName){
		String requiredXpath = "//span[contains(text(),needsSubstitution)]/..//input[@type='radio']";
		return getDriver().findElement(By.xpath(requiredXpath.replace("needsSubstitution", serviceName)));

	}
	

}
