package day6;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnTable_MultipleElement {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		driver.get("https://erail.in");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys("MSB", Keys.TAB);
		
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("SBC", Keys.TAB);
		
		//for table rows
		WebElement table = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']");
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		System.out.println("Rows count " + allRows.size());
		
		//for first row columns
		WebElement firstRow = allRows.get(0);
		List<WebElement> allColumn = firstRow.findElements(By.tagName("td"));
		System.out.println("First Row Column Count "+ allColumn.size());
		
		WebElement secColumn = allColumn.get(1);		
		System.out.println(secColumn.getText());
		
	}

}
