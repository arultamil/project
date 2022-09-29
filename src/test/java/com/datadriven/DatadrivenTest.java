package com.datadriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DatadrivenTest {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\arulv\\eclipse-workspace\\project\\drtiver\\chromedriver.exe" );
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@Test(dataProvider="logindata")
	public void loginTest(String user,String pwd,String exp) {
		driver.get("https://admin-demo.nopcommerce.com/login");
		WebElement txtEmail=driver.findElement(By.id("Email"));
		txtEmail.clear();
		txtEmail.sendKeys(user);
	WebElement passwrd=driver.findElement(By.id("Password"));
	passwrd.clear();
	passwrd.sendKeys(pwd);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	String exp_title="Dashboard / nopCommerce administration";
	String act_title=driver.getTitle();
//System.out.println("actual title is"+act_title);
	
	if(exp.equals("valid")) {
		if(exp_title. equals(act_title)) {
			driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();
			Assert.assertTrue(true);
			
		}
		else {
			Assert.assertTrue(false);
		}
	}
	else if(exp.equals("invalid")) {
		if(exp_title.equals(act_title)) {
			driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();
			Assert.assertTrue(false);
		}
		else{
			Assert.assertTrue(true);
			
		}
		
	}
		
		
	}
	@DataProvider(name="logindata")
	public Object[][] getdata(){
		Object logindata[][]= {
				{"admin@yourstore.com","admin","valid"},
				{"admin@youstore.com","admi","invalid"},
				{"am@youstore.com","admi","invalid"},
				{"admin@youstrore.com","adm","invalid"}

		
	};
		return logindata;

}
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}