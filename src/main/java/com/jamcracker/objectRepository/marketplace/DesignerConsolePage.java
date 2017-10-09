package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jamcracker.utilities.TestBase;

public class DesignerConsolePage extends TestBase {	
	
	public DesignerConsolePage() {
		PageFactory.initElements(driver, this);		
	}
	
	public void waitForDesignerConsolePage() {		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("designerConsoleFrame")));		
	}
	
	@FindBy(id="designerConsoleFrame")
	public WebElement dcFrame;
	
	@FindBy(id="_id_link_cont_VM_linux")
	public WebElement getlinuxOS;
	
	@FindBy(id="_id_canvas_cont")
	public WebElement canvasSpace;
	
	@FindBy(id="dynamicParameterId_1_stackName")
	public WebElement getStackTempNameTextBox;
	
	@FindBy(id="dynamicParameterId_2_stackDescription")
	public WebElement getDescriptionTextBox;
	
	@FindBy(id="tagsContainerTitle")
	public WebElement getTagsTitle;
	
	@FindBy(id="addNewNameAndValueTag")
	public WebElement getAddNewLink;
	
	@FindBy(xpath="//input[@name='name']")
	public WebElement getInstanceNameTextBox;
	
	@FindBy(xpath="//div[select[@name='providerId']]/button[@type='button']")
	public WebElement getVendorsDropDown;
	
	//Dynamically Fetching the Vendor Element
	public WebElement getVendorCheckBox(String vendorName) {		
		String requiredXpath = "//input[@value='needsSubstitution']";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", vendorName)));		
	}
	
	@FindBy(xpath="//img[@title='Choose vendors from the list available.']")
	public WebElement getVendorToolTip;
	
	@FindBy(linkText="Create Security Group")
	public WebElement getSecurityGroupLink;
	
	@FindBy(id="webSecurityGroup")
	public WebElement getSecurityGroupNameTextBox;
	
	@FindBy(xpath="//tr[@id='lastPopUp']/td/a[contains(text(),'Add New')]")
	public WebElement getSgAddNewLink;
	
	@FindBy(id="doneSecg")
	public WebElement getDoneButton;
	
	@FindBy(id="cancelSecg")
	public WebElement getSgCancelButton;
	
	@FindBy(id="saveTemplate")
	public WebElement getSaveTemplateButton;
	
	@FindBy(id="closeDesignerConsole")
	public WebElement getCancelButton;
	
	@FindBy(xpath="//label[text()='Value']")
	public WebElement getValueLabel;
	
	//Dynamically Fetching Tag Key Elements
	public WebElement getTagKeyCheckBox(String value) {		
		String requiredXpath = "//input[@id='tagName_needsSubstitution']";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", value)));		
	}
	
	//Dynamically Fetching Tag Value Elements
	public WebElement getTagValueCheckBox(String value) {		
		String requiredXpath = "//input[@id='tagValue_needsSubstitution']";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", value)));		
	}
	
	//Dynamically Fetching the Rule Selection
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
	
	@FindBy(id="_id_link_cont_VM_mswin")
	public WebElement getWindowsOS;
	
	@FindBy(xpath="//div[@class='canvasresources resource ui-draggable _jsPlumb_endpoint_anchor_ ui-droppable vmbase-selected']")
	public WebElement getScriptContainer;
	
	@FindBy(id="resourceItemMenuAnchor_SCRIPTS")
	public WebElement getScritpsLink;
	
	@FindBy(id="_id_link_cont_SCRIPTS_SCRIPT")
	public WebElement getShellScript;
	
	@FindBy(id="_id_link_cont_SCRIPTS_CHEF")
	public WebElement getChefScript;
	
	@FindBy(name="script")
	public WebElement getShellScriptTextBox;
	
	@FindBy(name="chefClient")
	public WebElement getChefType;
	
	@FindBy(name="client")
	public WebElement getClientTextBox;
	
	@FindBy(name="validator")
	public WebElement getValidatorTextBox;
	
	@FindBy(name="endpoint")
	public WebElement getEndpointTextBox;
	
	@FindBy(name="validatorPemFile")
	public WebElement getValidatorPemFileTextBox;
	
	@FindBy(name="clientPemFile")
	public WebElement getClientPemFileTextBox;
	
	@FindBy(name="certFile")
	public WebElement getCertificateTextBox;
	
	@FindBy(name="organization")
	public WebElement getOrganizationTextBox;
	
	@FindBy(xpath="//input[@class='cookbooksequenceinput']")
	public WebElement getCookbookTextBox;
		
}
