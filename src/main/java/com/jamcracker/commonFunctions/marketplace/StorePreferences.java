package com.jamcracker.commonFunctions.marketplace;

import org.testng.Reporter;

import com.jamcracker.objectRepository.marketplace.SetUpPage;

public class StorePreferences 
{
	private static SetUpPage objSetUpPage=SetUpPage.getInstance();
	
	//private final static StorePreferences instance = new StorePreferences();

	private StorePreferences() 
	{
		
	}

	public static StorePreferences getInstance() 
	{
		return new StorePreferences();
	}


	public void storePreferences(String deleteCompany,String suspendCompany,String proxyCustomer,String enableSelfOrder,
			String showPublisherInfo,String manageCommercialContent, String showAnalyticStatistics,
			String overrideServiceDependency,String itemLevelSAD,String accessHelpDesk)
	{
		objSetUpPage.preferencesLink.click();
// Selecting or unselecting Delete company option based on the input from excel sheet
		try 
		{
			
			if (deleteCompany.equalsIgnoreCase("Y")) {
				
				if (!(objSetUpPage.deleteCompaniesCheckbox.isSelected())) {
					objSetUpPage.deleteCompaniesCheckbox.click();
					if (objSetUpPage.deleteCompaniesCheckbox.isSelected()) {
						Reporter.log("Delete company checkbox is selected");
				} else {
					Reporter.log("<p style='color:red'>Delete company checkbox is Not selected.Please check the issue.<p>");

				}
			}
			}
			
			
			else {
				if (objSetUpPage.deleteCompaniesCheckbox.isSelected()) {
					objSetUpPage.deleteCompaniesCheckbox.click();
					if (!(objSetUpPage.deleteCompaniesCheckbox.isSelected())) {
						Reporter.log("Delete company checkbox is un-selected");
					} else {
						Reporter.log("<p style='color:red'>Delete company checkbox is Not un-selected.Please check the issue<p>");
					}
				}

			}
			
			
		}
		catch (Exception e) 
		{
			//Need to capture screenshot here Manually
			e.printStackTrace();
			Reporter.log("<p style='color:Red'>Issue while selecting/unselecting delete company checkbox. Please check the issue </p>");
		
		}
		
		// Selecting or unselecting Suspend company option based on the input from excel sheet
				try 
				{
					
					if (suspendCompany.equalsIgnoreCase("Y")) {
						
						if (!(objSetUpPage.suspendCompaniesCheckbox.isSelected())) {
							objSetUpPage.suspendCompaniesCheckbox.click();
							if (objSetUpPage.suspendCompaniesCheckbox.isSelected()) {
								Reporter.log("Suspend company checkbox is selected");
						} else {
							Reporter.log("<p style='color:red'>Suspend company checkbox is Not selected.Please check the issue.<p>");

						}
					}
					}
					
					
					else {
						if (objSetUpPage.suspendCompaniesCheckbox.isSelected()) {
							objSetUpPage.suspendCompaniesCheckbox.click();
							if (!(objSetUpPage.suspendCompaniesCheckbox.isSelected())) {
								Reporter.log("Suspend company checkbox is un-selected");
							} else {
								Reporter.log("<p style='color:red'>Delete company checkbox is Not un-selected.Please check the issue<p>");
							}
						}

					}
					
					
				}
				catch (Exception e) 
				{
					//Need to capture screenshot here 
					e.printStackTrace();
					Reporter.log("<p style='color:Red'>Issue while selecting/unselecting suspend company checkbox. Please check the issue </p>");
				
				}
				
				// Selecting or unselecting proxy Customer option based on the input from excel sheet
				try 
				{
					
					if (deleteCompany.equalsIgnoreCase("Y")) {
						
						if (!(objSetUpPage.proxyCustomerCheckbox.isSelected())) {
							objSetUpPage.proxyCustomerCheckbox.click();
							if (objSetUpPage.proxyCustomerCheckbox.isSelected()) {
								Reporter.log("Proxy customer y checkbox is selected");
						} else {
							Reporter.log("<p style='color:red'>Proxy customer checkbox is Not selected.Please check the issue.<p>");

						}
					}
					}
					
					
					else {
						if (objSetUpPage.proxyCustomerCheckbox.isSelected()) {
							objSetUpPage.proxyCustomerCheckbox.click();
							if (!(objSetUpPage.proxyCustomerCheckbox.isSelected())) {
								Reporter.log("Proxy customer checkbox is un-selected");
							} else {
								Reporter.log("<p style='color:red'>Proxy customer checkbox is Not un-selected.Please check the issue<p>");
							}
						}

					}
					
					
				}
				catch (Exception e) 
				{
					//Need to capture screenshot here 
					e.printStackTrace();
					Reporter.log("<p style='color:Red'>Issue while selecting/unselecting Proxy customer. Please check the issue </p>");
				
				}
				
				
				// Selecting or unselecting Enable Self order  option based on the input from excel sheet
				try 
				{
					
					if (deleteCompany.equalsIgnoreCase("Y")) {
						
						if (!(objSetUpPage.selfOrderCheckbox.isSelected())) {
							objSetUpPage.selfOrderCheckbox.click();
							if (objSetUpPage.selfOrderCheckbox.isSelected()) {
								Reporter.log(" Enable Self order checkbox is selected");
						} else {
							Reporter.log("<p style='color:red'> Enable Self order checkbox is Not selected.Please check the issue.<p>");

						}
					}
					}
					
					
					else {
						if (objSetUpPage.selfOrderCheckbox.isSelected()) {
							objSetUpPage.selfOrderCheckbox.click();
							if (!(objSetUpPage.selfOrderCheckbox.isSelected())) {
								Reporter.log("Enable Self order checkbox is un-selected");
							} else {
								Reporter.log("<p style='color:red'>Enable Self order checkbox is Not un-selected.Please check the issue<p>");
							}
						}

					}
					
					
				}
				catch (Exception e) 
				{
					//Need to capture screenshot here 
					e.printStackTrace();
					Reporter.log("<p style='color:Red'>Issue while selecting/unselecting Enable Self order checkbox. Please check the issue </p>");
				
				}
				
				
				// Selecting or unselecting Show publisher  option based on the input from excel sheet
				try 
				{
					
					if (deleteCompany.equalsIgnoreCase("Y")) {
						
						if (!(objSetUpPage.showPublisherCheckbox.isSelected())) {
							objSetUpPage.showPublisherCheckbox.click();
							if (objSetUpPage.showPublisherCheckbox.isSelected()) {
								Reporter.log(" Show publisher  checkbox is selected");
						} else {
							Reporter.log("<p style='color:red'>Show publisher checkbox is Not selected.Please check the issue.<p>");

						}
					}
					}
					
					
					else {
						if (objSetUpPage.showPublisherCheckbox.isSelected()) {
							objSetUpPage.showPublisherCheckbox.click();
							if (!(objSetUpPage.showPublisherCheckbox.isSelected())) {
								Reporter.log("Show publisher checkbox is un-selected");
							} else {
								Reporter.log("<p style='color:red'>Show publisher checkbox is Not un-selected.Please check the issue<p>");
							}
						}

					}
					
					
				}
				catch (Exception e) 
				{
					//Need to capture screenshot here 
					e.printStackTrace();
					Reporter.log("<p style='color:Red'>Issue while selecting/unselecting Show publisher checkbox. Please check the issue </p>");
				
				}
				// Selecting or unselecting Manage commercial content option based on the input from excel sheet
				try 
				{
					
					if (deleteCompany.equalsIgnoreCase("Y")) {
						
						if (!(objSetUpPage.manageCommericalContentCheckbox.isSelected())) {
							objSetUpPage.manageCommericalContentCheckbox.click();
							if (objSetUpPage.manageCommericalContentCheckbox.isSelected()) {
								Reporter.log("Manage commercial content checkbox is selected");
						} else {
							Reporter.log("<p style='color:red'>Manage commercial content checkbox is Not selected.Please check the issue.<p>");

						}
					}
					}
					
					
					else {
						if (objSetUpPage.manageCommericalContentCheckbox.isSelected()) {
							objSetUpPage.manageCommericalContentCheckbox.click();
							if (!(objSetUpPage.manageCommericalContentCheckbox.isSelected())) {
								Reporter.log("Manage commercial content checkbox is un-selected");
							} else {
								Reporter.log("<p style='color:red'>Manage commercial content checkbox is Not un-selected.Please check the issue<p>");
							}
						}

					}
					
					
				}
				catch (Exception e) 
				{
					//Need to capture screenshot here 
					e.printStackTrace();
					Reporter.log("<p style='color:Red'>Issue while selecting/unselecting Manage commercial content checkbox. Please check the issue </p>");
				
				}
				
				// Selecting or unselecting Show Analytic Statistics option based on the input from excel sheet
				try 
				{
					
					if (deleteCompany.equalsIgnoreCase("Y")) {
						
						if (!(objSetUpPage.showAnalyticStaticCheckbox.isSelected())) {
							objSetUpPage.showAnalyticStaticCheckbox.click();
							if (objSetUpPage.showAnalyticStaticCheckbox.isSelected()) {
								Reporter.log("Show Analytic Statistics checkbox is selected");
						} else {
							Reporter.log("<p style='color:red'>Show Analytic Statistics checkbox is Not selected.Please check the issue.<p>");

						}
					}
					}
					
					
					else {
						if (objSetUpPage.showAnalyticStaticCheckbox.isSelected()) {
							objSetUpPage.showAnalyticStaticCheckbox.click();
							if (!(objSetUpPage.showAnalyticStaticCheckbox.isSelected())) {
								Reporter.log("Show Analytic Statistics checkbox is un-selected");
							} else {
								Reporter.log("<p style='color:red'>Show Analytic Statistics checkbox is Not un-selected.Please check the issue<p>");
							}
						}

					}
					
					
				}
				catch (Exception e) 
				{
					//Need to capture screenshot here 
					e.printStackTrace();
					Reporter.log("<p style='color:Red'>Issue while selecting/unselecting Show Analytic Statistics checkbox. Please check the issue </p>");
				
				}
				
				// Selecting or unselecting Override Service Dependency option based on the input from excel sheet
				try 
				{
					
					if (deleteCompany.equalsIgnoreCase("Y")) {
						
						if (!(objSetUpPage.overrideServiceDependencyCheckbox.isSelected())) {
							objSetUpPage.overrideServiceDependencyCheckbox.click();
							if (objSetUpPage.overrideServiceDependencyCheckbox.isSelected()) {
								Reporter.log("Override service dependency checkbox is selected");
						} else {
							Reporter.log("<p style='color:red'>Override service dependency checkbox is Not selected.Please check the issue.<p>");

						}
					}
					}
					
					
					else {
						if (objSetUpPage.overrideServiceDependencyCheckbox.isSelected()) {
							objSetUpPage.overrideServiceDependencyCheckbox.click();
							if (!(objSetUpPage.overrideServiceDependencyCheckbox.isSelected())) {
								Reporter.log("Override service dependency checkbox is un-selected");
							} else {
								Reporter.log("<p style='color:red'>Override service dependency checkbox is Not un-selected.Please check the issue<p>");
							}
						}

					}
					
					
				}
				catch (Exception e) 
				{
					//Need to capture screenshot here 
					e.printStackTrace();
					Reporter.log("<p style='color:Red'>Issue while selecting/unselecting Override service dependency checkbox. Please check the issue </p>");
				
				}
				
			//Selecting Item level Service Activation date based on the input value from excel sheet
		try{
			
		
		if (itemLevelSAD.equalsIgnoreCase("Y")) {
			if (!(objSetUpPage.itemLevelSADcheckbox.isSelected())) {
				objSetUpPage.itemLevelSADcheckbox.click();
				objSetUpPage.itemLevelRadioButton.click();
				if (objSetUpPage.itemLevelSADcheckbox.isSelected() && objSetUpPage.itemLevelRadioButton.isSelected()) {
					Reporter.log("Set Service activation date at item level  is selected");
				} else {
					Reporter.log(
							"<p style='color:red'>Set Service activation date at item level  is Not selected.Please check the issue.<p>");

				}
			}
		}
			
			else
			{ if (!(objSetUpPage.itemLevelSADcheckbox.isSelected())) {
				objSetUpPage.itemLevelSADcheckbox.click();}
			
			objSetUpPage.orderLevelRadioButton.click();
			if (objSetUpPage.itemLevelSADcheckbox.isSelected() && objSetUpPage.orderLevelRadioButton.isSelected()) {
				Reporter.log("Set Service activation date at order level  is selected");
			} else {
				Reporter.log(
						"<p style='color:red'>Set Service activation date order level  is Not selected.Please check the issue.<p>");

			}
				
		}
		}
		catch (Exception e) 
		{
			//Need to capture screenshot here 
			e.printStackTrace();
			Reporter.log("<p style='color:Red'>Issue while selecting order level/Item level SAD Radiobutton. Please check the issue </p>");
		
		}
		
		// Selecting or unselecting Access helpdesk option based on the input from excel sheet
		try 
		{
			
			if (accessHelpDesk.equalsIgnoreCase("Y")) {
				
				if (!(objSetUpPage.accessHelpDeskcheckbox.isSelected())) {
					objSetUpPage.accessHelpDeskcheckbox.click();
					if (objSetUpPage.accessHelpDeskcheckbox.isSelected()) {
						Reporter.log("Access Helpdesk  checkbox is selected");
				} else {
					Reporter.log("<p style='color:red'>Access Helpdesk checkbox is Not selected<p>.Please check the issue.");

				}
			}
			}
			
			
			else {
				if (objSetUpPage.accessHelpDeskcheckbox.isSelected()) {
					objSetUpPage.accessHelpDeskcheckbox.click();
					if (!(objSetUpPage.accessHelpDeskcheckbox.isSelected())) {
						Reporter.log("Access Helpdesk checkbox is un-selected");
					} else {
						Reporter.log("<p style='color:red'>Access Helpdesk checkbox is Not un-selected.Please check the issue<p>");
					}
				}

			}
			
			
		}
		catch (Exception e) 
		{
			//Need to capture screenshot here 
			e.printStackTrace();
			Reporter.log("<p style='color:Red'>Issue while selecting/unselecting Access Helpdesk checkbox. Please check the issue </p>");
		
		}
					
				
		
		objSetUpPage.saveAndNextButton.click();

	}
	
}
