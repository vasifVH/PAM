package utility;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class Hooks {

    public BrowserDriver driver;

    @Before
    public void setup(){
        driver = new BrowserDriver();
    }

    @After
    public void tearDown(){
        //driver.close();
    }

}
