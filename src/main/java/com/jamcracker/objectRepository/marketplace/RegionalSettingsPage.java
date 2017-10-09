package com.jamcracker.objectRepository.marketplace;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class RegionalSettingsPage extends TestBase
{
	public RegionalSettingsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Regional Settings')]")
	public WebElement regionalSettingsLink;
	
	@FindBy(xpath="//input[@id='language_en_US']")
	public WebElement languageEnglishCheckbox;
	
	@FindBy(xpath="//div[@id='new_language_en_US']//input[@value='en_US']")
	public WebElement defaultEnglishRadioButton;
	
	@FindBy(id="SelectLanguageBtn")
	public WebElement addTimezoneButton;

	@FindBy(id="timezone_JCP_TIMEZONE_00018")
	public WebElement brasiliaTimezoneCheckBox;
	
	@FindBy(id="timezone_JCP_TIMEZONE_00039")
	public WebElement moscowTimezoneCheckBox;
	
	@FindBy(id="timezone_JCP_TIMEZONE_00069")
	public WebElement GMTTimezoneCheckBox;
	
	@FindBy(id="SelectTimeZoneBtn")
	public WebElement addDateFormatButton;
	
	@FindBy(xpath="//button[@id='SelectDateFormatBtn'][contains(text(),'Save')]")
	public WebElement saveButton;

}
