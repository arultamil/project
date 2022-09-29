package com.youtube;

import java.awt.Window;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YouTube {
	public static void main(String[]args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\arulv\\eclipse-workspace\\project\\drtiver\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.findElement(By.xpath("(//yt-chip-cloud-chip-renderer[@role='tab'])[2]")).click();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)","");
//		WebElement search=driver.findElement(By.xpath("//input[@id='search']"));
		//js.executeScript("arguments[0].value='tamil';",search);
	List<WebElement> link=driver.findElements(By.tagName("a"));
	System.out.println("The Total Link in the Web Page is"+link.size());
	for(int i=0;i<link.size();i++) {
WebElement element=		link.get(i);
//System.out.println("The Total Element in The WebPage is"+element);
String url=element.getAttribute("href");
//System.out.println(url);
URL link1 =new URL(url);
HttpURLConnection httpurl=(HttpURLConnection)link1.openConnection();
Thread.sleep(3000);
httpurl.connect();
int responsecode=httpurl.getResponseCode();
if(responsecode>=400) {
	System.out.println(url+"-"+"link is invalid");
}
else {
	System.out.println(url+"-"+"link is valid");
}
	}
	}

}
