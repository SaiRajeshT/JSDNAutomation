package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class MyservicesPage extends TestBase {

	public MyservicesPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "My Services")
	public WebElement myServiceLInk;

	@FindBy(xpath = "//input[@value='Add Service']")
	public WebElement addServiceButton;

	@FindBy(id = "new")
	public WebElement newServiceRadioButton;

	@FindBy(id = "source")
	public WebElement sourceServiceRadioButton;

	@FindBy(xpath = "//button[text()='Continue']")
	public WebElement continueButton;

	@FindBy(name = "serviceId")
	public WebElement serviceToSourceDropDown;

	@FindBy(name = "offerId")
	public WebElement offerNameDropDown;

	@FindBy(name = "serviceName")
	public WebElement serviceNameTextBox;

	@FindBy(name = "servicePublisher")
	public WebElement servicePublisherTextBox;

	@FindBy(id = "serviceDesc")
	public WebElement serviceSummaryTextBox;

	@FindBy(id = "moreInformation")
	public WebElement serviceMoreInfoTextBox;

	@FindBy(name = "requirements")
	public WebElement requirementsTextBox;

	@FindBy(id = "faqs")
	public WebElement faqsTextBox;

	@FindBy(name = "serviceLogo")
	public WebElement serviceLogoBrowseButton;

	@FindBy(name = "cloudServiceType")
	public WebElement cloudServiceTypeDropDown;

	@FindBy(id = "chkLicenseMgmt")
	public WebElement licenseMgmtcheckBox;

	@FindBy(id = "provToAdmin")
	public WebElement firstAdminEnableCheckBox;

	@FindBy(xpath = "//button[text()='Add']")
	public WebElement addSlaTextBox;

	@FindBy(xpath = "//input[@name='serviceAgreementFile']")
	public WebElement slaBrowseButton;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public WebElement saveButton;

	@FindBy(xpath = "//button[contains(text(),'Next >>')]")
	public WebElement nextButton;

	@FindBy(xpath = "//strong[contains(text(),'Saved successfully')]")
	public WebElement sourceSuccessMsg;

	@FindBy(xpath = "//button[contains(text(),'Save & Next')]")
	public WebElement saveAndNextButton;

	@FindBy(xpath = "//button[text()='Save & Next']")
	public WebElement pricingInfoSaveAndNextButton;

	@FindBy(linkText = "Add Offer")
	public WebElement addOfferLink;

	@FindBy(name = "offerName")
	public WebElement offerNameTextBox;

	@FindBy(name = "offerDescription")
	public WebElement offerDescriptionTextBox;

	@FindBy(name = "usagePrice")
	public WebElement payAsYouGoCheckBox;

	@FindBy(name = "billBasedOnUser")
	public WebElement payPerUserCheckBox;

	@FindBy(name = "resell")
	public WebElement offerCatalogCheckBox;

	@FindBy(id = "regularStyleID")
	public WebElement regularSubscriptionRadioButton;

	@FindBy(id = "termStyleID")
	public WebElement termSubscriptionRadioButton;

	@FindBy(name = "offerCode")
	public WebElement offerCodeTextBox;

	@FindBy(name = "ShowDCForOrderMoreOrLess")
	public WebElement showDataCollectionDropDown;

	@FindBy(name = "unitPriceDescription")
	public WebElement unitPriceTextBox;

	@FindBy(name = "minimumQuantity")
	public WebElement minQtyTextBox;

	@FindBy(name = "unitPriceQuantity")
	public WebElement unitPriceQtyTextBox;

	@FindBy(xpath = "//input[@name='staticQuantity'] [@value='N']")
	public WebElement staticQtyNoRadio;

	@FindBy(xpath = "//input[@name='staticQuantity'] [@value='Y']")
	public WebElement staticQtyYesRadio;

	@FindBy(name = "priceType")
	public WebElement billingCycleDropDown;

	@FindBy(xpath = "//input[@name='setUpFeeCharge'][@value='Y']")
	public WebElement SetUpFeeYesRadioButton;

	@FindBy(xpath = "//input[@name='setUpFeeCharge'][@value='N']")
	public WebElement SetUpFeeNoRadioButton;

	@FindBy(name = "setUpFeePerLicense")
	public WebElement setUpFeeDropDown;

	@FindBy(xpath = "//input[@name='isProrated'][@value='Y']")
	public WebElement proRateYesRadioButton;

	@FindBy(xpath = "//input[@name='isProrated'][@value='N']")
	public WebElement proRateNoRadioButton;

	@FindBy(xpath = "//td[text()='Marketplace - Store']//following-sibling::td//img")
	public WebElement expandIcon;

	public WebElement getSubCategory(String subCategory) {
		String objXPath = "//div[@id='subcat_<REPLACE>']//input";
		objXPath = objXPath.replaceAll("<REPLACE>", subCategory);
		return driver.findElement(By.xpath(objXPath));
	}

	public WebElement getServiceStatus(String serviceName) {
		String objXPath = "//tr[td[contains(@title,'<REPLACE>')]]/td[@title='Approved']";
		objXPath = objXPath.replaceAll("<REPLACE>", serviceName);
		return driver.findElement(By.xpath(objXPath));
	}

	public WebElement getPriceTextbox(Integer currencyId, String priceType) {
		String objXpath = "//input[@id='" + priceType + "_" + currencyId + "']";
		return driver.findElement(By.xpath(objXpath));
	}

	public WebElement getTaxTextBox(String currency) {
		String objXpath = "//div[@id='mp" + currency + "']";
		return driver.findElement(By.xpath(objXpath));
	}

	public WebElement getCheckAllTaxCheckBox(String currency) {
		String objXpath = "(//legend[contains(text(),'" + currency
				+ "')])[2]//following-sibling::div//input[@type='checkbox']";
		return driver.findElement(By.xpath(objXpath));
	}

	@FindBy(name = "resell")
	public WebElement resellCheckbox;

	@FindBy(id = "selectAllRS")
	public WebElement selectAllCheckbox;

	@FindBy(id = "unSelectAllRS")
	public WebElement unSelectAllCheckbox;

	@FindBy(name = "requestQuote")
	public WebElement requestQuoteCheckbox;

	@FindBy(xpath = "//div[@id='servicedependencywin']//button[text()='Continue']")
	public WebElement activitiesContinueButton;

	@FindBy(xpath = "//button[text()='Finish']")
	public WebElement finishButton;

	@FindBy(name = "_iframe-divwin")
	public WebElement addServiceFrame;

}
