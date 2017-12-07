package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class InstancesPage extends TestBase{
	
	public InstancesPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Manage")
	public WebElement manageLink;
	
	@FindBy(linkText="Instances")
	public WebElement instancesLink;
	
	@FindBy(linkText="AppStacks")
	public WebElement appstacksLink;
	
	@FindBy(linkText="Volume Snapshots")
	public WebElement volSnapshotLink;
	
	@FindBy(id="table_search")
	public WebElement searchTextBox;
	
	@FindBy(xpath="//div[@id='postConfirmResize']//span[text()='Confirm']")
	public WebElement resizeConfirmButton;
	
	@FindBy(id="table_col_name")
	public WebElement searchDropDown;
	
	@FindBy(linkText="View Details")
	public WebElement viewDetaisLink;
	
	@FindBy(xpath="//button[@id='privateKey']//span[text()='Download Private Key']")
	public WebElement downLoadPrivateKeyButton;
	
	@FindBy(linkText="Stop")
	public WebElement stopLink;
	
	@FindBy(linkText="Resize")
	public WebElement resizeLink;
	
	@FindBy(id="flavor")
	public WebElement resizeDropDown;
	
	@FindBy(linkText="Start")
	public WebElement startLink;
	
	@FindBy(linkText="Terminate")
	public WebElement terminateLink;
	
	@FindBy(linkText="Load More")
	public WebElement loadMoreLink;
	
	@FindBy(linkText="Launch SSH")
	public WebElement launchSshLink;
	
	@FindBy(linkText="Create VM Image")
	public WebElement createImageLink;
	
	@FindBy(linkText="Attach New Volume")
	public WebElement attachNewVolumeLink;
	
	@FindBy(linkText="Detach")
	public WebElement detachVolumeLink;
	
	@FindBy(linkText="Attach Existing Volume")
	public WebElement attachExistingVolumeLink;
	
	@FindBy(linkText="Detach and Terminate")
	public WebElement detachTerminateVolumeLink;
	
	@FindBy(linkText="Create Snapshot")
	public WebElement createVolumeSnapshotLink;
	
	@FindBy(xpath="//form[@id='newvolume']//input[@id='displayName']")
	public WebElement volumeNameTextBox;
	
	@FindBy(id="submitVolume")
	public WebElement submitVolumeButton;
	
	
	@FindBy(id="volumeType")
	public WebElement volumeTypeDropDown;
	
	@FindBy(id="size")
	public WebElement volumeSizeTextBox;
	
	@FindBy(id="units")
	public WebElement sizeDropDown;
	
	@FindBy(id="createNewVolume")
	public WebElement volumeDoneButton;
	
	@FindBy(id="btsubmit")
	public WebElement volSnapshotDoneButton;
	
	@FindBy(id="cancelPopUp")
	public WebElement volumeCancelButton;
	
	@FindBy(xpath="//div[@id='header_popUpId']//following-sibling::div//button[span[text()='Confirm']]")
	public WebElement volumeDetachConfirmButton;
	
	@FindBy(xpath="//div[@id='header_popUpId']//following-sibling::div//button[span[text()='Cancel']]")
	public WebElement volumeDetachCancelButton;
	
	@FindBy(xpath="//button[@id='cancel']//span")
	public WebElement existingVolCancelButton;
	
	@FindBy(xpath="//div[@id='header_popUpId']/a")
	public WebElement closePouUp;
	
	@FindBy(xpath="//div[contains(text(),'Showing:')]")
	public WebElement showingText;
	
	@FindBy(xpath="//button[@id='enableSubmit']//span[text()='Confirm']")
	public WebElement confirmButton;
	
	
	@FindBy(xpath="//div[@id='jcTable_listServers']//img[@title='Refresh Table']")
	public WebElement refreshIcon;
	
	@FindBy(xpath="(//div[@id='terminateEntireAppStackHtml']//button//span[text()='Terminate Instance Only'])[2]")
	public WebElement terminateInstanceOnlyButton;
	
	@FindBy(xpath="//div[@id='noVolume']//button//span[text()='Confirm']")
	public WebElement instanceconfirmButton;
	
	
	
	@FindBy(xpath="(//div[@id='terminateEntireAppStackHtml']//button//span[text()='Terminate Entire AppStack'])[2]")
	public WebElement terminateAppstackOnlyButton;
	
	@FindBy(xpath="//span[text()='Reconnect']")
	public WebElement ReconnectButton;
	
	@FindBy(xpath="(//span[text()='Cancel'])[2]")
	public WebElement cancelButton;
	
	@FindBy(id="display")
	public WebElement sshWindow;
	
	@FindBy(xpath="//form[@id='resizeVM']//span[text()='Resize']")
	public WebElement resizeButton;
	
	@FindBy(xpath="//form[@id='resizeVM']//span[text()='Cancel']")
	public WebElement resizeCancelButton;
	
	@FindBy(id="name")
	public WebElement imageNameTextBox;
	
	@FindBy(id="description")
	public WebElement imageDescription;
	
	@FindBy(id="btsubmit")
	public WebElement createImageButton;
	
	@FindBy(xpath="//form[@id='snapshotForm']//span[text()='Cancel']")
	public WebElement imageCancelButton;
	
	@FindBy(linkText="Volume(s)")
	public WebElement volumeTab;

	@FindBy(id="UserInputTxtBox")
	public WebElement existingVolumeSearchBox;
	
	@FindBy(id="name")
	public WebElement volSnapshotNameTextBox;
	
	@FindBy(id="description")
	public WebElement volSnapShotDescriptionTextBox;
	
public String getVolumeStatus(String volumeName){
	String value = null;
	try{
		value= driver.findElement(By.xpath("(//td[text()='"+volumeName+"']//following-sibling::td[5])[1]")).getText();
		}
	
	catch(Exception e)
	{
		
	}
	
	try{
		value = driver.findElement(By.xpath("//tr[td[span[@title='"+volumeName+"']]]//td[6]")).getText();
	}
	
	catch(Exception e1){
	}
	return value;
	
}
	
	
public WebElement getSize(String size)
{
	return driver.findElement(By.xpath("//div[@id='billableParams']//div[text()='"+size+"']"));
	
}
	
	public WebElement getInstanceActionLink(String instName) {
		WebElement  a = null;
		//Instance action link without monitoring
		try {
			a= driver.findElement(By.xpath("(//td[text()='" + instName + "']//parent::tr//td[contains(@class,'lastaction')]//img)[1]"));
		} catch (NoSuchElementException e) {
			//e.printStackTrace();
		}
		//xpath for lengthy instance name and monitor not enabled
		if(a == null)
		try {
			a = driver.findElement(By.xpath("(//tr[td[span[@title='" + instName + "']]]//td[contains(@class,'lastaction')]//img)[1]"));
		} catch (NoSuchElementException e) {
			//e.printStackTrace();

		}
		//xpath for monitoring enabled instnace action link
		if(a == null)
		try {
			a = driver.findElement(By.xpath("(//tr[td[div[text()='" + instName + "']]]//td[contains(@class,'lastaction')]//img)[1]"));
		} catch (NoSuchElementException e) {
			//e.printStackTrace();

		}
		
		//xpath for lengthy instance name and monitor  enabled
		if(a == null){
		try {
			a = driver.findElement(By.xpath("(//tr[td[span[@title='" + instName + "']]]//td[contains(@class,'lastaction')]//img)[1]"));
		} catch (NoSuchElementException e) {
			//e.printStackTrace();

		}}

		return a;
	}
	
	public WebElement getInstanceLNameActionLink(String instName){
		return driver.findElement(By.xpath("(//tr[td[span[@title='"+instName+"']]]//td[contains(@class,'lastaction')]//img)[1]"));}
	
	
		
	public WebElement getMonitorInstanceActionLink(String instName){
		return driver.findElement(By.xpath("(//tr[td[div[text()='"+instName+"']]]//td[contains(@class,'lastaction')]//img)[1]"));}
	/*
	public WebElement getStoppedInstance(String instName){
		return driver.findElement(By.xpath("(//td[text()='"+instName+"']//parent::tr//td//div[text()='Stopped'])[1]"));}
	
	public WebElement getStoppedMonitorInstance(String instName){
		return driver.findElement(By.xpath("(//div[text()='"+instName+"']//parent::td//following-sibling::td//div[text()='Stopped'])[1]"));}
	
	public WebElement getRunningMonitorInstance(String instName){
		return driver.findElement(By.xpath("(//tr[td[div[text()='"+instName+"']]]//parent::tr//td//div[text()='Running'])[1]"));}
	
		public WebElement getRunningInstance(String instName){
			return driver.findElement(By.xpath("(//td[text()='"+instName+"']//parent::tr//td//div[text()='Running'])[1]"));}
		*/
	
	
	public WebElement getStoppedInstance(String instName){
		WebElement element = null;
		try {
			element =driver.findElement(By.xpath("(//td[text()='"+instName+"']//parent::tr//td//div[text()='Stopped'])[1]"));
		} catch (Exception e) {

		}

		try {
			element =driver.findElement(By.xpath("(//div[text()='"+instName+"']//parent::td//following-sibling::td//div[text()='Stopped'])[1]"));
		} catch (Exception e) {

		}
		
		// lengthy instance name without monitoring icon
					try {
						element = driver.findElement(By.xpath("(//tr[td[span[@title='"+instName+"']]]//td//div[text()='Stopped'])[1]"));
					} catch (Exception e) {

					}
					// lengthy instance name with monitoring icon		
					try{
						element =  driver.findElement(By.xpath("(//tr[td[div[span[@title='"+instName+"']]]]//td//div[text()='Stopped'])[1]"));
						
					} catch (Exception e) {

					}

		return element;
	
	}
		public WebElement getRunningInstance(String instName) {
			WebElement element = null;
			try {
				element = driver.findElement(By.xpath("(//td[text()='"+instName+"']//parent::tr//td//div[text()='Running'])[1]"));;
			} catch (Exception e) {

			}

			try {
				element = driver.findElement(By.xpath("(//tr[td[div[text()='"+instName+"']]]//parent::tr//td//div[text()='Running'])[1]"));
			} catch (Exception e) {

			}
			// lengthy instance name without monitoring icon
			try {
				element = driver.findElement(By.xpath("(//tr[td[span[@title='"+instName+"']]]//td//div[text()='Running'])[1]"));
			} catch (Exception e) {

			}
			
			try{
				element =  driver.findElement(By.xpath("(//tr[td[div[span[@title='"+instName+"']]]]//td//div[text()='Running'])[1]"));
				
			} catch (Exception e) {

			}

			return element;
		}
					
		
		
	public WebElement getStackName(String instName){
		return driver.findElement(By.xpath("//td[text()='"+instName+"']//following-sibling::td[3]//a[@id='showStackDetails']"));}
				
	
		
	public WebElement getTermiantedInstance(String instName) {
		WebElement element = null;
		try {
			element = driver.findElement(
					By.xpath("(//td[text()='" + instName + "']//parent::tr//td//div[text()='Terminated'])[1]"));
			//System.out.println("(//td[text()='" + instName + "']//parent::tr//td//div[text()='Terminated'])[1]");
		} catch (Exception e) {

		}

		try {
			element = driver.findElement(By.xpath(
					"(//tr[td[span[@title='" + instName + "']]]//td//div[text()='Terminated'])[1]"));
			//System.out.println("(//tr[td[span[@title='" + instName + "']]]//td//div[text()='Terminated'])[1]");
		} catch (Exception e) {

		}

		return element;
	}
		
	
	public String getImageStatus(String instName)
	{
		
	 return driver.findElement(By.xpath("//tr[td[text()='"+instName+"']]//td[6]")).getText();
	}
	
	public WebElement getVolumeActionLink(String volumeName)
	{
		WebElement element = null;
				
		try{
		element = driver.findElement(By.xpath("(//td[text()='"+volumeName+"']//following-sibling::td//span[contains(text(),'Actions')])[1]"));}
		catch(Exception e){}
		
		try{
			element = driver.findElement(By.xpath("(//td[span[@title='"+volumeName+"']]//following-sibling::td//span[contains(text(),'Actions')])[1]"));}
			catch(Exception e){}
		
	return	element ; }
	
	public boolean getDetachVolumeStatus(String volumeName) {
		boolean test = false;
		try {
			if (driver.findElement(By.xpath("//td[text()='" + volumeName + "']//following-sibling::td[5][text()='Detaching']")).isDisplayed())
				test = true;

		} catch (Exception e) {
			test = false;
		}
		return test;
	}
	
	
	public boolean getExistingVolumeStatus(String volumeName) {
		boolean test = false;
		try {
			if (driver.findElement(By.xpath("(//td[contains(text(),'"+volumeName+"')]//following-sibling::td[4][text()='Active'])[1]")).isDisplayed())
				test = true;

		} catch (Exception e) {
			test = false;
		}
		return test;
	}	
}
