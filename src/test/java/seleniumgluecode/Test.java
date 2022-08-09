package seleniumgluecode;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.assignment.managers.ConfigReader;
import com.assignment.managers.PageManager;
import com.assignment.managers.Utilities;
import com.assignment.managers.WebdriverManager;
import com.assignment.pages.AlleCloudwisersPage;
import com.assignment.pages.HomePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test {
	
	WebDriver driver;
	HomePage hp;
	AlleCloudwisersPage acp;
	PageManager pm;
	ConfigReader cr;
	WebdriverManager wdm;
	Map<String,Integer> map;
	List<String> duplicates;
	static Scenario scenario;
	
	@Before
	public void setup(Scenario scenario)
	{
		cr = new ConfigReader();
		wdm = new WebdriverManager();
		driver= wdm.getDriver();
        pm = new PageManager(driver);
        Test.scenario = scenario;
		
	}
	
	@Given("user navigates to the alle cloudwisers page")
	public void user_navigates_to_the_alle_cloudwisers_page() {
	    // Write code here that turns the phrase above into concrete actions
		hp = pm.getHomePage();
		acp = pm.getAlleCloudWisersPage();
		
		hp.navigatetoURL(cr.getApplicationUrl());
		hp.navigateToDitIsCloudWise();
		hp.navigateToAlleCloudWisers();
		String header = acp.getHeaderText();
		Assert.assertTrue(header.equals("Alle Cloudwisers"));
		Test.scenario.log("User is on the Alle Cloudwise page");
	}
	
	
	@When("user views the names of all the members across all departments")
	public void user_views_the_names_of_all_the_members_across_all_departments() {
	    // Write code here that turns the phrase above into concrete actions
		acp = pm.getAlleCloudWisersPage();
		map=acp.getNameCounts();
		Test.scenario.log("User has visited all the "+acp.getDeptCount()+" departments and collected all the names");
		
	}
	
	@Then("user is able to find the duplicate names within cloudwise")
	public void user_is_able_to_find_the_duplicate_names_within_cloudwise() {
	    // Write code here that turns the phrase above into concrete actions
		duplicates = Utilities.getDuplicates(map);
		if(duplicates.size()==0)
			Test.scenario.log("There are no duplicate names across Cloudwise");
		else
		{
			Test.scenario.log("List of names which occur more than once across Cloudwise: ");
			for(String n:duplicates)
				Test.scenario.log(n+" ");
		}
		
	}
	
	
	@After
    public void close(Scenario scenario) {
		
		if(scenario.isFailed())
        {
        	byte[] screenshot=Utilities.takeScreenshot(driver, scenario);
        	scenario.attach(screenshot, "image/png", scenario.getName());
        }
        // Close the browser
		 wdm.closeDriver();
    }

}
