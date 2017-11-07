package com.jamcracker.commonFunctions.customer;

import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.UsersPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class AddUser extends TestBase{
	
	public void addUser(String firstName,String lastName,String email, String phone,String role,String department)
	{
		UsersPage objAddUserPage = new UsersPage();
		objAddUserPage.manageLink.click();
		objAddUserPage.UsersLink.click();
		explicitWait(objAddUserPage.addUserLink);
		objAddUserPage.addUserLink.click();
		explicitWait(objAddUserPage.firstNameTextBox);
		objAddUserPage.firstNameTextBox.sendKeys(firstName);
		objAddUserPage.lastNameTextBox.sendKeys(lastName);
		objAddUserPage.emailTextBox.sendKeys(email);
		objAddUserPage.contactPhoneTextBox.sendKeys(phone);
		HandleDropDown.selectDDLByVisibletext(objAddUserPage.roleDropDown, role);
		HandleDropDown.selectDDLByVisibletext(objAddUserPage.departmentDropDown, department);
		objAddUserPage.saveAndExitButton.click();
		if(objAddUserPage.successMsgBar.getText().contains("added successfully"))
			{
			Reporter.log(firstName + lastName + "User Added Successfully");
			}
		else{
			Reporter.log("<p style= 'color:red'> User creation failed </p>");
		}
		
		
		
		
	}

}
