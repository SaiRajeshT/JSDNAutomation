package com.jamcracker.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	ExcelReader reader;
	DesiredCapabilities capability;
	static WebDriverWait wait;
	public static int explicitTimeout = 30;
	public static int implicitTimeout = 10;
	public static  String packageName;
	public static int timeout =  600;
	public static String testClassName;
	
	
	@BeforeClass
	public void intialize()
	{
		 testClassName = this.getClass().getName();
		testClassName = testClassName.substring(testClassName.lastIndexOf(".")+1 ,testClassName.length());
	    packageName=this.getClass().getPackage().getName();
		packageName=packageName.substring(packageName.lastIndexOf(".")+1,packageName.length());
	}
	public void init(String browser, String url) {
		selectBrowser(browser);
		if (!browser.equalsIgnoreCase("firefox")) {
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(implicitTimeout,TimeUnit.SECONDS);
		driver.get(url);
		if (browser.equalsIgnoreCase("ie")) {
			driver.get("javascript:document.getElementById('overridelink').click();");
		}
	}
		
	public void selectBrowser(String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
			capability = DesiredCapabilities.firefox();
			capability.setAcceptInsecureCerts(true);
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver(capability);
			/*FirefoxProfile profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
			driver = new FirefoxDriver(profile);*/
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			capability = DesiredCapabilities.chrome();
			capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver(capability);
		} else if (browser.equalsIgnoreCase("ie")) {
			//System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/Drivers/IEDriverServer.exe");
			InternetExplorerDriverManager.getInstance().arch32().setup();
			driver = new InternetExplorerDriver();
		}
	}
	
	public String getData(String excelName, String sheetName, String colName, int rowNum) {
		String path = System.getProperty("user.dir")+"/Data/"+excelName;
		reader = new ExcelReader(path);
		String data = reader.getCellData(sheetName, colName, rowNum);
		return data;
	}
	
	public String[][] getData(String excelName, String sheetName) {
   	 	String path = System.getProperty("user.dir")+"/Data/"+excelName;
   	 	reader = new ExcelReader(path);
   	 	String[][] data = reader.getDataFromSheet(excelName, sheetName);
   	 	return data;
    }
		
	public void closeBrowser() {
		driver.close();
	}
	
	public static void explicitWait(WebElement element){
		wait = new WebDriverWait(driver, explicitTimeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void manualWait(WebElement element, int time) {
		wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void explicitWaitToClickable(WebElement element) {
		wait = new WebDriverWait(driver, explicitTimeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
