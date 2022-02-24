package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CityBankPage {
	WebDriver driver;
	
	@FindBy(linkText="CITIGROUP.COM")
	WebElement citygroupLink;
	
	public WebElement getcitygroupLink() {
		return citygroupLink;
	}
	
	@FindBy(linkText="TERMS AND CONDITIONS")
	WebElement termscondition;
	
	public WebElement gettermscondition() {
		return termscondition;
	}
	
	@FindBy(linkText="MCLR")
	WebElement mclrLink;
	
	public WebElement getmclrLink() {
		return mclrLink;
	}
	
	public CityBankPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
