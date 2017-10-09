package com.jamcracker.utilities;

import java.util.Iterator;
import java.util.Set;

public class ThreeWindowsSwitch extends TestBase {
	
	private static String parentID;
	private static String childID;
	private static String grandchildID;
		
	public static void  getWindowHandles() {
		Set<String> windowIDs = driver.getWindowHandles();
		Iterator<String> it = windowIDs.iterator();
		parentID = it.next();
		childID = it.next();
		grandchildID = it.next();
	}
	
	public static void  switchToParent() {
		driver.switchTo().window(parentID);
	}
	
	public static void switchToChild() {
		driver.switchTo().window(childID);
	}
	
	public static void switchTograndChild() {
		driver.switchTo().window(grandchildID);
	}

}
