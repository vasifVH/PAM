package BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseFunctionsClass {
    int count;
    WebDriverWait wait;
    WebDriver driver;

    public BaseFunctionsClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public WebElement multipleElements(List<WebElement> webElementsList, String option){
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfAllElements(webElementsList));
        for(WebElement element : webElementsList){
            if(element.getText().contains(option) )
                return element;
        }
        return null;
    }

    public int getOptionCount(List<WebElement> webElementsList, String option){
        count = 0;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfAllElements(webElementsList));
        for(WebElement element : webElementsList){
            count++;
            if(element.getText().contains(option) )
                return count;
        }
        return count;
    }

    public boolean waitForElement(WebElement element , int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void waitForElements(List<WebElement> element , int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public boolean waitForElementToBeClickable(WebElement element , int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element.isEnabled();
    }

    public boolean isDisplayed(WebElement element , int seconds){
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element.isDisplayed();
    }
}
