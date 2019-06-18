package day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnAUI_MouseHover {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		driver.get("https://www.flipkart.com/");			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		
		// driver.getKeyboard().sendKeys(Keys.ESCAPE);
		 driver.findElementByXPath("//button[text()='✕']").click();
		
		
		
		WebElement ele = driver.findElementByXPath("//span[text()='Electronics']");
		
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();
		
		Thread.sleep(2000);
		
		driver.findElementByLinkText("Apple").click();
		
		
	
				
		
		
	}

}
