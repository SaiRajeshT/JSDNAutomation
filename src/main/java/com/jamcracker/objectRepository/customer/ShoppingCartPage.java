package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class ShoppingCartPage extends TestBase {
	
	public ShoppingCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//div[@id='jcBodyWarpper']")
	public WebElement shoppingCartPage;
	
	public WebElement quantityTextbox(String offerCode) throws Exception {
		String offerId = ResultsFromDB.getOfferID(offerCode);
		String requiredXpath = "//div[@id='overrideQty_needsSubstitution']//input[@id='qty_needsSubstitution']";
		return getDriver().findElement(By.xpath(requiredXpath.replace("needsSubstitution", offerId)));		
	}
	
	
	@FindBy(id="checkout")
	public WebElement checkoutButton;
	
	@FindBy(id="continueshopping")
	public WebElement continueShoppingButton;
	
	@FindBy(xpath="//button[@name='agree']")
	public WebElement  slaAgreeButton;
	
	@FindBy(id="pop_title")
	public WebElement slaPopUp;
	
	@FindBy(xpath="//div[@id='pop_title']")
	public WebElement additionalInfoPopUp;

    @FindBy(xpath="//input[@id='excusno']")
	public WebElement existingCustomerNoRadioButton;
    
    @FindBy(xpath="//input[@id='domain']")
    public WebElement primaryDomainTextBox;
    
    @FindBy(xpath="//span[contains(text(),'Save & Finish')]")
	public WebElement saveAndFinishButton;

    @FindBy(xpath="//input[@id='excusyes']")
	public WebElement existingCustomerYesRadioButton;

}
