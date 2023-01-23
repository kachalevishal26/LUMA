package com.luma.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.luma.base.TestBase;
import com.luma.pages.LoginPage;
import com.luma.testutil.TestUtil;

public class LoginPageTest extends TestBase {
	private static final Logger logger = LogManager.getLogger(LoginPageTest.class);

	LoginPage loginPage;

	@Parameters("browser")
	@BeforeTest
	public void setUp(String browser) {
		initialization(browser);
		loginPage = new LoginPage();

		logger.info("setup");
	}

	@Test
	public void navTest() {
		loginPage.navToLogin();

		logger.info("navigate to login page");
	}

	@DataProvider
	public Object[][] excelData() {
		Object data[][] = TestUtil.getData("login");
		return data;
	}
	
	@Test(dataProvider = "excelData")
	public void loginTest(String user, String pass) {
		loginPage.loginCred(user, pass);

		logger.info("login");
	}

	@Test
	public void verifyLoginTest() {
		loginPage.verifyLogin();

		logger.info("verifying login");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

		logger.info("close the browser");
	}
}
