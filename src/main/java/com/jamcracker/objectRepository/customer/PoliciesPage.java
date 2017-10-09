package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class PoliciesPage extends TestBase {
	
	public PoliciesPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="showAddPolicy")
	public WebElement addPolicyLink;
	
	@FindBy(id="policyName")
	public WebElement policyNameTextBox;
	
	@FindBy(id="policyDesc")
	public WebElement policyDescTextBox;
	
	@FindBy(id="addPolicyFor")
	public WebElement policyCategoryDropDown;
	
	@FindBy(id="addPolicyUsing")
	public WebElement usingEventDropDown;
	
	@FindBy(id="actionDropDown")
	public WebElement actionDropDown;
	
	@FindBy(id="criteriaParamInput_departments")
	public WebElement departmentsDropDown;
	
	@FindBy(id="criteriaParamInput_provider")
	public WebElement providerDropDown;
	
	@FindBy(xpath="//div[select[@id='criteriaParamInput_region']]/button[@name='multiselectbutton']")
	public WebElement regionsButton;
	
	public WebElement regionsCheckBox(String region) {
		String requiredXpath = "//input[@value='needsSubstitution']";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", region))); 
	}
	
	@FindBy(className="leftDivCont")
	public WebElement providersText;
	
	@FindBy(xpath="//div[select[@id='criteriaParamInput_image']]/button[@name='multiselectbutton']")
	public WebElement imagesButton;
	
	public WebElement imagesCheckBox(String image) {
		String requiredXpath = "//label[span[contains(text(),'needsSubstitution')]]/input";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", image))); 
	}
	
	@FindBy(xpath="//div[select[@id='criteriaParamInput_flavor']]/button[@name='multiselectbutton']")
	public WebElement sizeButton;
	
	public WebElement sizesCheckBox(String size) {
		String requiredXpath = "//input[@value='needsSubstitution']";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", size))); 
	}
	
	@FindBy(xpath="//div[select[@id='criteriaParamInput_networkId']]/button[@name='multiselectbutton']")
	public WebElement networkButton;
	
	public WebElement networksCheckBox(String network) {
		String requiredXpath = "//label[span[contains(text(),'needsSubstitution')]]/input";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", network))); 
	}
	
	@FindBy(id="saveFinish")
	public WebElement saveAndFinishButton;
	
	@FindBy(id="table_search")
	public WebElement searchPolicyTextBox;
	
	public WebElement policyNameText(String policyName) {
		String requiredXpath = "//div[contains(text(),'needsSubstitution')]";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", policyName)));
	}
	
	@FindBy(xpath="//div[contains(text(),'Go')]")
	public WebElement goButton;
	
	@FindBy(id="HelpIconProvider")
	public WebElement providerHelpIcon;
	
	@FindBy(xpath="(//div[@class='ui-multiselect-menu ui-widget ui-widget-content ui-corner-all'])[1]")
	public WebElement regionSelectionSection;
	
	public WebElement resourceTagKeyTextBox(int a) {
		String requiredXpath = "(//input[@name='policyKey'])[needsSubstitution]";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", Integer.toString(a))));	
	}
	
	public WebElement resourceTagValueTextBox(int a) {
		String requiredXpath = "(//input[@name='policyValue'])[needsSubstitution]";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", Integer.toString(a))));	
	}
	
	@FindBy(id="FilterBy")
	public WebElement tagsHelpIcon;
	
	@FindBy(partialLinkText="Another Tag")
	public WebElement anothertagLink;
	
}
