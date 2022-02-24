package com.qa.scripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_Amazon_002 extends BaseScript {
	SoftAssert SAssert = new SoftAssert();
	
	List<WebElement> getFooterLinks;
	
	@Test
	public void verifyFooterLinks() {
		getFooterLinks = amazon.getFooterLinks();
		int numberOfFooterLinks = getFooterLinks.size();		
		// footer links should not be exceed more than 50
		
		// Assert.assertEquals(numberOfFooterLinks, 50);	// It is Hard Assert
		SAssert.assertEquals(numberOfFooterLinks, 50);	// It is Soft Assert
		
		SAssert.assertAll();	// In last line of function, It is required if use SoftAssert otherwise not
	}
	
	@Test(priority=2, dependsOnMethods="verifyFooterLinks")
	public void fetchAllFooterLinksText() {
		for(WebElement links: getFooterLinks) {
			Reporter.log(links.getText(), true);
		}
	}
}
