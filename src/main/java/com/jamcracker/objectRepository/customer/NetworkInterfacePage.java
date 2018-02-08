package com.jamcracker.objectRepository.customer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class NetworkInterfacePage extends TestBase{
	
	public NetworkInterfacePage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(linkText="Network Interfaces")
	public WebElement networkInterfaceLink;
	
	@FindBy(xpath="//button[span[text()='Add Network Interface']]")
	public WebElement addNetworkIntefaceButton;
	
	@FindBy(id="nameDesc")
	public WebElement nicNameTextBox;
	
	@FindBy(id="subnetId")
	public WebElement subNetDropDown;
	
	@FindBy(id="publicIP")
	public WebElement publicIpDropdown;
	
	@FindBy(xpath="//p[contains(text(),'Security Groups')]")
	public WebElement securityGroupLink;
	
	@FindBy(linkText="Create Security Group")
	public WebElement createSecurityGroupLink;
	
	@FindBy(xpath="//form[@id='createNewSecGrp']//input[@name='secGrpNmae']")
	public WebElement securityGroupNameTextBox;
	
	@FindBy(name="secGrpRule")
	public WebElement ruleDropDown;
	
	@FindBy(id="fromPort")
	public WebElement fromPortRangeTextBox;
	
	@FindBy(id="toPort")
	public WebElement toPortRangeTextBox;
	
	@FindBy(id="cidrIpAddress")
	public WebElement ipAddressTextBox;
	
	@FindBy(id="cidrIpPort")
	public WebElement subnetMaskTextBox;
	
	@FindBy(id="addPort")
	public WebElement addButton;
	
	@FindBy(id="table_search")
	public WebElement searchTextBox;
	
	@FindBy(xpath="//div[text()='Go']")
	public WebElement goButton;
	
	@FindBy(linkText="Active")
	public WebElement activeNic;
	
	@FindBy(linkText="Error")
	public WebElement errorNic;
	
	@FindBy(linkText="Delete")
	public WebElement deleteNicLink;
	
	@FindBy(xpath="//div[@id='facebox']//button[@name='btname']//span[text()='Confirm']")
	public WebElement nicDeleteConfirm;
	
	@FindBy(linkText="Edit")
	public WebElement editNic;
	
	
	
	public WebElement getNicAction(String nicName)
	{
		return getDriver().findElement(By.xpath("//td[text()='"+nicName+"']//following::span[contains(text(),'Actions')]"));
		
	}
	
	@FindBy(xpath="//table[@id='jcTable_listOfPorts_main']//tbody//tr")
	public List<WebElement> rows;
	
	
	
	public String getStatus(String nicName){
		return getDriver().findElement(By.xpath("//a[@portname='"+nicName+"']")).getAttribute("linkstatus");
			
		
	}
	
	
	
	//Security group rule drop down
	public WebElement getRuleDD(String value) {		
		String requiredXpath = "//select[@id='protocol_"+value+"']";
		return getDriver().findElement(By.xpath(requiredXpath));		
	}
	
	//Dynamically Fetching Port Start Range Element
		public WebElement getPortStartRange(String value) {		
			String requiredXpath = "//input[@id='fromPort_"+value+"']";
			
			return getDriver().findElement(By.xpath(requiredXpath));		
		}
		
		//Dynamically Fetching Port End Range Element
		public WebElement getPortEndRange(String value) {		
			String requiredXpath = "//input[@id='toPort_"+value+"']";
			return getDriver().findElement(By.xpath(requiredXpath));		
		}
	
	//Ip address Text Box
		public WebElement getIpddressTextBox(String value)
		{
			return getDriver().findElement(By.id("cidrIpAddress_"+value));
		}
		
		//SubNetMask TextBox
		public WebElement getSubNetMaskTextBox(String value)
		{
			return getDriver().findElement(By.id("cidrIpPort_"+value));
		}
		

	@FindBy(linkText="Add New")
	public WebElement addNewRuleLink;
	
	@FindBy(xpath="//form[@id='createNewSecGrp']//span[text()='Create']")
	public WebElement createButton;
	
	@FindBy(xpath="//form[@id='createNewSecGrp']//span[text()='Cancel']")
	public WebElement cancelButton;
	
	
		
	
}
