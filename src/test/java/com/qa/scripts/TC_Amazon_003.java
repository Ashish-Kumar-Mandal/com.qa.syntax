package com.qa.scripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Amazon_003 extends BaseScript {
	
	@Test
	public void registration() {
		Actions act = new Actions(driver);
		WebElement accountAndLists = amazon.getAccountAndLists();
		act.moveToElement(accountAndLists).build().perform(); // mouse hover on the element
		
		amazon.clickStartHereLink();
		
		boolean contains = driver.getTitle().contains("Registration");
		
		if(contains) {
			Reporter.log("Title has Registration Word");
			Assert.assertTrue(contains);
		}else {
			Reporter.log("Title has not Registration Word");
			Assert.assertTrue(contains);
		}
	}
}
