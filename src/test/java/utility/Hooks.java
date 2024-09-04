package utility;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    public static BrowserDriver driver;

    public static ChromeOptions options;

    @Before
    public void setup(){
        driver = new BrowserDriver();
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
