package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeMethods implements WdMethods{

	public RemoteWebDriver driver;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;
	int i =1;

	public SeMethods() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
	}
	
	public void startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("The browser:" + browser + " launched successfully");
		} catch (WebDriverException e){			
			System.out.println("The browser:" + browser + " could not be launched");
		}
		
	}


	public void startApp(String browser) {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./drivers/internetexplorerserver.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(sUrl);
			driver.manage().window().maximize();	
		
			System.out.println("The browser:" + browser + " launched successfully");
		} catch (WebDriverException e) {			
			System.out.println("The browser:" + browser + " could not be launched");
		}
	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator) {			
			case("id"): return driver.findElementById(locValue);
			case("link"): return driver.findElementByLinkText(locValue);
			case("xpath"):return driver.findElementByXPath(locValue);
			case("name"): return driver.findElementByName(locValue);
			case("className"): return driver.findElementByClassName(locValue);
			case("tag"):return driver.findElementByTagName(locValue);
			}
		} catch (NoSuchElementException e) {
			System.out.println("The element with locator "+locator+" and with value "+locValue+" not found.");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			System.out.println("WebDriverException");
		}
		return null;
	}
	
	public WebElement locateElement(String locValue) {
		return driver.findElementById(locValue);
	}


	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The data: "+data+" entered successfully");
		} catch (InvalidElementStateException e) {
			System.out.println("The data: "+data+" could not entered");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException"+e.getMessage());
		}
	}

	public void click(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));			
			text = ele.getText();
			ele.click();			
			System.out.println("The element : "+text+" is clicked successfully");
		} catch (InvalidElementStateException e) {
			System.out.println("The element: "+text+" could not clicked");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException"+e.getMessage());
		} 

	}

	public void clickWithNoSnap(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));	
			text = ele.getText();
			ele.click();
		System.out.println("The element : "+text+" is clicked successfully");
		} catch (InvalidElementStateException e) {
			System.out.println("The element: "+text+" could not clicked");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException"+e.getMessage());
		} 
	}

	public String getText(WebElement ele) {	
		String bReturn = "";
		try {
			bReturn = ele.getText();
		} catch (WebDriverException e) {
			System.out.println("WebDriverException"+e.getMessage());
		}
		return bReturn;
	}

	public String getTitle() {		
		String title = "";
		try {
			title =  driver.getTitle();
		} catch (WebDriverException e) {
			System.out.println("WebDriverException"+e.getMessage());
		} 
		return title;
	}

	public String getAttribute(WebElement ele, String attribute) {		
		String bReturn = "";
		try {
			bReturn=  ele.getAttribute(attribute);
		} catch (WebDriverException e) {
			System.out.println("WebDriverException"+e.getMessage());
		} 
		return bReturn;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			new Select(ele).selectByVisibleText(value);
			System.out.println("The dropdown is selected with text "+value);
		} catch (WebDriverException e) {
			System.out.println("WebDriverException"+e.getMessage());
		}

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			new Select(ele).selectByIndex(index);
			System.out.println("The dropdown is selected with index "+index);
		} catch (WebDriverException e) {
			System.out.println("WebDriverException"+e.getMessage());
		} 

	}

	public boolean verifyTitle(String expectedTitle) {
		boolean bReturn =false;
		try {
			if(getTitle().equals(expectedTitle)) {
				System.out.println("The expected title "+expectedTitle+" matches the actual "+getTitle());
				bReturn= true;
			}else {
				System.out.println(getTitle()+" The expected title "+expectedTitle+" doesn't matches the actual "+getTitle());
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		} 
		return bReturn;

	}

	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).equals(expectedText)) {
				System.out.println("The expected text matches the actual "+expectedText);
			}else {
				System.out.println("The expected text doesn't matches the actual "+expectedText);
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		} 

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).contains(expectedText)) {
				System.out.println("The expected text contains the actual "+expectedText);
			}else {
				System.out.println("The expected text doesn't contain the actual "+expectedText);
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		} 
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).equals(value)) {
				System.out.println("The expected attribute :"+attribute+" value matches the actual "+value);
			}else {
				System.out.println("The expected attribute :"+attribute+" value does not matches the actual "+value);
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		} 

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).contains(value)) {
				System.out.println("The expected attribute :"+attribute+" value contains the actual "+value);
			}else {
				System.out.println("The expected attribute :"+attribute+" value does not contains the actual "+value);
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}
	}

	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()) {
				System.out.println("The element "+ele+" is selected");
			} else {
				System.out.println("The element "+ele+" is not selected");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}
	}

	public void verifyDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()) {
				System.out.println("The element "+ele+" is visible");
			} else {
				System.out.println("The element "+ele+" is not visible");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		} 
	}

	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			List<String> allHandles = new ArrayList<String>();
			allHandles.addAll(allWindowHandles);
			driver.switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			System.out.println("The driver could not move to the given window by index "+index);
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}
	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			System.out.println("switch In to the Frame "+ele);
		} catch (NoSuchFrameException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		} 
	}

	public void acceptAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			System.out.println("The alert "+text+" is accepted.");
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}  
	}

	public void dismissAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			System.out.println("The alert "+text+" is dismissed.");
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		} 

	}

	public String getAlertText() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		} 
		return text;
	}

	public void takeSnap(){
		 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , 
					new File("./snaps/img"+i+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		i++;
		
	}

	public void closeBrowser() {
		try {
			driver.close();
			System.out.println("The browser is closed");
		} catch (Exception e) {
			System.out.println("The browser could not be closed");
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			System.out.println("The opened browsers are closed");
		} catch (Exception e) {
			System.out.println("The browsers could not be closed");
		}
	}



	


	

}
