package com.jamcracker.utilities;

import java.util.HashMap;
import java.util.Map;
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
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class TestBase {
	
	ExcelReader reader;
	DesiredCapabilities capability;
	static WebDriverWait wait;
	public static int explicitTimeout = 30;
	public static int implicitTimeout = 10;
	public static  String packageName;
	public static int timeout =  600;
	public static String testClassName;
	
	public static Map<String, WebDriver> webDriversMap = new HashMap<String, WebDriver>();
	
	
	public static  WebDriver getDriver() {
		return webDriversMap.get(Thread.currentThread().getName());
	}
	@BeforeClass
	public void intialize()
	{
		 testClassName = this.getClass().getName();
		testClassName = testClassName.substring(testClassName.lastIndexOf(".")+1 ,testClassName.length());
	    packageName=this.getClass().getPackage().getName();
		packageName=packageName.substring(packageName.lastIndexOf(".")+1,packageName.length());
	}
	public void init(String browser, String url) {
		System.out.println("Inside init");
		
		selectBrowser(browser);
		if (!browser.equalsIgnoreCase("firefox")) {
			getDriver().manage().window().maximize();
		}
		getDriver().manage().timeouts().implicitlyWait(implicitTimeout,TimeUnit.SECONDS);
		getDriver().get(url);
		if (browser.equalsIgnoreCase("ie")) {
			getDriver().get("javascript:document.getElementById('overridelink').click();");
		}
	}
	
	
	public  void  selectBrowser(String browser) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName);
		WebDriver driver = webDriversMap.get(currentThreadName);
		if(driver == null) {
			if(browser.equalsIgnoreCase("firefox")) {
				capability = DesiredCapabilities.firefox();
				capability.setAcceptInsecureCerts(true);
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
				//FirefoxDriverManager.getInstance().setup();
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
			webDriversMap.put(currentThreadName, driver);
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
		getDriver().close();
	}
	
	public static void explicitWait(WebElement element){
		wait = new WebDriverWait(getDriver(), explicitTimeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void explicitWaitInvisible(WebElement element){
		wait = new WebDriverWait(getDriver(), explicitTimeout);
		//wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void manualWait(WebElement element, int time) {
		wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void explicitWaitToClickable(WebElement element) {
		wait = new WebDriverWait(getDriver(), explicitTimeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void explicitWaitFrameToLoad(WebElement element)
	{
		wait = new WebDriverWait(getDriver(), explicitTimeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		
	}
	
	public static void waitTillFrameLoad(WebElement element){
		
		 wait =new WebDriverWait(getDriver(), explicitTimeout);
		 wait.ignoring(org.openqa.selenium.StaleElementReferenceException.class);
		 wait.ignoring(org.openqa.selenium.WebDriverException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
