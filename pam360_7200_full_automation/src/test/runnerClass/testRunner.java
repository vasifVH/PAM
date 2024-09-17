package test.runnerClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D:/IntelliJ/PamProject/pamautomation/src/test/resources/features/adduser.feature",
        glue ={"test.StepDefinitions","test.Hooks"},
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-html-report" , "json:cucumber.json"}

)
public class testRunner {

}
