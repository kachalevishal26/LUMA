package com.luma.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.luma.base.TestBase;
import com.luma.pages.HomePage;
import com.luma.testdata.DataSupplier;

public class HomePageTest extends TestBase {
	private static final Logger logger = LogManager.getLogger(HomePageTest.class);
	HomePage homePage;

	public HomePageTest() {
		super();
	}

	@Parameters("browser")
	@BeforeTest
	public void setup(@Optional("chrome") String browser) {
		initialization(browser);
		homePage = new HomePage();
		logger.info("setup");
	}
	
	@Test
	public void homePageTest() {
		logger.info("verifying home page");
		homePage.homePageVerify();
	}

	
	@Test
	public void selectProduct() throws InterruptedException {
		logger.info("selecting the product");
		homePage.productList();
	}

	@Test
	public void prodFilter() {
		logger.info("filtering the page");
		homePage.sortFilter();
	}

	@Test
	public void selProd() throws InterruptedException {
		logger.info("testing the product");
		homePage.prodTest();
	}

	@AfterTest
	public void tearDown() {
		logger.info("closing browser");
		driver.quit();
	}
}
