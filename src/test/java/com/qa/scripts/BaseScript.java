package com.qa.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.AmazonPage;
import com.qa.pages.CityBankPage;
import com.qa.pages.MinifbPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseScript {

	WebDriver driver;
	AmazonPage amazon;
	MinifbPage minifb;
	FileInputStream fileLoc;
	CityBankPage citybank;
	Properties prop;
	
	@Parameters({"Browser", "url"})
	@BeforeClass
	public void setUp(String Browser, String url) throws IOException {	
		
		try {
			fileLoc = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/qa/testdata/credentials.properties");
			prop = new Properties();
			prop.load(fileLoc);			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		if(Browser.equalsIgnoreCase("Chrome")) {
		  	// System.setProperty("webdriver.chrome.driver", "D:\\All My Core Programming\\Testing-with-Java\\com.qa.syntax\\SeleniumDrivers\\chromedriver.exe");
			// -- OR --
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);		
		//NOTE: driver.get(url) and driver.navigate().to(url) both are same.
		
		amazon = new AmazonPage(driver);
		minifb = new MinifbPage(driver);
		citybank = new CityBankPage(driver);
	}
		
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
//		driver.close();	// close only current instance
		driver.quit();	// close all windows, tab, popup and frames.
	}
	
	public void captureScreenshot(WebDriver driver, String tName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"/Screenshots/"+tName+".png");
		FileUtils.copyFile(source, destination);
	}
}
