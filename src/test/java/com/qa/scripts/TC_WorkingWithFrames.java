package com.qa.scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_WorkingWithFrames extends BaseScript{
	
	@Test(priority=1)
	public void framesByID() {
		List<WebElement> frames = driver.findElements(By.tagName("frame"));
		int totalFrames = frames.size();
		System.out.println("Total number of Frames on this page: "+totalFrames);
		
		for(int i=0; i<totalFrames; i++) {
			WebDriver frame	= driver.switchTo().frame(i);
			int totalLinks = frame.findElements(By.tagName("a")).size();
			System.out.println("Total links of Frames "+i+" is: "+ totalLinks);
			driver.switchTo().defaultContent(); // iterate smoothly
		}
	}
	
	@Test(priority=2)
	public void framesByName() {
		WebDriver frame = driver.switchTo().frame("packageListFrame");
		System.out.println("Page Title is: "+frame.getTitle());
		driver.switchTo().defaultContent(); 
	}
	
	@Test(priority=3)
	public void framesByElement() {
		WebElement ele = driver.findElement(By.xpath("//frame[@src='allclasses-frame.html']"));
		WebDriver frame = driver.switchTo().frame(ele);
		System.out.println("Page Title is: "+frame.getTitle());
		WebElement arrayLink = frame.findElement(By.linkText("ArrayType"));
		if(arrayLink.isDisplayed()) {
			System.out.println(arrayLink.getAttribute("href"));
			arrayLink.click();
		}
	}
}
