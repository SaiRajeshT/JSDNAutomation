package com.jamcracker.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions extends TestBase {
		
	public static void opDragDrop(WebElement source, WebElement target) {		
		Actions actions = new Actions(driver);
		actions.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();
	}
	
	public static void mouseHover(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

}
