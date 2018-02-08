package com.jamcracker.utilities;

import java.util.Iterator;
import java.util.Set;

public class ThreeWindowsSwitch extends TestBase {
	
	private static String parentID;
	private static String childID;
	private static String grandchildID;
		
	public static void  getWindowHandles() {
		Set<String> windowIDs = getDriver().getWindowHandles();
		Iterator<String> it = windowIDs.iterator();
		parentID = it.next();
		childID = it.next();
		grandchildID = it.next();
	}
	
	public static void  switchToParent() {
		getDriver().switchTo().window(parentID);
	}
	
	public static void switchToChild() {
		getDriver().switchTo().window(childID);
	}
	
	public static void switchTograndChild() {
		getDriver().switchTo().window(grandchildID);
	}

}
