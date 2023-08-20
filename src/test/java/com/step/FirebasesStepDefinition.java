package com.step;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirebasesStepDefinition {
	WebDriver driver;

	@Given("user go to {string}")
	public void user_go_to(String url) {
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\prave\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}

	@When("user enters {string} in username field")
	public void user_enters_in_username_field(String userName) throws InterruptedException {
		Thread.sleep(5000);
	By locator = By.id("email_field");
	WebElement username = driver.findElement(locator);
username.sendKeys(userName);}
	
	@When("{string} in password field")
	public void in_password_field(String password) {
		By locator1 = By.id("password_field");
		 WebElement username1 = driver.findElement(locator1);
		username1.sendKeys(password);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		driver.findElement(By.tagName("button")).click();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expectedTitle);
	    
	}
	
}
