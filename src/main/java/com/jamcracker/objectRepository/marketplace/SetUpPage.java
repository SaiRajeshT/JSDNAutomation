package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class SetUpPage extends TestBase 
{
	
	static SetUpPage  instance = new SetUpPage();
	
	private  SetUpPage()
	{
		PageFactory.initElements(driver, this);
	}
	
		public static SetUpPage getInstance()
	{
	return  new SetUpPage();	
	}
	
	@FindBy(xpath="//a[contains(text(),'Set Up')]")
	public WebElement setUpLink;
	
	
	
	
	@FindBy(xpath="//a[text()='Branding']")
	public WebElement brandingLink;
	
	@FindBy(linkText="Upload Logo")
	public WebElement uploadLogoLink;
	
	@FindBy(xpath="//input[@id='logo']")
	public WebElement browseButton;
	
	@FindBy(xpath="//select[@id='displayTheme']")
	public WebElement themeDropdown;
	
	@FindBy(xpath="//button[contains(text(),'Save & Next')]")
	public WebElement saveAndNextButton;
		
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	public WebElement submitButton;
	
	@FindBy(xpath="//input[@id='language_en_US']")
	public WebElement languageEnglishCheckbox;
	
	@FindBy(xpath="//div[@id='new_language_en_US']//input[@value='en_US']")
	public WebElement defaultEnglishRadioButton;
	
	@FindBy(id="SelectLanguageBtn")
	public WebElement addTimezoneButton;
	
	@FindBy(linkText="Regional Settings")
	public WebElement regionalSettingsLink;
	
	public WebElement getLanguage(String language) 
	{
		  String requiredXpath = "//label[text()='<REPLACE>']//parent::p/input";
		  return driver.findElement(By.xpath(requiredXpath.replace("<REPLACE>", language)));
	 }
	
	public WebElement getDefaultLanguage(String defaultLanguage) 
	{
		  String requiredXpath = "//div[text()='<REPLACE>']//preceding-sibling::div//input[@type='radio']";
		  return driver.findElement(By.xpath(requiredXpath.replace("<REPLACE>", defaultLanguage)));
	 }
	
	
	public WebElement getTimeZone(String TimeZone) 
	{
		  String requiredXpath = "//label[text()='needsSubstitution']//parent::p/input";
		  return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", TimeZone)));
		 }

	public WebElement getDefaultTimeZone(String defaultTimeZone) 
	{
		  String requiredXpath = "//div[div[(text()='needsSubstitution')]]/div/input[@name='defaultTimeZone']";
		  return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", defaultTimeZone)));
		 }
	
	
	@FindBy(id="SelectTimeZoneBtn")
	public WebElement addDateFormatButton;
	
	public WebElement getDateFormat(String dateFormat) 
	{
		  String requiredXpath = "//label[text()='needsSubstitution']//parent::p//input";
		  return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", dateFormat)));
	}
	
	
	public WebElement getDefaultDateFormat(String defaultDateFormat) 
	{
		  String requiredXpath = "//div[text()='needsSubstitution']//parent::div//input";
		  return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", defaultDateFormat)));
	}
	
	@FindBy(linkText="On Demand Service Delivery Network Policies")
	public WebElement onDemandNetworkPolicyLink;
	
	@FindBy(id="SelectDateFormatBtn")
	public WebElement saveAndContinueButton;
	
	@FindBy(id="copyrightNotice")
	public WebElement copyRightNoticeField;
	
	@FindBy(xpath="//input[@name='idendtityRadio'][@value='no']")
	public WebElement identityMgtNoRadioButton;
	
	@FindBy(xpath="//div[@id='finish']//button[contains(text(),'Save & Finish')]")
	public WebElement saveAndFinishButton;
	
	@FindBy(id="memberAddService")
	public WebElement memberAddServiceTextBox;
	
	@FindBy(id="emailSignature")
	public WebElement emailSignatureTextBox;
	
	@FindBy(linkText="Billing Options")
	public WebElement bilingOptionsLink;
	
	@FindBy(id="billingCurrValue")
	public WebElement currenciesDropdown;
	
	@FindBy(id="defCurrencyVal")
	public WebElement defaultCurrencyDropdown;
	
	
	
	public WebElement getsameDayRadioButton(String billingType) 
	{
		  String requiredXpath = "//label[text()='<REPLACE>']//parent::td//parent::tr//input[@value='D']";
		  return driver.findElement(By.xpath(requiredXpath.replace("<REPLACE>", billingType)));
	}

	public WebElement getmonthlyRadioButton(String billingType) 
	{
		  String requiredXpath = "//label[text()='<REPLACE>']//parent::td//parent::tr//input[@value='M']";
		  return driver.findElement(By.xpath(requiredXpath.replace("<REPLACE>", billingType)));
	}
	
	@FindBy(xpath="//table[@id='invoiceDay1']//select[@id='invoiceDay']")
	public WebElement monthlyDomDateDropDown;
	
	@FindBy(id="cutOffPeriod")
	public WebElement cutOffPeriodDropdown;
	
	@FindBy(name="itemizedInvoice")
	public WebElement itemizedInvoiceCheckbox;
	
	@FindBy(xpath="//input[@name='invoiceChargeDelay']")
	public WebElement paymentDueTextBox;
	
	@FindBy(id="700008")
	public WebElement creditCardCheckBox;
	
	@FindBy(xpath="//label[text()='Braintree']//preceding-sibling::input")
	public WebElement brainTreeCheckbox;
	
	@FindBy(id="autoBRAINTREE_GATEWAY_ID")
	public WebElement brainTreeAutomaticCheckBox;
	
	@FindBy(id="700008_option")
	public WebElement tmPaymentChcekBox;
	
	@FindBy(xpath="(//label[text()='Customer Self Service']//preceding-sibling::input)[1]")
	public WebElement customerSelfServiceCheckBox;
	
	@FindBy(id="700000")
	public WebElement payPalCheckBox;
	
	@FindBy(xpath="//label[text()='PayPal Express']//preceding-sibling::input")
	public WebElement payPalExpressCheckBox;
	
	@FindBy(id="autoJCB_GATEWAY_00007")
	public WebElement paypalAutomaticCheckBox;
	
	
	@FindBy(id="700005")
	public WebElement preApprovedCheckbox;
	
	@FindBy(xpath="//select[@name='noOfpaymentDueAlertsDay']")
	public WebElement paymentDueAlertDropDown;
	
	@FindBy(xpath="//select[@name='noOfAlertsDay']")
	public WebElement numberofAlertsDropDown;
	
	@FindBy(xpath="//select[@name='noOfIntervalDay']")
	public WebElement intervalBetweenAlertsDropDown;
	
	@FindBy(linkText="Tax Setup")
	public WebElement taxSetUpLink;
	
	@FindBy(xpath="//button[text()='Add new tax']")
	public WebElement addNewTaxButton;
	
	@FindBy(xpath="//button[contains(text(),'Next')]")
	public WebElement nextButton;
	
	@FindBy(id="recordsPerPage")
	public WebElement noOfRecordsPerPage;
	
	@FindBy(xpath="//input[@value='Add Content']")
	public WebElement addContentButton;
	
	@FindBy(xpath="//button[contains(text(),'Finish')]")
	public WebElement finishButton;
	
	@FindBy(xpath="//td[@class='sbListText']/p[1]")
	public WebElement finishMktplaceSetuPMessage;
	
	@FindBy(xpath="//button[text() ='Close']")
	public WebElement closeButton;
	
	
//Specific to store user in marketplace url
	
	@FindBy(name="dstoreLoginURL")
	public WebElement storeURLTextBox;
	
	@FindBy(linkText="Store Policies")
	public WebElement storePolicyLink;
	
	@FindBy(xpath="//td[text()='Privacy Policy*']//following-sibling::td//img[@title='Edit']")
	public WebElement privacyPolicyEditIcon;
	
	@FindBy(xpath="//input[@name='uploadFile']")
	public WebElement upLoadFile;
	
	@FindBy(xpath="//input[@value='uploadRadio']")
	public WebElement FileRadionButton;
	
	@FindBy(name="save")
	public WebElement saveButton;
	
	@FindBy(xpath="//td[text()='Privacy Policy*']//following-sibling::td[text()='Activated']")
	public WebElement privacyPolicyStatus;
	
	@FindBy(xpath="//td[text()='Security Statement*']//following-sibling::td//img[@title='Edit']")
	public WebElement securityEditIcon;
	
	
	
	@FindBy(xpath="//td[text()='Security Statement*']//following-sibling::td[text()='Activated']")
	public WebElement securityStatus;
	
	@FindBy(xpath="//input[@value='R']")
	public WebElement resellerRadioButton;
	
	@FindBy(xpath="//input[@value='E']")
	public WebElement enterpriseRadioButton;
	
	@FindBy(linkText="Store Type")
	public WebElement storeTypeLink;
	
	@FindBy(name="isBudgetEnabled")
	public WebElement enableBudgetCheckbox;
	
	@FindBy(xpath="//input[@name='idendtityRadio'][@value='no']")
	public WebElement identityMgmtNoRadioButton;
	
	@FindBy(xpath="//input[@name='idendtityRadio'][@value='yes']")
	public WebElement identityMgmtYesRadioButton;
	
	@FindBy(id="selectAllServices")
	public WebElement selectAllcheckbox;
	
	@FindBy(id="unSelectAllServices")
	public WebElement unSelectServiceCheckbox;
	
	@FindBy(linkText="Customer Email Notifications")
	public WebElement customerEmailNotificationLink; 
	
	@FindBy(xpath="//textarea[@name='notifySign']")
	public WebElement storeEmailSignatureTextBox;
	
	@FindBy(name="notifyOrder")
	public WebElement storeMemberOrderEmailTextBox;
	
	
	@FindBy(name="notifyComp")
	public WebElement storeRegistrantEmailTextBox;
	
	@FindBy(name="mailFrom")
	public WebElement fromAddressEmailTextBox;
	
	@FindBy(name="supportSign")
	public WebElement customerHelpDeskSignatureTextBox;
	
	@FindBy(name="notifyEnquire")
	public WebElement contentOnlyServiceEmailTextBox;
	
	
	@FindBy(name="supportMailFrom")
	public WebElement supportFromEmailTextBox;
	
	@FindBy(id="700008_paymentOption")
	public WebElement creditPaymentGateWayDropDown;
	
	@FindBy(id="700000_paymentOption")
	public WebElement paypalPaymentGateWayDropDown;
	
	@FindBy(name="BRAINTREE_GATEWAY_IDCARD_RETRIES_DAYS")
	public WebElement brainTreeDaysBtwnRetriesDropDown;
	
	@FindBy(name="BRAINTREE_GATEWAY_IDCARD_NO_OF_RETRIES_DAYS")
	public WebElement brainTreeNumberOfPaymentAttemptsDropDown;
	
	@FindBy(name="JCB_GATEWAY_00007CC_RETRIES_DAYS")
	public WebElement payPalDaysBtwnRetriesDropDown;
	
	@FindBy(name="JCB_GATEWAY_00007CC_NO_OF_RETRIES_DAYS")
	public WebElement payPalNumberOfPaymentAttemptsDropDown;
	
	@FindBy(name="defaultPaymentMethod")
	public WebElement defaultPaymentMethodDropDown;
	
	@FindBy(name="enablePayNow")
	public WebElement payNowCheckBox;
	
	@FindBy(name="canDelete")
	public WebElement deleteCompaniesCheckbox;
	
	@FindBy(name="canSuspend")
	public WebElement suspendCompaniesCheckbox;
	
	@FindBy(name="canDAdminOrder")
	public WebElement selfOrderCheckbox;
	

	@FindBy(name="showPublisher")
	public WebElement showPublisherCheckbox;

	@FindBy(name="canProxy")
	public WebElement proxyCustomerCheckbox;

	@FindBy(name="manageRealestate")
	public WebElement manageCommericalContentCheckbox;

	@FindBy(name="showAnalytic")
	public WebElement showAnalyticStaticCheckbox;

	@FindBy(name="overrideServiceDependency")
	public WebElement overrideServiceDependencyCheckbox;
	
	@FindBy(name="hideServiceActivationDate")
	public WebElement itemLevelSADcheckbox;
	
	@FindBy(name="restrictHelpdesk2Customer")
	public WebElement accessHelpDeskcheckbox;
	
	@FindBy(xpath="//input[@value='O']")
	public WebElement orderLevelRadioButton;
	
	@FindBy(xpath="//input[@value='I']")
	public WebElement itemLevelRadioButton;
	
	@FindBy(linkText="Preferences")
	public WebElement preferencesLink;

	@FindBy(id="invoiceLogo")
	public WebElement invoiceLogoBrowseButton;
	
	@FindBy(xpath="//button[text()='Submit Store for Approval']")
	public WebElement submitStoreApproveButton;
	
	@FindBy(xpath="//button[text()='Browse Marketplace']")
	public WebElement browseMarketplaceButton;
	
	@FindBy(xpath="//div[@id='InfoBarProxy']//strong")
	public WebElement proxyBackToMktPlaceLink;
	
	
	
	
	
	
}
