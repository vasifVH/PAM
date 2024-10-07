package BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static Hooks.Hooks.prop;

public class BaseClass {
    int count;
    WebDriverWait wait;
    WebDriver driver;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public WebElement multipleElements(List<WebElement> webElementsList, String option){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(webElementsList));
        for(WebElement element : webElementsList){
            if(element.getText().contains(option) )
                return element;
        }
        return null;
    }

    public WebElement multipleElementsWithoutWait(List<WebElement> webElementsList, String option){
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

    public String generateSecureRandomString(int length) {
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz234567";
        SecureRandom random = new SecureRandom();
        StringBuilder result = new StringBuilder();

        // Generate the random string
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowedChars.length());  // Pick a random index
            result.append(allowedChars.charAt(index));          // Append the random character
        }

        return result.toString();
    }

    public boolean isElementPresent(WebElement element, int seconds) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true; // Element is found
        } catch (Exception e) {
            System.out.println(e.toString());
            return false; // Timeout happened and element was not found
        }
    }

    public void clickWithfluentWait(WebElement element,int minutes, int pollingSeconds){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMinutes(minutes)) // Total wait time is 3 minutes
                .pollingEvery(Duration.ofSeconds(pollingSeconds)) // Check every 10 seconds
                .ignoring(NoSuchElementException.class);
        wait.until(driver -> element).click();
    }
}


