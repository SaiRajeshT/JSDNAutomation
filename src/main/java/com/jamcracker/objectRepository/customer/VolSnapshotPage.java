package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class VolSnapshotPage extends TestBase {
	
	public VolSnapshotPage(){
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Volume Snapshot")
	public WebElement volumeSnapshotPageLink;
	
	@FindBy(xpath="//div[@id='Search_panel_div']//input[@id='UserInputTxtBox']")
	public WebElement searchTextBox;
	
	
	public WebElement getactiveSnapshotStatus(String volumeName)
	{
		WebElement element = null;
		try{
			 	element = driver.findElement(By.xpath("//tr[td[div[@title='"+volumeName+"']]]//td//div[text()='Active']"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return element;
	}
	
	public WebElement getErrorSnapshotStatus(String volumeName)
	{
		WebElement element = null;
		try{
			element = driver.findElement(By.xpath("//tr[td[div[@title='"+volumeName+"']]]//td//span[text()='Error']"));
			}
			catch(Exception e)
		{
				e.printStackTrace();
		}
		
		return element;
			
	}
	
	
	
	
}
