package com.steps1;


	

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.When;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class SalesforceStepDefinition {

		WebDriver driver;

	@Given("user go to the {string}")
	public void user_go_to_the(String url) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		Thread.sleep(5000);
	    //throw new io.cucumber.java.PendingException();
	}
	@When("user enter user {string} in  Username field")
	public void user_enter_user_in_username_field(String username) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		By locator = By.id("username");
		WebElement username1 = driver.findElement(locator);
	username1.sendKeys(username);
	}

	@When("user enter {string} in password field")
	public void user_enter_in_password_field(String password) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		By locator1 = By.id("password");
		 WebElement password1 = driver.findElement(locator1);
		// clearElement(username1,"password");
		password1.sendKeys(password);
	    
	}


	
	

	@When("user click on login button.")
	public void user_click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("Login")).click();
	   // throw new io.cucumber.java.PendingException();
	}
	}


