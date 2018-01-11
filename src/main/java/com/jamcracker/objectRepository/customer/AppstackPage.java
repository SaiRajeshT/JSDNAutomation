package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
	 if(elementValue==null)
	try{	
		String a = driver.findElement(By.xpath("//td[text()='"+appstackName +"']//following-sibling::td[4]//div/div")).getText();
		System.out.println(a);
		if(!a.equals("") && !a.equals(null)){
			elementValue=a;
		}
	}
	catch(Exception e){e.printStackTrace(); }
	 if(elementValue==null)
	try{
		String a = driver.findElement(By.xpath("//td[span[@title='"+appstackName+"']]//following-sibling::td[4]/div/div")).getText().trim();
		if(!a.equals("") && !a.equals(null)){
			elementValue=a;
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	 if(elementValue==null)
	try{
		String a = driver.findElement(By.xpath("//td[text()='"+appstackName +"']//following-sibling::td[4]//a")).getText().trim();
		if(!a.equals("") && !a.equals(null)){
			elementValue=a;
		}
	}
	catch(Exception e){ 
		e.printStackTrace();
		}
	
	/*try{
		String a = driver.findElement(By.xpath("//td[span[@title='"+appstackName+"']]//following-sibling::td[4]//div/a")).getText();
		if(!a.equals("") && !a.equals(null)){
			elementValue=a;
		}	}
	catch(Exception e){}*/
	 if(elementValue==null)
	try{
		String a = driver.findElement(By.xpath("//td[span[@title='"+appstackName+"']]//following-sibling::td[4]//a")).getText();
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
	
	@FindBy(linkText="Start")
	public WebElement startLink;
	
	@FindBy(linkText="Stop")
	public WebElement stopLink;
	
	@FindBy(linkText="Terminate")
	public WebElement terminateLink;
	
	@FindBy(linkText="View Details")
	public WebElement viewDetailsLink;
	
	@FindBy(xpath="//div[@id='header_popUpId']//following::span[text()='Confirm']")
	public WebElement confirmButton;
	
	
	public WebElement getStackActionLink(String stackName) {
		WebElement  a = null;
		try {
			a= driver.findElement(By.xpath("(//td[text()='" + stackName + "']//parent::tr//td[contains(@class,'lastaction')]//img)[1]"));
			return a;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		
	try {
			a = driver.findElement(By.xpath("(//tr[td[span[@title='" + stackName + "']]]//td[contains(@class,'lastaction')]//img)[1]"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();

		}
		
		return a;
	}
	
	
	public WebElement getRunningstack(String stackName) {
		WebElement element = null;
		
		try {
			element = driver.findElement(By.xpath("(//td[text()='"+stackName+"']//parent::tr//td//div[text()='Running'])[1]"));
			return element;
		} catch (Exception e) {

		}
		
		try {
			element = driver.findElement(By.xpath("(//tr[td[span[@title='"+stackName+"']]]//td//div[text()='Running'])[1]"));
			return element;
		} catch (Exception e) {

		}
		return element;
	}
	
	public WebElement getStoppedStack(String stackName) {
		WebElement element = null;
		
		try {
			element = driver.findElement(By.xpath("(//td[text()='"+stackName+"']//parent::tr//td//div[contains(text(),'Stopped')])[1]"));
			return element;
		} catch (Exception e) {

		}
		
		try {
			element = driver.findElement(By.xpath("(//tr[td[span[@title='"+stackName+"']]]//td//div[contains(text(),'Stopped')])[1]"));
			return element;
		} catch (Exception e) {

		}
		return element;
	}
				
	
	public WebElement getTerminatedStack(String stackName) {
		WebElement element = null;
		
		try {
			element = driver.findElement(By.xpath("(//td[text()='"+stackName+"']//parent::tr//td//div[contains(text(),'Terminated')])[1]"));
			return element;
		} catch (Exception e) {

		}
		
		try {
			element = driver.findElement(By.xpath("(//tr[td[span[@title='"+stackName+"']]]//td//div[contains(text(),'Terminated')])[1]"));
			return element;
		} catch (Exception e) {

		}
		return element;
	}
				
	
	
	
}
