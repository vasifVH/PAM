package BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class BaseClass {
    int count;
    WebDriverWait wait;
    WebDriver driver;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
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
            //System.out.println(element.getText());
            //System.out.println("sas");
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

    public boolean waitForElementToBeVisible(WebElement element , int seconds) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForElementsAttributeToChange(WebElement element, String attribute, String value) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForURL(String url , int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.urlContains(url));
    }

    public void waitForURLs(String url1, String url2, int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains(url1),
                ExpectedConditions.urlContains(url2)
        ));
    }

    public void dropDownSelectText(WebElement element, String option) {
        if (element == null) {
            System.out.println("Dropdown element is null.");
            return;
        }

        if (option == null || option.trim().isEmpty()) {
            System.out.println("Option value is null or empty.");
            return;
        }

        try {
            Select select = new Select(element);
            select.selectByVisibleText(option);
        } catch (NoSuchElementException e) {
            System.out.println("Option '" + option + "' not found in dropdown.");
        } catch (Exception e) {
            System.out.println("Error selecting value from dropdown: " + e.getMessage());
        }
    }

    public void dropDownSelectValue(WebElement element, String option) {
        if (element == null) {
            System.out.println("Dropdown element is null.");
            return;
        }

        if (option == null || option.trim().isEmpty()) {
            System.out.println("Option value is null or empty.");
            return;
        }

        try {
            Select select = new Select(element);
            select.selectByValue(option);
        } catch (NoSuchElementException e) {
            System.out.println("Option '" + option + "' not found in dropdown.");
        } catch (Exception e) {
            System.out.println("Error selecting value from dropdown: " + e.getMessage());
        }
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

    public boolean isElementsPresent(List<WebElement> element) {
        return !element.isEmpty();
    }

    public void clickWithfluentWait(WebElement element,int minutes, int pollingSeconds){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMinutes(minutes)) // Total wait time is 3 minutes
                .pollingEvery(Duration.ofSeconds(pollingSeconds)) // Check every 10 seconds
                .ignoring(NoSuchElementException.class);
        wait.until(driver -> element).click();
    }
    public void setCheckbox(WebElement checkboxElement, boolean shouldBeChecked) {
        if (checkboxElement != null && checkboxElement.isDisplayed()) {
            boolean isChecked = checkboxElement.isSelected();

            if (shouldBeChecked && !isChecked) {
                checkboxElement.click(); // Select if not already selected
            } else if (!shouldBeChecked && isChecked) {
                checkboxElement.click(); // Deselect if already selected
            }
        } else {
            System.out.println("Checkbox not found or not visible.");
        }
    }

}


