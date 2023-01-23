package com.luma.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.luma.base.TestBase;
import com.luma.pages.HomePage;

public class HomePageTest extends TestBase {
	private static final Logger logger = LogManager.getLogger(HomePageTest.class);
	HomePage homePage;

	public HomePageTest() {
		super();
	}

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		initialization(browser);
		homePage = new HomePage();
		logger.info("setup");
	}
	
	@Test
	public void homePageTest() {
		homePage.homePageVerify();
		logger.info("verifying home page");
	}
	
	@Test
	public void listPageTest() {
		homePage.productList();
		homePage.sortFilter();
		homePage.items();
		logger.info("product list page");
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//		logger.info("closing browser");
//	}
}
