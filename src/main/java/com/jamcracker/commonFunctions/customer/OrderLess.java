package com.jamcracker.commonFunctions.customer;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.entity.service.OrderLessData;
import com.jamcracker.objectRepository.customer.CustomerMenuAndSubmenuObjects;
import com.jamcracker.objectRepository.customer.ManageSubscriptionsPage;
import com.jamcracker.objectRepository.customer.SubscriptionDetailsPage;
import com.jamcracker.utilities.TestBase;

public class OrderLess extends TestBase {
	
	SubscriptionDetailsPage objSDpage = new SubscriptionDetailsPage();
	
	public void orderLess(OrderLessData olData) throws Exception {
		
		CustomerMenuAndSubmenuObjects objCustCommon = new CustomerMenuAndSubmenuObjects();
		try {
			objCustCommon.manageLink.click();
			explicitWait(objCustCommon.subscriptionsLink);
		} catch (Exception e) {
			objCustCommon.manageLink.click();
			explicitWait(objCustCommon.subscriptionsLink);
		}
		objCustCommon.subscriptionsLink.click();
		ManageSubscriptionsPage objMSpage = new ManageSubscriptionsPage();
		explicitWait(objMSpage.manageSubscritpionsPage);
		objMSpage.actionsLink(olData.getOfferCode()).click();
		objMSpage.viewDetailsLink.click();
		explicitWait(objSDpage.newQuantityTextBox);
		objSDpage.newQuantityTextBox.clear();
		objSDpage.newQuantityTextBox.sendKeys("-"+olData.getTotalQty());
		objSDpage.applyButton.click();
		explicitWait(objSDpage.confirmationSection);
		explicitWait(objSDpage.confirmButton);
		objSDpage.confirmButton.click();
		Map<String, String> ordQty = olData.getOrderQnt();
		for(Map.Entry<String, String> m : ordQty.entrySet()) {
			reduceQuantity(m.getKey(), m.getValue());
		}
		objSDpage.saveAndFinishButton.click();
		Thread.sleep(5000);
		explicitWait(objSDpage.orderNotifyMsg);
		String actualMessage = objSDpage.orderNotifyMsg.getText();
		String expectedMessage = "Your subscription quantity has been updated successfully.";
		Assert.assertEquals(actualMessage, expectedMessage);
				
	}
	
	public void reduceQuantity(String orderNumber, String newQuantity) {
		
		try {
			explicitWait(objSDpage.reduceSubscriptionPopUp);
			explicitWait(objSDpage.reduceQtyTextBox(orderNumber));
		} catch (Exception e) {
			explicitWait(objSDpage.reduceSubscriptionPopUp);
			Reporter.log("Element is not visible and hence moving to the element by scrolling", true);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);",objSDpage.reduceQtyTextBox(orderNumber));
			/*js.executeScript("window.scrollBy(0,1000);");*/
		}
		objSDpage.reduceQtyTextBox(orderNumber).clear();
		objSDpage.reduceQtyTextBox(orderNumber).sendKeys(newQuantity);
		
	}
	
}
