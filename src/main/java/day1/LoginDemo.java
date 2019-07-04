package day1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginDemo {

	@Test
	@Parameters("url")	
	public void sample(String url) {
		//Launch the Browser		
		//ClassName obj =  new ClassName();
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();	
		//load the URL
		driver.get(url);
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
