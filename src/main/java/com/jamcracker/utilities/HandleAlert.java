package com.jamcracker.utilities;

import org.openqa.selenium.Alert;

public class HandleAlert extends TestBase {
	
	//Click on OK button on Alert
	public static void acceptAlert() {
		Alert alt = getDriver().switchTo().alert();
		alt.accept();
	}
	//Click on Cancel button on Alert
	public static void dismissAlert() {
		Alert alt = getDriver().switchTo().alert();
		alt.dismiss();
	}
	//To get Alert Text
	public static String getAlertText() {
		Alert alt = getDriver().switchTo().alert();
		String alertText = alt.getText();
		return alertText;
	}
	//To enter text on Alert text box
	public static void enterTextToAlert(String text) {
		Alert alt = getDriver().switchTo().alert();
		alt.sendKeys(text);
	}

}
