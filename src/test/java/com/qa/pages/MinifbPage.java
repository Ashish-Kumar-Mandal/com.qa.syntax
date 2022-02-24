package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MinifbPage {
	WebDriver driver;
	
//	for login fields
	
	@FindBy(id="mob")
	WebElement username;
	
	public void setLoginId(String loginId) {
		username.sendKeys(loginId);
	}
	
	@FindBy(id="pass")
	WebElement pass;
	
	public void setLoginPwd(String pwd) {
		pass.sendKeys(pwd);
	}
	
	@FindBy(id="login")
	WebElement loginButton;
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
//	for signUp  fields.
	
	@FindBy(id="login-btn")
	WebElement clickForSignup;
	
	public void clickForCreateNewUser() {
		clickForSignup.click();
	}
	
	@FindBy(id="name")
	WebElement name;
	
	public void setName(String name_val) {
		name.sendKeys(name_val);
	}
	
	@FindBy(id="mobile")
	WebElement mobile;
	
	public void setMobile(String mobile_val) {
		mobile.sendKeys(mobile_val);
	}
	
	@FindBy(id="email")
	WebElement email;
	
	public void setEmail(String email_val) {
		email.sendKeys(email_val);
	}
	
	@FindBy(id="password")
	WebElement password;
	
	public void setPassword(String password_val) {
		password.sendKeys(password_val);
	}
	
	@FindBy(id="signup")
	WebElement signupButton;
	
	public void clickSignupButton() {
		signupButton.click();
	}
	
	// Constructor.
	public MinifbPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
