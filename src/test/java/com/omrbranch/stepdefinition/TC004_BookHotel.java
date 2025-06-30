package com.omrbranch.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.pom.PageObjectManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC004_BookHotel extends BaseClass {
	String orderIdText;
	String selectedHotelName;
	String bookedHotelName;

	PageObjectManager pom = new PageObjectManager(driver);
	
	@When("User select the first hotel and accept the alert")
	public void user_select_the_first_hotel_and_accept_the_alert() {
	    pom.getbBookHotelPage4().selectFirstHotelAndAcceptAlert();
	}

	@When("User add Guest Details {string},{string},{string},{string},{string} and {string}")
	public void user_add_guest_details_and(String myself, String title, String firstName, String lastName, String phone, String email) {
	    pom.getbBookHotelPage4().enterGuestDetails(myself, title, firstName, lastName, phone, email);
	}


	@When("User add GST Details {string},{string} and {string}")
	public void user_add_gst_details_and(String gstNo, String companyName, String address) throws InterruptedException {
		pom.getbBookHotelPage4().enterGstDetails(gstNo, companyName, address);
	}

	@When("User add Special Request {string}")
	public void user_add_special_request(String request)  {
		
		pom.getbBookHotelPage4().enterSpecialRequest(request);
	}

	@When("User enter payment details, procced with Card Type {string}")
	public void user_enter_payment_details_procced_with_card_type(String cardType, DataTable dataTable) {
		   pom.getbBookHotelPage4().selectCreditCard();
		   
	    Map<String, String> data = dataTable.asMaps().get(0); 

	    String cardNo = data.get("Card No");
	    String cardName = data.get("Card Name");
	    String month = data.get("Month");
	    String year = data.get("Year");
	    String cvv = data.get("CVV");

	  
	    pom.getbBookHotelPage4().enterCardDetails(cardType, cardNo, cardName, month, year, cvv); 
	}

	@When("User should verify after hotel booking success message {string} and save the order ID")
	public void user_should_verify_after_hotel_booking_success_message_and_save_the_order_id(String expectedMsg) {
	    
	    String actualMsg = pom.getbBookHotelPage4().getBookingConfirmationText();
	    
	    
	    Assert.assertTrue("Booking confirmation message mismatch", actualMsg.contains(expectedMsg));
	    System.out.println("Booking Message Verified: " + actualMsg);

	    
	    orderIdText = pom.getbBookHotelPage4().getOrderId();
	    System.out.println("Order ID: " + orderIdText);

	    
	    selectedHotelName = pom.getbBookHotelPage4().getSelectedHotelName();
	    System.out.println("Selected Hotel Name: " + selectedHotelName);
	}
	@Then("User should verify same selected Hotel is booked or not")
	public void user_should_verify_same_selected_hotel_is_booked_or_not() {
	    
	    bookedHotelName = pom.getbBookHotelPage4().getBookedHotelName();
	    System.out.println("Booked Hotel Name: " + bookedHotelName);

	    
	    Assert.assertEquals("Hotel mismatch after booking", selectedHotelName, bookedHotelName);
	}

	@When("User click credit card")
	public void user_click_credit_card() {
		pom.getbBookHotelPage4().selectCreditCard();
	}

	@When("User click submit without entering payment details")
	public void user_click_submit_without_entering_payment_details() {
		pom.getbBookHotelPage4().clickSubmitWithoutPayment();
	}

//	@Then("User should verify after payment details error message {string} ,{string} ,{string} ,{string} ,{string} and {string}")
//	public void user_should_verify_after_payment_details_error_message_and(String err1, String err2, String err3, String err4, String err5, String err6) {
//		pom.getbBookHotelPage4().verifyCardErrorMessages(err1, err2, err3, err4, err5, err6);
//	}

	@When("User enter upi details {string} and click submit")
	public void user_enter_upi_details_and_click_submit(String upiId) {
		pom.getbBookHotelPage4().enterUpiDetails(upiId);
	}

	@When("User click upi")
	public void user_click_upi() {
		pom.getbBookHotelPage4().selectUpiOption();
	}

//	@Then("User should verify after payment details error message {string}")
//	public void user_should_verify_after_payment_details_error_message(String upiError) {
//		pom.getbBookHotelPage4().verifyUpiErrorMessage(upiError);
//	}
}
