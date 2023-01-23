package com.luma.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.luma.base.TestBase;

public class RegisterPage extends TestBase {
	private static final Logger logger = LogManager.getLogger(RegisterPage.class);

	// PageFactory
	@FindBy(xpath = "//header/div[1]/div[1]/ul[1]/li[3]/a[1]")
	WebElement createAccount;

	@FindBy(id = "firstname")
	WebElement fName;

	@FindBy(id = "lastname")
	WebElement lName;

	@FindBy(id = "email_address")
	WebElement emailAddress;

	@FindBy(id = "password")
	WebElement uPwd;

	@FindBy(id = "password-confirmation")
	WebElement cPwd;

	@FindBy(xpath = "//button[@type='submit' and @class='action submit primary']")
	WebElement submitBtn;

	// initialize PageFactory
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public void navToRegister() {
		createAccount.click();
		logger.info("navigate to create account");
	}

	public void fillDetails(String fname, String lname, String email, String password, String cPassword) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		fName.sendKeys(fname);
		lName.sendKeys(lname);
		emailAddress.sendKeys(email);
		uPwd.sendKeys(password);
		cPwd.sendKeys(cPassword);
		js.executeScript("scroll(0,150)");
		submitBtn.click();
	}
}
