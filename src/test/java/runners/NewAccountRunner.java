package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		glue = "steps",
		tags = "@NewAccount",
		monochrome = true,
		dryRun = false,
		plugin = {
				"pretty",
				"html:target/cucumber/cucumber.html",
				"json:target/cucumber/cucumber.json"
		}
		
		)
public class NewAccountRunner {
	
}
