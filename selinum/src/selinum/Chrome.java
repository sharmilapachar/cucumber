package selinum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Chrome {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		String expectedTitle = "Google";
		System.setProperty("webdriver.chrome.driver","C:\\Users\\prave\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver;
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		String actual = driver.getTitle();
		if(actual.equals(expectedTitle)){
			System.out.println("pass");
		}
		else
			System.out.println("fail");
	}

}
