package testCase;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wrappers.ProjectMethods;

public class TC001_FindLead extends ProjectMethods {

	@Test
	public void findLead() {
		WebElement eleLead = locateElement("link", "Leads");
		click(eleLead);
		WebElement eleCreateLead = locateElement("link", "Find Leads");
		click(eleCreateLead);
		
		WebElement eleFirstName = locateElement("xpath", "(//input[@name= 'firstName'])[3]");
		type(eleFirstName, "Gopi");
		
		WebElement eleFindLead = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLead);		
	}

}
