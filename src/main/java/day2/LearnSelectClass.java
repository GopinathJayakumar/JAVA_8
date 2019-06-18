package day2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnSelectClass {

	public static void main(String[] args) {
		
		String txt = "Testleaf";
		
		int i = 10;
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium_Online\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();	
		
		//load the URL
		driver.get("http://leaftaps.com/opentaps");
		
		//Maximize
		driver.manage().window().maximize();
		
		
		//Enter the UserName
		driver.findElementById("username").sendKeys("DemoSalesManager");	
		
		
		//Enter the Password
		driver.findElementById("password").sendKeys("crmsfa");
		
		
		//Click the LoginButton
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByLinkText("CRM/SFA").click();
		
		driver.findElementByLinkText("Create Lead").click();
		
		
		
		//for Dropdown		
		WebElement source = driver.findElementById("createLeadForm_dataSourceId");			
		
		Select dd = new Select(source);		
		//Way 1:- using Visible text
		dd.selectByVisibleText("Employee");
		
		// Way 2:- using Value attribute text
		// dd.selectByValue("LEAD_WEBSITE");
		
		// Way 3:- using index number
		// dd.selectByIndex(6);
		
		
		
		//Collection -> list, set, map		
		List<WebElement> allOptions = dd.getOptions();		
		System.out.println(allOptions.size());
		
		
		
		
		
		
		
		
		
		

	}

}













