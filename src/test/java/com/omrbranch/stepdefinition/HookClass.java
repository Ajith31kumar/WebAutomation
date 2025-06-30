package com.omrbranch.stepdefinition;

import com.omrbranch.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HookClass extends BaseClass {

	@Before
	public void beforeScenario() {
		browserLaunch();
		enterApplUrl("https://www.omrbranch.com/");
		maximizeWindow();
		implicitWait();

	}

	@After
	public void afterScenario(Scenario scenario) {
		scenario.attach(screenshot(), "images/png", "Every Scenario");
		closeBrowser();
	}
}
