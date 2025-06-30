package com.omrbranchpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingConfirmationPage5 {
	
	By orderIdElement = By.xpath("//h2[@class='couppon-code']/strong");
	
	By myBookingButton = By.xpath("//button[contains(text(), 'My Booking')]");
	
	
//    @FindBy(xpath = "//h2[@class='couppon-code']/strong")
//    private WebElement orderIdElement;
//
//    @FindBy(xpath = "//button[contains(text(), 'My Booking')]")
//    private WebElement myBookingButton;

}
