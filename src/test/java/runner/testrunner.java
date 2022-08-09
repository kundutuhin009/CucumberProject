package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/", glue = { "seleniumgluecode" },
plugin = { "pretty", "html:target/htmlreports/report.html"})

public class testrunner {
	
	@AfterClass
	public static void writeExtentReport() {
		
	}

}
