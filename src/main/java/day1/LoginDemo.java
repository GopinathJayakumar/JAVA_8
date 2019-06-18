package day1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemo {

	public static void main(String[] args) {
		
		//Launch the Browser		
		//ClassName obj =  new ClassName();
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium_Online\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();	
		
		//load the URL
		driver.get("http://leaftaps.com/opentaps");
		
		//Maximize
		driver.manage().window().maximize();
		
		
		//Enter the UserName
		driver.findElementById("username").sendKeys("DemoSalesManager", Keys.ENTER);	
		
		
		//Enter the Password
		driver.findElementById("password").sendKeys("crmsfa");
		
		
		//Click the LoginButton
		driver.findElementByClassName("decorativeSubmit").click();
		
		
		//close browser
		driver.close();
		

	}

}
