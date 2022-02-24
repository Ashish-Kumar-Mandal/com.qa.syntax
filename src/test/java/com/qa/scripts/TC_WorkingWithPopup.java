package com.qa.scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_WorkingWithPopup extends BaseScript {

	@Test
	public void popupHandle() throws InterruptedException {
		WebElement userName = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input"));
		WebElement userEmail = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]"));
		
		userName.sendKeys("123456");
		userName.sendKeys(Keys.TAB);
		
		Alert jsAlert = driver.switchTo().alert();
		System.out.println(jsAlert.getText());
		// here popUp appears
		jsAlert.accept();	// click OK button on alert popUp window
//		jsAlert.dismiss();	// click Cancel button on alert popUp window
		
		Thread.sleep(3000);
		
		userName.clear();
		userName.sendKeys("Smith");
		
		userEmail.sendKeys("akm@gmail.com");
		Thread.sleep(3000);
	}
}
