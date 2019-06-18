package day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnAUI_dragdrop {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		driver.get("http://jqueryui.com/droppable/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		
		WebElement draggable = driver.findElementById("draggable");
		WebElement droppable = driver.findElementById("droppable");
		
		Actions builder =new Actions(driver);
		builder.dragAndDrop(draggable, droppable).perform();
				
		
		
	}

}
