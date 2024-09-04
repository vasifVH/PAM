package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = "D:/Personal/Selenium/PamNew/src/test/java/features/adduser.feature",
        glue = {"StepDefinitions", "utility"},
        plugin = {"pretty", "html:target/cucumber-html-report" , "json:cucumber.json"}

)

public class TestRunner {

}
