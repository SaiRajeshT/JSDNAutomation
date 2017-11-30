package com.jamcracker.testcases.usermanagement;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.AddUser;
import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.CustomerLogout;
import com.jamcracker.utilities.TestBase;

public class TC001AddUser extends TestBase {
	int count = 0;
	ArrayList<String> al = new ArrayList<String>();

	private String getURL() {
		return getData("User Creation.xls", "CredentialsSheet", "URL", 2);
	}

	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String browser) {
		init("chrome", getURL());
	}

	@DataProvider(name = "UserData")
	public String[][] getUserData() {
		return getData("User Creation.xls", "Users");
	}

@Test(dataProvider="UserData",priority=1)
public void testaddUser(String executable,String custEmail,String password,String firstName,String lastName,String email,String phone,String role,
		String department)
{
	
	
	if(executable.equalsIgnoreCase("y"))
	{  
		al.add(custEmail);
		CustomerAdminLogin loginObj = new CustomerAdminLogin();
		AddUser objAddUser = new AddUser();
		if(count ==0){
		loginObj.customerAdminLogin(custEmail, password);
		objAddUser.addUser(firstName, lastName, email, phone, role, department);
		CustomerLogout.logOut();

				}
		else
		{	
			if(custEmail.equalsIgnoreCase(al.get(count-1)))
			{
				objAddUser.addUser(firstName, lastName, email, phone, role, department);
			}
			else{
				CustomerLogout.logOut();
				loginObj.customerAdminLogin(custEmail, password);
				objAddUser.addUser(firstName, lastName, email, phone, role, department);
				
			}
		}
	
		count++;

	}
	
}

}