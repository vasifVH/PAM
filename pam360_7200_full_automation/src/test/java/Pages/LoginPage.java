package Pages;

import BasePackage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(xpath = "//select[@id = 'pmp_domainName']")
    static WebElement domainName;

    @FindBy(xpath = "//label[text() = 'Log on to']")
    static List<WebElement> logOnTo;

    @FindBy(xpath = "//em[text() = 'Login ']")
    static WebElement loginButton;

    @FindBy(xpath = "//form[@id = 'PasswordChangeForm']")
    static WebElement passChangePage;

    @FindBy(xpath = "//input[@id = 'OLDPASSWORD']")
    static WebElement oldPassword;

    @FindBy(xpath = "//input[@id = 'NEWPASSWORD']")
    static WebElement newPassword;

    @FindBy(xpath = "//input[@id = 'NEWUSLOGINCP']")
    static WebElement confirmPassword;

    @FindBy(xpath = "//em[text() = 'Save']")
    static WebElement passSaveButton;

    @FindBy(xpath = "//a[@onclick = 'SessionLogOut();']")
    static WebElement logoutButton;

    @FindBy(xpath = "//a[@id = 'usacc_id']")
    static WebElement userAccount;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.base = new BaseClass(this.driver);
    }

    public void webBrowserLogin() throws InterruptedException {
        base.waitForElementToBeVisible(loginUserName, 10);
        loginUserName.sendKeys(prop.getProperty("username"));
        loginPassword.sendKeys(prop.getProperty("password"));
//        if (base.isElementPresent(logOnTo)) {
//            base.dropDownSelectText(domainName, "Local Authentication");
//        }
        loginButton.click();
        //System.out.println("Test click");
//        base.waitForURLs("PasswordFullView/PasswordMainView","ChangeLoginPassword.cc",10);
//        if(passChangePage.isDisplayed()){
//            oldPassword.sendKeys(prop.getProperty("userName"));
//            newPassword.sendKeys(prop.getProperty("userPassword"));
//            confirmPassword.sendKeys(prop.getProperty("userPassword"));
//            passSaveButton.click();
//        }
    }

    public void webBrowserLogin(String username, String password, String domainName) throws InterruptedException {
        base.waitForElementToBeVisible(loginUserName, 10);
        loginUserName.sendKeys(username);
        loginPassword.sendKeys(password);
        if (base.isElementsPresent(logOnTo)) {
            base.dropDownSelectText(LoginPage.domainName, domainName);
        }
        loginButton.click();
    }
    public void setupLogin() throws InterruptedException {
        base.waitForElementToBeVisible(loginUserName, 10);
        loginUserName.sendKeys("admin");
        loginPassword.sendKeys("admin");
        loginButton.click();
        base.waitForURLs("PasswordFullView/PasswordMainView","ChangeLoginPassword.cc",10);
        if(passChangePage.isDisplayed()){
            oldPassword.sendKeys("admin");
            newPassword.sendKeys("Test@123");
            confirmPassword.sendKeys("Test@123");
            passSaveButton.click();
        }
    }

    public void webBrowserLogout() throws InterruptedException {
        Thread.sleep(2000);
        base.waitForElementToBeVisible(userAccount, 10);
        userAccount.click();
        base.waitForElementToBeVisible(logoutButton,10);
        logoutButton.click();
    }
}
