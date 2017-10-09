package com.jamcracker.objectRepository.store;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class StoreHomePage extends TestBase {
	
	public StoreHomePage() {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Store")
	public WebElement storeLink;

}
