package com.luma.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.luma.base.TestBase;

public class LoginPage extends TestBase {
	private static final Logger logger = LogManager.getLogger(LoginPage.class);

	// PageFactory
	@FindBy(xpath = "//body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
	WebElement signIn;

	@FindBy(id = "email")
	WebElement uName;

	@FindBy(id = "pass")
	WebElement uPwd;

	@FindBy(xpath = "//button[@type='submit' and @class='action login primary']")
	WebElement loginBtn;

	@FindBy(xpath = "//header/div[1]/div[1]/ul[1]")
	WebElement welcomeMsg;

	// initialize PageFactory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void navToLogin() {
		signIn.click();

		logger.info("navigate to create account");
	}

	public void loginCred(String user, String pass) {
		uName.sendKeys(user);
		uPwd.sendKeys(pass);
		loginBtn.click();

		logger.info("login");
	}

	public void verifyLogin() {
		boolean msg = driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]")).isDisplayed();
		if (msg == true) {
			System.out.println("Logged in successfully");
		} else {
			System.out.println("Login failed");
		}
		
		logger.info("verify login");
	}

}
