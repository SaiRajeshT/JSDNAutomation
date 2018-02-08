package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

	
	public class Imagespage extends TestBase{
		
		public Imagespage(){
			PageFactory.initElements(getDriver(), this);
		}
		
		
		@FindBy(linkText="Manage")
		public WebElement manageLink;
		
		@FindBy(linkText="Images")
		public WebElement imageLink;
		
		@FindBy(xpath="//div[contains(text(),'Showing:')]")
		public WebElement showingText;
		
		@FindBy(linkText="Create Instance")
		public WebElement createInstanceLink;
		
		@FindBy(linkText="Delete")
		public WebElement deleteLink;
		
		@FindBy(xpath="//div[@id='header_popUpId']//following-sibling::div//button[@name='btnyes']//span[text()='Confirm']")
		public WebElement deleteImageConfirmButton;
		
		@FindBy(id="table_search")
		public WebElement searchTextBox;
		
		@FindBy(xpath="//div[text()='Go']")
		public WebElement goButton;
		
		@FindBy(xpath="//div[@id='header_popUpId']//following-sibling::div//button[@name='btcancel']//span[text()='Cancel']")
		public WebElement deleteImageCancelButton;
		
		
	
		
		public WebElement getImageActionLink(String imageName){
			WebElement element = null;
			try{ element = getDriver().findElement(By.xpath("//tr[td[text()='"+imageName+"']]//span[contains(text(),'Actions')]//img"));
				
			}
			catch(Exception e)
			{
				
			}
			
			try{
				element = getDriver().findElement(By.xpath("//tr[td[span[@title='"+imageName+"']]]//span[contains(text(),'Actions')]//img"));
			}
			catch(Exception e)
			{
				
			}
			
			return element;
			
		}
		
		
		public WebElement getDeletingImage(String imageName){
			WebElement element = null;
			try{ element = getDriver().findElement(By.xpath("//tr[td[text()='"+imageName+"']]//td[text()='Deleting']"));
				
			}
			catch(Exception e)
			{
				
			}
			
			try{
				element = getDriver().findElement(By.xpath("//tr[td[span[@title='"+imageName+"']]]//span[text()='Deleting']"));
			}
			catch(Exception e)
			{
				
			}
			
			return element;
			
		}
		

}
