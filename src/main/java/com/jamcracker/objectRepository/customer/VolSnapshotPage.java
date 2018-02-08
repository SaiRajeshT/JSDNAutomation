package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class VolSnapshotPage extends TestBase {
	
	public VolSnapshotPage(){
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(linkText="Volume Snapshots")
	public WebElement volumeSnapshotLink;
	
	@FindBy(linkText="Volume Snapshot")
	public WebElement volumeSnapshotPageLink;
	
	@FindBy(xpath="//div[@id='Search_panel_div']//input[@id='UserInputTxtBox']")
	public WebElement searchTextBox;
	
	@FindBy(xpath="(//div[@id='confirmDeleteVolumeMessage']//button[@name='btnyes'])[2]")
	public WebElement volSnapshotDelconfirmButton;
	
	public boolean getDeletingSnapshot(String snapShotName)
	{
		boolean result = false;
		try{
			if (getDriver().findElement(By.xpath("//tr[td[div[@title='"+snapShotName+"']]]//div[text()='Deleting']")).isDisplayed())
				result = true;
		}
		
		catch(Exception e)
		{
			result = false;	
		}
		
		return result;
	}
	
	
	public WebElement getactiveSnapshotStatus(String snashotName)
	{
		WebElement element = null;
		try{
			 	element = getDriver().findElement(By.xpath("//tr[td[div[@title='"+snashotName+"']]]//td//div[text()='Active']"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return element;
	}
	
	public WebElement getErrorSnapshotStatus(String snashotName)
	{
		WebElement element = null;
		try{
			element = getDriver().findElement(By.xpath("//tr[td[div[@title='"+snashotName+"']]]//td//span[text()='Error']"));
			}
			catch(Exception e)
		{
				e.printStackTrace();
		}
		
		return element;
			
	}
	
	public WebElement getDeleteSnapshotLink(String snashotName)
	{
		return getDriver().findElement(By.xpath("(//td[div[text()='"+snashotName+"']])[1]//a[contains(text(),'Delete')]"));
		
	}
	
	
	
	
}
