package com.jamcracker.commonFunctions.customer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.CatalogPage;
import com.jamcracker.objectRepository.customer.CustomerMenuAndSubmenuObjects;
import com.jamcracker.objectRepository.customer.OrderReceiptPage;
import com.jamcracker.objectRepository.customer.PaymentDetailsPage;
import com.jamcracker.objectRepository.customer.ShoppingCartPage;
import com.jamcracker.utilities.MouseActions;
import com.jamcracker.utilities.TestBase;

public class OrderNew extends TestBase {

	static final String FILENAME = "./ConfigFile/orderNumber.txt";
	CatalogPage objCatalog = new CatalogPage();

	public void orderNew(String serviceName, String offerName, String offerCode, String quantity,
			String paymentMethod,String budgetCode)
			throws Exception {
		CustomerMenuAndSubmenuObjects objCustCommon = new CustomerMenuAndSubmenuObjects();
		objCustCommon.catalogLink.click();
		explicitWait(objCatalog.searchTextBox);
		objCatalog.searchTextBox.sendKeys(serviceName,Keys.ENTER);
		/*objCatalog.searchIconButton.click();*/
		explicitWait(objCatalog.serviceNameText(serviceName));
		MouseActions.mouseHover(objCatalog.serviceNameText(serviceName));
		explicitWait(objCatalog.serviceViewOffersLink(serviceName));
		try {
			objCatalog.serviceViewOffersLink(serviceName).click();
		} catch (Exception e) {
			Thread.sleep(2000);
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
		
		PaymentDetailsPage objPaymentPage = new PaymentDetailsPage();
		try{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			objPaymentPage.bugetLookUpLink.click();
			/*objPaymentPage.budgetSearchTextBox.click();
			objPaymentPage.budgetSearchTextBox.clear();*/
			//objPaymentPage.budgetSearchTextBox.sendKeys(budgetCode);
			objPaymentPage.selectBudgetRadioButton(budgetCode);
			js.executeScript("arguments[0].scrollIntoView(true);",objPaymentPage.proceedButton);
			//explicitWait(objPaymentPage.proceedButton);
			objPaymentPage.budgetConfirmButton.click();

			
		}
		catch(NoSuchElementException e)
		{
			Reporter.log("Budget is not Enabled ");
		}
		
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
		
		try{
			  objPaymentPage.budgetExceedOkButton.click();
			
		}
		
		catch(NoSuchElementException e)
		{
			Reporter.log("Clicked on proceed button in payment details page");
		}
		OrderReceiptPage objORpage = new OrderReceiptPage();
		String actualMessage = objORpage.orderNotifyMsg.getText();
		/*String expectedMessage = "Thank you for your order. An order confirmation email has been sent to you. Please visit your account subscriptions page to check the status of your order.";*/
		String expectedMessage = "Thank you for your request. An email will be sent to you once the order is approved and the offer/stack is ready to use.";
		//Assert.assertEquals(actualMessage, expectedMessage);
		String orderNewId = objORpage.getOrderNumber();
		if(actualMessage.equalsIgnoreCase(expectedMessage))
		{
			Reporter.log("Order Placed Successfully. Order id is " + orderNewId);
		}
		else{
			Reporter.log("Issue while placing order please look in to the issue");
		}
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
