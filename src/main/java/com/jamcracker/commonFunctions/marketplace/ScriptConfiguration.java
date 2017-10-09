package com.jamcracker.commonFunctions.marketplace;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.jamcracker.objectRepository.marketplace.DesignerConsolePage;
import com.jamcracker.utilities.HandleDropDown;
import com.jamcracker.utilities.TestBase;

public class ScriptConfiguration extends TestBase {
	
	DesignerConsolePage dConsole = new DesignerConsolePage();
	Properties prop = new Properties();
	
	//Method to enter shell script using property file
		public void shellScriptConfiguration() throws Exception {		
			InputStream input = null;
			input = new FileInputStream(System.getProperty("user.dir") + "/ConfigFile/stackScript.properties");
			prop.load(input);
			dConsole.getShellScriptTextBox.sendKeys(prop.getProperty("shellScript"));		
		}
		
	//Method to enter Chef Details using property file
		public void chefScriptConfiguration(String chefType) throws Exception {		
			InputStream input = null;
			input = new FileInputStream(System.getProperty("user.dir") + "/ConfigFile/stackScript.properties");
			prop.load(input);
			if (chefType.contains("enterprise")) {
				HandleDropDown.selectDDLByValue(dConsole.getChefType, chefType);
				dConsole.getClientTextBox.sendKeys(prop.getProperty("Eclient"));
				dConsole.getValidatorTextBox.sendKeys(prop.getProperty("Evalidator"));
				dConsole.getEndpointTextBox.sendKeys(prop.getProperty("Eendpoint"));
				dConsole.getOrganizationTextBox.sendKeys(prop.getProperty("Eorganization"));
				dConsole.getValidatorPemFileTextBox.sendKeys(prop.getProperty("EvalidatorPemFile"));
				dConsole.getClientPemFileTextBox.sendKeys(prop.getProperty("EclientPemFile"));
				dConsole.getCertificateTextBox.sendKeys(prop.getProperty("ECertificateFileName"));
				dConsole.getCookbookTextBox.sendKeys(prop.getProperty("cookbook"));
			}else {
				HandleDropDown.selectDDLByValue(dConsole.getChefType, chefType);
				dConsole.getClientTextBox.sendKeys(prop.getProperty("Oclient"));
				dConsole.getValidatorTextBox.sendKeys(prop.getProperty("Ovalidator"));
				dConsole.getEndpointTextBox.sendKeys(prop.getProperty("Oendpoint"));
				dConsole.getValidatorPemFileTextBox.sendKeys(prop.getProperty("OvalidatorPemFile"));
				dConsole.getClientPemFileTextBox.sendKeys(prop.getProperty("OclientPemFile"));
				dConsole.getCertificateTextBox.sendKeys(prop.getProperty("OCertificateFileName"));
				dConsole.getCookbookTextBox.sendKeys(prop.getProperty("cookbook"));
			}	
		}

}
