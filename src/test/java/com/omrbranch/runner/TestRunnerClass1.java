package com.omrbranch.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.reports.ReportGenerate;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"com.omrbranch.stepdefinition"},
    plugin = {
        "pretty",
        "json:target/cucumber-reports/cucumber.json",
        "junit:target/cucumber-reports/junit-report.xml",
        "html:target/cucumber-reports/html"
    },
    tags = "@Smoke",
    stepNotifications = false,
    snippets = SnippetType.CAMELCASE,
    monochrome = false,
    dryRun = false
)
public class TestRunnerClass1 {

    @AfterClass
    public static void runner() {
        ReportGenerate.genetateJvmReport("target/cucumber-reports/cucumber.json");
    }
    
    /// this is try
}
