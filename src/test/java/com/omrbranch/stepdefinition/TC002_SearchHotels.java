package com.omrbranch.stepdefinition;

import java.io.IOException;

import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranchpage.ExploreHotelPage2;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC002_SearchHotels  extends BaseClass{

    ExploreHotelPage2 pom = new ExploreHotelPage2();

    @When("User search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
    public void userSearchHotelWithAllFields(String state, String city, String roomType, String checkInDate,
                                             String checkOutDate, String noOfRooms, String noOfAdults, String noOfChildren) throws Exception {
        pom.clickHotelBooking();      
     
        
        pom.selectState(state);
        pom.selectCity(city);
        pom.selectRoomType(roomType);
        pom.enterCheckInDate(checkInDate);
        pom.enterCheckOutDate(checkOutDate);
        pom.selectNoOfRooms(noOfRooms);
        pom.selectNoOfAdults(noOfAdults);
        pom.enterChildren(noOfChildren);
        pom.switchToSearchFrame();
        pom.clickSearchButton();
    }

    @Then("User should verify after search hotel success message {string}")
    public void userShouldVerifySearchHotelSuccessMessage(String expectedMessage) throws InterruptedException {
    	Thread.sleep(3000);
        String actualMessage = pom.getWelcomeText();
        Assert.assertTrue("Verify success message", actualMessage.contains(expectedMessage));
    }

    @When("User search hotel {string},{string},{string},{string},{string} and {string}")
    public void userSearchHotelWithMandatoryFields(String state, String city, String checkInDate,
                                                   String checkOutDate, String noOfRooms, String noOfAdults) throws IOException {
    
      pom.clickHotelBooking();      
     
        
        pom.selectState(state);
        pom.selectCity(city);
        pom.enterCheckInDate(checkInDate);
        pom.enterCheckOutDate(checkOutDate);
        pom.selectNoOfRooms(noOfRooms);
        pom.selectNoOfAdults(noOfAdults);
        pom.switchToSearchFrame();
        pom.clickSearchButton();
    }


    @Then("User click Search button")
    public void userClickSearchButton() {
        pom.clickHotelBooking();
        pom.switchToSearchFrame();
        pom.clickSearchButton();
    }

    @Then("User should verify after search hotel error message {string} ,{string} ,{string} ,{string} ,{string} and {string}")
    public void userShouldVerifyAfterSearchHotelErrorMessageAnd(String stateErr, String cityErr, String checkInErr,
                                                                 String checkOutErr, String roomsErr, String adultsErr) {
        boolean result = pom.validateErrorMessages(
                stateErr, cityErr, checkInErr, checkOutErr, roomsErr, adultsErr);
        Assert.assertTrue("Error messages did not match!", result);
    }

    @When("User click sort from low to high")
    public void userClickSortLowToHigh() {
        pom.clickSortLowToHigh();
    }

    @Then("User should verify after sorting that price are listed from low to high")
    public void userShouldVerifyPriceLowToHigh() {
        boolean sorted = pom.isPriceSortedLowToHigh();
        System.out.println("Is sorted (Low to High)? : " + sorted);
       
    }

    @When("User click sort from Descending order")
    public void userClickSortDescending() {
        pom.clickSortNameDescending();
    }

    @Then("User should verify after sorting that name in Descending order")
    public void userShouldVerifyNameDescending() {
        boolean sorted = pom.isNameSortedDescending();
        System.out.println("Is sorted(High to Low)? " + sorted);
        Assert.assertTrue("Hotel names are not sorted in descending order", sorted);
    }



    @Then("User should verify the header contains {string}")
    public void userShouldVerifyHeaderContains(String expectedRoomType) {
        boolean contains = pom.isHeaderContains(expectedRoomType);
        Assert.assertTrue("Header does not contain room type: " + expectedRoomType, contains);
    }

    @When("User click Standard room type")
    public void userClickStandardRoomType() {
        pom.selectStandardRoom();
    }

    @Then("User should verify after sorting that Standard room type is listed")
    public void userShouldVerifyStandardRoomTypeListed() {
        boolean onlyStandard = pom.verifyStandardRoomTypeOnly();
        Assert.assertTrue("Not only standard rooms listed", onlyStandard);
    }
}
