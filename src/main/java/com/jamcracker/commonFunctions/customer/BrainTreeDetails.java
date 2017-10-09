package com.jamcracker.commonFunctions.customer;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.BrainTreePage;
import com.jamcracker.objectRepository.customer.OrderReceiptPage;
import com.jamcracker.utilities.SwitchFrame;
import com.jamcracker.utilities.TestBase;

public class BrainTreeDetails extends TestBase {

	Properties prop = new Properties();

	public void enterCCDetails() throws Exception {
		InputStream input = null;
		input = new FileInputStream(System.getProperty("user.dir") + "/ConfigFile/brainTreeDetails.properties");
		prop.load(input);
		BrainTreePage objBTPage = new BrainTreePage();
		explicitWait(objBTPage.ccDetailsFrame);
		Reporter.log("Waited for the Card Details Frame to be loaded", true);
		SwitchFrame.elementSwitch(objBTPage.ccDetailsFrame);
		Reporter.log("Switched to Card Details Frame", true);
		objBTPage.ccnTextBox.sendKeys(prop.getProperty("creditCardNumber"));
		Reporter.log("Entered Card Number", true);
		objBTPage.expirationTextBox.sendKeys(prop.getProperty("expiration"));
		Reporter.log("Entered Expiry Date", true);
		objBTPage.cvvTextBox.sendKeys(prop.getProperty("cvv"));
		Reporter.log("Entered CVV Number", true);
		SwitchFrame.defaultSwitch();
		objBTPage.submitButton.click();
		Reporter.log("Clicked on Submit Button", true);
		OrderReceiptPage objORpage = new OrderReceiptPage();
		String acutalMsg = objORpage.cardVerifiedMsg.getText();
		String expectedMsg = "Your card is verified. If you wish to replace the card, please access Company Profile page.";
		Assert.assertEquals(acutalMsg, expectedMsg);
	}

}
