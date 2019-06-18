package day6;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindows {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");		
		driver.manage().window().maximize();
		driver.findElementByLinkText("AGENT LOGIN").click();
		
		driver.findElementByLinkText("Contact Us").click();
		
		//Collection Framework:- List - Set - Map
		
		//List -> Its allows Duplicates - [Gopi, Babu, Gopi] - getOptions
		//Set  -> its does nt allow Dup - [win1, win2, win3....]
		
		
	//	String firstWindow = driver.getWindowHandle();
		System.out.println(driver.getTitle());
		
		
		Set<String> allWin = driver.getWindowHandles();		
		for (String eachWin : allWin) {
			driver.switchTo().window(eachWin);
		}
		
		System.out.println(driver.getTitle());
		
		
		int i =0;
		Set<String> allWin1 = driver.getWindowHandles();		
		for (String eachWin : allWin1) {
			driver.switchTo().window(eachWin);
			i++;
			if(i==3) {
				break;
			}
		}
		
		
		
		
		
		
		
		
		
	}
	

}
