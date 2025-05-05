package RunnerClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D:/Selenium/PAM_Resource_Group_Branch/source/PAM/pam360_7200_full_automation/src/test/resources/features/trial.feature",
        glue = {"StepDefinitions","Hooks"},
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-html-report" , "json:cucumber.json"}
)
public class TestRunner {

}
