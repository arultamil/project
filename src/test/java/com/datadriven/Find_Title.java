package com.datadriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Find_Title {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\arulv\\eclipse-workspace\\project\\drtiver\\chromedriver.exe" );
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login");
////		WebElement txtEmail=driver.findElement(By.id("Email"));
//		//txtEmail.clear();
//		txtEmail.sendKeys("admin@youstore.com");
//	WebElement passwrd=driver.findElement(By.id("Password"));
//	//passwrd.clear();
//	passwrd.sendKeys("admin");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(2000);
String actual_title=driver.getTitle();
System.out.println("Title of the WebPage is"+actual_title);
WebElement dashboard = driver.findElement(By.linkText("Dashboard"));
dashboard.click();
	}

}
