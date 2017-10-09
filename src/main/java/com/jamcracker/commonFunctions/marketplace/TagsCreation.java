package com.jamcracker.commonFunctions.marketplace;

import com.jamcracker.objectRepository.marketplace.DesignerConsolePage;
import com.jamcracker.utilities.TestBase;

public class TagsCreation extends TestBase {
	
	DesignerConsolePage dConsole = new DesignerConsolePage();
	
	//Method to Create Tags
	public void createTags(String[][] tagsData) {		
		dConsole.getTagsTitle.click();
		/*String[][] tagsData = getData("TestData.xls", "TagsSheet");*/
		for (int i = 0; i < tagsData.length; i++) {			
			for (int j = 0; j <=1; j++) {				
				if(j==0) {
					dConsole.getTagKeyCheckBox(Integer.toString(i+1)).sendKeys(tagsData[i][j]);
					dConsole.getValueLabel.click();
				} else if (j==1) {
					dConsole.getTagValueCheckBox(Integer.toString(i+1)).sendKeys(tagsData[i][j]);
					dConsole.getValueLabel.click();
				}
			}
			if(i<tagsData.length-1) {
				dConsole.getAddNewLink.click();
			}
		}		
	}

}
