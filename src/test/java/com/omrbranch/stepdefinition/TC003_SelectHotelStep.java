package com.omrbranch.stepdefinition;

import org.junit.Assert;
import com.omrbranch.baseclass.BaseClass;
import com.omrbranchpage.SelectHotelPage3;
import com.pom.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC003_SelectHotelStep extends BaseClass {

    PageObjectManager pom = new PageObjectManager(driver);

    @Then("User should stay on the Select Hotel page with message {string}")
    public void userShouldStayOnSelectHotelPageWithMessage(String expectedMsg) {
        String actualMsg = pom.getSelectHotelPage3().getBookHotelPageHeaderText();
        Assert.assertEquals("User should remain on the Select Hotel page", expectedMsg, actualMsg);
    }

    @When("User save the Second hotel name and hotel price")
    public void userSaveTheSecondHotelNameAndHotelPrice() {
        pom.getSelectHotelPage3().saveSecondHotelNameAndPrice();
    }

    @When("User select the Select hotel and accept the alert")
    public void userSelectTheSelectHotelAndAcceptTheAlert() {
        pom.getSelectHotelPage3().selectSecondHotelAndAcceptAlert();
    }

    @Then("User should verify after select success message {string}")
    public void userShouldVerifyAfterSelectSuccessMessage(String expectedMsg) {
        String actualMsg = pom.getSelectHotelPage3().getBookHotelPageHeaderText(); 
        Assert.assertTrue("Verify Book Hotel page message", actualMsg.contains(expectedMsg));
    }


    @When("User save the last hotel name and hotel price")
    public void userSaveTheLastHotelNameAndHotelPrice() {
        pom.getSelectHotelPage3().saveLastHotelNameAndPrice();
    }

    @When("User select the last hotel and accept the alert")
    public void userSelectTheLastHotelAndAcceptTheAlert() {
        pom.getSelectHotelPage3().selectLastHotelAndAcceptAlert();
    }

    @When("User save the first hotel name and hotel price")
    public void userSaveTheFirstHotelNameAndHotelPrice() {
        pom.getSelectHotelPage3().saveFirstHotelNameAndPrice();
    }

    @When("User select the first hotel and dismiss the alert")
    public void userSelectTheFirstHotelAndDismissTheAlert() {
        pom.getSelectHotelPage3().selectFirstHotelAndDismissAlert();
    }
}
