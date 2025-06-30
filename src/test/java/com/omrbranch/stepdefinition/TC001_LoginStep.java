package com.omrbranch.stepdefinition;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import com.omrbranch.baseclass.BaseClass;
import com.pom.PageObjectManager;

import io.cucumber.java.en.*;

public class TC001_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager(driver);

	@Given("User is on the OMR Branch hotel page")
	public void user_is_on_the_omr_branch_hotel_page() {
		enterApplnUrl("https://omrbranch.com/");
	}

	@When("User login {string} and {string}")
	public void user_login_and(String username, String password) {
		pom.getLoginPage().login(username, password);
	}

	@Then("User should verify success message after login {string}")
	public void user_should_verify_success_message_after_login(String expectedWelcomeMsg) {
		String actualWelcome = pom.getLoginPage().getWelcomeMessage();
		Assert.assertEquals("Verify login success message", expectedWelcomeMsg, actualWelcome);
	}

	@When("User login {string} and {string} with enter key")
	public void user_login_and_with_enter_key(String username, String password) {
		pom.getLoginPage().loginWithEnterKey(username, password);
	}

	@Then("User should verify error message after login {string}")
	public void user_should_verify_error_message_after_login(String expectedErrorMsg) throws InterruptedException {
		Thread.sleep(2000);
		String actualError = pom.getLoginPage().getLoginErrorMessage();
		assertTrue("Expected error message not matched", actualError.contains(expectedErrorMsg));
	}
}
