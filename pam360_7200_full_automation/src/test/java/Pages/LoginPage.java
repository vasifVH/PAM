package Pages;

import BasePackage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Hooks.Hooks.prop;

public class LoginPage {
    WebDriver driver;
    BaseClass base;

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

    @FindBy(xpath = "//a[text() = 'Logout']")
    static WebElement logoutButton;

    @FindBy(xpath = "//li[@id = 'usacc_id_span']")
    static WebElement userAccount;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.base = new BaseClass(this.driver);
    }

    public void webBrowserLogin() throws InterruptedException {
        base.waitForElement(loginUserName,10);
        loginUserName.sendKeys(prop.getProperty("username"));
        loginPassword.sendKeys(prop.getProperty("password"));
        loginButton.click();
    }

    public void webBrowserLogin(String username, String password) throws InterruptedException {
        base.waitForElement(loginUserName,10);
        loginUserName.sendKeys(username);
        loginPassword.sendKeys(password);
        loginButton.click();
    }

    public void webBrowserLogout() throws InterruptedException {
        base.waitForElement(userAccount,10);
        userAccount.click();
        logoutButton.click();
    }
}
