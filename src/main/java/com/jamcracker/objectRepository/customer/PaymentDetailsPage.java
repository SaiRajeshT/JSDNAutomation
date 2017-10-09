package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class PaymentDetailsPage extends TestBase {
	
	public PaymentDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="jcBodyWarpper")
	public WebElement paymentDetailsPage;
	
	@FindBy(id="billingMapCC")
	public WebElement paypalRadioButton;
	
	@FindBy(id="billingMapCARD")
	public WebElement creditCardRadioButton;
	
	@FindBy(id="billingMapPAC")
	public WebElement pacRadioButton;
	
	@FindBy(id="btnProceed")
	public WebElement proceedButton;
	
	@FindBy(xpath="//td[div[@id='header_popUpId']]/div/div/div/div/div/div/button[@id='authorizeBtn']")
	public WebElement authorizeButton;
	
	@FindBy(id="cancelPayment")
	public WebElement cancelButton;
	
	@FindBy(id="processingModevalueCARD")
	public WebElement processingMode;
	
	@FindBy(id="close")
	public WebElement closeButton;
	
	@FindBy(id="paymentBillingMethod")
	public WebElement billingOption;
	
}
