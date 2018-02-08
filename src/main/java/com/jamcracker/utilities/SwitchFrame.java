package com.jamcracker.utilities;

import org.openqa.selenium.WebElement;

public class SwitchFrame extends TestBase 
{
	
		
	public static void indexSwitch(int index){
		getDriver().switchTo().frame(index);
	}
	
	public static void nameIdSwitch(String nameId){
		getDriver().switchTo().frame(nameId);
	}
	
	public static void elementSwitch(WebElement element){
		getDriver().switchTo().frame(element);
	}
	
	public static void parentSwitch(){
		getDriver().switchTo().parentFrame();
	}
	
	public static void defaultSwitch(){
		getDriver().switchTo().defaultContent();
	}

}
