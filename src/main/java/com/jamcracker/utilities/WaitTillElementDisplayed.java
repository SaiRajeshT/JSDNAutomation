package com.jamcracker.utilities;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class WaitTillElementDisplayed extends TestBase {
	public  static boolean elementdisplayed(WebElement element)
	{
		boolean result = false;
		long startTime = (System.currentTimeMillis()) / 1000;
		while (result==false) // Converting in to second and waiting till the time
						// out or the condition satisfied
		{
			if ((System.currentTimeMillis() / 1000) - startTime > timeout) {
				System.out.println("Reached 10 minutes and exiting the loop");
				Reporter.log(
						"<p Style ='color:Red'> Waited for" +timeout+" Seconds. Element did not appear please look in to the issue.</p>");
				Assert.fail();
			}
	
			try{
				element.isDisplayed();
				result=true;
				break;
				}
				
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

}
