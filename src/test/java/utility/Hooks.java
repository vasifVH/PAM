package utility;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

public class Hooks {

    public static BrowserDriver driver;

    @FindBy(xpath = "//button[@id='details-button']")
    static WebElement advancedButton;

    @FindBy(xpath = "//a[@id='proceed-link']")
    static WebElement unsafeButton;

    @Before
    public void setup(){
        driver = new BrowserDriver();
        advancedButton.click();
        unsafeButton.click();
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
