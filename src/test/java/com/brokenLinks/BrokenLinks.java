package com.brokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	
	public static void checkUrl(String href) throws URISyntaxException, IOException {
		
		   URL url = new URI(href).toURL();
		URLConnection openconnection = url.openConnection();
		HttpURLConnection httpURLConnection = (HttpURLConnection) openconnection;
		httpURLConnection.setRequestMethod("HEAD");
		httpURLConnection.connect();
		
		int responseCode = httpURLConnection.getResponseCode();
		if(responseCode >= 400) {
			System.out.println("URL" + href + "- with error code" + responseCode);
		}else {
			System.out.println("URL" + href + "- with success code"+responseCode);
		}
		
		
	}
	
	
	public static void main(String[] args) throws URISyntaxException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		System.out.println("====== check Anchor tag url =====");
		
		List<WebElement> alinks = driver.findElements(By.tagName("a"));
		for(WebElement ele :alinks) {
			@Nullable
			String domProperty = ele.getDomProperty("href");
//			checkUrl(domProperty);
			if(domProperty.trim().length()>= 1) {
				checkUrl(domProperty);
			}
		}
		
		System.out.println("========= checkimagerl====");
		
		List<WebElement> imagelinks =driver.findElements(By.tagName("img"));
		for (WebElement imagel : imagelinks) {
			@Nullable
			String domProperty = imagel.getDomProperty("src");
//			checkUrl(domProperty);
			if(domProperty.trim().length()>= 1) {
				checkUrl(domProperty);
			}
			
			
		}
		driver.quit();
	}
	

}
