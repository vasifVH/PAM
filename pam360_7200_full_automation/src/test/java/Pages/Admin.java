package Pages;

import BasePackage.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static Hooks.Hooks.prop;

public class Admin{
    WebDriver driver;
    BaseClass base;
    Actions actions;
    JavascriptExecutor js;
    Select dropdown;

    String adminPage = prop.getProperty("url") + "PassTrixMain.cc#/admin/adminMain";

    @FindBy(xpath = "//span[text() = 'Admin']")
    static WebElement adminTab;

    @FindBy(xpath = "//div[@id = 'adminContainer']/div/ul/li/span/a")
    static List<WebElement> adminAction;

    @FindBy(xpath = "//input[@id='search-text']")
    static WebElement adminTabSearchTextbox;

    @FindBy(xpath = "//button[@id='searchButtonId']")
    static WebElement adminSearchIcon;

    @FindBy(xpath = "//ul[@id='adminDrpDownSelect']/li/a")
    static List<WebElement> adminTabSearchResults;

    @FindBy(xpath = "//input[@columnname = 'RESOURCENAME']")
    static WebElement adminResourceSearchTextbox;

    @FindBy(xpath = "//input[@columnname = 'LOGINNAME']")
    static WebElement adminAccountSearchTextbox;

    @FindBy(xpath = "//em[text() = 'Approve']")
    static WebElement adminApproveButton;

    @FindBy(xpath = "//em[text() = 'Reject']")
    static WebElement adminRejectButton;

    @FindBy(xpath = "//div[@class = 'pageTitle']")
    static WebElement adminPageTitle;

    @FindBy(xpath = "//em[text() = 'Save']")
    static WebElement saveButton;

    @FindBy(xpath = "//em[text() = 'Cancel']")
    static WebElement cancelButton;

    //AuthenticationSection

    @FindBy(xpath = "//em[text() = 'Enable Now']")
    static WebElement authenticationEnableNowButton;

    @FindBy(xpath = "//em[text() = 'Enable']")
    static WebElement authenticationDisableButton;

    @FindBy(xpath = "//span[@id = 'STATUS_TXT']")
    static WebElement authentiationCurrentStatus;

    //Mail Server Settings

    @FindBy(xpath = "//input[@name = 'serverName']")
    static WebElement mailSettingsServerName;

    @FindBy(xpath = "//input[@name = 'port']")
    static WebElement mailSettingsPort;

    @FindBy(xpath = "//input[@name = 'defaultFrom']")
    static WebElement mailSettingsSenderEMailAddress;

    //PasswordAccessRequest

    @FindBy(xpath = "//ul[@id='RequestsViewUl']/li/a/span")
    static List<WebElement> requestsListInPassAccessRequests;

    @FindBy(xpath = "//label[text() = 'Now']")
    static WebElement passAccessApprovalNowButton;

    @FindBy(xpath = "//label[text() = 'Later']")
    static WebElement passAccessApprovalLaterButton;

    @FindBy(xpath = "//input[@name = 'startDate']")
    static WebElement passAccessApprovalStartDate;

    @FindBy(xpath = "//input[@name = 'endDate']")
    static WebElement passAccessApprovalEndDate;

    @FindBy(xpath = "//select[@name = 'startTimeH']")
    static WebElement passAccessApprovalStartTimeHour;

    @FindBy(xpath = "//select[@name = 'startTimeM']")
    static WebElement passAccessApprovalStartTimeMinute;

    @FindBy(xpath = "//select[@name = 'endTimeH']")
    static WebElement passAccessApprovalEndTimeHour;

    @FindBy(xpath = "//select[@name = 'endTimeM']")
    static WebElement passAccessApprovalEndTimeMinute;

    @FindBy(xpath = "//textarea[@id = 'reason']")
    static WebElement passAccessApprovalReasonTextbox;

    //Manage Agents

    @FindBy(xpath = "//div[text() = 'Manage Agents']")
    static WebElement manageAgentsPage;

    @FindBy(xpath = "//ul[@role = 'menu']/li/a[@role = 'menuitem']")
    static List<WebElement> agentActionMenuItems;

    //Organization

    @FindBy(xpath = "//a[text() = 'Add Organization']")
    static WebElement addOrganizationButton;

    @FindBy(xpath = "//input[@id = 'orgname']")
    static WebElement orgName;

    @FindBy(xpath = "//input[@id = 'orgLoginUrl']")
    static WebElement orgDisplayName;

    @FindBy(xpath = "//select[@id = 'contactname']")
    static WebElement orgAccountManager;

    @FindBy(xpath = "//input[@name = 'dept']")
    static WebElement orgDepartment;

    @FindBy(xpath = "//input[@name = 'location']")
    static WebElement orgLocation;

    @FindBy(xpath = "//input[@name = 'city']")
    static WebElement orgCity;

    @FindBy(xpath = "//input[@name = 'state']")
    static WebElement orgState;

    @FindBy(xpath = "//input[@name = 'country']")
    static WebElement orgCountry;

    @FindBy(xpath = "//input[@name = 'zipcode']")
    static WebElement orgCountryCode;

    public Admin (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.base = new BaseClass(this.driver);
        actions = new Actions(this.driver);
        js = (JavascriptExecutor) this.driver;
    }

    public String dialogCloseIcon(String pageTitle){
        return "//span[contains(text() , '" + pageTitle + "')]/following::button[@title = 'Close']";
    }

    public String pageTitle(String pageTitle){
        return "//span[contains(text() , '" + pageTitle + "')]";
    }

    public String selectAdminAction(String actionName){
        return "//div[@id = 'adminContainer']/div/ul/li/span[@onmouseover = \"showAdminPageTip('" + actionName + "',this)\"]/a";
    }

    public String passAccessProcessRequestButton(String accountName) {
        return "//span[text() ='" + accountName +"']/ancestor::*[1]/following-sibling::div/descendant::span[text() = 'Process Request']";
    }

    public String agentActionButton(String resourceName){
        return "//span[text() = '" + resourceName + "']/parent::div/following-sibling::div/child::span/div";
    }

    public void approvePasswordRequest(String approval, String resourceName, String accountName, String approvalTiming, int approvalMinutes) throws InterruptedException {
        base.waitForElementToBeVisible(adminTab, 10);
        driver.get(adminPage);
        base.waitForElementToBeVisible(adminTabSearchTextbox,10);
        adminTabSearchTextbox.sendKeys("Password Access Requests");
        Thread.sleep(2000);
        base.multipleElementsWithoutWait(adminTabSearchResults, "Password Access Requests").click();
//        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(selectAdminAction("Password Access Requests"))));
//        driver.findElement(By.xpath(selectAdminAction("Password Access Requests"))).click();
//        Thread.sleep(1000);
        base.isElementsPresent(requestsListInPassAccessRequests);
        base.multipleElements(requestsListInPassAccessRequests,"Password Access").click();
        base.waitForElementToBeVisible(adminSearchIcon, 10);
        adminSearchIcon.click();
        base.waitForElementToBeVisible(adminResourceSearchTextbox, 10);
        adminResourceSearchTextbox.sendKeys(resourceName);
        adminAccountSearchTextbox.sendKeys(accountName + Keys.ENTER);
        Thread.sleep(500);
        base.waitForElementToBeVisible(driver.findElement(By.xpath(passAccessProcessRequestButton(accountName))), 10);
        driver.findElement(By.xpath(passAccessProcessRequestButton(accountName))).click();
        base.waitForElementToBeVisible(passAccessApprovalReasonTextbox, 10);
        passAccessApprovalReasonTextbox.sendKeys(prop.getProperty("passApprovalReason"));
        if(approval.equalsIgnoreCase("approve") && approvalMinutes == 0){
            if("Now".equalsIgnoreCase(approvalTiming))
                passAccessApprovalNowButton.click();
            adminApproveButton.click();
            return;
        }
        if (approval.equalsIgnoreCase("approve") && approvalMinutes > 0) {
            passAccessApprovalLaterButton.click();
            String formattedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", passAccessApprovalStartDate, formattedDate);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", passAccessApprovalEndDate, formattedDate);
            int currentHour = LocalTime.now().getHour();
            int currentMinutes = LocalTime.now().getMinute();
            int startMinutes = 5 * (currentMinutes / 5 + 1);
            startMinutes %= 60;
            prop.setProperty("checkoutTime", String.valueOf(startMinutes));
            String setHourString = String.format("%02d", currentHour);
            String setMinuteString = String.format("%02d", startMinutes);
            base.dropDownSelectText(passAccessApprovalStartTimeHour, setHourString);
            base.dropDownSelectText(passAccessApprovalStartTimeMinute, setMinuteString);
            int endMinutes = startMinutes + approvalMinutes;
            int endHour = currentHour;
            if (endMinutes >= 60) {
                endHour = endHour + (endMinutes / 60);
                if (endHour >= 24) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", passAccessApprovalEndDate, LocalDate.now().plusDays(endHour / 24).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                }
                endHour %= 24;
            }
            endMinutes %= 60;
            setHourString = String.format("%02d", endHour);
            setMinuteString = String.format("%02d", endMinutes);
            base.dropDownSelectText(passAccessApprovalEndTimeHour, setHourString);
            base.dropDownSelectText(passAccessApprovalEndTimeMinute, setMinuteString);
            adminApproveButton.click();
        } else
            adminRejectButton.click();

    }

    public void authenticationEnableDisable(String authType, String requiredStatus){
        base.waitForElementToBeVisible(adminTab,10);
        if ((driver.findElements(By.xpath(selectAdminAction(authType)))).isEmpty()) {
            js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(selectAdminAction(authType))));
        }
        driver.findElement((By.xpath(selectAdminAction(authType)))).click();
        base.waitForElementToBeVisible(adminPageTitle,10);
        if(requiredStatus.equalsIgnoreCase("enable") && (authentiationCurrentStatus.getText().equalsIgnoreCase("Disabled") || authentiationCurrentStatus.getText().equalsIgnoreCase("Disable"))){
            authenticationEnableNowButton.click();
        } else if(requiredStatus.equalsIgnoreCase("disable") && (authentiationCurrentStatus.getText().equalsIgnoreCase("Enabled") || authentiationCurrentStatus.getText().equalsIgnoreCase("Enable"))){
            authenticationDisableButton.click();
        }
        adminTab.click();
    }

    public void enableActiveDirectoryAuthentication(){
        base.waitForElementToBeVisible(adminTab, 10);
        driver.get(adminPage);
        authenticationEnableDisable("Microsoft Entra ID", "disable");
        authenticationEnableDisable("LDAP", "disable");
        authenticationEnableDisable("SAML Single Sign-On", "disable");
        authenticationEnableDisable("RADIUS", "disable");
        authenticationEnableDisable("Smart Card / PKI / Certificate", "disable");
        authenticationEnableDisable("Active Directory", "enable");
    }

    public void enableMicrosoftEntraIDAuthentication(){
        base.waitForElementToBeVisible(adminTab, 10);
        driver.get(adminPage);
        authenticationEnableDisable("LDAP", "disable");
        authenticationEnableDisable("SAML Single Sign-On", "disable");
        authenticationEnableDisable("RADIUS", "disable");
        authenticationEnableDisable("Smart Card / PKI / Certificate", "disable");
        authenticationEnableDisable("Active Directory", "disable");
        authenticationEnableDisable("Microsoft Entra ID", "enable");
    }

    public void enableLDAPAuthentication(){
        base.waitForElementToBeVisible(adminTab, 10);
        driver.get(adminPage);
        authenticationEnableDisable("Microsoft Entra ID", "disable");
        authenticationEnableDisable("SAML Single Sign-On", "disable");
        authenticationEnableDisable("RADIUS", "disable");
        authenticationEnableDisable("Smart Card / PKI / Certificate", "disable");
        authenticationEnableDisable("Active Directory", "disable");
        authenticationEnableDisable("LDAP", "enable");
    }

    public void configureMailServerSettings() throws InterruptedException {
        base.waitForElementToBeVisible(adminTab, 10);
        driver.get(adminPage);
        base.waitForElementToBeVisible(adminTab,10);
        if ((driver.findElements(By.xpath(selectAdminAction("Mail Server Settings")))).isEmpty()) {
            js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(selectAdminAction("Mail Server Settings"))));
        }
        driver.findElement(By.xpath(selectAdminAction("Mail Server Settings"))).click();
        Thread.sleep(1000);
        base.waitForElementToBeVisible(mailSettingsServerName,10);
        mailSettingsServerName.clear();
        mailSettingsServerName.sendKeys("localhost");
        mailSettingsPort.clear();
        mailSettingsPort.sendKeys("25");
        mailSettingsSenderEMailAddress.clear();
        mailSettingsSenderEMailAddress.sendKeys("test@test.com");
        saveButton.click();
    }

    public void manageAgent(String agentAction, String resourceName) throws InterruptedException {
        base.waitForElementToBeVisible(adminTab, 10);
        driver.get(adminPage);
        base.waitForElementToBeVisible(adminTab,10);
        if ((driver.findElements(By.xpath(selectAdminAction("Manage Agents")))).isEmpty()) {
            js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(selectAdminAction("Manage Agents"))));
        }
        driver.findElement(By.xpath(selectAdminAction("Manage Agents"))).click();
        Thread.sleep(1000);
        base.waitForElementToBeVisible(manageAgentsPage,10);
        driver.findElement(By.xpath(agentActionButton(resourceName))).click();
        base.multipleElements(agentActionMenuItems,agentAction);
    }

    public void addOrganization() throws InterruptedException {
        base.waitForElementToBeVisible(adminTab, 10);
        driver.get(adminPage);
        base.waitForElementToBeVisible(adminTab,10);
        if ((driver.findElements(By.xpath(selectAdminAction("Manage Agents")))).isEmpty()) {
            js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(selectAdminAction("Manage Agents"))));
        }
        driver.findElement(By.xpath(selectAdminAction("Manage Agents"))).click();
        Thread.sleep(1000);
        base.waitForElementToBeVisible(adminPageTitle,10);
        addOrganizationButton.click();
        base.waitForElementToBeVisible(driver.findElement(By.xpath(pageTitle("Add Organization"))),10);
        orgName.sendKeys("org");
        orgDisplayName.sendKeys("org");
        base.dropDownSelectText(orgAccountManager," user1 - user 1 ");
        orgDepartment.sendKeys("dept");
        orgLocation.sendKeys("location");
        orgCity.sendKeys("chennai");
        orgState.sendKeys("tamil nadu");
        orgCountry.sendKeys("IN");
        orgCountryCode.sendKeys("624008");
        saveButton.click();
    }
}
