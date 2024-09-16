package pages;

import BasePackage.BaseFunctionsClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Users {
    WebDriver driver;
    BaseFunctionsClass base;

    @FindBy(xpath = "//span[text() = 'Users']")
    WebElement usersTab;

    @FindBy(xpath = "//div[@id = 'userSubtab']//a[text() = 'Users']")
    static WebElement usersSubTab;

    @FindBy(xpath = "//div[text() = 'Add User']")
    WebElement addUserDropdown;

    @FindBy(xpath = "//div[text() = 'Add User']/following-sibling::div/child::ul/li/a")
    List<WebElement> addUserDropdownList;

    @FindBy(xpath = "//div[text() = 'Add User']/following-sibling::div/child::ul/li/a[text() = 'Add User']")
    WebElement addUser;

    @FindBy(xpath = "//div[text() = 'Add User']/following-sibling::div/child::ul/li/a[text() = 'Import From Active Directory']")
    WebElement addUserFromAD;

    @FindBy(xpath = "//input[@name = 'fname']")
    WebElement userFirstName;

    @FindBy(xpath = "//input[@name = 'lname']")
    WebElement userLastName;

    @FindBy(xpath = "//input[@name = 'user']")
    WebElement userUserName;

    @FindBy(xpath = "//input[@name = 'mail']")
    WebElement userEmail;

    @FindBy(xpath = "//select[@name = 'role']")
    WebElement userRole;

    @FindBy(xpath = "//option[text() = 'Password User']")
    WebElement userRolePasswordUser;

    @FindBy(xpath = "//select[@name = 'superAdmin']")
    WebElement userScope;

    @FindBy(xpath = "//option[text() = 'Passwords Owned and Shared']")
    WebElement userScopePasswordsOwnedAndShared;

    @FindBy(xpath = "//select[@name = 'rbutton']")
    WebElement userPasswordSetup;

    @FindBy(xpath = "//option[text() = 'Username as a Password']")
    WebElement userPasswordSetupUsernameAsAPassword;

    @FindBy(xpath = "//em[text()= 'Save']")
    WebElement userSaveButton;

    @FindBy(xpath = "//span[@id = 'NEW_LINK']")
    WebElement userNewDomainButton;

    @FindBy(xpath = "//input[@id = 'NEW_DOMAIN']")
    WebElement userNewDomainTextBox;

    @FindBy(xpath = "//span[text() = 'Add']")
    WebElement userAddButton;

    @FindBy(xpath = "//input[@name= 'DCNAME']")
    WebElement adPrimaryDomainControllerTextBox;

    @FindBy(xpath = "//label[text() = 'Specify Username and Password Manually']")
    WebElement adSpecifyUsernameAndPasswordManuallyRadioButton;

    @FindBy(xpath = "//input[@name = 'LOGINNAME']")
    WebElement adUserName;

    @FindBy(xpath = "//input[@name = 'PASSWORD']")
    WebElement adPassword;

    @FindBy(xpath = "//select[@name = 'ROLEID']")
    WebElement adRoleID;

    @FindBy(xpath = "//option[text() = 'Password User']")
    WebElement adRoleIDPasswordUser;

    @FindBy(xpath = "//input[@name = 'OU_']")
    WebElement adOUsToImport;

    @FindBy(xpath = "//div[@id = 'importFromADUsersClose']//em[contains(text() , 'Close')]")
    WebElement adUserImportCloseButton;

    @FindBy(xpath = "//em[text() = 'Import']")
    WebElement userImportButton;

    @FindBy(xpath = "//em[contains(text() , 'Fetch Groups')]")
    WebElement userFetchButton;

    @FindBy(xpath = "//em[contains(text() , 'Close')]")
    WebElement userCloseButton;

    @FindBy(xpath = "//span[@class = 'error_info']")
    WebElement adImportConnectionErrorMsg;

    @FindBy(xpath = "//input[@id = 'TENANTID']")
    WebElement entraIDTenantID;

    @FindBy(xpath = "//input[@id = 'clientid']")
    WebElement entraIDClientID;

    @FindBy(xpath = "//input[@id = 'CLIENTSECRET']")
    WebElement entraIDClientSecret;

    @FindBy(xpath = "//select[@id = 'azureRoleIdInput']")
    WebElement entraIDRoleID;

    @FindBy(xpath = "//select[@id = 'azureRoleIdInput']//optgroup/option")
    List<WebElement> entraIDRoleDropdownList;

    @FindBy(xpath = "//input[@id = 'userNames']")
    WebElement entraIDUserNames;

    @FindBy(xpath = "//input[@id = 'userGroups']")
    WebElement entraIDUserGroups;

    @FindBy(xpath = "//select[@id = 'day_id']")
    WebElement entraIDSyncDay;

    @FindBy(xpath = "//select[@id = 'day_id']/option")
    List<WebElement> entraIDSyncDayDropdownList;

    @FindBy(xpath = "//select[@id = 'hour_id']")
    WebElement entraIDSyncHour;

    @FindBy(xpath = "//select[@id = 'day_id']/option")
    List<WebElement> entraIDSyncHourDropdownList;

    @FindBy(xpath = "//table[@id = 'azureGroupsTable']/tbody/tr")
    List<WebElement> entraIDGroupsList;

    @FindBy(xpath = "//em[text() = 'Add LDAP Server']")
    WebElement ldapAddServerButton;

    @FindBy(xpath = "//input[@id = 'providerHost']")
    WebElement ldapProviderURL;

    @FindBy(xpath = "//input[@id = 'providerPort']")
    WebElement ldapProviderPort;

    @FindBy(xpath = "//input[@id = 'secondaryHost_1']")
    WebElement ldapSecondaryURL;

    @FindBy(xpath = "//input[@id = 'manualUserName']")
    WebElement ldapServerUserName;

    @FindBy(xpath = "//input[@id = 'manualPassword']")
    WebElement ldapServerPassword;

    @FindBy(xpath = "//input[@id = 'baseDN']")
    WebElement ldapServerbaseDN;

    @FindBy(xpath = "//div[@pmpqaattr= 'AddResourceMenu']")
    WebElement ldapImportDropdown;

    @FindBy(xpath = "//div[@pmpqaattr= 'AddResourceMenu']/following-sibling::div/ul/li/a")
    List<WebElement> ldapImportDropdownList;

    @FindBy(xpath = "//button[@id = 'TSFetchButton']")
    WebElement ldapViewAllGroupsOrOU;

    @FindBy(xpath = "//div[@class = 'custom-table-cell ldap-group-name-col set-ldap-search-input-width']/input")
    WebElement ldapGroupsOrOUTextBox;

    @FindBy(xpath = "//div[@id = 'ldap-container']/div/div/div[1]/input")
    WebElement ldapGroupsOrOUCheckBox;

    @FindBy(xpath = "//div[@id = 'ldap-container']/div/div/div[4]/select")
    WebElement ldapRoleID;

    @FindBy(xpath = "//div[@id = 'ldap-container']/div/div/div[4]//optgroup/option")
    List<WebElement> ldapRoleDropdownList;

    public Users(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.base = new BaseFunctionsClass(this.driver);
    }

    public void addUserManually() throws InterruptedException {

        base.waitForElement(usersTab, 10);
        usersTab.click();
        if(base.waitForElement(usersSubTab, 10)) {
            base.waitForElementToBeClickable(addUserDropdown,10);
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
    }

    public void addUserFromAD() throws InterruptedException {
        base.waitForElement(usersTab, 10);
        usersTab.click();
        if(base.waitForElement(usersSubTab, 10)) {
            base.waitForElementToBeClickable(addUserDropdown,10);
            addUserDropdown.click();
            Thread.sleep(1500);
            addUserFromAD.click();
            Thread.sleep(2000);
            userNewDomainButton.click();
            userNewDomainTextBox.sendKeys("PMP2019");
            userAddButton.click();
            adPrimaryDomainControllerTextBox.sendKeys("PMP2K19");
            adSpecifyUsernameAndPasswordManuallyRadioButton.click();
            adUserName.sendKeys("administrator");
            adPassword.sendKeys("Test@123");
            adRoleID.click();
            adRoleIDPasswordUser.click();
            adOUsToImport.sendKeys("ragulou");
            Thread.sleep(1500);
            userImportButton.click();
            Thread.sleep(3000);
            adUserImportCloseButton.click();
        }
    }

    public void addUserFromENTRAID(String userNames, String userGroups,String groupName) throws InterruptedException {
        base.waitForElement(usersTab, 10);
        usersTab.click();
        if(base.waitForElement(usersSubTab, 10)) {
            base.waitForElementToBeClickable(addUserDropdown,10);
            addUserDropdown.click();
            base.multipleElements(addUserDropdownList, "Import From Microsoft Entra ID").click();
            base.waitForElementToBeClickable(userNewDomainButton, 10);
            userNewDomainButton.click();
            userNewDomainTextBox.sendKeys("marketPlaceZohooutlook.onmicrosoft.com");
            userAddButton.click();
            entraIDTenantID.sendKeys("b0165b34-2a0e-4f4b-805d-5b96cc9b426a");
            entraIDClientID.sendKeys("6b07c27a-c46e-48be-b12b-cb6909b9d8ca");
            entraIDClientSecret.sendKeys("QN_8Q~9VgOwRDGLBbnzYADGMKmzvnyz-_W2utaZy");
            entraIDRoleID.click();
            base.multipleElements(entraIDRoleDropdownList, "Connection User").click();
            entraIDSyncDay.click();
            base.multipleElements(entraIDSyncDayDropdownList, "00").click();
            entraIDSyncHour.click();
            base.multipleElements(entraIDSyncHourDropdownList, "02").click();
            entraIDUserNames.sendKeys(userNames);
            entraIDUserGroups.sendKeys(userGroups);
            if (!userNames.isEmpty() || !userGroups.isEmpty()) {
                userImportButton.click();
            } else {
                base.waitForElementToBeClickable(userFetchButton, 10);
                userFetchButton.click();
                base.waitForElements(entraIDGroupsList, 10);
                WebElement entraIDGroupName;
                entraIDGroupName = driver.findElement(By.xpath("//table[@id = 'azureGroupsTable']/tbody/tr[" + base.getOptionCount(entraIDGroupsList, groupName) + "]/td[1]/input"));
                entraIDGroupName.click();
                userImportButton.click();
                base.waitForElementToBeClickable(userCloseButton, 10);
                userCloseButton.click();
            }
        }
    }

    public String addUserFromLDAP(){
        base.waitForElement(usersTab, 10);
        usersTab.click();
        if(base.waitForElement(usersSubTab, 10)) {
            base.waitForElementToBeClickable(addUserDropdown,10);
            addUserDropdown.click();
            base.multipleElements(addUserDropdownList, "Import From LDAP").click();
            base.waitForElementToBeClickable(ldapAddServerButton, 10);
            ldapAddServerButton.click();
            base.waitForElement(ldapProviderURL, 10);
            ldapProviderURL.sendKeys("PMP2k19");
            ldapProviderPort.sendKeys("389");
            ldapServerUserName.sendKeys("cn=suaravind,dc=pmp2019,dc=com");
            ldapServerPassword.sendKeys("Test@123");
            ldapServerbaseDN.sendKeys("dc=pmp2019,dc=com");
            userSaveButton.click();
            base.waitForElementToBeClickable(ldapImportDropdown, 10);
            ldapImportDropdown.click();
            base.multipleElements(ldapImportDropdownList, "Groups").click();
            base.waitForElementToBeClickable(ldapViewAllGroupsOrOU, 10);
            ldapViewAllGroupsOrOU.click();
            base.waitForElement(ldapGroupsOrOUTextBox, 10);
            ldapGroupsOrOUTextBox.sendKeys("ragulgroup");
            base.waitForElementToBeClickable(ldapGroupsOrOUCheckBox, 10);
            ldapGroupsOrOUCheckBox.click();
            base.waitForElementToBeClickable(ldapRoleID, 10);
            ldapRoleID.click();
            base.multipleElements(ldapRoleDropdownList, "Password Auditor").click();
            userSaveButton.click();
            return "users import is completed";
        }
        else
            return "users tab not loaded";
    }

}

