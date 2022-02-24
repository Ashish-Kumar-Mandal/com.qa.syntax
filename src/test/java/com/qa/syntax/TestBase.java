package com.qa.syntax;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	@BeforeTest
	public void invokeBrowser() {
		System.out.println("Launch browser and enter the URL");
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("Close the browser");
	}
	
	@BeforeClass
	public void login() {
		System.out.println("Login successfully");
	}
	
	@AfterClass
	public void logout() {
		System.out.println("Logout successfully");
	}
	
	@BeforeMethod	// execute before every method annotated @Test method.
	public void checkBalance() {
		System.out.println("Check the balance");
	}
	
	@AfterMethod	// execute after every method annotated @Test method.
	public void acknowledgement() {
		System.out.println("Print an acknowledgement");
	}	
	
}
