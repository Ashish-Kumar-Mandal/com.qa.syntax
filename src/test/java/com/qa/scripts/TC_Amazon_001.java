package com.qa.scripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.utility.ExcelUtility;

public class TC_Amazon_001 extends BaseScript {
	
	SoftAssert SAssert = new SoftAssert();
		
	@Test(dataProvider="getData")
	public void searchItem(String category, String itemName) throws IOException {
		System.out.println(amazon.isCategorySelected());
		amazon.setCategory(category);
		
		System.out.println(amazon.isDisplayedSearchTextField());
		amazon.setSearchTextField(itemName);		
		
		System.out.println(amazon.isEnabledSearchButton());
		amazon.clickSearchButton();		

		System.out.println("Total No. of items are : "+amazon.noOfItems());
		
		boolean status = driver.getTitle().contains(itemName);
		
		if(status) {
			captureScreenshot(driver, "searchItem");
			Reporter.log("Title of the page has item name");
			SAssert.assertTrue(status);		
		}else {
			captureScreenshot(driver, "searchItem");
			Reporter.log("Title of the page has not item name");
			
			SAssert.assertTrue(status);		// It is Soft assert
			// Assert.assertTrue(status);	// It is Hard assert
		}		
		
		List<WebElement> getItems = amazon.getItemsName();
		for(WebElement item: getItems) {
			Reporter.log(item.getText(), true);
		}
		
		SAssert.assertAll();
	}
	
//	@DataProvider
//	public Object[][] getData(){
//		Object[][] data = new Object[3][2];
//		//set category
//		data[0][0] = "Electronics";
//		data[1][0] = "Appliances";
//		data[2][0] = "Books";
//		
//		//set itemName
//		data[0][1] = "Mobile Phones";
//		data[1][1] = "Washing Machines";
//		data[2][1] = "Da Vinci Code";
//		
//		return data;
//	}
	
	@DataProvider
	public String[][] getData() throws IOException{
		String xFile = "D:\\All My Core Programming\\Testing-with-Java\\com.qa.syntax\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";
		String xSheetName = "Sheet1";
		
		int rowCount = ExcelUtility.getRowCount(xFile, xSheetName);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheetName, rowCount);
		
		String[][] data = new String[rowCount][cellCount];
		
		for(int i=1; i<=rowCount; i++) {
			for(int j=0; j<cellCount; j++){
				data[i-1][j] = ExcelUtility.getCellData(xFile, xSheetName, i, j);
			}
		}
		
		return data;
	}
	
}
