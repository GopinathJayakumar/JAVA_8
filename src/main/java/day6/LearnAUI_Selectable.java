package day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnAUI_Selectable {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		driver.get("http://jqueryui.com/selectable/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		
		WebElement li1 = driver.findElementByXPath("//ol[@id='selectable']/li[1]");
		WebElement li2 = driver.findElementByXPath("//ol[@id='selectable']/li[3]");
		WebElement li3 = driver.findElementByXPath("//ol[@id='selectable']/li[5]");
		WebElement li4 = driver.findElementByXPath("//ol[@id='selectable']/li[7]");
		
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).
		click(li1).
		click(li2).
		click(li3).
		click(li4).
		keyUp(Keys.CONTROL).perform();
				
		
		
	}

}
