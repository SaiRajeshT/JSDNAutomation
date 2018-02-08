package com.jamcracker.utilities;

import java.util.Iterator;
import java.util.Set;

public class TwoWindowsSwitch extends TestBase {
	
	
	public static String parentID;
	public static String childID;
		

	
	public static void getWindowHandles()
	{
		Set<String> windowIDs = getDriver().getWindowHandles();
		Iterator<String> it = windowIDs.iterator();
		parentID = it.next();
		childID = it.next();
	}
	
	public static  void switchToParent() {
		getDriver().switchTo().window(parentID);
	}
	
	public static void switchToChild() {
		getDriver().switchTo().window(childID);
	}
	
}
