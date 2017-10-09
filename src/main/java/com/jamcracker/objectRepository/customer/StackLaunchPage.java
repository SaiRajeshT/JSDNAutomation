package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class StackLaunchPage extends TestBase
{
	public StackLaunchPage(){
	PageFactory.initElements(driver, this);}
	
	@FindBy(name="stackName")
	public WebElement stackNameTextBox;
	
	@FindBy(name="stackDescription")
	public WebElement descriptionTextBox;
	
	@FindBy(name="salesRefCode")
	public WebElement salesReferenceCodeTextBox;
	
	@FindBy(id = "tagsContainerTitle")
	public WebElement tagLink;
	
	@FindBy(id="tagName_3")
	public WebElement tagTextBox;
	
	public WebElement getTagKeyTextBox(int i)
	{
		return driver.findElement(By.id("tagName_"+i));
	}
	
	public WebElement getTagValueTextBox(int i)
	{
		return driver.findElement(By.id("tagValue_"+i));
	}
	
	@FindBy(id="addNewNameAndValueTag")
	public WebElement addNewTagLink;
	
	@FindBy(xpath="//label[text()='Value']")
	public WebElement valueLink;
	
	@FindBy(name="name")
	public WebElement instanceNameTextBox;
	
	
	@FindBy(name="providerId")
	public WebElement vendorDropDown;
	
	@FindBy(name="region")
	public WebElement regionDropDown;
	
	@FindBy(name="availabilityZone")
	public WebElement availabilityZoneDropDown;
	
	@FindBy(name="InstanceType")
	public WebElement familyDropDown;
	
	@FindBy(name="familyType")
	public WebElement familyTypeDropDown;
	
	@FindBy(name="image")
	public WebElement imageDropDown;
	
	@FindBy(name="flavor")
	public WebElement flavorDropDown;
	
	@FindBy(name="AdminUserName")
	public WebElement instUserNameTextBox;
	
	@FindBy(name="AdminPassword")
	public WebElement instPasswordTextBox;
	
	@FindBy(name="resourceGroup")
	public WebElement resourceGroupDropDown;
	
	@FindBy(name="storageAccountType")
	public WebElement storageTypeDropDown;
	
	@FindBy(name="storageAccount")
	public WebElement storageAccountDropDown;
	
	@FindBy(name="availabilityset")
	public WebElement availabilitySetDropDown;
	
	
	
	
	
	
	@FindBy(name="AgentInstallation")
	public WebElement enableMonitoringDropDown;
	
	@FindBy(name="nicNameDesc")
	public WebElement networkNameTextBox;
	
	@FindBy(name="networkId")
	public WebElement networkDropDown;
	
	@FindBy(name="subnetId")
	public WebElement subnetDropDown;
	
	@FindBy(name="publicIP")
	public WebElement publicIPDropdown;
	
	@FindBy(id="saveTemplate")
	public WebElement stackLaunchButton;
	
	@FindBy(linkText="Create Security Group")
	public WebElement createSecurityGroupLink;
	
	@FindBy(id="webSecurityGroup")
	public WebElement SecurityGroupNameTextBox;
	
	@FindBy(xpath="//tr[@id='lastPopUp']/td/a[contains(text(),'Add New')]")
	public WebElement addNewRuleLink;
	
	@FindBy(id="doneSecg")
	public WebElement doneButton;
	
	@FindBy(id="cancelSecg")
	public WebElement SgCancelButton;
	
	
	public WebElement getRuleDD(String value) {		
		String requiredXpath = "//select[@id='selectCustomInput_needsSubstitution']";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", value)));		
	}
	
	//Dynamically Fetching Port Start Range Element
		public WebElement getPortStartRange(String value) {		
			String requiredXpath = "//input[@id='portRangeStartneedsSubstitution']";
			return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", value)));		
		}
		
		//Dynamically Fetching Port End Range Element
		public WebElement getPortEndRange(String value) {		
			String requiredXpath = "//input[@id='portRangeEndneedsSubstitution']";
			return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", value)));		
		}
		
		//Dynamically Fetching Ip Address Element
		public WebElement getIpAddress(String value) {		
			String requiredXpath = "//input[@id='ipaddress_needsSubstitution']";
			return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", value)));		
		}
		
		//Dynamically Fetching Sub-net Mask Element
		public WebElement getSubnetMask(String value) {		
			String requiredXpath = "//input[@id='portSubnetMaskneedsSubstitution']";
			return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", value)));		
		}
	
	
	

}
