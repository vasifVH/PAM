package Pages;

import BasePackage.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Hooks.Hooks.prop;

public class Resources {
    WebDriver driver;
    Actions actions;
    BaseClass base;
    JavascriptExecutor js;

    String resourcePage = prop.getProperty("url") + "PassTrixMain.cc#/PasswordFullView/PasswordMainView";
    String dialogTitle = "";

    @FindBy(xpath = "//button[@id='searchButtonId']")
    public static WebElement resourceSearchIcon;

    @FindBy(xpath = "//em[text() = 'Clear Search']")
    static WebElement resourceClearSearchButton;

    @FindBy(xpath = "//span[@class = 'noRowMsg']")
    static List<WebElement> searchResultEmpty;

    @FindBy(xpath = "//em[text() = 'Clear Search']")
    static List<WebElement> resourceClearSearchButtonPresence;

    @FindBy(xpath = "//input[@columnname='PTRX_LNAME']")
    static WebElement accountSearchTextBox;

    @FindBy(xpath = "//a[normalize-space()='Windows Remote Desktop']")
    static WebElement rdpwindowsLaunch;

    @FindBy(xpath = "//span[text() = 'Resources']")
    static WebElement resourceTab;

    @FindBy(xpath = "//div[@pmpqaattr='AddResourceMenu']")
    static WebElement addResourceDropdown;

    @FindBy(xpath = "//div[@pmpqaattr='AddResourceMenu']/following-sibling::div/child::ul/li/a")
    List<WebElement> addResourceDropdownList;

    @FindBy(xpath = "//input[@columnname='PTRX_RNAME']")
    static WebElement resourceNameSearchTextBox;

    @FindBy(xpath = "//input[@id = 'shareSearchTextBoxId']")
    static WebElement shareSearchTextBox;

    @FindBy(xpath = "//span[@id = 'searchBoxCloseSpan']")
    static WebElement shareSearchClearSearchButton;

    @FindBy(xpath = "//div[text() = 'Resource Actions']")
    static WebElement bulkResourceActionsDropdown;

    @FindBy(xpath = "//div[text() = 'Resource Actions']/following-sibling::div/ul/li/a")
    static List<WebElement> bulkResourceActionsDropdownList;

    @FindBy(xpath = "//div[text() = 'Resource Actions']/following-sibling::div/ul/li/ul/li/a")
    static List<WebElement> bulkResourceActionsDropdownSubOptionList;

    @FindBy(xpath = "//li[contains(@class , 'ui-menu-item')]/a")
    static List<WebElement> resourceActionMenuList;

    @FindBy(xpath = "//div[@divtype = 'ResourceGroupHomeFilter_default_table']/descendant::a[text() = 'Discover Resources']")
    static WebElement resourceDiscoveryButton;

    //add/edit Resource

    @FindBy(xpath = "//input[@id='sysname']")
    static WebElement addResourceName;

    @FindBy(xpath = "//input[@id='DNSName']")
    static WebElement addResourceDNSName;

    @FindBy(xpath = "//div[@id = 'DNSNameToggleButton']")
    static WebElement resourceDNSNameEyeIcon;

    @FindBy(xpath = "//select[@id='SysType']")
    static WebElement addResourceResourceTypeDropdown;

    @FindBy(xpath = "//em[text()='Save']")
    static WebElement resourceSaveButton;

    @FindBy(xpath = "//em[text()='Save & Proceed']")
    static WebElement resourceSaveAndProceedButton;

    @FindBy(xpath = "//em[text()='Cancel']")
    static WebElement resourceCancelButton;

    @FindBy(xpath = "//em[text() = 'Save & Activate']")
    static WebElement resourceSaveAndActivateButton;

    @FindBy(xpath = "//em[text() = 'Send']")
    static WebElement resourceSendButton;

    @FindBy(xpath = "//button[@id = 'checkOut']")
    static WebElement passCheckoutButton;

    @FindBy(xpath = "//em[text() = 'Check In']")
    static WebElement passCheckinButton;

    //Account Details Dialog box

    @FindBy(xpath = "//input[@id='Usr1']")
    static WebElement addAccountAccountName;

    @FindBy(xpath = "//div[@id='GENPASS']")
    static WebElement addAccountPasswordGenerate;

    @FindBy(xpath = "//input[@id='Pas1']")
    static WebElement addAccountPassword;

    @FindBy(xpath = "//input[@id='cpassword']")
    static WebElement addAccountConfirmPassword;

    @FindBy(xpath = "//input[@id='sharedTOTPKey']")
    static WebElement addAccountTOTPSecretKey;

    @FindBy(xpath = "//input[@id='dormantAcc']")
    static WebElement addAccountPasswordResetCheckBox;

    @FindBy(xpath = "//em[text()='Add']")
    static WebElement accountAddButton;

    @FindBy(xpath = "//tr[@class = 'hide']//em[text() = 'Add']")
    static WebElement accountAddButtonHideCheck;

    @FindBy(xpath = "//a[text()='Add']")
    static WebElement addAccountButton;

    @FindBy(xpath = "//tr[@class = 'datarow']/td[2]")
    static List<WebElement> addedAccountList;

    @FindBy(xpath = "//span[contains (text(),'Account Details')]/following::button[@id='searchButtonId']")
    static WebElement accountSearchIcon;

    @FindBy(xpath = "//ul[@role = 'menu']//child::li/a[@role = 'menuitem']")
    static List<WebElement> accountActionsOptions;

    @FindBy(xpath = "//td[contains(text() , 'Resource Name')]/following-sibling::td[2]")
    static WebElement changePassResourceName;

    @FindBy(xpath = "//td[contains(text() , 'Account Name')]/following-sibling::td[2]")
    static WebElement changePassAccountName;

    @FindBy(xpath = "//input[@id = 'defaultvalue_schar1']")
    static WebElement changePassNewPasswordTextBox;

    @FindBy(xpath = "//input[@id = 'cpassword1']")
    static WebElement changePassConfirmPasswordTextBox;

    @FindBy(xpath = "//input[@id = 'defaultvalue_schar1']/following-sibling::div[2]")
    static WebElement changePassGeneratePasswordIcon;

    @FindBy(xpath = "//span[text()= 'Apply password changes to the remote resource.']")
    static WebElement changePassRemoteCheckBox;

    @FindBy(xpath = "//span[@id = 'remoteError1']")
    static WebElement changePassErrorMessageContainer;

    @FindBy(xpath = "//span[@id = 'remoteError']")
    static WebElement changePassErrorMessage;

    //Configure Remote Password Reset

    @FindBy(xpath = "//input[@id = 'SameResource']")
    static WebElement remotePassResetLinuxSameResourceButton;

    @FindBy(xpath = "//input[@id = 'OtherResource']")
    static WebElement remotePassResetLinuxDomainResourceButton;

    @FindBy(xpath = "//select[@id = 'NormalAccount']")
    static WebElement remotePassResetLinuxSameResourceAccount;

    @FindBy(xpath = "//select[@id = 'ResourceName']")
    static WebElement remotePassResetLinuxDomainResourceResourceName;

    @FindBy(xpath = "//select[@id = 'wdUserName']")
    static WebElement remotePassResetLinuxDomainResourceAccount;

    @FindBy(xpath = "//input[@id = 'suroot']")
    static WebElement remotePassResetLinuxElevationTypeSuRoot;

    @FindBy(xpath = "//input[@id = 'sudo']")
    static WebElement remotePassResetLinuxElevationTypeSudo;

    @FindBy(xpath = "//input[@id = 'local']")
    static WebElement remotePassResetWindowsSameResourceButton;

    @FindBy(xpath = "//input[@id = 'domain']")
    static WebElement remotePassResetWindowsDomainResourceButton;

    @FindBy(xpath = "//div[@id = 'windows_admin_account-container']")
    static WebElement remotePassResetWindowsSameResourceAccount;

    @FindBy(xpath = "//select[@id = 'wd_resName']")
    static WebElement remotePassResetWindowsDomainResourceResourceName;

    @FindBy(xpath = "//div[@id = 'wdUserName-container']")
    static WebElement remotePassResetWindowsDomainResourceAccount;

    @FindBy(xpath = "//div[@id = 'AdminAccount-container']")
    static WebElement remotePassResetWindowsDomainSameResourceAccount;

    @FindBy(xpath = "//li[@role = 'option']/div/span")
    static List<WebElement> zSelectOptions;

    //Transfer Resource Ownership

    @FindBy(xpath = "//select[@name ='NEW_OWNER']")
    static WebElement transferOwnershipNewOwner;

    //Configure Access Control Dialog box WebElements:

    @FindBy(xpath = "//li[@id = 'AdminView_li']")
    static WebElement accCntlApprovalAdminTab;

    @FindBy(xpath = "//li[@id = 'ExcludeView_li']")
    static WebElement accCntlExcludedUsersTab;

    @FindBy(xpath = "//li[@id = 'SettingView_li']")
    static WebElement accCntlMiscellaneousSettingsTab;

    @FindBy(xpath = "//li[@id = 'userview_li']")
    static WebElement accCntlApprovalAdminsUsersTab;

    @FindBy(xpath = "//li[@id = 'groupview_li']")
    static WebElement accCntlApprovalAdminsGroupTab;

    @FindBy(xpath = "//li[@id = 'excludeuserview_li']")
    static WebElement accCntlExcludedUsersUsersTab;

    @FindBy(xpath = "//li[@id = 'excludegroupview_li']")
    static WebElement accCntlExcludedUsersGroupTab;

    @FindBy(xpath = "//select[@id = 'PasswordUser']")
    static WebElement accCntlAllAdmins;

    @FindBy(xpath = "//select[@id = 'PasswordUserGroup']")
    static WebElement accCntlallAdminGroups;

    @FindBy(xpath = "//select[@id = 'PasswordUser1']")
    static WebElement accCntlExcludedUsers;

    @FindBy(xpath = "//select[@id = 'ExcludePasswordUserGroup']")
    static WebElement accCntlExcludedGroups;

    @FindBy(xpath = "//div[@onclick = 'return addadmin()']")
    static WebElement addArrowApprovalAdminUsers;

    @FindBy(xpath = "//div[@onclick = \"return addadmingroup('PasswordUserGroup','ADMINGROUP')\"]")
    static WebElement addArrowApprovalAdminGroups;

    @FindBy(xpath = "//div[@onclick = 'return addpassadmin();']")
    static WebElement addArrowExcludeUsers;

    @FindBy(xpath = "//div[@onclick = 'return addadmingroup('ExcludePasswordUserGroup','ExcludePasswordUserGroup1');']")
    static WebElement addArrowExcludeGroups;

    @FindBy(xpath = "//input[@name = 'IS_DUAL']")
    static WebElement accCntlMultipleAdminSettingCheckBox;

    @FindBy(xpath = "//select[@id= 'numAdmin']")
    static WebElement accCntlMultipleAdminCount;

    @FindBy(xpath = "//input[@name = 'IS_REASON']")
    static WebElement accCntlIsReasonSettingCheckBox;

    @FindBy(xpath = "//input[@name = 'IS_REMIND']")
    static WebElement accCntlIsRemindSettingCheckBox;

    @FindBy(xpath = "//input[@name = 'REMINDER_MINUTES']")
    static WebElement accCntlReminderMinutesSettingTextBox;

    @FindBy(xpath = "//input[@name = 'IS_GRACETIME']")
    static WebElement accCntlIsGraceTimeSettingCheckBox;

    @FindBy(xpath = "//input[@name = 'GRACE_TIME']")
    static WebElement accCntlGraceTimeSettingTextBox;

    @FindBy(xpath = "//input[@name = 'AUTO_CHECKIN']")
    static WebElement accCntlAutoCheckinSettingCheckBox;

    @FindBy(xpath = "//input[@name = 'CHECKIN_TIME']")
    static WebElement accCntlCheckinTimeSettingTextBox;

    @FindBy(xpath = "//input[@name = 'REQ_TIMEOUT']")
    static WebElement accCntlRequestTimeoutSettingTextBox;

    @FindBy(xpath = "//input[@name = 'CHECKOUT_TIMEOUT']")
    static WebElement accCntlCheckoutTimeoutSettingTextBox;

    @FindBy(xpath = "//input[@name = 'IS_RESET']")
    static WebElement accCntlResetPassSettingCheckBox;

    //Bulk Reset Password

    @FindBy(xpath = "//input[@id = 'pwd_to_use']")
    static WebElement bulkResetPassPasswordToUseRadioButton;

    @FindBy(xpath = "//input[@id = 'generate_unique']")
    static WebElement bulkResetPassGenerateUniqueRadioButton;

    @FindBy(xpath = "//input[@name = 'password']")
    static WebElement bulkResetPassPasswordTextBox;

    @FindBy(xpath = "//div[@id = 'GENPASS']")
    static WebElement bulkResetPasGeneratePasswordIcon;

    @FindBy(xpath = "//input[@name = 'password']")
    static WebElement bulkResetPassRemoteResetCheckBox;

    //Password Request

    @FindBy(xpath = "//label[text() = 'Now']")
    static WebElement passRequestNowButton;

    @FindBy(xpath = "//label[text() = 'Later']")
    static WebElement passRequestLaterButton;

    @FindBy(xpath = "//textarea[@name = 'REASON_ID']")
    static WebElement passRequestCommentsTextbox;

    @FindBy(xpath = "//input[@name = 'startDate']")
    static WebElement passRequestStartDate;

    @FindBy(xpath = "//input[@name = 'endDate']")
    static WebElement passRequestEndDate;

    @FindBy(xpath = "//select[@name = 'startTimeH']")
    static WebElement passRequestStartTimeHour;

    @FindBy(xpath = "//select[@name = 'startTimeM']")
    static WebElement passRequestStartTimeMinute;

    @FindBy(xpath = "//select[@name = 'endTimeH']")
    static WebElement passRequestEndTimeHour;

    @FindBy(xpath = "//select[@name = 'endTimeM']")
    static WebElement passRequestEndTimeMinute;

    @FindBy(xpath = "//form[@name = 'PasswordRequestForm']/descendant::td[1]")
    static WebElement passCheckoutInstruction;

    //Discover Resources

    @FindBy(xpath = "//span[@id = 'NEW_LINK']")
    WebElement resourcesNewDomainButton;

    @FindBy(xpath = "//input[@id = 'NEW_DOMAIN']")
    WebElement resourcesNewDomainTextBox;

    @FindBy(xpath = "//span[text() = 'Add']")
    WebElement resourcesAddButton;

    @FindBy(xpath = "//input[@name= 'DCNAME']")
    WebElement adPrimaryDomainControllerTextBox;

    @FindBy(xpath = "//label[text() = 'Specify Username and Password Manually']")
    WebElement adSpecifyUsernameAndPasswordManuallyRadioButton;

    @FindBy(xpath = "//input[@name = 'LOGINNAME']")
    WebElement adUserName;

    @FindBy(xpath = "//input[@name = 'PASSWORD']")
    WebElement adPassword;

    @FindBy(xpath = "//select[@name = 'PASSWDRULENAME']")
    WebElement adPasswordPolicy;

    @FindBy(xpath = "//input[@id = 'cusers']")
    WebElement adResourcesToImport;

    @FindBy(xpath = "//input[@name = 'USER_GROUPS']")
    WebElement adGroupsToImport;

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

    @FindBy(xpath = "//div[@class = 'rslink']/descendant::span[text() = 'Resources']")
    WebElement adRedirectResources;

    public Resources (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.base = new BaseClass(this.driver);
        actions = new Actions(this.driver);
        js = (JavascriptExecutor) this.driver;
    }

    public String dialogCloseIcon(String dialogTitle) {
        return "//span[contains(text() , '" + dialogTitle + "')]/following::button[@title = 'Close']";
    }

    public String pageTitle(String pageTitle){
        return "//span[contains(text() , '" + pageTitle + "')]";
    }

    public String resource(String resourceName){
        return "//a[text() = '" + resourceName + "']";
    }

    public String resourceTextCheckboxFields(String fieldName, String inputType){
        return "//div[text() = '" + fieldName + "']/following-sibling::div/input[@type = '" + inputType + "']";
    }

    public String resourceHiddenTextFields(String fieldName){
        if(driver.findElement(By.xpath("//div[text() = '" + fieldName + "']/following-sibling::div/div/input[1]")).getAttribute("class").equalsIgnoreCase("txtbox"))
            driver.findElement(By.xpath("//div[text() = '" + fieldName + "']/following-sibling::div/div/div[contains(@id,'ToggleButton')]")).click();
        return "//div[text() = '" + fieldName + "']/following-sibling::div/div/input[1]";
    }

    public String resourceDropdownFields(String fieldName){
        return "//div[text() = '" + fieldName + "']/following-sibling::div/select";
    }

    public String resourceCheckBoxInTable(String resourceName){
        return "//a[text() = '" + resourceName + "']/ancestor::div/div/span/input[@name = 'rowSelection']";
    }

    public String resourceActionsIcon(String resourceName){
        return "//a[text() = '" + resourceName +"']/ancestor::*[2]/following-sibling::div/span/div/a/span";
    }

    public String getResourceType(String resourceName) {
        String resourceTypeElement =  "//a[text() = '" + resourceName + "']/ancestor::*[2]/following-sibling::div/span/img/parent::span";
        return driver.findElement(By.xpath(resourceTypeElement)).getText();
    }

    public String accountActionsIcon(String accountName){
        return "//span[text() = '" + accountName +"']/ancestor::*[3]/following-sibling::div/span/div/a/span";
    }

    public String clickHiddenPassword(String accountName){
        return "//span[text() = '" + accountName + "']/ancestor::*[3]/following-sibling::div/descendant::span[contains(@id , 'PasswordRetreival')]";
    }

    public String getShownPassword(String accountName){
        return "//span[text() = '" + accountName + "']/ancestor::*[3]/following-sibling::div/descendant::span[@title = 'Hide Password']";
    }

    public String requestPassword(String accountName){
        return "//span[text() = '" + accountName + "']/ancestor::*[3]/following-sibling::div/descendant::span[text() = 'Request']";
    }

    public String passCheckout(String accountName){
        return "//span[text() = '" + accountName + "']/ancestor::*[3]/following-sibling::div/descendant::span[@id = 'PasswordCheckoutBtn']";
    }

    public String passCheckin(String accountName){
        return "//span[text() = '" + accountName + "']/ancestor::*[3]/following-sibling::div/descendant::span[@id = 'PasswordCheckinBtn']";
    }

    public String userShareAccessType(String userName, String accessType){
        return "//span[@onmouseover = \"Tip('Login name :" + userName +"',this);\"]/ancestor::*[2]/following-sibling::div/descendant::span[text() = '" + accessType + "']";
    }

    public String userShareActionButton(String userName, String access){
        return "//span[@onmouseover = \"Tip('Login name :" + userName +"',this);\"]/ancestor::*[2]/following-sibling::div/descendant::span[text() = '" + access + "']";
    }

    public String userGroupShareActionButton(String userGroupName) {
        return "//span[@onmouseover = \"Tip('" + userGroupName + "',this)\"]/ancestor::*[3]/following-sibling::div/descendant::span[text() = 'Grant']";
    }

    public void accountPage(String resourceName) throws InterruptedException {
        base.waitForElementToBeClickable(resourceTab, 10);
        driver.get(resourcePage);
        Thread.sleep(1000);
        base.waitForElementToBeVisible(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElementToBeVisible(resourceNameSearchTextBox,10);
        resourceNameSearchTextBox.sendKeys(resourceName);
        Thread.sleep(1500);
        resourceNameSearchTextBox.sendKeys(Keys.ENTER);
        Thread.sleep(1500);
        base.waitForElementToBeVisible(driver.findElement(By.xpath(resource(resourceName))),10);
        driver.findElement(By.xpath(resource(resourceName))).click();
    }

    public String resourceAction(String resourceName, String resourceActionOne, String resourceActionTwo) throws InterruptedException {
        String resourceType = "";
        base.waitForElementToBeClickable(resourceTab, 10);
        driver.get(resourcePage);
        Thread.sleep(1500);
        base.waitForElementToBeVisible(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElementToBeVisible(resourceNameSearchTextBox,10);
        resourceNameSearchTextBox.sendKeys(resourceName + Keys.ENTER);
        Thread.sleep(500);
        base.waitForElementToBeVisible(driver.findElement(By.xpath(resourceActionsIcon(resourceName))),10);
        driver.findElement(By.xpath(resourceActionsIcon(resourceName))).click();
        if(resourceActionTwo.equalsIgnoreCase("Remote Password Reset")){
            resourceType = getResourceType(resourceName);
        }
        if (!resourceActionOne.isEmpty()) {
            actions.moveToElement(base.multipleElementsWithoutWait(resourceActionMenuList,resourceActionOne)).perform();
        }
        Thread.sleep(1000);
        base.multipleElementsWithoutWait(resourceActionMenuList,resourceActionTwo).click();
        return resourceType;
    }

    public void resourceBulkSelection(String searchName, String resourceNames) throws InterruptedException {
        String[] resourceNamesArray = resourceNames.split(",");
        int index = 0;
        base.waitForElementToBeClickable(resourceTab, 10);
        driver.get(resourcePage);
        Thread.sleep(1000);
        base.waitForElementToBeVisible(resourceSearchIcon, 10);
        resourceSearchIcon.click();
        base.waitForElementToBeVisible(resourceNameSearchTextBox, 10);
        resourceNameSearchTextBox.sendKeys(searchName);
        Thread.sleep(1500);
        resourceNameSearchTextBox.sendKeys(Keys.ENTER);
        Thread.sleep(1500);
        while(index < resourceNamesArray.length) {
            base.waitForElementToBeVisible(driver.findElement(By.xpath(resourceCheckBoxInTable(resourceNamesArray[index]))),10);
            driver.findElement(By.xpath(resourceCheckBoxInTable(resourceNamesArray[index]))).click();
            index++;
        }
    }

    public void addResourceManually(String resourceName, String dnsName, String resourceType, String withOrWithoutAccount) throws InterruptedException {
        base.waitForElementToBeClickable(resourceTab, 10);
        resourceTab.click();
        base.waitForElementToBeVisible(resourceSearchIcon, 10);
        resourceSearchIcon.click();
        base.waitForElementToBeVisible(resourceNameSearchTextBox, 10);
        resourceNameSearchTextBox.sendKeys(resourceName);
        Thread.sleep(500);
        resourceNameSearchTextBox.sendKeys(Keys.ENTER);
        if(!base.isElementsPresent(driver.findElements(By.xpath(resource(resourceName))))) {
            base.waitForElementToBeVisible(addResourceDropdown, 10);
            addResourceDropdown.click();
            base.multipleElements(addResourceDropdownList, "Add Manually").click();
            base.waitForElementToBeVisible(addResourceName, 10);
            addResourceName.sendKeys(resourceName);
            addResourceDNSName.sendKeys(dnsName);
            base.dropDownSelectText(addResourceResourceTypeDropdown, resourceType);
            if (withOrWithoutAccount.equalsIgnoreCase("with Account"))
                resourceSaveAndProceedButton.click();
            else
                resourceSaveButton.click();
        }else{
            System.out.println("Resource Already Exist");
        }
        Thread.sleep(1000);
        base.waitForElementToBeVisible(resourceClearSearchButton,10);
        resourceClearSearchButton.click();
    }

    public void addAccountManually(String accountName, String passGen, String password, String resourceType, String withOrWithoutAccount) throws InterruptedException {
        if (withOrWithoutAccount.equalsIgnoreCase("without Account")) {
            base.waitForElementToBeVisible(addAccountButton, 10);
            accountSearchIcon.click();
            accountSearchTextBox.sendKeys(accountName);
            Thread.sleep(500);
            accountSearchTextBox.sendKeys(Keys.ENTER);
            if(base.isElementsPresent(searchResultEmpty))
                addAccountButton.click();
            else
                System.out.println("Account is already present");
        }
        base.waitForElementToBeVisible(addAccountAccountName,10);
        addAccountAccountName.sendKeys(accountName);
        if(passGen.equalsIgnoreCase("generate")){
            addAccountPasswordGenerate.click();
        }else {
            addAccountPassword.sendKeys(password);
            addAccountConfirmPassword.sendKeys(password);
        }
        prop.setProperty("TOTPSecretKey",base.generateSecureRandomString(10));
        addAccountTOTPSecretKey.sendKeys(prop.getProperty("TOTPSecretKey"));
        if(!addAccountPasswordResetCheckBox.isSelected()){
            addAccountPasswordResetCheckBox.click();
        }
        if(resourceType.equals("Linux")){
            resourceSaveButton.click();
        } else {
            accountAddButton.click();
            if (base.multipleElements(addedAccountList, accountName).isDisplayed()) {
                System.out.println("Account is added");
                resourceSaveButton.click();
            } else {
                System.out.println("Account is not added");
            }
        }
        dialogTitle = "Account Details";
        base.waitForElementToBeVisible(driver.findElement(By.xpath(dialogCloseIcon(dialogTitle))),10);
        driver.findElement(By.xpath(dialogCloseIcon(dialogTitle))).click();
        base.waitForElementToBeVisible(resourceTab,10);
        resourceClearSearchButton.click();
    }

    public void editResourceManually(String fieldNames , String fieldValues) throws InterruptedException {
        String[] fieldNamesArray = fieldNames.split(",");
        String[] fieldValuesArray = fieldValues.split(",");
        Thread.sleep(1000);
        base.waitForElementToBeVisible(addResourceName,10);
        for (int i = 0; i < fieldNamesArray.length; i++){
            if (prop.getProperty("resourceTextFieldNames").contains(fieldNamesArray[i])) {
                String textFieldXPath = resourceTextCheckboxFields(fieldNamesArray[i], "text");
                driver.findElement(By.xpath(textFieldXPath)).clear();
                driver.findElement(By.xpath(textFieldXPath)).sendKeys(fieldValuesArray[i]);
                continue;
            }
            if (prop.getProperty("resourceHiddenTextFieldNames").contains(fieldNamesArray[i])) {
                String hiddenTextFieldXPath = resourceHiddenTextFields(fieldNamesArray[i]);
                driver.findElement(By.xpath(hiddenTextFieldXPath)).clear();
                driver.findElement(By.xpath(hiddenTextFieldXPath)).sendKeys(fieldValuesArray[i]);
                continue;
            }
            if (prop.getProperty("resourceCheckboxFieldNames").contains(fieldNamesArray[i])) {
                String checkBoxFieldXPath = resourceTextCheckboxFields(fieldNamesArray[i], "checkbox");
                if(fieldValuesArray[i].equalsIgnoreCase("true") && !driver.findElement(By.xpath(checkBoxFieldXPath)).isSelected())
                    driver.findElement(By.xpath(checkBoxFieldXPath)).click();
                if(fieldValuesArray[i].equalsIgnoreCase("false") && driver.findElement(By.xpath(checkBoxFieldXPath)).isSelected())
                    driver.findElement(By.xpath(checkBoxFieldXPath)).click();
                continue;
            }
            if (prop.getProperty("resourceDropdownFieldNames").contains(fieldNamesArray[i])) {
                base.dropDownSelectText(driver.findElement(By.xpath(resourceDropdownFields(fieldNamesArray[i]))),fieldValuesArray[i]);
            }
        }
        resourceSaveButton.click();
        base.waitForElementToBeVisible(resourceClearSearchButton,10);
        resourceClearSearchButton.click();
    }

    public void configureAccessControlInBulk(String[] configureData) throws InterruptedException {
        Thread.sleep(500);
        base.waitForElementToBeVisible(bulkResourceActionsDropdown,10);
        bulkResourceActionsDropdown.click();
        actions.moveToElement(base.multipleElements(bulkResourceActionsDropdownList,"Configure")).perform();
        base.multipleElementsWithoutWait(bulkResourceActionsDropdownSubOptionList,"Access Control").click();
        base.waitForElementToBeVisible(accCntlApprovalAdminTab,10);
        if(!configureData[2].isEmpty()){
            String[] adminUsersArray = configureData[2].split(";");
            accCntlApprovalAdminTab.click();
            base.waitForElementToBeVisible(accCntlApprovalAdminsUsersTab,10);
            accCntlApprovalAdminsUsersTab.click();
            for(String option: adminUsersArray) {
                base.dropDownSelectText(accCntlAllAdmins,option);
                addArrowApprovalAdminUsers.click();
            }
        }
        if(!configureData[3].isEmpty()){
            String[] adminGroupsArray = configureData[3].split(";");
            accCntlApprovalAdminTab.click();
            base.waitForElementToBeVisible(accCntlApprovalAdminsGroupTab,10);
            accCntlApprovalAdminsGroupTab.click();
            for(String option: adminGroupsArray) {
                base.dropDownSelectText(accCntlallAdminGroups,option);
                addArrowApprovalAdminGroups.click();
            }
        }
        if(!configureData[4].isEmpty()){
            String[] excludedUsersArray = configureData[4].split(";");
            accCntlExcludedUsersTab.click();
            base.waitForElementToBeVisible(accCntlExcludedUsersUsersTab,10);
            accCntlExcludedUsersUsersTab.click();
            for(String option: excludedUsersArray) {
                base.dropDownSelectText(accCntlExcludedUsers,option);
                addArrowExcludeUsers.click();
            }
        }
        if(!configureData[5].isEmpty()){
            String[] excludedGroupsArray = configureData[5].split(";");
            accCntlExcludedUsersTab.click();
            base.waitForElementToBeVisible(accCntlExcludedUsersGroupTab,10);
            accCntlExcludedUsersGroupTab.click();
            for(String option: excludedGroupsArray) {
                base.dropDownSelectText(accCntlExcludedGroups,option);
                addArrowExcludeGroups.click();
            }
        }
        accCntlMiscellaneousSettingsTab.click();
        base.waitForElementToBeVisible(accCntlResetPassSettingCheckBox,10);
        base.setCheckbox(accCntlMultipleAdminSettingCheckBox, Boolean.parseBoolean(configureData[6]));
        base.dropDownSelectValue(accCntlMultipleAdminCount,configureData[7]);
        base.setCheckbox(accCntlIsReasonSettingCheckBox, Boolean.parseBoolean(configureData[8]));
        base.setCheckbox(accCntlIsRemindSettingCheckBox, Boolean.parseBoolean(configureData[9]));
        if(!configureData[10].isEmpty())
            accCntlReminderMinutesSettingTextBox.sendKeys(configureData[10]);
        base.setCheckbox(accCntlIsGraceTimeSettingCheckBox, Boolean.parseBoolean(configureData[11]));
        if(!configureData[12].isEmpty())
            accCntlGraceTimeSettingTextBox.sendKeys(configureData[12]);
        base.setCheckbox(accCntlAutoCheckinSettingCheckBox, Boolean.parseBoolean(configureData[13]));
        if(!configureData[14].isEmpty())
            accCntlCheckinTimeSettingTextBox.sendKeys(configureData[14]);
        if(!configureData[15].isEmpty())
            accCntlRequestTimeoutSettingTextBox.sendKeys(configureData[15]);
        if(!configureData[16].isEmpty())
            accCntlCheckoutTimeoutSettingTextBox.sendKeys(configureData[16]);
        base.setCheckbox(accCntlResetPassSettingCheckBox, Boolean.parseBoolean(configureData[17]));
        resourceSaveAndActivateButton.click();
        Thread.sleep(1000);
        base.waitForElementToBeVisible(resourceTab,10);
        resourceClearSearchButton.click();
    }

    public void configureAccessControl(String[] configureData) throws InterruptedException {
        resourceAction(configureData[0], "Configure", "Access Control");
        base.waitForElementToBeVisible(accCntlApprovalAdminTab,10);
        if(!configureData[2].isEmpty()){
            String[] adminUsersArray = configureData[2].split(";");
            accCntlApprovalAdminTab.click();
            base.waitForElementToBeVisible(accCntlApprovalAdminsUsersTab,10);
            accCntlApprovalAdminsUsersTab.click();
            for(String option: adminUsersArray) {
                System.out.println(option);
                base.dropDownSelectText(accCntlAllAdmins,option);
                addArrowApprovalAdminUsers.click();
            }
        }
        if(!configureData[3].isEmpty()){
            String[] adminGroupsArray = configureData[3].split(";");
            accCntlApprovalAdminTab.click();
            base.waitForElementToBeVisible(accCntlApprovalAdminsGroupTab,10);
            accCntlApprovalAdminsGroupTab.click();
            for(String option: adminGroupsArray) {
                base.dropDownSelectText(accCntlallAdminGroups,option);
                addArrowApprovalAdminGroups.click();
            }
        }
        if(!configureData[4].isEmpty()){
            String[] excludedUsersArray = configureData[4].split(";");
            accCntlExcludedUsersTab.click();
            base.waitForElementToBeVisible(accCntlExcludedUsersUsersTab,10);
            accCntlExcludedUsersUsersTab.click();
            for(String option: excludedUsersArray) {
                base.dropDownSelectText(accCntlExcludedUsers,option);
                addArrowExcludeUsers.click();
            }
        }
        if(!configureData[5].isEmpty()){
            String[] excludedGroupsArray = configureData[5].split(";");
            accCntlExcludedUsersTab.click();
            base.waitForElementToBeVisible(accCntlExcludedUsersGroupTab,10);
            accCntlExcludedUsersGroupTab.click();
            for(String option: excludedGroupsArray) {
                base.dropDownSelectText(accCntlExcludedGroups,option);
                addArrowExcludeGroups.click();
            }
        }
        accCntlMiscellaneousSettingsTab.click();
        base.waitForElementToBeVisible(accCntlResetPassSettingCheckBox,10);
        base.setCheckbox(accCntlMultipleAdminSettingCheckBox, Boolean.parseBoolean(configureData[6]));
        base.dropDownSelectValue(accCntlMultipleAdminCount,configureData[7]);
        base.setCheckbox(accCntlIsReasonSettingCheckBox, Boolean.parseBoolean(configureData[8]));
        base.setCheckbox(accCntlIsRemindSettingCheckBox, Boolean.parseBoolean(configureData[9]));
        if(!configureData[10].isEmpty()) {
            accCntlReminderMinutesSettingTextBox.clear();
            accCntlReminderMinutesSettingTextBox.sendKeys(configureData[10]);
        }
        base.setCheckbox(accCntlIsGraceTimeSettingCheckBox, Boolean.parseBoolean(configureData[11]));
        if(!configureData[12].isEmpty()) {
            accCntlGraceTimeSettingTextBox.clear();
            accCntlGraceTimeSettingTextBox.sendKeys(configureData[12]);
        }
        base.setCheckbox(accCntlAutoCheckinSettingCheckBox, Boolean.parseBoolean(configureData[13]));
        if(!configureData[14].isEmpty()) {
            accCntlCheckinTimeSettingTextBox.clear();
            accCntlCheckinTimeSettingTextBox.sendKeys(configureData[14]);
        }
        if(!configureData[15].isEmpty()) {
            accCntlRequestTimeoutSettingTextBox.clear();
            accCntlRequestTimeoutSettingTextBox.sendKeys(configureData[15]);
        }
        if(!configureData[16].isEmpty()) {
            accCntlCheckoutTimeoutSettingTextBox.clear();
            accCntlCheckoutTimeoutSettingTextBox.sendKeys(configureData[16]);
        }
        base.setCheckbox(accCntlResetPassSettingCheckBox, Boolean.parseBoolean(configureData[17]));
        resourceSaveAndActivateButton.click();
        Thread.sleep(1000);
        base.waitForElementToBeVisible(resourceTab,10);
        resourceClearSearchButton.click();
    }

    public void takeRdp() throws InterruptedException {
        base.waitForElementToBeVisible(resourceSearchIcon,10);
        resourceSearchIcon.click();
        Thread.sleep(2000);
        accountSearchTextBox.sendKeys("aakash",Keys.ENTER);
        WebElement accountConnectionIcon;
        Thread.sleep(500);
        accountConnectionIcon = driver.findElement(By.xpath("//span[text() = '" + prop.getProperty("accountName") + "']/ancestor::div/following-sibling::div/span/a/span[@class = 'icon-open-connection iconlf ']"));
        rdpwindowsLaunch.click();
        System.out.println("HI");
        Set<String> allTabs = driver.getWindowHandles();
        String originalTab = driver.getWindowHandle();

        for (String tab : allTabs) {
            if (!tab.equals(originalTab)) {
                // Switch to the newly opened tab
                driver.switchTo().window(tab);

                // Validate the RDP session (e.g., check the URL contains "rdp")
                if (driver.getCurrentUrl().contains("rdp.ma")) {
                    System.out.println("RDP session established successfully.");
                } else {
                    System.out.println("Failed to establish RDP session.");
                }
                System.out.println(driver.getPageSource());
                System.out.println(driver.getTitle());
                System.out.println(driver.getClass());
                // Close the RDP tab and switch back to the original
                //driver.close();
                driver.switchTo().window(originalTab);
            }
        }
    }

    public void shareResourceToUser(String resourceName, String userName, String shareAccess) throws InterruptedException {
        resourceAction(resourceName, "Share", "With Users");
        String[] userArray = userName.split(";");
        for(String user:userArray) {
            base.waitForElementToBeVisible(shareSearchTextBox, 10);
            shareSearchTextBox.sendKeys(user + Keys.ENTER);
            if(shareAccess.equalsIgnoreCase("Revoke") && base.isElementsPresent(driver.findElements(By.xpath(userShareActionButton(user, "Revoke"))))){
                driver.findElement(By.xpath(userShareActionButton(user,"Revoke"))).click();
                continue;
            }
            if(base.isElementsPresent(driver.findElements(By.xpath(userShareAccessType(user,"No Access"))))) {
                base.waitForElementToBeVisible(driver.findElement(By.xpath(userShareActionButton(user, "Grant"))), 10);
                driver.findElement(By.xpath(userShareActionButton(user,"Grant"))).click();
                Thread.sleep(500);
                base.multipleElementsWithoutWait(resourceActionMenuList, shareAccess).click();
            }else {
                base.waitForElementToBeVisible(driver.findElement(By.xpath(userShareActionButton(user, "Change"))), 10);
                driver.findElement(By.xpath(userShareActionButton(user,"Change"))).click();
                Thread.sleep(500);
                //System.out.println(Arrays.toString(resourceActionMenuList.toArray()));
                base.multipleElementsWithoutWait(resourceActionMenuList, shareAccess).click();

            }
            shareSearchClearSearchButton.click();
        }
        base.waitForElementToBeVisible(driver.findElement(By.xpath(dialogCloseIcon("Share"))),10);
        driver.findElement(By.xpath(dialogCloseIcon("Share"))).click();
        if(base.isElementsPresent(resourceClearSearchButtonPresence))
            resourceClearSearchButton.click();
    }

    public void shareResourceToUserGroup(String resourceName, String userGroupName) throws InterruptedException {
        resourceAction(resourceName, "Share", "With User Groups");
        String[] userArray = userGroupName.split(";");
        for(String user:userArray) {
            base.waitForElementToBeVisible(shareSearchTextBox, 10);
            shareSearchTextBox.sendKeys(userGroupName + Keys.ENTER);
            base.waitForElementToBeVisible(driver.findElement(By.xpath(userGroupShareActionButton(userGroupName))), 10);
            driver.findElement(By.xpath(userGroupShareActionButton(userGroupName))).click();
            Thread.sleep(500);
            base.multipleElementsWithoutWait(resourceActionMenuList, "View Passwords").click();
            shareSearchClearSearchButton.click();
        }
        base.waitForElementToBeVisible(driver.findElement(By.xpath(dialogCloseIcon("Share"))),10);
        driver.findElement(By.xpath(dialogCloseIcon("Share"))).click();
        if(base.isElementsPresent(resourceClearSearchButtonPresence))
            resourceClearSearchButton.click();
    }

    public void requestPasswordAccess(String resourceName, String accountName, String timing , int minutes) throws InterruptedException {
        driver.get(resourcePage);
        Thread.sleep(500);
        base.waitForElementToBeVisible(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElementToBeVisible(resourceNameSearchTextBox,10);
        resourceNameSearchTextBox.sendKeys(resourceName + Keys.ENTER);
        Thread.sleep(500);
        base.waitForElementToBeVisible(driver.findElement(By.xpath(resource(resourceName))),10);
        driver.findElement(By.xpath(resource(resourceName))).click();
        base.waitForElementToBeVisible(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElementToBeVisible(accountSearchTextBox,10);
        accountSearchTextBox.sendKeys(accountName + Keys.ENTER);
        Thread.sleep(500);
        driver.findElement(By.xpath(requestPassword(accountName))).click();
        if (timing.equalsIgnoreCase("Now")) {
            base.waitForElementToBeVisible(passRequestNowButton,10);
            passRequestNowButton.click();

        } else if (timing.equalsIgnoreCase("Later")) {
            base.waitForElementToBeVisible(passRequestLaterButton,10);
            passRequestLaterButton.click();
            base.waitForElementToBeVisible(passRequestStartDate,10);
            //LocalDate currentDate = LocalDate.now();
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            js.executeScript("arguments[0].value=arguments[1];",passRequestStartDate,formattedDate);
            js.executeScript("arguments[0].value=arguments[1];",passRequestEndDate,formattedDate);
            int currentHour = LocalTime.now().getHour();
            int currentMinutes = LocalTime.now().getMinute();
            int startMinutes = 5*(currentMinutes/5+1);
            if(startMinutes >= 60) {
                currentHour = currentHour+(startMinutes/60);
                if(currentHour >= 24) {
                    js.executeScript("arguments[0].value=arguments[1];",passRequestEndDate,LocalDate.now().plusDays(currentHour/24).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                }
                currentHour %= 24;
            }
            startMinutes %= 60;
            String setHourString = String.format("%02d" , currentHour);
            String setMinuteString = String.format("%02d" , startMinutes);
            base.dropDownSelectText(passRequestStartTimeHour,setHourString);
            base.dropDownSelectText(passRequestStartTimeMinute,setMinuteString);
            int endMinutes = startMinutes + minutes;
            int endHour = currentHour;
            if(endMinutes >= 60) {
                endHour = endHour+(endMinutes/60);
                if(endHour >= 24) {
                    js.executeScript("arguments[0].value=arguments[1];",passRequestEndDate,LocalDate.now().plusDays(endHour/24).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                }
                endHour %= 24;
            }
            endMinutes %= 60;
            setHourString = String.format("%02d" , endHour);
            setMinuteString = String.format("%02d" , endMinutes);
            base.dropDownSelectText(passRequestEndTimeHour,setHourString);
            base.dropDownSelectText(passRequestEndTimeMinute,setMinuteString);
        }
        passRequestCommentsTextbox.sendKeys(prop.getProperty("passRequestReason"));
        resourceSendButton.click();
        driver.findElement(By.xpath(dialogCloseIcon("Account Details"))).click();
    }

    public void passCheckout(String resourceName, String accountName) throws InterruptedException {
        driver.get(resourcePage);
        Thread.sleep(500);
        base.waitForElementToBeVisible(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElementToBeVisible(resourceNameSearchTextBox,10);
        resourceNameSearchTextBox.sendKeys(resourceName + Keys.ENTER);
        Thread.sleep(500);
        base.waitForElementToBeVisible(driver.findElement(By.xpath(resource(resourceName))),10);
        driver.findElement(By.xpath(resource(resourceName))).click();
        base.waitForElementToBeVisible(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElementToBeVisible(accountSearchTextBox,10);
        accountSearchTextBox.sendKeys(accountName + Keys.ENTER);
        Thread.sleep(500);
        driver.findElement(By.xpath(passCheckout(accountName))).click();
        base.waitForElementToBeVisible(driver.findElement((By.xpath(dialogCloseIcon("Password Checkout")))),10);
        if(passCheckoutButton.getAttribute("disabled") != null) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(passCheckoutInstruction.getText());
            if (matcher.find()) {
                Thread.sleep((long) Integer.parseInt(matcher.group()) *60*1000);
            }
            driver.findElement(By.xpath(dialogCloseIcon("Password Checkout"))).click();
            driver.findElement(By.xpath(passCheckout(accountName))).click();
        }
        base.waitForElementToBeVisible(passCheckoutButton,10);
        passCheckoutButton.click();
        Thread.sleep(1000);
        getPassword(accountName);
        base.waitForElementToBeVisible(driver.findElement(By.xpath(dialogCloseIcon("Account Details"))),10);
        driver.findElement(By.xpath(dialogCloseIcon("Account Details"))).click();
        Thread.sleep(1000);
        base.waitForElementToBeVisible(resourceTab,10);
        resourceClearSearchButton.click();
    }

    public void getPassword(String accountName){
        base.waitForElementToBeVisible(driver.findElement(By.xpath(clickHiddenPassword(accountName))),10);
        driver.findElement(By.xpath(clickHiddenPassword(accountName))).click();
        System.out.println(driver.findElement(By.xpath(getShownPassword(accountName))).getText());
    }

    public void passCheckin(String resourceName, String accountName) throws InterruptedException {
        driver.get(resourcePage);
        Thread.sleep(500);
        base.waitForElementToBeVisible(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElementToBeVisible(resourceNameSearchTextBox,10);
        resourceNameSearchTextBox.sendKeys(resourceName + Keys.ENTER);
        Thread.sleep(500);
        base.waitForElementToBeVisible(driver.findElement(By.xpath(resource(resourceName))),10);
        driver.findElement(By.xpath(resource(resourceName))).click();
        base.waitForElementToBeVisible(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElementToBeVisible(accountSearchTextBox,10);
        accountSearchTextBox.sendKeys(accountName + Keys.ENTER);
        Thread.sleep(500);
        driver.findElement(By.xpath(passCheckin(accountName))).click();
        base.waitForElementToBeVisible(passCheckinButton,10);
        passCheckinButton.click();
        base.waitForElementToBeVisible(driver.findElement(By.xpath(requestPassword(accountName))),10);
        driver.findElement(By.xpath(dialogCloseIcon("Account Details"))).click();
        Thread.sleep(1000);
        base.waitForElementToBeVisible(resourceTab,30);
        Thread.sleep(1000);
        resourceClearSearchButton.click();
    }

    public void discoverResources() throws InterruptedException {
        base.waitForElementToBeClickable(resourceTab, 10);
        driver.get(resourcePage);
        Thread.sleep(500);
        resourceDiscoveryButton.click();
        base.waitForElementToBeVisible(resourcesNewDomainButton,10);
        resourcesNewDomainButton.click();
        base.waitForElementToBeVisible(resourcesNewDomainTextBox,10);
        resourcesNewDomainTextBox.sendKeys("PMP2019");
        resourcesAddButton.click();
        adPrimaryDomainControllerTextBox.sendKeys("PMP2K19");
        adSpecifyUsernameAndPasswordManuallyRadioButton.click();
        adUserName.clear();
        adUserName.sendKeys("suaravind");
        adPassword.clear();
        adPassword.sendKeys("Test@123");
        adPasswordPolicy.click();
        base.dropDownSelectText(adPasswordPolicy,"Medium");
        adGroupsToImport.clear();
        adGroupsToImport.sendKeys("1Computers");
        Thread.sleep(1500);
        userImportButton.click();
        Thread.sleep(3000);
        //adUserImportCloseButton.click();
        base.waitForElementToBeVisible(adRedirectResources,10);
        adRedirectResources.click();
    }

    public void changePassword(String accountName, String passwordType, String newPassword, String remoteLocalCheckBox) throws InterruptedException {
        base.waitForElementToBeVisible(accountSearchIcon,10);
        accountSearchIcon.click();
        base.waitForElementToBeVisible(accountSearchTextBox,10);
        accountSearchTextBox.sendKeys(accountName);
        Thread.sleep(1500);
        accountSearchTextBox.sendKeys(Keys.ENTER);
        Thread.sleep(1500);
        base.waitForElementToBeVisible(driver.findElement(By.xpath(accountActionsIcon(accountName))),10);
        driver.findElement(By.xpath(accountActionsIcon(accountName))).click();
        base.multipleElements(accountActionsOptions,"Change Password").click();
        base.waitForElementToBeVisible(driver.findElement(By.xpath(dialogCloseIcon("Change Password"))),10);
        if(passwordType.equalsIgnoreCase("Given Password")){
            changePassNewPasswordTextBox.sendKeys(newPassword);
            changePassConfirmPasswordTextBox.sendKeys(newPassword);
        }else{
            changePassGeneratePasswordIcon.click();
        }
        if(remoteLocalCheckBox.equalsIgnoreCase("Local"))
            changePassRemoteCheckBox.click();
        resourceSaveButton.click();
        if(base.waitForElementsAttributeToChange(changePassErrorMessageContainer,"class", "pmpshow")){
            Thread.sleep(2000);
            System.out.println(changePassErrorMessage.getText());
            System.out.println("inside the if condition");
            driver.findElement(By.xpath(dialogCloseIcon("Change Password"))).click();
        }
        else
            System.out.println("if case failed");
        Thread.sleep(1000);
        base.waitForElementToBeVisible(driver.findElement(By.xpath(dialogCloseIcon("Account Details"))),10);
        driver.findElement(By.xpath(dialogCloseIcon("Account Details"))).click();
        base.waitForElementToBeVisible(resourceClearSearchButton,5);
        resourceClearSearchButton.click();
    }

    public void bulkResetPassword(String newPassword,String remoteLocalCheckBox) throws InterruptedException {
        Thread.sleep(500);
        base.waitForElementToBeVisible(bulkResourceActionsDropdown,10);
        bulkResourceActionsDropdown.click();
        Thread.sleep(500);
        base.multipleElementsWithoutWait(bulkResourceActionsDropdownList,"Reset Passwords").click();
        base.waitForElementToBeVisible(driver.findElement(By.xpath(pageTitle("Reset Passwords"))),10);
        System.out.println("reset pass one");
        bulkResetPassPasswordToUseRadioButton.click();
        base.waitForElementToBeVisible(bulkResetPassPasswordTextBox,10);
        bulkResetPassPasswordTextBox.sendKeys(newPassword);
        System.out.println("two");
        if(remoteLocalCheckBox.equalsIgnoreCase("Local")) {
            bulkResetPassRemoteResetCheckBox.click();
            System.out.println("three");
        }
        Thread.sleep(5000);
        resourceSaveButton.click();
    }

    public void configureRemotePasswordReset(String resourceType, String resource, String domainResourceName, String accountName) throws InterruptedException {
        System.out.println(accountName);
        System.out.println(resource);
        base.waitForElementToBeVisible(driver.findElement(By.xpath(dialogCloseIcon("Configure Remote Login Credentials"))),10);
        String[] resourceTypes = prop.getProperty("linuxTypeResources").split(",");
        for (String type: resourceTypes){
            if(resourceType.equalsIgnoreCase(type)){
                if(resource.equalsIgnoreCase("local")) {
                    remotePassResetLinuxSameResourceButton.click();
                    base.waitForElementToBeVisible(remotePassResetLinuxSameResourceAccount,10);
                    base.dropDownSelectValue(remotePassResetLinuxSameResourceAccount, accountName);
                }
                else {
                    remotePassResetLinuxDomainResourceButton.click();
                    base.waitForElementToBeVisible(remotePassResetLinuxDomainResourceResourceName,10);
                    base.dropDownSelectValue(remotePassResetLinuxDomainResourceResourceName, domainResourceName);
                    base.dropDownSelectValue(remotePassResetLinuxDomainResourceAccount, accountName);
                }
                remotePassResetLinuxElevationTypeSudo.click();
                resourceSaveButton.click();
                break;
            }
        }
        if(resourceType.equalsIgnoreCase("Windows")){
            if(resource.equalsIgnoreCase("local")) {
                remotePassResetWindowsSameResourceButton.click();
                base.waitForElementToBeVisible(remotePassResetWindowsSameResourceAccount,10);
                remotePassResetWindowsSameResourceAccount.click();
                base.multipleElementsWithoutWait(zSelectOptions,accountName).click();
            }
            else {
                remotePassResetWindowsDomainResourceButton.click();
                base.waitForElementToBeVisible(remotePassResetWindowsDomainResourceResourceName,10);
                base.dropDownSelectValue(remotePassResetWindowsDomainResourceResourceName, domainResourceName);
                Thread.sleep(1000);
                base.multipleElementsWithoutWait(zSelectOptions,accountName).click();
            }
            resourceSaveButton.click();
        } else if (resourceType.equalsIgnoreCase("WindowsDomain")){
            if(resource.equalsIgnoreCase("local")) {
                remotePassResetLinuxSameResourceButton.click();
                base.waitForElementToBeVisible(remotePassResetWindowsDomainSameResourceAccount,10);
                remotePassResetWindowsDomainSameResourceAccount.click();
                base.multipleElementsWithoutWait(zSelectOptions,accountName).click();
            }
            else {
                remotePassResetLinuxDomainResourceButton.click();
                base.waitForElementToBeVisible(remotePassResetWindowsDomainResourceResourceName,10);
                base.dropDownSelectText(remotePassResetWindowsDomainResourceResourceName, domainResourceName);
                Thread.sleep(1000);
                base.multipleElementsWithoutWait(zSelectOptions,accountName).click();
            }
            resourceSaveButton.click();
        }
        base.waitForElementToBeVisible(resourceClearSearchButton,10);
        Thread.sleep(1000);
        resourceClearSearchButton.click();
    }

    public void transferResourceOwnership(String newOwner) throws InterruptedException {
        base.waitForElementToBeVisible(driver.findElement(By.xpath(pageTitle("Transfer Resource Ownership"))),10);
        base.dropDownSelectText(transferOwnershipNewOwner, newOwner);
        resourceSaveButton.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(dialogCloseIcon("Transfer Resource Ownership")));
    }
}
