package com.datadriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Admin_Demo {
	WebDriver driver;
	
	@Test(dataProvider="loginData",dataProviderClass=ExcelData.class)
	public void testLogin(String user,String pwd) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\arulv\\eclipse-workspace\\project\\drtiver\\chromedriver.exe" );
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://admin-demo.nopcommerce.com/login");
		WebElement txtEmail=driver.findElement(By.id("Email"));
		txtEmail.clear();
		txtEmail.sendKeys(user);
	WebElement passwrd=driver.findElement(By.id("Password"));
	passwrd.clear();
	passwrd.sendKeys(pwd);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
Assert.assertTrue(driver.findElement(By.linkText("Dashboard")).isDisplayed());
Thread.sleep(2000);
driver.quit();
	}

}
