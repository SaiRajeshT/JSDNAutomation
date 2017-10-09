package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class CustomerMenuAndSubmenuObjects extends TestBase {
	
	public CustomerMenuAndSubmenuObjects() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Dashboard")
	public WebElement dashboardLink;
	
	@FindBy(linkText="Smartboard")
	public WebElement smartboardLink;
	
	@FindBy(linkText="SaaS Dashboard")
	public WebElement saasDashboardLink;
	
	@FindBy(linkText="IaaS Dashboard")
	public WebElement iaasDashboardLink;
	
	@FindBy(linkText="Catalog")
	public WebElement catalogLink;
	
	@FindBy(linkText="Manage")
	public WebElement manageLink;
	
	@FindBy(linkText="AppStacks")
	public WebElement appStacksLink;
		
	@FindBy(linkText="Instances")
	public WebElement instancesLink;
	
	@FindBy(linkText="Images")
	public WebElement imagesLink;
	
	@FindBy(linkText="Volume Snapshots")
	public WebElement volSnapLink;
	
	@FindBy(linkText="Monitoring")
	public WebElement monitoringLink;
	
	@FindBy(linkText="Static Public IP Address")
	public WebElement staticPublicIpLink;
	
	@FindBy(linkText="Import IaaS Resources")
	public WebElement importIaaSLink;
	
	@FindBy(linkText="Stack Templates")
	public WebElement stackTemplatesLink;
	
	@FindBy(linkText="Orders")
	public WebElement ordersLink;
	
	@FindBy(linkText="Subscriptions")
	public WebElement subscriptionsLink;
	
	@FindBy(linkText="Invoices")
	public WebElement invoicesLink;
	
	@FindBy(linkText="Payments")
	public WebElement paymentsLink;
	
	@FindBy(linkText="Cloud Service Credentials")
	public WebElement cloudCredentialsLink;
	
	@FindBy(linkText="Users")
	public WebElement usersLink;
	
	@FindBy(linkText="Policies")
	public WebElement policiesLink;
	
	@FindBy(linkText="Roles and Privileges")
	public WebElement rolesAndPrivilegesLink;
	
	@FindBy(linkText="Departments")
	public WebElement departmentsLink;
	
	@FindBy(linkText="Dealer")
	public WebElement dealerLink;
	
	@FindBy(linkText="Company Profile")
	public WebElement companyProfileLink;
	
	@FindBy(xpath="//li/a[text()='Reports']")
	public WebElement reportsMenuLink;
	
	@FindBy(xpath="//h2/a[text()='Reports']")
	public WebElement reportsSubMenuLink;
	
	@FindBy(linkText="Custom Reports")
	public WebElement customReportsLink;
	
	@FindBy(linkText="Offline Reports")
	public WebElement offlineReportsLink;
	
	@FindBy(xpath="//div[@id='profileMenu']/ul/li/div/a")
	public WebElement profileIcon;
	
	
	@FindBy(linkText="Sign Out")
	public WebElement signOutLink;

}
