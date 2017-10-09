package com.jamcracker.utilities;

import org.openqa.selenium.WebElement;

public class SwitchFrame extends TestBase 
{
	
		
	public static void indexSwitch(int index){
		driver.switchTo().frame(index);
	}
	
	public static void nameIdSwitch(String nameId){
		driver.switchTo().frame(nameId);
	}
	
	public static void elementSwitch(WebElement element){
		driver.switchTo().frame(element);
	}
	
	public static void parentSwitch(){
		driver.switchTo().parentFrame();
	}
	
	public static void defaultSwitch(){
		driver.switchTo().defaultContent();
	}

}
