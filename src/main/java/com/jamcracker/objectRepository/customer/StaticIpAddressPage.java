package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class StaticIpAddressPage extends TestBase {
	public  StaticIpAddressPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Static Public IP Address")
	public WebElement staticPublicIpLink;
	
	@FindBy(xpath="//div[@id='staticIPWrapper']//span[text()='Obtain New IP']")
	public WebElement obtainNewIpButton;
	
	@FindBy(xpath="//td[div[@id='header_popUpId']]//select[@id='providerCode']")
	public WebElement providerDropdown;
	
	@FindBy(xpath="//div[@id='header_popUpId']//following::select[@id='region']")
	public WebElement regionDropDown;
	
	@FindBy(xpath="//div[@id='header_popUpId']//following::select[@id='network']")
	public WebElement networkDropDown;
	
	@FindBy(xpath="//div[@id='header_popUpId']//following::button[@id='confirm']")
	public WebElement staticIpConfirmButton;
	
	@FindBy(xpath="//div[@id='header_popUpId']//following::button[@id='Cancel']")
	public WebElement staticIpCancelButton;
	
	@FindBy(xpath="//div[contains(text(),'Showing:')]")
	public WebElement showingText;
	
	@FindBy(xpath="//input[@id='table_search']")
	public WebElement searchTextBox;
	
	public String getDropDownValue(String partialtext)
	{
		return driver.findElement(By.xpath("//td[div[@id='header_popUpId']]//select[@id='providerCode']//option[contains(@value,'"+partialtext+"')]")).getText();
	}

	public String getIp()
	{
		return driver.findElement(By.xpath("//table[@id='jcTable_listOfFloatingIPs_main']//tr[2]/td[3]")).getText();
	}
	
	public String getSuccessMsg()
	{
		return driver.findElement(By.xpath("//div[@class='notify-msg']")).getText();
	}
}
