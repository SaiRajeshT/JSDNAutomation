package com.jamcracker.commonFunctions.customer;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.jamcracker.entity.service.PolicyCreationData;
import com.jamcracker.objectRepository.customer.CustomerMenuAndSubmenuObjects;
import com.jamcracker.objectRepository.customer.PoliciesPage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class PolicyCreation extends TestBase {
	
	public void policyCreation(PolicyCreationData pcData) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		CustomerMenuAndSubmenuObjects objCustCommon = new CustomerMenuAndSubmenuObjects();
		objCustCommon.manageLink.click();
		try {
			explicitWaitToClickable(objCustCommon.policiesLink);
			objCustCommon.policiesLink.click();
		} catch (Exception e) {
			objCustCommon.manageLink.click();
			explicitWaitToClickable(objCustCommon.policiesLink);
			objCustCommon.policiesLink.click();
		}
		PoliciesPage objPolicies = new PoliciesPage();
		objPolicies.addPolicyLink.click();
		objPolicies.policyNameTextBox.clear();
		objPolicies.policyNameTextBox.sendKeys(pcData.getPolicyName());
		objPolicies.policyDescTextBox.clear();
		objPolicies.policyDescTextBox.sendKeys(pcData.getPolicyDesc());
		
		switch (pcData.getPolicyCategory()) {
		case "Iaas Resources":			
			HandleDropDown.selectDDLByVisibletext(objPolicies.policyCategoryDropDown, pcData.getPolicyCategory());
			HandleDropDown.selectDDLByVisibletext(objPolicies.usingEventDropDown, pcData.getUsingEvent());
			HandleDropDown.selectDDLByVisibletext(objPolicies.actionDropDown, pcData.getAction());
			HandleDropDown.selectDDLByVisibletext(objPolicies.departmentsDropDown, pcData.getDepartment());
			HandleDropDown.selectDDLByVisibletext(objPolicies.providerDropDown, pcData.getProvider());
			objPolicies.regionsButton.click();
			for (String region : pcData.getRegions()) {
				js.executeScript("arguments[0].scrollIntoView(true);",objPolicies.regionsCheckBox(region));
				explicitWaitToClickable(objPolicies.regionsCheckBox(region));
				objPolicies.regionsCheckBox(region).click();
			}		
			explicitWait(objPolicies.regionSelectionSection);
			objPolicies.providerHelpIcon.click();
			objPolicies.imagesButton.click();
			for (String image : pcData.getImages()) {
				js.executeScript("arguments[0].scrollIntoView(true);",objPolicies.imagesCheckBox(image));
				explicitWaitToClickable(objPolicies.imagesCheckBox(image));
				objPolicies.imagesCheckBox(image).click();
			}
			objPolicies.providerHelpIcon.click();
			objPolicies.sizeButton.click();
			for (String size : pcData.getSizes()) {
				js.executeScript("arguments[0].scrollIntoView(true);",objPolicies.sizesCheckBox(size));
				explicitWaitToClickable(objPolicies.sizesCheckBox(size));
				objPolicies.sizesCheckBox(size).click();
			}		
			objPolicies.providerHelpIcon.click();
			objPolicies.networkButton.click();
			for (String network : pcData.getNetworks()) {
				js.executeScript("arguments[0].scrollIntoView(true);",objPolicies.networksCheckBox(network));
				explicitWaitToClickable(objPolicies.networksCheckBox(network));
				objPolicies.networksCheckBox(network).click();
			}		
			objPolicies.providerHelpIcon.click();			
			break;
			
		case "Instance":
			HandleDropDown.selectDDLByVisibletext(objPolicies.policyCategoryDropDown, pcData.getPolicyCategory());
			Map<String, String> tags = pcData.getTags();
			int tagSize = tags.size();
			Set<Map.Entry<String, String>> set = tags.entrySet();
			Iterator<Entry<String, String>> itr = set.iterator();
			for (int i = 1; i <= tagSize; i++) {
				if(i==1) {
					Map.Entry<String , String> entry = (Map.Entry<String, String>) itr.next();
					objPolicies.resourceTagKeyTextBox(i).sendKeys(entry.getKey());
					objPolicies.tagsHelpIcon.click();
					objPolicies.resourceTagValueTextBox(i).sendKeys(entry.getValue());
					objPolicies.tagsHelpIcon.click();
				} else {
					objPolicies.anothertagLink.click();
					Map.Entry<String , String> entry = (Map.Entry<String, String>) itr.next();
					objPolicies.resourceTagKeyTextBox(i).sendKeys(entry.getKey());
					objPolicies.tagsHelpIcon.click();
					objPolicies.resourceTagValueTextBox(i).sendKeys(entry.getValue());
					objPolicies.tagsHelpIcon.click();
				}
			}
			

		default:
			break;
		}
		
		
		objPolicies.saveAndFinishButton.click();
		objPolicies.searchPolicyTextBox.sendKeys(pcData.getPolicyName());
		objPolicies.goButton.click();
		Assert.assertTrue(objPolicies.policyNameText(pcData.getPolicyName()).isDisplayed());
		
	}

}
