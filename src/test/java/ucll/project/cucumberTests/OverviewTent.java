package ucll.project.cucumberTests;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = {"src/test/resources/OverviewTent.feature"},
                plugin = {"html:target/cucumber", "json:target/cucumber.json"}
        )
public class OverviewTent
{
}
