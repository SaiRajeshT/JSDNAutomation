package com.jamcracker.commonFunctions.customer;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.jamcracker.objectRepository.customer.CustomerMenuAndSubmenuObjects;
import com.jamcracker.objectRepository.customer.ManageSubscriptionsPage;
import com.jamcracker.objectRepository.customer.OrderReceiptPage;
import com.jamcracker.objectRepository.customer.PaymentDetailsPage;
import com.jamcracker.objectRepository.customer.ShoppingCartPage;
import com.jamcracker.objectRepository.customer.SubscriptionDetailsPage;
import com.jamcracker.utilities.TestBase;

public class OrderMore extends TestBase {

	public void orderMore(String offerCode, String newQuantity) throws Exception {

		CustomerMenuAndSubmenuObjects objCustCommon = new CustomerMenuAndSubmenuObjects();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		objCustCommon.manageLink.click();
		explicitWait(objCustCommon.subscriptionsLink);
		objCustCommon.subscriptionsLink.click();
		ManageSubscriptionsPage objMSpage = new ManageSubscriptionsPage();
		explicitWait(objMSpage.manageSubscritpionsPage);
		objMSpage.actionsLink(offerCode).click();
		objMSpage.viewDetailsLink.click();
		SubscriptionDetailsPage objSDpage = new SubscriptionDetailsPage();
		explicitWait(objSDpage.subscriptionDetailsPage);
		objSDpage.newQuantityTextBox.sendKeys(newQuantity);
		objSDpage.applyButton.click();
		explicitWait(objSDpage.confirmationSection);
		explicitWait(objSDpage.confirmButton);
		objSDpage.confirmButton.click();
		explicitWait(objSDpage.alertOkButton);
		objSDpage.alertOkButton.click();
		ShoppingCartPage objSCpage = new ShoppingCartPage();
		explicitWait(objSCpage.shoppingCartPage);
		js.executeScript("arguments[0].scrollIntoView(true);",objSCpage.checkoutButton);
		explicitWaitToClickable(objSCpage.checkoutButton);
		//(objSCpage.checkoutButton);
		objSCpage.checkoutButton.click();
		PaymentDetailsPage objPDpage = new PaymentDetailsPage();
		explicitWait(objPDpage.paymentDetailsPage);
		explicitWait(objPDpage.proceedButton);
		Thread.sleep(5000);
		js.executeScript("arguments[0].scrollIntoView(true);",objPDpage.proceedButton);
		objPDpage.proceedButton.click();
		OrderReceiptPage objORpage = new OrderReceiptPage();
		String actualMessage = objORpage.orderNotifyMsg.getText();
		//String expectedMessage = "Thank you for your order. An order confirmation email has been sent to you. Please visit your account subscriptions page to check the status of your order.";
		String expectedMessage = "Thank you for your request. An email will be sent to you once the order is approved and the offer/stack is ready to use.";
		Assert.assertEquals(actualMessage, expectedMessage);

	}

}
