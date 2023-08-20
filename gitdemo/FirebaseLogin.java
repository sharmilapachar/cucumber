package com.firebase.common.tests;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirebaseLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\prave\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver;

		driver = new ChromeDriver();
		driver.get("https://qa-tekarch.firebaseapp.com/"); 
		By locator = By.id("email_field");
		WebElement username = driver.findElement(locator);
username.sendKeys("admin123@gmail.com");
 By locator1 = By.id("password_field");
 WebElement username1 = driver.findElement(locator1);
username1.sendKeys("admin123");
driver.findElement(By.tagName("button")).click();
Thread.sleep(8000);
driver.findElement(By.id("name")).sendKeys("sharmila");
driver.findElement(By.id("lname")).sendKeys("Praveen");


driver.findElement(By.id("postaladdress")).sendKeys("112 nautique drive");
driver.findElement(By.xpath("//*[@id=\'radiobut' and @value='female']")).click();
Select  city=new Select(driver.findElement(By.xpath("//select[@id='city']")));
city.selectByVisibleText("GOA");
//WebElement city = driver.findElement(By.xpath("//select[@id='city']"));
//Select ob= new Select(city);
//ob.selectByVisibleText("GOA");
WebElement Course = driver.findElement(By.xpath("//select[@id='course']"));
Select ob1= new Select(Course);
ob1.selectByVisibleText("MCA");
Thread.sleep(5000);


	}

}
