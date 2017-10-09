package com.jamcracker.commonFunctions.marketplace;

import com.jamcracker.objectRepository.marketplace.DesignerConsolePage;
import com.jamcracker.utilities.TestBase;

public class StackVendorSelection extends TestBase {
	
	DesignerConsolePage dConsole = new DesignerConsolePage();
	
	//Method to Select the Vendors where the Stack created will support
	public void selectVendors(String[][] vendorsData) {		
		/*String[][] vendors = getData("TestData.xls", "StackSupportVendorsSheet");*/
		try {
			dConsole.getVendorsDropDown.click();
			for (int i = 0; i < vendorsData.length; i++) {
				for (int j = 0; j <= 0; j++) {
					dConsole.getVendorCheckBox(vendorsData[i][j]).click();
				}
			} 
		} catch (Exception e) {
			dConsole.getVendorsDropDown.click();
			for (int i = 0; i < vendorsData.length; i++) {
				for (int j = 0; j <= 0; j++) {
					dConsole.getVendorCheckBox(vendorsData[i][j]).click();
				}
			}
		}
		dConsole.getVendorToolTip.click();
	}

}
