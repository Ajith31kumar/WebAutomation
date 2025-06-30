package com.omrbranchpage;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.omrbranch.baseclass.BaseClass;

public class LoginPage1 extends BaseClass {

	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPage1(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	private By txtEmailId = By.id("email");
	private By txtPassword = By.id("pass");
	private By btnLogin = By.xpath("//button[text()='Login']");
	private By txtWelcome = By.xpath("//a[contains(text(),'Welcome')]");
	private By txtLoginError = By.xpath("//div[@id='errorMessage']");

	public void login(String username, String password) {
		elementSendKeys(findElementBy(txtEmailId), username);
		elementSendKeys(findElementBy(txtPassword), password);
		elementClick(findElementBy(btnLogin));
	}

	public void loginWithEnterKey(String username, String password) {
		findElementBy(txtEmailId).sendKeys(username);
		findElementBy(txtPassword).sendKeys(password + Keys.ENTER);
	}

	public String getWelcomeMessage() {
		WebElement welcomeMsgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(txtWelcome));
		return elementGetText(welcomeMsgElement);
	}

	public String getLoginErrorMessage() {
		WebElement errorMsgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(txtLoginError));
		return elementGetText(errorMsgElement);
	}
	
}
