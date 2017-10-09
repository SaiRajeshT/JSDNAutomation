package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class SubscriptionDetailsPage extends TestBase {
	
	public SubscriptionDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="jcBodyWarpper")
	public WebElement subscriptionDetailsPage;
	
	@FindBy(name="spinbox")
	public WebElement newQuantityTextBox;
	
	@FindBy(id="apply")
	public WebElement applyButton;
	
	@FindBy(xpath="//div[@class='bt-content']")
	public WebElement confirmationSection;
	
	@FindBy(xpath="//div[@class='bt-content']//following-sibling::div//button[@id='confirm']")
	public WebElement confirmButton;
	
	@FindBy(xpath="//div[@class='bt-content']//following-sibling::div//button[@id='cancel']")
	public WebElement cancelButton;
	
	@FindBy(xpath="(//div[@id='confirmMsg']//following-sibling::button[@name='confirm'])[2]")
	public WebElement alertOkButton;
	
	@FindBy(id="header_popUpId")
	public WebElement reduceSubscriptionPopUp;
	
	public WebElement reduceQtyTextBox(String orderNumber) {
		String requiredXpath = "//td[table[tbody[tr[td[text()='needsSubstitution']]]]]//following-sibling::td//input[@id='Quantity']";
		return driver.findElement(By.xpath(requiredXpath.replace("needsSubstitution", orderNumber)));		
	}
	
	@FindBy(id="saveReduceSubscription")
	public WebElement saveAndFinishButton;
	
	@FindBy(xpath="//div[@class='notify-msg']")
	public WebElement orderNotifyMsg;

}
