package com.jamcracker.utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot 
{
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	
	 public static  void screenshot(WebDriver driver, String screenshotname,String testClassName,String packageName) 
	  {	
			 Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		 
		  TakesScreenshot ts = (TakesScreenshot) driver;

		  File srcfile = ts.getScreenshotAs(OutputType.FILE);
		  try {
			  
			//FileUtils.copyFile(srcfile, new File ("D:\\AutomationScreenshot\\" + screenshotname+".png"));
			FileUtils.copyFile(srcfile, new File ("./Results/Screenshots"+File.separator+packageName+File.separator+testClassName+File.separator+screenshotname+sdf.format(timestamp)+".png"));

		  	} 
		  catch (IOException e) 
		  {
			System.out.println("Exception while taking screenshot" + e.getMessage());
		  }
	  } 

}
