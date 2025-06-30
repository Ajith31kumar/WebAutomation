package com.pom;

import org.openqa.selenium.WebDriver;

import com.omrbranchpage.BookHotelPage4;
import com.omrbranchpage.ExploreHotelPage2;
import com.omrbranchpage.LoginPage1;
import com.omrbranchpage.SelectHotelPage3;

public class PageObjectManager {

	private WebDriver driver;
	private LoginPage1 loginPage;
	private ExploreHotelPage2 exploreHotelPage;
	private SelectHotelPage3 selectHotelPage;
	private BookHotelPage4 bookHotelPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage1 getLoginPage() {
	    return (loginPage == null) ? loginPage = new LoginPage1(driver) : loginPage;
	}
	
	public ExploreHotelPage2 getexploreHotelPage() {
		return ( exploreHotelPage == null) ? exploreHotelPage = new ExploreHotelPage2() : exploreHotelPage;
	}
	
	public SelectHotelPage3 getSelectHotelPage3() {
	    return (selectHotelPage == null) ? selectHotelPage = new SelectHotelPage3() : selectHotelPage;
	}

	public  BookHotelPage4 getbBookHotelPage4() {
		return(bookHotelPage == null)? bookHotelPage = new BookHotelPage4(driver):bookHotelPage;
	}

}
