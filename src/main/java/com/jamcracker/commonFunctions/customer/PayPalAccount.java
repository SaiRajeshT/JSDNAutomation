package com.jamcracker.commonFunctions.customer;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.OrderReceiptPage;
import com.jamcracker.objectRepository.customer.PayPalPage;
import com.jamcracker.utilities.SwitchFrame;
import com.jamcracker.utilities.TestBase;

public class PayPalAccount extends TestBase {

	Properties prop = new Properties();
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public void enterPayPalDetails() throws Exception {
		InputStream input = null;
		input = new FileInputStream(System.getProperty("user.dir") + "/ConfigFile/paypalAccount.properties");
		prop.load(input);
		PayPalPage objPPpage = new PayPalPage();
		explicitWait(objPPpage.paypalPage);
		Reporter.log("Waiting for the Paypal Page to load completely", true);
		SwitchFrame.elementSwitch(objPPpage.paypalDetailsFrame);
		Reporter.log("Switched to Paypal Details Entering Frame", true);
		objPPpage.paypalEmailTextBox.clear();
		Reporter.log("Cleared the value which exists in the Email field", true);
		objPPpage.paypalEmailTextBox.sendKeys(prop.getProperty("paypalEmail"));
		Reporter.log("Entered Paypal Account Email Address" + prop.getProperty("paypalEmail"), true);
		objPPpage.paypalPasswordTextBox.sendKeys(prop.getProperty("paypalPassword"));
		Reporter.log("Entered Paypal Account Password", true);
		objPPpage.loginButton.click();
		Reporter.log("Clicked on the Login Button", true);
		SwitchFrame.defaultSwitch();
		explicitWait(objPPpage.agreeButton);
		Reporter.log("Waited for the Agree and Continue button to be visible", true);
		Thread.sleep(10000);
		try {
			js.executeScript("arguments[0].scrollIntoView(true);",objPPpage.agreeButton);
			objPPpage.agreeButton.click();
		} catch (Exception e) {
			objPPpage.agreeButton.click();
		}
		Reporter.log("Accepted the Terms and Conditions by clicking Agree Button", true);
		OrderReceiptPage objORpage = new OrderReceiptPage();
		String acutalMsg = objORpage.cardVerifiedMsg.getText();
		String expectedMsg = "Your card is verified. If you wish to replace the card, please access Company Profile page.";
		Assert.assertEquals(acutalMsg, expectedMsg);
	}

}
