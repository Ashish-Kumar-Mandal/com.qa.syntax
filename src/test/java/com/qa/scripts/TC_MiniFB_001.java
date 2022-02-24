package com.qa.scripts;

import org.testng.annotations.Test;

public class TC_MiniFB_001 extends BaseScript {
	@Test
	public void login() {
		minifb.setLoginId(prop.getProperty("Uname"));
		minifb.setLoginPwd(prop.getProperty("Upwd"));
		minifb.clickLoginButton();
	}
}
