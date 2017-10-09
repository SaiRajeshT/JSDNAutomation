package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class AppstackPage extends TestBase {
	
	public AppstackPage(){
		PageFactory.initElements(driver, this);
	}

	public String getAppStackStatus(String appstackName)
	{   
		String elementValue= null;
	try{	
		String a = driver.findElement(By.xpath("//td[text()='"+appstackName +"']//following-sibling::td[4]//div/div")).getText();
		if(!a.equals("") && !a.equals(null)){
			elementValue=a;
		}
	}
	catch(Exception e){ }
	
	try{
		String a = driver.findElement(By.xpath("//td[span[@title='"+appstackName+"']]//following-sibling::td[4]/div/div")).getText();
		if(!a.equals("") && !a.equals(null)){
			elementValue=a;
		}
	}
	catch(Exception e){}
	
	try{
		String a = driver.findElement(By.xpath("//td[text()='"+appstackName +"']//following-sibling::td[4]//div/a")).getText();
		if(!a.equals("") && !a.equals(null)){
			elementValue=a;
		}
	}
	catch(Exception e){ e.printStackTrace();}
	
	try{
		String a = driver.findElement(By.xpath("//td[span[@title='"+appstackName+"']]//following-sibling::td[4]//div/a")).getText();
		if(!a.equals("") && !a.equals(null)){
			elementValue=a;
		}	}
	catch(Exception e){}
	
		return elementValue;
				
	}
	
	@FindBy(xpath="//div[contains(text(),'Showing:')]")
	public WebElement showingText;
	
	@FindBy(id="table_search")
	public WebElement searchTextBox;
	
	@FindBy(id="table_col_name")
	public WebElement searchDropDown;
	
	
	@FindBy(linkText="Manage")
	public WebElement manageLink;
	
	@FindBy(linkText="AppStacks")
	public WebElement appStacksLink;
	
	
}
