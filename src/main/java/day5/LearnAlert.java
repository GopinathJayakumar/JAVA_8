package day5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlert {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");		
		driver.manage().window().maximize();
		
		driver.findElementByLinkText("AGENT LOGIN").click();
		
		driver.findElementById("loginbutton").click();
		
		Thread.sleep(2000);
		
		//for alert
		
		/*
		 * String text = driver.switchTo().alert().getText(); 
		 * System.out.println(text);
		 * driver.switchTo().alert().accept();
		 */
		/*
		 * Alert alt = driver.switchTo().alert(); System.out.println(alt.getText());
		 * alt.accept();
		 */
		
		driver.findElementById("usernameId").sendKeys("gggggggg");
		
	}

}
