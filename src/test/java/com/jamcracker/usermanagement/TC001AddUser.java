package com.jamcracker.usermanagement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.AddUser;
import com.jamcracker.commonFunctions.customer.AssginSubscription;
import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.utilities.TestBase;

public class TC001AddUser extends TestBase{

		private String getURL() {
			return getData("TestData.xls", "URLSheet", "URL", 4);
		}
		
		

		@BeforeClass
		@Parameters({ "browser" })
		public void setUp(String browser) {
			init("chrome", getURL());
		}
		
		@DataProvider(name="UserData")
			public String[][] getUserData()
			{
				return getData("User Creation.xls", "Users");
			}

@Test (priority=1)
public void customerLogin(){
	String email = getData("User Creation.xls", "CredentialsSheet", "Email Address", 2);
	String password = getData("User Creation.xls", "CredentialsSheet", "Password", 2);
	CustomerAdminLogin loginObj = new CustomerAdminLogin();
	loginObj.customerAdminLogin(email, password);
}


@Test(dataProvider="UserData",priority=2)
public void testaddUser(String executable,String firstName,String lastName,String email,String phone,String role,
		String department,String offerName,String siteName,String callingPermission,String language,String phoneType,String phoneName)
{
	if(executable.equalsIgnoreCase("y"))
	{
		AddUser objAddUser = new AddUser();
		AssginSubscription objAssign = new AssginSubscription();
		objAddUser.addUser(firstName, lastName, email, phone, role, department);
		objAssign.assignSubscription(email, phone, offerName, siteName, callingPermission, language, phoneType,phoneName);
	}
	
	
}
		


}


