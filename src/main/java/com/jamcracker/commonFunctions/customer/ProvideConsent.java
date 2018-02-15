package com.jamcracker.commonFunctions.customer;


//import java.io.FileReader;

//import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.SmartDashboardPage;
import com.jamcracker.utilities.TestBase;
import com.jamcracker.utilities.TwoWindowsSwitch;

public class ProvideConsent extends TestBase {
	
	 
	public void provideConsent(String custEmail, String password,
			String offerName, String userEmail, String userPassword, String newPassword) throws Exception{
		
		SmartDashboardPage objSmartDashboardPage = new SmartDashboardPage();
		objSmartDashboardPage.selectDashboard.click();
		objSmartDashboardPage.smartDashboard.click();
		objSmartDashboardPage.gettingStartedLink(offerName).click();
		objSmartDashboardPage.provideConsentLink.click();
		
		//FileReader fr = new FileReader("./ConfigFile/UserEmailID.txt");
		//BufferedReader br= new BufferedReader(fr);
		//String mailId= br.readLine();
		
		//try{
	
		TwoWindowsSwitch.getWindowHandles();
		TwoWindowsSwitch.switchToChild();
		objSmartDashboardPage.enterEmailTextBox.sendKeys(userEmail);
		objSmartDashboardPage.nextButton.click();
		objSmartDashboardPage.passwordTextBox.sendKeys(userPassword);
		Thread.sleep(3000);
		objSmartDashboardPage.signInButton.click();
		Thread.sleep(3000);
		objSmartDashboardPage.currentPasswordTextBox.sendKeys(userPassword);
		objSmartDashboardPage.newPasswordTextBox.sendKeys(newPassword);
		objSmartDashboardPage.confirmNewPasswordTextBox.sendKeys(newPassword);
		objSmartDashboardPage.signInButton.click();
		Thread.sleep(2000);
		objSmartDashboardPage.acceptButton.click();
		Thread.sleep(2000);
		objSmartDashboardPage.noButton.click();
		Thread.sleep(3000);
		TwoWindowsSwitch.switchToParent();
		objSmartDashboardPage.closeButton.click();
		
		//}
		//catch(Exception e){
		//	Reporter.log("Unable to enter User Mail Id");
		//}
		
		
   }

}
