package com.jamcracker.commonFunctions.marketplace;

import com.jamcracker.objectRepository.marketplace.DesignerConsolePage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class SecurityGroupCreation extends TestBase {
	
	DesignerConsolePage dConsole = new DesignerConsolePage();
	
	//Method to Create Security Group
	public void createSecurityGroup() {		
		String[][] sgData = getData("TestData.xls", "SGCreationSheet");
		for (int i = 0; i < sgData.length; i++) {			
			for (int j = 0; j <=4; j++) {				
				if(j==0) {
					HandleDropDown.selectDDLByValue(dConsole.getRuleDD(Integer.toString(i+1)), sgData[i][j]);
				} else if (j==1) {
					dConsole.getPortStartRange(Integer.toString(i+1)).sendKeys(sgData[i][j]);
				} else if (j==2) {
					dConsole.getPortEndRange(Integer.toString(i+1)).sendKeys(sgData[i][j]);
				} else if (j==3) {
					dConsole.getIpAddress(Integer.toString(i+1)).sendKeys(sgData[i][j]);
				} else if (j==4) {
					dConsole.getSubnetMask(Integer.toString(i+1)).sendKeys(sgData[i][j]);
				}						
			}
			if(i<sgData.length-1) {
				dConsole.getSgAddNewLink.click();
			}						
		}
		dConsole.getDoneButton.click();		
	}

}
