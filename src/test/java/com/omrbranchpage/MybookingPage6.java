package com.omrbranchpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MybookingPage6 {
	


	By searchBox = By.xpath("//input[@name='search']");
	
	By alertMsg = By.xpath("//li[@class='alertMsg']");
	
	By hotelPriceElement = By.xpath("//strong[contains(@class,'total-prize')]");
	
	By btnEdit = By.xpath("//button[text()='Edit'])[1]");
	
	By checkInInput = By.xpath("//input[@name='check_in']");
	
	By checkOutInput = By.xpath("//input[@name='check_out']");
	
	By confirmBtn = By.xpath("//button[text()='Confirm']");
	
	By hotelNameLink = By.xpath("btnEditForCancel");
	
	By btnEditForCancel = By.xpath("//button[text()='Edit'])[1]");
	
	By cancelBtn = By.xpath("//a[text()='Cancel'][1]");
	
	By cancelledStatusBtn = By.xpath("//button[contains(text(),'Cancelled')]");
	
//	
//    @FindBy(xpath = "//input[@name='search']")
//    private WebElement searchBox;
//
//    @FindBy(xpath = "//li[@class='alertMsg']")
//    private WebElement alertMsg;
//
//    @FindBy(xpath = "//strong[contains(@class,'total-prize')]")
//    private WebElement hotelPriceElement;
//
//    @FindBy(xpath = "(//button[text()='Edit'])[1]")
//    private WebElement btnEdit;
//
//    @FindBy(name = "check_in")
//    private WebElement checkInInput;
//
//    @FindBy(name = "check_out")
//    private WebElement checkOutInput;
//
//    @FindBy(xpath = "//button[text()='Confirm']")
//    private WebElement confirmBtn;
//
//    @FindBy(xpath = "//a/h5")
//    private WebElement hotelNameLink;
//
//    @FindBy(xpath = "(//button[text()='Edit'])[1]")
//    private WebElement btnEditForCancel;
//
//    @FindBy(xpath = "//a[text()='Cancel'][1]")
//    private WebElement cancelBtn;
//
//    @FindBy(xpath = "//button[contains(text(),'Cancelled')]")
//    private WebElement cancelledStatusBtn;

}
