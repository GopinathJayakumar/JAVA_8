package wrappers;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectMethods extends SeMethods{
	
	@BeforeMethod
	public void login() {
		startApp("chrome", "http://leaftaps.com/opentaps");		
		WebElement eleUname = locateElement("id", "username");		
		type(eleUname, "DemoSalesManager");	
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");		
		WebElement eleLogin = locateElement("className", "decorativeSubmit");
		click(eleLogin);
		WebElement eleCrmsfa = locateElement("link", "CRM/SFA");
		click(eleCrmsfa);
	}
	
	@AfterMethod
	public void closeApp() {
		closeBrowser();
	}

}
