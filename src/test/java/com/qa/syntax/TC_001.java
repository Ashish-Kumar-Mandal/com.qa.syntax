package com.qa.syntax;

import org.testng.annotations.Test;

public class TC_001 extends TestBase {
	
	@Test(priority=3)
	public void fundTransferByNEFT() {
		System.out.println("Transfer money using NEFT");
	}
	
	@Test(priority=1)
	public void fundTransferByRTGS() {
		System.out.println("Transfer money using RTGS");
	}
	
	@Test(priority=2)
	public void fundTransferByIMPS() {
		System.out.println("Transfer money using IMPS");
	}
		
}
