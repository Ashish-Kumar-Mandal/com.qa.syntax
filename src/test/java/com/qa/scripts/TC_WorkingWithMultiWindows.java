package com.qa.scripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TC_WorkingWithMultiWindows extends BaseScript {

	@Test
	public void multipleWins() {
		citybank.getcitygroupLink().click();	// 2nd window
		citybank.gettermscondition().click();	//3rd window	
		citybank.getmclrLink().click();		// 4th window
		
		Set<String> winIDs = driver.getWindowHandles();
		Iterator<String> iterator = winIDs.iterator();
		
		while(iterator.hasNext()) {
			String id = iterator.next();
			WebDriver window = driver.switchTo().window(id);
			System.out.println(window.getTitle());
		}
	}
}
