package com.omrbranchpage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.omrbranch.baseclass.BaseClass;

public class SelectHotelPage3 extends BaseClass {

    // Locators
    By txtSelectHotel = By.xpath("//h5[text()='Select Hotel']");
    By hotelList = By.xpath("//div[@id='hotellist']/div[contains(@class, 'fliter_box_inner')]");
    By txtHotel = By.xpath(".//div[contains(@class,'hotel-suites')]//h5");
    By txtPriceWithTax = By.xpath(".//div[contains(@class,'prize')]//strong[contains(@class,'total-prize')]");
    By btnContinue = By.xpath(".//div[contains(@class,'prize')]//a[contains(@class,'btn') and contains(@class,'filter_btn')]");
    By headerBookHotel = By.xpath("//h2[contains(text(),'Book Hotel')]");
    
    // Static variables to hold hotel details
    public static String secondHotelName;
    public static String secondHotelPrice;
    public static String selectHotelName;
    public static String selectedHotelPrice;
    public static String lastHotelName;
    public static String lastHotelPrice;

    // Save the second hotel name and price
    public void saveSecondHotelNameAndPrice() {
        List<WebElement> hotels = findElementsBy(hotelList);
        if (hotels.size() >= 2) {
            WebElement secondHotel = hotels.get(1);
            secondHotelName = secondHotel.findElement(txtHotel).getText().trim();
            secondHotelPrice = secondHotel.findElement(txtPriceWithTax).getText().replaceAll("[^0-9]", "").trim();
            System.out.println("Saved Second Hotel Name: " + secondHotelName);
            System.out.println("Saved Second Hotel Price: " + secondHotelPrice);
        } else {
            System.out.println("Less than 2 hotels available to select.");
        }
    }

    // Save the first hotel name and price
    public void saveFirstHotelNameAndPrice() {
        List<WebElement> hotels = findElementsBy(hotelList);
        if (!hotels.isEmpty()) {
            WebElement hotel = hotels.get(0);
            selectHotelName = hotel.findElement(txtHotel).getText().trim();
            selectedHotelPrice = hotel.findElement(txtPriceWithTax).getText().replaceAll("[^0-9]", "").trim();
            System.out.println("First Hotel Name: " + selectHotelName);
            System.out.println("First Hotel Price: " + selectedHotelPrice);
        }
    }

    // Save the last hotel name and price
    public void saveLastHotelNameAndPrice() {
        List<WebElement> hotels = findElementsBy(hotelList);
        if (!hotels.isEmpty()) {
            WebElement lastHotel = hotels.get(hotels.size() - 1);
            lastHotelName = lastHotel.findElement(txtHotel).getText().trim();
            lastHotelPrice = lastHotel.findElement(txtPriceWithTax).getText().replaceAll("[^0-9]", "").trim();
            System.out.println("Last Hotel Name: " + lastHotelName);
            System.out.println("Last Hotel Price: " + lastHotelPrice);
        } else {
            System.out.println("No hotels available to save last hotel details.");
        }
    }

    // Select the second hotel and accept alert
    public void selectSecondHotelAndAcceptAlert() {
        List<WebElement> hotels = findElementsBy(hotelList);
        if (hotels.size() >= 2) {
            WebElement secondHotel = hotels.get(1);
            secondHotel.findElement(btnContinue).click();
            acceptAlert();
        }
    }

    // Select the first hotel and dismiss the alert
    public void selectFirstHotelAndDismissAlert() {
        List<WebElement> hotels = findElementsBy(hotelList);
        if (!hotels.isEmpty()) {
            WebElement firstHotel = hotels.get(0);
            firstHotel.findElement(btnContinue).click();
            dismissAlert();
        }
    }

    // Select the last hotel and accept alert
    public void selectLastHotelAndAcceptAlert() {
        List<WebElement> hotels = findElementsBy(hotelList);
        if (!hotels.isEmpty()) {
            WebElement lastHotel = hotels.get(hotels.size() - 1);
            lastHotel.findElement(btnContinue).click();
            acceptAlert();
        }
    }

    // Get the Book Hotel page header text
    public String getBookHotelPageHeaderText() {
        return findElementBy(headerBookHotel).getText().trim();
    }

    // Optional getters
    public static String getSecondHotelName() {
        return secondHotelName;
    }

    public static String getSecondHotelPrice() {
        return secondHotelPrice;
    }

    public static String getFirstHotelName() {
        return selectHotelName;
    }

    public static String getFirstHotelPrice() {
        return selectedHotelPrice;
    }

    public static String getLastHotelName() {
        return lastHotelName;
    }

    public static String getLastHotelPrice() {
        return lastHotelPrice;
    }
 


}
