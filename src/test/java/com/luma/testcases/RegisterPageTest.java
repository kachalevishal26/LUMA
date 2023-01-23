package com.luma.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.luma.base.TestBase;
import com.luma.pages.RegisterPage;
import com.luma.testutil.TestUtil;

public class RegisterPageTest extends TestBase {
	private static final Logger logger = LogManager.getLogger(RegisterPageTest.class);

	RegisterPage registerPage;

	public RegisterPageTest() {
		super();
	}

	@Parameters("browser")
	@BeforeTest
	public void setUp(String browser) {
		initialization(browser);
		registerPage = new RegisterPage();
		logger.info("setup");
	}

	@Test()
	public void navTest() {
		registerPage.navToRegister();
		logger.info("navigate to register page");
	}
	
	@DataProvider
	public Object[][] excelData() {
		Object data[][] = TestUtil.getData("register");
		return data;
	}

	@Test(dataProvider = "excelData")
	public void fillDetailsTest(String fname, String lname, String email, String password, String cPassword) {
		registerPage.fillDetails(fname, lname, email, password, cPassword);
		logger.info("fill user details");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		logger.info("close the browser");
	}
}
