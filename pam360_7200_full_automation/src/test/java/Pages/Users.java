package Pages;

import BasePackage.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static Hooks.Hooks.prop;

public class Users {
    WebDriver driver;
    BaseClass base;
    Select dropdown;

    String dialogTitle = "";

    @FindBy(xpath = "//span[text() = 'Users']")
    WebElement usersTab;

    @FindBy(xpath = "//div[@id = 'userSubtab']//a[text() = 'Users']")
    static WebElement usersSubTab;

    @FindBy(xpath = "//div[@id = 'userSubtab']//a[text() = 'User Groups']")
    static WebElement userGroupsSubTab;

    @FindBy(xpath = "//div[text() = 'Add User']")
    WebElement addUserDropdown;

    @FindBy(xpath = "//div[text() = 'Add User']/following-sibling::div/child::ul/li/a")
    List<WebElement> addUserDropdownList;

    @FindBy(xpath = "//button[@id= 'searchButtonId']")
    WebElement userSearchIcon;

    @FindBy(xpath = "//input[@columnname = 'NAME1']")
    WebElement userNameSearchTextBox;

    @FindBy(xpath = "//em[text()= 'Clear Search']")
    WebElement userClearSearchIcon;

    @FindBy(xpath = "//span[@class = 'noRowMsg']")
    static List<WebElement> searchResultEmpty;

    @FindBy(xpath = "//input[@id = 'shareSearchTextBoxId']")
    static WebElement dialogSearchTextBox;

    @FindBy(xpath = "//span[@id = 'searchBoxCloseSpan']")
    static WebElement dialogClearSearchButton;

    //user group

    @FindBy(xpath = "//a[@pmpqaattr = 'Add Group']")
    static WebElement userGroupsAddGroupButton;

    @FindBy(xpath = "//input[@id = 'userGroupName']")
    static WebElement createUserGroupGroupNameTextName;

    @FindBy(xpath = "//textarea[@id = 'userGroupDesc']")
    static WebElement createUserGroupGroupDescTextName;

    @FindBy(xpath = "//em[text() = 'Save & Proceed']")
    static WebElement userSaveAndProceedButton;

    //user creation

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

    @FindBy(xpath = "//select[@name = 'superAdmin']")
    WebElement userScope;

    @FindBy(xpath = "//select[@name = 'rbutton']")
    WebElement userPasswordSetup;

    @FindBy(xpath = "//input[@id = 'dpass']")
    WebElement userPassword;

    @FindBy(xpath = "//input[@id = 'cpassword']")
    WebElement userConfirmPassword;

    @FindBy(xpath = "//em[text()= 'Save']")
    WebElement userSaveButton;

    //AD User Import

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

    @FindBy(xpath = "//input[@id = 'cusers']")
    WebElement adUsersToImport;

    @FindBy(xpath = "//input[@name = 'USER_GROUPS']")
    WebElement adGroupsToImport;

    @FindBy(xpath = "//input[@name = 'OU_']")
    WebElement adOUsToImport;

    @FindBy(xpath = "//div[@id = 'importFromADUsersClose']//em[contains(text() , 'Close')]")
    WebElement adUserImportCloseButton;

    @FindBy(xpath = "//td[contains(text(), 'Active Directory Import Summary')]")
    WebElement adImportSummary;

    @FindBy(xpath = "//em[text() = 'Import']")
    WebElement userImportButton;

    @FindBy(xpath = "//em[contains(text() , 'Fetch Groups')]")
    WebElement userFetchButton;

    @FindBy(xpath = "//em[contains(text() , 'Close')]")
    WebElement userCloseButton;

    @FindBy(xpath = "//span[@class = 'error_info']")
    WebElement adImportConnectionErrorMsg;

    //EntraID User Import

    @FindBy(xpath = "//input[@id = 'TENANTID']")
    WebElement entraIDTenantID;

    @FindBy(xpath = "//input[@id = 'clientid']")
    WebElement entraIDClientID;

    @FindBy(xpath = "//input[@id = 'CLIENTSECRET']")
    WebElement entraIDClientSecret;

    @FindBy(xpath = "//select[@id = 'azureRoleIdInput']")
    WebElement entraIDRoleID;

    @FindBy(xpath = "//input[@id = 'userNames']")
    WebElement entraIDUserNames;

    @FindBy(xpath = "//input[@id = 'userGroups']")
    WebElement entraIDUserGroups;

    @FindBy(xpath = "//select[@id = 'day_id']")
    WebElement entraIDSyncDay;

    @FindBy(xpath = "//select[@id = 'hour_id']")
    WebElement entraIDSyncHour;

    @FindBy(xpath = "//table[@id = 'azureGroupsTable']/tbody/tr")
    List<WebElement> entraIDGroupsList;

    //LDAP user import

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

    @FindBy(xpath = "//span[@class = 'ldap-domain-name']")
    List<WebElement> ldapDomains;

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
        this.base = new BaseClass(this.driver);
    }

    public String dialogCloseIcon(String dialogTitle) {
        return "//span[contains(text() , '" + dialogTitle + "')]/following::button[@title = 'Close']";
    }

    public String pageTitle(String pageTitle) {
        return "//span[contains(text() , '" + pageTitle + "')]";
    }

    public String UserGroupsAddToGroupActionButton(String userName) {
        return "//span[@onmouseover = \"Tip('Login name :" + userName +"',this);\"]/ancestor::*[2]/following-sibling::div/descendant::span[text() = 'Add to group']";
    }

    public String ldapGroupsorOUCheckBox(String groupOROUName) {
        return "//div[not(text())]/strong[text() = '" + groupOROUName + "']/parent::div/preceding-sibling::div/input";
    }

    public String userNameInUserTab(String userName) {
        return "//span[@onmouseover= \"Tip('Login name :" + userName + "',this);\"]";
    }

    public void addUserManually(String firstName, String lastName, String userName, String role, String mail, String passwordSetup,String password) throws InterruptedException {
        base.waitForElementToBeVisible(usersTab, 10);
        usersTab.click();
        Thread.sleep(1000);
        base.waitForElementToBeVisible(userSearchIcon,10);
        userSearchIcon.click();
        base.waitForElementToBeVisible(userNameSearchTextBox,10);
        userNameSearchTextBox.sendKeys(userName);
        Thread.sleep(1500);
        userNameSearchTextBox.sendKeys(Keys.ENTER);
        if(base.isElementsPresent(searchResultEmpty)) {
            if (base.waitForElementToBeVisible(usersSubTab, 10)) {
                base.waitForElementToBeClickable(addUserDropdown, 10);
                addUserDropdown.click();
                base.multipleElements(addUserDropdownList, "Add User").click();
                base.waitForElementToBeVisible(userFirstName, 10);
                userFirstName.sendKeys(firstName);
                userLastName.sendKeys(lastName);
                userUserName.sendKeys(userName);
                userEmail.sendKeys(mail);
                base.dropDownSelectText(userRole, role);
                base.dropDownSelectText(userScope, prop.getProperty("userScope"));
                if (password.isEmpty())
                    base.dropDownSelectText(userPasswordSetup, passwordSetup);
                else {
                    base.dropDownSelectText(userPasswordSetup, "Enter a Password");
                    base.waitForElementToBeVisible(userPassword, 10);
                    userPassword.sendKeys(password);
                    userConfirmPassword.sendKeys(password);
                }
                userSaveButton.click();
            }
        }
        else {
            System.out.println("User is already present");
            userClearSearchIcon.click();
        }
    }

    public void addUserFromAD() throws InterruptedException {
        base.waitForElementToBeVisible(usersTab, 10);
        usersTab.click();
        if(base.waitForElementToBeVisible(usersSubTab, 10)) {
            base.waitForElementToBeClickable(addUserDropdown,10);
            addUserDropdown.click();
            base.multipleElements(addUserDropdownList,"Import From Active Directory").click();
            base.waitForElementToBeVisible(userNewDomainButton,10);
            userNewDomainButton.click();
            userNewDomainTextBox.sendKeys("PMP2019");
            userAddButton.click();
            adPrimaryDomainControllerTextBox.sendKeys("PMP2K19");
            adSpecifyUsernameAndPasswordManuallyRadioButton.click();
            adUserName.sendKeys("");
            adPassword.sendKeys("Test@123");
            base.dropDownSelectText(adRoleID,prop.getProperty("userRole"));
            adUsersToImport.sendKeys("user1mrs");
            base.waitForElementToBeVisible(userImportButton,10);
            userImportButton.click();
            dialogTitle = "Import";
            base.waitForElementToBeVisible(driver.findElement(By.xpath(dialogCloseIcon(dialogTitle))),10);
            driver.findElement(By.xpath(dialogCloseIcon(dialogTitle))).click();
        }
    }

    public void addUserFromENTRAID(String importType) throws InterruptedException {
        base.waitForElementToBeVisible(usersTab, 10);
        usersTab.click();
        if(base.waitForElementToBeVisible(usersSubTab, 10)) {
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
            base.dropDownSelectText(entraIDRoleID,prop.getProperty("userRole"));
            if(importType.equalsIgnoreCase("directuser")) {
                entraIDUserNames.sendKeys(prop.getProperty("entraIDuserName"));
                base.waitForElementToBeVisible(userImportButton,10);
                userImportButton.click();
            }else if(importType.equalsIgnoreCase("directgroup")){
                entraIDUserGroups.sendKeys(prop.getProperty("entraIDgroupName"));
                base.waitForElementToBeVisible(userImportButton,10);
                userImportButton.click();
            } else {
                base.waitForElementToBeClickable(userFetchButton, 10);
                userFetchButton.click();
                base.waitForElements(entraIDGroupsList, 10);
                WebElement entraIDGroupName;
                entraIDGroupName = driver.findElement(By.xpath("//table[@id = 'azureGroupsTable']/tbody/tr[" + base.getOptionCount(entraIDGroupsList, prop.getProperty("entraIDgroupName")) + "]/td[1]/input"));
                entraIDGroupName.click();
                userImportButton.click();
            }
            base.waitForElementToBeVisible(driver.findElement(By.xpath(dialogCloseIcon("Import"))),10);
            driver.findElement(By.xpath(dialogCloseIcon("Import"))).click();
        }
    }

    public String addUserFromLDAP(){
        base.waitForElementToBeVisible(usersTab, 10);
        usersTab.click();
        if(base.waitForElementToBeVisible(usersSubTab, 10)) {
            base.waitForElementToBeClickable(addUserDropdown,10);
            addUserDropdown.click();
            base.multipleElements(addUserDropdownList, "Import From LDAP").click();
            base.waitForURL("admin/LdapHomeView/Configs",10);
            if(ldapAddServerButton.isDisplayed()) {
                base.waitForElementToBeClickable(ldapAddServerButton, 10);
                ldapAddServerButton.click();
                base.waitForElementToBeVisible(ldapProviderURL, 10);
                ldapProviderURL.sendKeys("PMP2k19");
                ldapProviderPort.sendKeys("389");
                ldapServerUserName.sendKeys("cn=suaravind,dc=pmp2019,dc=com");
                ldapServerPassword.sendKeys("Test@123");
                ldapServerbaseDN.sendKeys("dc=pmp2019,dc=com");
                userSaveButton.click();
            }
            base.multipleElements(ldapDomains,"pmp2019.com");
            base.waitForElementToBeClickable(ldapImportDropdown, 10);
            ldapImportDropdown.click();
            base.multipleElements(ldapImportDropdownList, "Groups").click();
            base.waitForElementToBeClickable(ldapViewAllGroupsOrOU, 10);
            ldapViewAllGroupsOrOU.click();
            base.waitForElementToBeVisible(ldapGroupsOrOUTextBox, 10);
            ldapGroupsOrOUTextBox.sendKeys("ragulgroup");
            base.waitForElementToBeClickable(driver.findElement(By.xpath(ldapGroupsorOUCheckBox("ragulgroup"))), 10);
            driver.findElement(By.xpath(ldapGroupsorOUCheckBox("ragulgroup"))).click();
            base.waitForElementToBeClickable(ldapRoleID, 10);
            ldapRoleID.click();
            base.multipleElements(ldapRoleDropdownList, "Password Auditor").click();
            userSaveButton.click();
            return "users import is completed";
        }
        else
            return "users tab not loaded";
    }

    public void createUserGroup(String groupName, String groupDesc, String users) throws InterruptedException {
        base.waitForElementToBeVisible(usersTab, 10);
        usersTab.click();
        Thread.sleep(1000);
        base.waitForElementToBeVisible(userGroupsSubTab,10);
        userGroupsSubTab.click();
        base.waitForElementToBeVisible(userGroupsAddGroupButton,10);
        userGroupsAddGroupButton.click();
        base.waitForElementToBeVisible(driver.findElement(By.xpath(pageTitle("Add User Group"))),10);
        createUserGroupGroupNameTextName.sendKeys(groupName);
        createUserGroupGroupDescTextName.sendKeys(groupDesc);
        userSaveAndProceedButton.click();
        base.waitForElementToBeVisible(driver.findElement(By.xpath(pageTitle("Add users"))),10);
        String[] usersArray = users.split(";");
        for(String user: usersArray) {
            dialogSearchTextBox.sendKeys(user);
            base.waitForElementToBeVisible(driver.findElement(By.xpath((UserGroupsAddToGroupActionButton(user)))),10);
            driver.findElement(By.xpath(UserGroupsAddToGroupActionButton(user))).click();
        }
    }

}

