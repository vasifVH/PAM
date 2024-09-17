package test.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.Hooks.hooks;

public class Users  {
    WebDriver ldriver;

    @FindBy(xpath = "//span[text() = 'Users']")
    static WebElement usersTab;

    @FindBy(xpath = "//div[text() = 'Add User']")
    static WebElement addUserDropdown;

    @FindBy(xpath = "//div[text() = 'Add User']/following-sibling::div/child::ul/li/a[text() = 'Add User']")
    static WebElement addUser;

    @FindBy(xpath = "//div[text() = 'Add User']/following-sibling::div/child::ul/li/a[text() = 'Import From Active Directory']")
    static WebElement addUserFromAD;

    @FindBy(xpath = "//input[@name = 'fname']")
    static WebElement userFirstName;

    @FindBy(xpath = "//input[@name = 'lname']")
    static WebElement userLastName;

    @FindBy(xpath = "//input[@name = 'user']")
    static WebElement userUserName;

    @FindBy(xpath = "//input[@name = 'mail']")
    static WebElement userEmail;

    @FindBy(xpath = "//select[@name = 'role']")
    static WebElement userRole;

    @FindBy(xpath = "//option[text() = 'Password User']")
    static WebElement userRolePasswordUser;

    @FindBy(xpath = "//select[@name = 'superAdmin']")
    static WebElement userScope;

    @FindBy(xpath = "//option[text() = 'Passwords Owned and Shared']")
    static WebElement userScopePasswordsOwnedAndShared;

    @FindBy(xpath = "//select[@name = 'rbutton']")
    static WebElement userPasswordSetup;

    @FindBy(xpath = "//option[text() = 'Username as a Password']")
    static WebElement userPasswordSetupUsernameAsAPassword;

    @FindBy(xpath = "//em[text()= 'Save']")
    static WebElement userSaveButton;

    @FindBy(xpath = "//span[text() = 'New Domain']")
    static WebElement adNewDomainButton;

    @FindBy(xpath = "//input[@id = 'NEW_DOMAIN']")
    static WebElement adNewDomainTextBox;

    @FindBy(xpath = "//span[text() = 'Add']")
    static WebElement adAddButton;

    @FindBy(xpath = "//input[@name= 'DCNAME']")
    static WebElement adPrimaryDomainControllerTextBox;

    @FindBy(xpath = "//label[text() = 'Specify Username and Password Manually']")
    static WebElement adSpecifyUsernameAndPasswordManuallyRadioButton;

    @FindBy(xpath = "//input[@name = 'LOGINNAME']")
    static WebElement adUserName;

    @FindBy(xpath = "//input[@name = 'PASSWORD']")
    static WebElement adPassword;

    @FindBy(xpath = "//select[@name = 'ROLEID']")
    static WebElement adRoleID;

    @FindBy(xpath = "//option[text() = 'Password User']")
    static WebElement adRoleIDPasswordUser;

    @FindBy(xpath = "//input[@name = 'OU_']")
    static WebElement adOUsToImport;

    @FindBy(xpath = "//em[text()= 'Import']")
    static WebElement adImportButton;

    @FindBy(xpath = "//div[@id ='importFromADUsersClose']/button/span/em[text()= 'Close']")
    static WebElement adAfterUserImportCloseButton;

    public Users(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    public void addUserManually() throws InterruptedException {

        Thread.sleep(5000);
        usersTab.click();
        Thread.sleep(2000);
        addUserDropdown.click();
        addUser.click();
        Thread.sleep(2000);
        userFirstName.sendKeys("user");
        userLastName.sendKeys("1");
        userUserName.sendKeys("user1");
        userEmail.sendKeys("user1@gmail.com");
        userRole.click();
        userRolePasswordUser.click();
        userScope.click();
        userScopePasswordsOwnedAndShared.click();
        userPasswordSetup.click();
        userPasswordSetupUsernameAsAPassword.click();
        userSaveButton.click();
    }

    public void addUserFromAD() throws InterruptedException {
        Thread.sleep(2000);
        usersTab.click();
        Thread.sleep(2000);
        addUserDropdown.click();
        Thread.sleep(1500);
        addUserFromAD.click();
        Thread.sleep(2000);
        adNewDomainButton.click();
        adNewDomainTextBox.sendKeys("PMP2019");
        adAddButton.click();
        adPrimaryDomainControllerTextBox.sendKeys("PMP2K19");
        adSpecifyUsernameAndPasswordManuallyRadioButton.click();
        adUserName.sendKeys("administrator");
        adPassword.sendKeys("Test@123");
        adRoleID.click();
        adRoleIDPasswordUser.click();
        adOUsToImport.sendKeys("ragulou");
        Thread.sleep(1500);
        adImportButton.click();
        Thread.sleep(3000);
        adAfterUserImportCloseButton.click();
    }
}
