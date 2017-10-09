package com.jamcracker.listeners;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.jamcracker.utilities.TestBase;

public class TestListener extends TestListenerAdapter {
	WebDriver driver;
	private static String fileSeperator = System.getProperty("file.separator");
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

	@Override
	public void onTestFailure(ITestResult result) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("***** Error " + result.getName() + " test has failed *****");

		//driver = Common.driver; //Taking the driver from common class.
		
		String packageName=result.getClass().getPackage().getName();
		packageName=packageName.substring(packageName.lastIndexOf(".")+1,packageName.length());

		String testClassName = result.getInstanceName().trim();
		testClassName = testClassName.substring(testClassName.lastIndexOf(".")+1 ,testClassName.length());
		System.out.println(testClassName);

		String testMethodName = result.getName().toString().trim();
		System.out.println(testMethodName);
		
		String screenShotName = testMethodName +sdf.format(timestamp)+ ".png";
		this.driver = TestBase.driver;
		if (driver != null) {
			String imagePath = ".." + fileSeperator + "Screenshots"
					+ fileSeperator + "Results" + fileSeperator +packageName+File.separator+ testClassName
					+ fileSeperator
					+ takeScreenShot(driver, screenShotName, testClassName);
			System.out.println("Screenshot can be found : " + imagePath);
		}
	}

	public static String takeScreenShot(WebDriver driver,
			String screenShotName, String testName) {
		try {
			File file = new File("Screenshots" + fileSeperator + "Results");
			if (!file.exists()) {
				System.out.println("File created " + file);
				file.mkdir();
			}

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File targetFile = new File("./Screenshots" + fileSeperator + "Results" + fileSeperator + testName, screenShotName);
			FileUtils.copyFile(screenshotFile, targetFile);

			return screenShotName;
		} catch (Exception e) {
			System.out.println("An exception occured while taking screenshot " + e.getCause());
			return null;
		}
	}

/*	public String getTestClassName(String testName) {
		String[] reqTestClassname = testName.split("\\.");
		int i = reqTestClassname.length - 1;
		System.out.println("Required Test Name : " + reqTestClassname[i]);
		return reqTestClassname[i];
	}
*/
}