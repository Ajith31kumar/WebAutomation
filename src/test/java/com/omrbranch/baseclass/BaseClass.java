package com.omrbranch.baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriverWait wait;

	Actions actions;
	Alert alert;
	JavascriptExecutor executor;
	TakesScreenshot takesScreenshot;
	Select select;
	
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
    
	 public void acceptAlert() {
	        alert = driver.switchTo().alert();
	        alert.accept();
	    }


    public void switchToContext(String view) {
        AndroidDriver androidDriver = (AndroidDriver) driver;
        androidDriver.context(view);
    }

    public void enterApplnUrl(String url) {
        driver.get(url);
    }

    public List<String> getAllOptions(WebElement element) {
        List<String> allOptionsText = new ArrayList<>();
        select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement webElement : options) {
            allOptionsText.add(webElement.getText());
        }
        return allOptionsText;
    }

    public void selectOptionByText(WebElement element, String text) {
        select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectOptionByIndex(WebElement element, int index) {
        select = new Select(element);
        select.selectByIndex(index);
    }

    public void selectOptionByValue(WebElement element, String text) {
        select = new Select(element);
        select.selectByValue(text);
    }
    public WebElement waitForElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void scroll(WebElement element) {
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView()", element);
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

   

    public void dragAndDrop(WebElement source, WebElement dest) {
        actions = new Actions(driver);
        actions.dragAndDrop(source, dest).perform();
    }

    public void screenshot(WebElement element, String fileName) throws IOException {
        File screenshotAs = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotAs, new File("H:\\OMRBranchHotelAutomation_Ajith\\target" + fileName + ".png"));
    }

    public void screenshot(String fileName) throws IOException {
        takesScreenshot = (TakesScreenshot) driver;
        File screenshotAs = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotAs, new File("H:\\OMRBranchHotelAutomation_Ajith\\target" + fileName + ".png"));
    }

    public void switchToChildWindow() {
        String windowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String eachWindowId : windowHandles) {
            if (!windowHandle.equals(eachWindowId)) {
                driver.switchTo().window(eachWindowId);
            }
        }
    }
    

    public boolean elementIsEnabled(WebElement element) {
        return element.isEnabled();
    }

    public boolean elementIsDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void visibilityOfElement(WebElement element) {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driverWait.until(ExpectedConditions.visibilityOf(element));
    }

    
    public String elementGetText(WebElement element) {
        return element.getText();
    }

    public List<WebElement> findLocatorsBy(By by) {
        return driver.findElements(by);
    }

    public WebElement findLocatorBy(By by) {
        return driver.findElement(by);
    }

    public void swipeToElement(By by) {
        implicitWait(5);
        List<WebElement> elements = findLocatorsBy(by);
        while (elements.size() == 0) {
            swipe();
            elements = findLocatorsBy(by);
        }
        implicitWait();
    }
    public void selectDropdownByVisibleText(By locator, String visibleText) {
        WebElement dropdown = findElementBy(locator);
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }
    
    public void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    
    public WebElement waitVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    
//    public void selectFromDropdown(By dropdownLocator, String optionText) throws InterruptedException {
//        tapByTouch(dropdownLocator);
//        Thread.sleep(1000); // wait for dropdown options to appear
//        By optionLocator = By.xpath("//android.widget.TextView[@text='" + optionText + "']");
//        tapByTouch(optionLocator);
//        Thread.sleep(1000);
//    }

    public void switchToFrameByElement(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }
    
    

    public void swipe() {
        Dimension size = driver.manage().window().getSize();
        int width = size.getWidth();
        int height = size.getHeight();
        int centerX = width / 2;
        int startY = (int) (height * 0.80);
        int endY = (int) (height * 0.20);

        PointerInput pointerInput = new PointerInput(Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(pointerInput, 1);

        sequence.addAction(pointerInput.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), centerX, startY));
        sequence.addAction(pointerInput.createPointerDown(MouseButton.LEFT.asArg()));
        sequence.addAction(pointerInput.createPointerMove(Duration.ofSeconds(1), Origin.viewport(), centerX, endY));
        sequence.addAction(pointerInput.createPointerUp(MouseButton.LEFT.asArg()));

        List<Sequence> asList = Arrays.asList(sequence);
        ((RemoteWebDriver) driver).perform(asList);
    }

    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    public WebElement waitForVisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void implicitWait(int secs) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public void elementSendKeys(WebElement element, String data) {
        visibilityOfElement(element);
        if (elementIsDisplayed(element) && elementIsEnabled(element)) {
            element.sendKeys(data);
        }
    }

    public String getApplnUrl() {
        return driver.getCurrentUrl();
    }

    public String getDomProperty(WebElement element) {
        visibilityOfElement(element);
        return element.getDomProperty("value");
    }

    public String getDomProperty(WebElement element, String attributeName) {
        visibilityOfElement(element);
        return element.getDomProperty(attributeName);
    }

    public void closeWindow() {
        driver.quit();
    }

    public void elementSendKeysEnter(WebElement element, String data) {
        visibilityOfElement(element);
        if (elementIsDisplayed(element) && elementIsEnabled(element)) {
            element.sendKeys(data, Keys.ENTER);
        }
    }

    public void elementSendKeysJs(WebElement element, String data) {
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
    }

    public void elementClick(WebElement element) {
        visibilityOfElement(element);
        if (elementIsDisplayed(element) && elementIsEnabled(element)) {
            element.click();
        }
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void appLaunch(String deviceName, String platformName, String platformVersion, String appPackage, String appActivity, String automationName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", deviceName);
        capabilities.setCapability("appium:platformName", platformName);
        capabilities.setCapability("appium:platformVersion", platformVersion);
        capabilities.setCapability("appium:appPackage", appPackage);
        capabilities.setCapability("appium:appActivity", appActivity);
        capabilities.setCapability("appium:automationName", automationName);
        driver = new AndroidDriver(capabilities);
    }

    public void mobileBrowserLaunch(String deviceName, String platformName, String platformVersion, String browserName, String automationName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", deviceName);
        capabilities.setCapability("appium:platformName", platformName);
        capabilities.setCapability("appium:platformVersion", platformVersion);
        capabilities.setCapability("appium:browserName", browserName);
        capabilities.setCapability("appium:automationName", automationName);
        driver = new AndroidDriver(capabilities);
    }

    public WebElement findElementBy(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElementsBy(By by) {
        return driver.findElements(by);
    }

    public WebElement elementlocatedByXpath(String data) {
        return driver.findElement(By.xpath(data));
    }
//
//    public void selectDropdownByVisibleText(By locator, String visibleText) {
//        WebElement dropdown = findElementBy(locator);
//        Select select = new Select(dropdown);
//        select.selectByVisibleText(visibleText);
//    }

    public void elementSendKeys(By locator, String text) {
        WebElement element = findElementBy(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void elementClick(By locator) {
        WebElement element = findElementBy(locator);
        elementClick(element);
    }

    public void waitForElementVisible(By locator, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public void browserLaunch() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    }

    public static void enterApplUrl(String url) {
        driver.get(url);
    }

    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

 

 

    public static void closeBrowser() {
        driver.quit();
    }
}
