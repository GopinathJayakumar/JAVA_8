package day5;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFrames {
	
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		driver.get("http://jqueryui.com/selectable/");		
		driver.manage().window().maximize();
		
		//switch to frame
		WebElement frm = driver.findElementByClassName("demo-frame");		
		driver.switchTo().frame(frm);	
		
		driver.findElementByXPath("//ol[@id='selectable']/li[1]").click();
		
		//come out to the frame
		driver.switchTo().defaultContent();
		
		driver.findElementByLinkText("Download").click();
		
		//snapshot
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/img.png");		
		FileUtils.copyFile(src, desc);
		
	}

}
