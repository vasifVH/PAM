package RunnerClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D:/Personal/Selenium/PAM_VASIF/source/PAM/pam360_7200_full_automation/src/test/resources/features/adduser.feature",
        glue = {"StepDefinitions","Hooks"},
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-html-report" , "json:cucumber.json"}
)
public class TestRunner {

}
