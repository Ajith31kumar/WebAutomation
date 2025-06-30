package com.omrbranchpage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.omrbranch.baseclass.BaseClass;

public class ExploreHotelPage2 extends BaseClass {

	By txtWelcome = By.xpath("//h3[text()='Hotel Booking']");

	By ddnState = By.xpath("//select[@id='state']");
	By ddnStateText = By.xpath("//option[@value='Kerala']");

	By ddnCity = By.name("city");
	By ddnCityText = By.xpath("//span[text()='Kochi']");

	By ddnRoomType = By.id("room_type");

	By ddnRoomTextStandard = By.xpath("//li[text()='Standard']");
	By ddnRoomTextDeluxe = By.xpath("//li[text()='Deluxe']");
	By ddnRoomTextSuite = By.xpath("//li[text()='Suite']");
	By ddnRoomTextLuxury = By.xpath("//li[text()='Luxury']");
	By ddnRoomTextStudio = By.xpath("//li[text()='Studio']");

	By txtCheckIn = By.name("check_in");

	By txtCheckOut = By.name("check_out");

	By ddnNoOfRooms = By.id("no_rooms");
	By ddnNoOfAdults = By.id("no_adults");
	By txtChildren = By.id("no_child");

	By btnSearch = By.id("searchBtn");
	By txtSuccessMessage = By.xpath("//h5[normalize-space()='Select Hotel']");

	// Validation messages
	By errState = By.id("invalid-state");
	By errCity = By.id("invalid-city");
	By errCheckIn = By.id("invalid-check_in");
	By errCheckOut = By.id("invalid-check_out");
	By errNoOfRooms = By.id("invalid-no_rooms");
	By errNoOfAdults = By.id("invalid-no_adults");

	// Sorting
	By rdoSortLowToHigh = By.xpath("//label[@for='value_pltoh']");
	By rdoSortNameDescending = By.xpath("//label[@for='value_ndesc']");

	By txtTotalPrices = By.xpath("//strong[@class='total-prize']");

	By txtHotelNames = By.xpath("//div[@class='col-md-5 hotel-suites']//h5");

	By headerRoomType = By.xpath("//a[@id='room_type']");
	By hotelRoomHeaders = By.xpath("//a[@id='room_type']");

	// Room Filters
	By chkSuiteRoom = By.xpath("//li[text()='Suite']");
	By chkStandardRoom = By.xpath("//label[@for='Standard']");

	// iFrame Placeholder (add correct one if needed)
	By iFrameSearch = By.id("hotelsearch_iframe");

	// Action Methods
	public void clickHotelBooking() {
		elementClick(findElementBy(txtWelcome));
	}

	public void selectState(String state) {

    	elementClick(findElementBy(ddnState));

//        WebElement stateDropdown = waitForElementVisible(ddnState);
		selectOptionByVisibleText(findLocatorBy(ddnState), state);
	}

	public void selectOptionByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectCity(String city) {

		selectOptionByText(findElementBy(ddnCity), city);
	}

	public void selectRoomType(String roomType) {
		selectOptionByText(findElementBy(ddnRoomType), roomType);
	}

	public void enterCheckInDate(String checkIn) {
		By dateCheckIn = By.xpath("//a[text()='" + checkIn + "']");
//		elementSendKeys(findElementBy(txtCheckIn), checkIn);
		elementClick(findElementBy(txtCheckIn));
		elementClick(findElementBy(dateCheckIn));
	
	}

	public void enterCheckOutDate(String checkOut) {
		By dateCheckIn = By.xpath("//a[text()='" + checkOut + "']");
		elementClick(findElementBy(txtCheckOut));
		elementClick(findElementBy(dateCheckIn));
		
		
	}

	public void selectNoOfRooms(String rooms) {
		selectOptionByText(findElementBy(ddnNoOfRooms), rooms);
	}

	public void selectNoOfAdults(String adults) {
		selectOptionByText(findElementBy(ddnNoOfAdults), adults);
	}

	public void enterChildren(String children) {
		elementSendKeys(findElementBy(txtChildren), children);
	}
	public void switchToSearchFrame() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrameSearch));
	    System.out.println("✅ Switched to hotelsearch_iframe successfully");
	}

	public void clickSearchButton() {
	    elementClick(findElementBy(btnSearch));
	    driver.switchTo().defaultContent();  
	}

	public String getWelcomeText() {
	    return getText(findElementBy(txtSuccessMessage));
	}

	// Sorting and Filtering
	public void clickSortLowToHigh() {
	    elementClick(findElementBy(rdoSortLowToHigh));
	}


	public boolean isPriceSortedLowToHigh() {
	    List<WebElement> prices = findElementsBy(txtTotalPrices);
	    List<Integer> actual = new ArrayList<>();
	    for (WebElement price : prices) {
	        String priceText = price.getText().replaceAll("[^0-9]", "");
	        actual.add(Integer.parseInt(priceText));
	    }
	    List<Integer> expected = new ArrayList<>(actual);
	    Collections.sort(expected);
	    return actual.equals(expected);
	}


	public void clickSortNameDescending() {
		elementClick(findElementBy(rdoSortNameDescending));
	}

	public boolean isNameSortedDescending() {
		List<WebElement> names = findElementsBy(txtHotelNames);
		List<String> actual = new ArrayList<>();
		for (WebElement name : names) {
			actual.add(name.getText().trim());
		}
		List<String> expected = new ArrayList<>(actual);
		expected.sort(Collections.reverseOrder());
		return actual.equals(expected);
	}

	public boolean isHeaderContains(String roomType) {
		List<WebElement> headers = findElementsBy(headerRoomType);
		for (WebElement header : headers) {
			if (header.getText().contains(roomType)) {
				return true;
			}
		}
		return false;
	}



	public void selectStandardRoom() {
		elementClick(findElementBy(chkStandardRoom));
	}

	public boolean verifyStandardRoomTypeOnly() {
		List<WebElement> headers = findElementsBy(hotelRoomHeaders);
		for (WebElement header : headers) {
			if (!header.getText().contains("Standard")) {
				return false;
			}
		}
		return true;
	}

	
	public boolean validateErrorMessages(String expectedStateErr, String expectedCityErr, String expectedCheckInErr,
			String expectedCheckOutErr, String expectedRoomsErr, String expectedAdultsErr) {

		boolean stateMatch = getText(findElementBy(errState)).equals(expectedStateErr);
		boolean cityMatch = getText(findElementBy(errCity)).equals(expectedCityErr);
		boolean checkInMatch = getText(findElementBy(errCheckIn)).equals(expectedCheckInErr);
		boolean checkOutMatch = getText(findElementBy(errCheckOut)).equals(expectedCheckOutErr);
		boolean roomsMatch = getText(findElementBy(errNoOfRooms)).equals(expectedRoomsErr);
		boolean adultsMatch = getText(findElementBy(errNoOfAdults)).equals(expectedAdultsErr);

		return stateMatch && cityMatch && checkInMatch && checkOutMatch && roomsMatch && adultsMatch;
	}
}
