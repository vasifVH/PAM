package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//button[@id='details-button']")
    static WebElement advancedButton;

    @FindBy(xpath = "//a[@id='proceed-link']")
    static WebElement unsafeButton;

    @FindBy(xpath = "//input[@id = 'username']")
    static WebElement loginUserName;

    @FindBy(xpath = "//input[@id = 'password']")
    static WebElement loginPassword;

    @FindBy(xpath = "//em[text() = 'Login ']")
    static WebElement loginButton;

    public LoginPage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(this.driver, this);
    }

    public void webBrowserLogin(String username, String password) throws InterruptedException {

        advancedButton.click();
        unsafeButton.click();
        Thread.sleep(3000);
        loginUserName.sendKeys(username);
        loginPassword.sendKeys(password);
        loginButton.click();
    }
}
