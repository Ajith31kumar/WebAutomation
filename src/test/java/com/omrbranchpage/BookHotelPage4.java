package com.omrbranchpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.omrbranch.baseclass.BaseClass;

public class BookHotelPage4 extends BaseClass {
	public BookHotelPage4(WebDriver driver) {
		super(); 
	}
	String selectedHotel;
	// Guest details
	By ddnMyself = By.id("own");
	By ddnTitle = By.id("user_title");
	By txtFirstName = By.id("first_name");
	By txtLastName = By.id("last_name");
	By txtPhone = By.id("user_phone");
	By txtEmail = By.id("user_email");
	By btnNext1 = By.id("step1next");
	By btnContinue =By.xpath(".//a[contains(@class,'filter_btn') and text()='Continue']");
    By hotelList = By.xpath("//div[@id='hotellist']/div[contains(@class, 'fliter_box_inner')]");

	// GST
	By chkGst = By.id("gst");
	By txtGstNumber = By.id("gst_registration");
	By txtCompanyName = By.id("company_name");
	By txtCompanyAddress = By.id("company_address");
	By btnNext2 = By.id("step2next");

	
	// Special request
	By btnSmoking = By.xpath("//input[@id='smoking']");

	// Payment – Card
	By creditCardOption = By.xpath("//div[@class='credit-card pm']");
	By ddnpaymentType = By.xpath("//select[@id='payment_type']");
	
	
	By ddnCardType = By.id("card_type");
	By txtCardNo = By.id("card_no");
	By txtCardName = By.id("card_name");
	By ddnMonth = By.id("card_month");
	By ddnYear = By.id("card_year");
	By txtCvv = By.id("cvv");
	By btnSubmit = By.id("submitBtn");

	By hotelName = By.xpath("//p[contains(text(),'Hotel')]/strong");
	By orderId = By.xpath("//h2[contains(@class,'couppon-code')]/strong");


	By bookingMessage = By.xpath("//h2[contains(@class,'couppon-code')]");

	// Payment – UPI
	By upiOption = By.xpath("//div[@class='upi pm']");
	By txtUpi = By.id("upi_id");
	By btnUpiSubmit = By.id("submitBtn");

	// Error locators (example)
	By errCardName = By.id("error_card_name");
	By errCardNo = By.id("error_card_no");
	By errCardMonth = By.id("error_card_month");
	By errCardYear = By.id("error_card_year");
	By errCvv = By.id("error_cvv");
	By errCardType = By.id("error_card_type");
	By errUpi = By.id("error_upi");
	
	public void selectFirstHotelAndAcceptAlert() {
	    List<WebElement> hotels = findElementsBy(hotelList);
	    if (!hotels.isEmpty()) {
	        WebElement firstHotel = hotels.get(0);
	        WebElement continueButton = firstHotel.findElement(btnContinue);
	        continueButton.click();

	        
	        acceptAlert();
	    }
	}


	public void enterGuestDetails(String myself, String title, String fName, String lName, String phone, String email) {
		elementClick(findElementBy(ddnMyself));
		selectByVisibleText(findElementBy(ddnTitle), title);
		elementSendKeys(findElementBy(txtFirstName), fName);
		elementSendKeys(findElementBy(txtLastName), lName);
		elementSendKeys(findElementBy(txtPhone), phone);
		elementSendKeys(findElementBy(txtEmail), email);
//		elementClick(findElementBy(btnNext1));
	
	}

	public void enterGstDetails(String regNo, String companyName, String companyAddr) throws InterruptedException {
		Thread.sleep(2000);
		elementClick(findElementBy(chkGst));
		elementSendKeys(findElementBy(txtGstNumber), regNo);
		elementSendKeys(findElementBy(txtCompanyName), companyName);
		elementSendKeys(findElementBy(txtCompanyAddress), companyAddr);
		elementClick(findElementBy(btnNext1));
	}

	public void enterSpecialRequest(String request) {
		elementClick(findElementBy(btnSmoking));
		elementClick(findElementBy(btnNext2));
	}
	

	public void selectCreditCard() {
	    elementClick(findElementBy(creditCardOption));
	    
	}


	public void enterCardDetails( String cardType, String cardNo, String cardName, String month, String year, String cvv) {
		selectByVisibleText(findElementBy(ddnpaymentType), "Debit Card");
		selectByVisibleText(findElementBy(ddnCardType), cardType);
		elementSendKeys(findElementBy(txtCardNo), cardNo);
		elementSendKeys(findElementBy(txtCardName), cardName);
		selectByVisibleText(findElementBy(ddnMonth), month);
		selectByVisibleText(findElementBy(ddnYear), year);
		elementSendKeys(findElementBy(txtCvv), cvv);
		elementClick(findElementBy(btnSubmit));
	}

	public void clickSubmitWithoutPayment() {
		elementClick(findElementBy(btnSubmit));
	}
	

	  
	   public String getBookingConfirmationText() {
			WebElement msgElement = findElementBy(bookingMessage);
			return msgElement.getText();
		}
	   public String getOrderId() {
			WebElement orderElement = findElementBy(orderId);
			return orderElement.getText();
		}
	   public String getSelectedHotelName() {
			WebElement hotelElement = driver.findElement(hotelName);
			selectedHotel = hotelElement.getText();
			return selectedHotel;
		}
	   public String getBookedHotelName() {
			WebElement bookedHotelElement = findElementBy(hotelName);
			return bookedHotelElement.getText();
		}

//	public void verifyCardErrorMessages(String err1, String err2, String err3, String err4, String err5, String err6) {
//		softAssertEquals("Verify card name error", getText(findElementBy(errCardName)), err1);
//		softAssertEquals("Verify card no error", getText(findElementBy(errCardNo)), err2);
//		softAssertEquals("Verify card month error", getText(findElementBy(errCardMonth)), err3);
//		softAssertEquals("Verify card year error", getText(findElementBy(errCardYear)), err4);
//		softAssertEquals("Verify CVV error", getText(findElementBy(errCvv)), err5);
//		softAssertEquals("Verify card type error", getText(findElementBy(errCardType)), err6);
//	}

	public void selectUpiOption() {
		elementClick(findElementBy(upiOption));
	}

	public void enterUpiDetails(String upiId) {
		elementSendKeys(findElementBy(txtUpi), upiId);
		elementClick(findElementBy(btnUpiSubmit));
	}
//
//	public void verifyUpiErrorMessage(String expectedMsg) {
//		softAssertEquals("Verify UPI error", getText(findElementBy(errUpi)), expectedMsg);
//	}
}
