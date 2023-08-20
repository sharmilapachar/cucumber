package com.sl;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
	import io.cucumber.java.en.When;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class jav {
		WebDriver driver;
		
			@Given("user go to {string} on google page")
			public void user_go_to(String url) throws InterruptedException {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.get(url);
			Thread.sleep(5000);}
		
		@When("user enters {string} in search field")
		public void user_enters_in_search_field(String search) {
			WebElement search1=driver.findElement(By.className("gLFyf"));
			search1.click();
			search1.sendKeys(search);
		}

	}





