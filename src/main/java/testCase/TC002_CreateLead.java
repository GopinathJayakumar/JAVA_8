package testCase;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wrappers.ProjectMethods;

public class TC002_CreateLead extends ProjectMethods{
	
	
	@Test
	public void createLead() {	
		WebElement eleLead = locateElement("link", "Leads");
		click(eleLead);
		WebElement eleCreateLead = locateElement("link", "Create Lead");
		click(eleCreateLead);
		WebElement eleCName = locateElement("id", "createLeadForm_companyName");
		type(eleCName, "TestLeaf");
		WebElement eleFName = locateElement("id", "createLeadForm_firstName");
		type(eleFName, "Gopinath");
		WebElement eleLName = locateElement("id", "createLeadForm_lastName");
		type(eleLName, "Jayakumar");
		WebElement eleCLead = locateElement("name", "submitButton");
		click(eleCLead);
		closeBrowser();
		
		
	}

}
