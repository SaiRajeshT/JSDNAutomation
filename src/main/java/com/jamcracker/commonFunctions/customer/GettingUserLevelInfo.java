package com.jamcracker.commonFunctions.customer;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.jamcracker.objectRepository.marketplace.PivotpathPages;
import com.jamcracker.utilities.TestBase;

public class GettingUserLevelInfo extends TestBase {
	
	static final String FILENAME = "./ConfigFile/Admin Password.txt";
	static final String FILENAME1 = "./ConfigFile/Admin UserName.txt";

	public void gettingInfo(String acronym, String userName, String password, String organizationName, String offerName)
	throws Exception{
		
		PivotpathPages objPivot = new PivotpathPages();
		objPivot.administrationLink.click();
		objPivot.memberOrgLink.click();
		objPivot.searchTextBox.sendKeys(organizationName);
		objPivot.searchButton.click();
		objPivot.manageLink.click();
		objPivot.editService(offerName).click();
		
		String adminPassword = objPivot.getAdminPassword();
		try {
			FileWriter fw = new FileWriter(FILENAME);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Admin Password = " + adminPassword);
			bw.newLine();
			bw.flush();
			bw.close();
    		}
		catch (IOException e) {
			e.printStackTrace();
		}	

		
		String adminUserName = objPivot.getAdminUserName();
		try {
			FileWriter fw = new FileWriter(FILENAME1);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Admin UserName = " + adminUserName);
			bw.newLine();
			bw.flush();
			bw.close();
    		}
		catch (IOException e) {
			e.printStackTrace();
		}	
				
	}
 
}

