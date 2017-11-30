package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class OrderReceiptPage extends TestBase {
	
	public OrderReceiptPage() {
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id="jcBodyWarpper")
	public WebElement orderReceiptPage;
	
	@FindBy(xpath="//div[@id='orderPaymentDetails']//p[contains(text(),'Order Number')]//following-sibling::p")
	public WebElement orderNumberText;
	
	public String getOrderNumber()
	{
		try{
			 return driver.findElement(By.xpath("//div[@id='orderPaymentDetails']//p[contains(text(),'Order Number')]//following-sibling::p")).getText();
			
		}
		catch(Exception e)
		{
			return driver.findElement(By.xpath("//div[@id='orderPaymentDetails']//p[contains(text(),'Request Number')]//following-sibling::p")).getText();	
		}
	}
	
	@FindBy(xpath="//div[@class='notify-msg']")
	public WebElement orderNotifyMsg;
	
	@FindBy(xpath="//div[contains(text(),'Your card is verified. If you wish to replace the card, please access Company Profile page.')]")
	public WebElement cardVerifiedMsg;

}
