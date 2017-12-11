package com.jamcracker.testcases.usermanagement;

import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.AssginSubscription;
import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.CustomerLogout;
import com.jamcracker.commonFunctions.customer.VerifySubscriptionStatus;
import com.jamcracker.utilities.TestBase;
@Listeners(com.jamcracker.listeners.TestListener.class)

public class TC002Assignsubscription extends TestBase {
	int count = 0;
	ArrayList<String> al = new ArrayList<String>();


/*	private String getURL() {
		return getData("User Creation.xls", "CredentialsSheet", "URL", 2);
	}*/
	
	

	@BeforeClass
	@Parameters({ "browser","storeUrl" })
	public void setUp(String browser,String url) {
		init(browser, url);
	}
	
	@DataProvider(name="UserData")
	public String[][] getUserData(){
		return getData("CustomerCreationData.xls", "Assign service");
	}


@Test(dataProvider="UserData")
public void testAssignSubscription(String executable, String custEmail, String password ,String email,String offerName)
{

	if(executable.equalsIgnoreCase("y"))
	{  
		al.add(custEmail);
		CustomerAdminLogin loginObj = new CustomerAdminLogin();
		AssginSubscription objAssignUser = new AssginSubscription();
		if(count ==0){
		loginObj.customerAdminLogin(custEmail, password);
		objAssignUser.assignSubscription(email, offerName);

				}
		else
		{	
			if(custEmail.equalsIgnoreCase(al.get(count-1)))
			{
				objAssignUser.assignSubscription(email, offerName);
				
			}
			else{
				CustomerLogout.logOut();
				loginObj.customerAdminLogin(custEmail, password);
				objAssignUser.assignSubscription(email, offerName);
				
			}
		}
		count++;
		VerifySubscriptionStatus.verifySubscriptionStatus(email, offerName);
	}
}
@AfterClass
public void close()
{
	closeBrowser();
}
}