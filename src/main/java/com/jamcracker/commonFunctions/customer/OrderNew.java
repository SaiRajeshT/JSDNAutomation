package com.jamcracker.commonFunctions.customer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.CatalogPage;
import com.jamcracker.objectRepository.customer.CustomerMenuAndSubmenuObjects;
import com.jamcracker.objectRepository.customer.OrderReceiptPage;
import com.jamcracker.objectRepository.customer.ShoppingCartPage;
import com.jamcracker.utilities.MouseActions;
import com.jamcracker.utilities.TestBase;

public class OrderNew extends TestBase {

	static final String FILENAME = "./ConfigFile/orderNumber.txt";

	public void orderNew(String serviceName, String offerName, String offerCode, String quantity, String paymentMethod)
			throws Exception {

		CustomerMenuAndSubmenuObjects objCustCommon = new CustomerMenuAndSubmenuObjects();
		objCustCommon.catalogLink.click();
		CatalogPage objCatalog = new CatalogPage();
		explicitWait(objCatalog.searchTextBox);
		objCatalog.searchTextBox.sendKeys(serviceName,Keys.ENTER);
		/*objCatalog.searchIconButton.click();*/
		explicitWait(objCatalog.serviceNameText(serviceName));
		MouseActions.mouseHover(objCatalog.serviceNameText(serviceName));
		explicitWait(objCatalog.serviceViewOffersLink(serviceName));
		try {
			objCatalog.serviceViewOffersLink(serviceName).click();
		} catch (Exception e) {
			objCatalog.serviceViewOffersLink(serviceName).click();
		}
		explicitWait(objCatalog.addToCartButton(offerName));
		objCatalog.addToCartButton(offerName).click();
		ShoppingCartPage objShopCart = new ShoppingCartPage();
		explicitWait(objShopCart.shoppingCartPage);
		try {
			objShopCart.quantityTextbox(offerCode).clear();
			Thread.sleep(3000);
			objShopCart.quantityTextbox(offerCode).sendKeys(quantity);
			Thread.sleep(3000);
		} catch (Exception e) {
			Reporter.log("Element is not clickable", true);
		}
		objShopCart.checkoutButton.click();
		try {
			explicitWait(objShopCart.slaPopUp);
			objShopCart.slaAgreeButton.click();
		} catch (Exception e) {
			Reporter.log("Sla Pop Up is not available");
		}
		Thread.sleep(5000);
		try {

			PaymentOptions payOption = new PaymentOptions();
			switch (paymentMethod.toLowerCase()) {

			case "paypal":

				payOption.paymentPaypal(paymentMethod);
				break;

			case "credit card":

				payOption.paymentCard(paymentMethod);
				break;

			case "pre approved credit":

				payOption.paymentPAC(paymentMethod);
				break;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		OrderReceiptPage objORpage = new OrderReceiptPage();
		String actualMessage = objORpage.orderNotifyMsg.getText();
		/*String expectedMessage = "Thank you for your order. An order confirmation email has been sent to you. Please visit your account subscriptions page to check the status of your order.";*/
		String expectedMessage = "Thank you for your request. An email will be sent to you once the order is approved and the offer/stack is ready to use.";
		Assert.assertEquals(actualMessage, expectedMessage);
		String orderNewId = objORpage.orderNumberText.getText();
		try {
			FileWriter fw = new FileWriter(FILENAME);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("orderNewId= " + orderNewId);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
