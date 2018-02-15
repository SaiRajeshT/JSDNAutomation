package com.jamcracker.testcases.customeManagement;

	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

	import com.jamcracker.commonFunctions.customer.EnterpriseAdminLogin;
	import com.jamcracker.commonFunctions.customer.ManageCatalog;
	import com.jamcracker.utilities.TestBase;

	public class TC021AddServiceToCatalog extends TestBase {
		
		@DataProvider(name = "EnterpriseCatalogData")
		public String[][] getCatalogData() {
			return getData("CustomerData.xls", "ManageCatalog");
		}

		@BeforeMethod
		@Parameters({"browser","storeUrl"})
		public void setUp(String browser, String url) {
			init(browser, url);
		}
		
		@Test(dataProvider = "EnterpriseCatalogData")
		public void addToCatalog(String executable, String email, String password, String serviceName, 
				String offerName, String multiDept) throws Exception{
			if(executable.equalsIgnoreCase("Y"))
			{
			EnterpriseAdminLogin objLogin = new EnterpriseAdminLogin();
			objLogin.enterpriseAdminLogin(email, password);
			ManageCatalog objManageCatalog = new ManageCatalog();
			objManageCatalog.manageCatalog(serviceName, offerName, multiDept);
			}
		}
		@AfterMethod
		public void tearDown() {
			closeBrowser();
		}
	}

	

