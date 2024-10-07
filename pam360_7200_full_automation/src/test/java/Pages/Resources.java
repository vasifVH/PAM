package Pages;

import BasePackage.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    Select dropdown;

    String resourcePage = prop.getProperty("url") + "PassTrixMain.cc#/PasswordFullView/PasswordMainView";
    WebElement resource;
    String dialogTitle = "";
    //String resourceCloseIcon = "//span[contains(text() , '" + dialogTitle + "')]/parent::span/following-sibling::button[@title = 'Close']";

    @FindBy(xpath = "//button[@id='searchButtonId']")
    public static WebElement resourceSearchIcon;

    @FindBy(xpath = "//em[text() = 'Clear Search']")
    static WebElement resourceClearSearchButton;

    @FindBy(xpath = "//input[@columnname='PTRX_LNAME'][position()=1]")
    static WebElement accountSearch;

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

    @FindBy(xpath = "//div[text() = 'Resource Actions']")
    static WebElement bulkResourceActionsDropdown;

    @FindBy(xpath = "//div[text() = 'Resource Actions']/following-sibling::div/ul/li/a")
    static List<WebElement> bulkResourceActionsDropdownList;

    @FindBy(xpath = "//div[text() = 'Resource Actions']/following-sibling::div/ul/li/ul/li/a")
    static List<WebElement> bulkResourceActionsDropdownSubOptionList;

    @FindBy(xpath = "//li[contains(@class , 'ui-menu-item')]/a")
    static List<WebElement> resourceActionMenuList;

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

    @FindBy(xpath = "//input[@id='Usr1']")
    static WebElement addAccountAccountName;

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

    //Configure Access Control Dialog box WebElements:

    @FindBy(xpath = "//li[@id = 'AdminView_li']")
    static WebElement accCntlApprovalAdminTab;

    @FindBy(xpath = "//li[@id = 'ExcludeView_li']")
    static WebElement accCntlExcludedUsersTab;

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

    @FindBy(xpath = "//div[@onclick = 'return addadmin();']")
    static WebElement addArrowApprovalAdminUsers;

    @FindBy(xpath = "//div[@onclick = \"return addadmingroup('PasswordUserGroup','ADMINGROUP');\"]")
    static WebElement addArrowApprovalAdminGroups;

    @FindBy(xpath = "//div[@onclick = 'return addpassadmin();']")
    static WebElement addArrowExcludeUsers;

    @FindBy(xpath = "//div[@onclick = 'return addadmingroup('ExcludePasswordUserGroup','ExcludePasswordUserGroup1');")
    static WebElement addArrowExcludeGroups;

    @FindBy(xpath = "//span[@title = 'guest']/ancestor::div/following-sibling::div/descendant::span[text() = 'Grant']")
    static WebElement share;

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

    public Resources (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.base = new BaseClass(this.driver);
        actions = new Actions(this.driver);
        js = (JavascriptExecutor) this.driver;
    }

    public String resourceCloseIcon(String dialogTitle) {
        return "//span[contains(text() , '" + dialogTitle + "')]/following::button[@title = 'Close']";
    }

    public String resource(String resourceName){
        return "//a[text() = '" + resourceName + "']";
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

    public void addResourceManually() {
        base.waitForElementToBeClickable(resourceTab, 10);
        resourceTab.click();
        base.waitForElement(addResourceDropdown,10);
        addResourceDropdown.click();
        base.multipleElements(addResourceDropdownList, "Add Manually").click();
        base.waitForElement(addResourceName,10);
        addResourceName.sendKeys(prop.getProperty("resourceName"));
        addResourceDNSName.sendKeys(prop.getProperty("DNSName"));
        dropdown = new Select(addResourceResourceTypeDropdown);
        dropdown.selectByVisibleText(prop.getProperty("resourceType"));
        resourceSaveButton.click();
    }

    public void addAccountManually() throws InterruptedException {
        Thread.sleep(1000);
        base.waitForElement(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElement(resourceNameSearchTextBox,10);
        resourceNameSearchTextBox.sendKeys(prop.getProperty("resourceName"));
        Thread.sleep(1500);
        resourceNameSearchTextBox.sendKeys(Keys.ENTER);
        Thread.sleep(1500);
        base.waitForElement(driver.findElement(By.xpath(resource(prop.getProperty("resourceName")))),10);
        driver.findElement(By.xpath(resource(prop.getProperty("resourceName")))).click();
        base.waitForElement(addAccountButton,10);
        addAccountButton.click();
        base.waitForElement(addAccountAccountName,10);
        addAccountAccountName.sendKeys(prop.getProperty("accountName"));
        addAccountPassword.sendKeys(prop.getProperty("accountPassword"));
        addAccountConfirmPassword.sendKeys(prop.getProperty("accountPassword"));
        prop.setProperty("TOTPSecretKey",base.generateSecureRandomString(10));
        addAccountTOTPSecretKey.sendKeys(prop.getProperty("TOTPSecretKey"));
        if(!addAccountPasswordResetCheckBox.isSelected()){
            addAccountPasswordResetCheckBox.click();
        }
        if(prop.getProperty("resourceType").equals("Linux")){
            resourceSaveButton.click();
        } else {
            accountAddButton.click();
            if (base.multipleElements(addedAccountList, prop.getProperty("accountName")).isDisplayed()) {
                System.out.println("Account is added");
                resourceSaveButton.click();
            } else {
                System.out.println("Account is not added");
            }
        }
        dialogTitle = "Account Details";
        base.waitForElement(driver.findElement(By.xpath(resourceCloseIcon(dialogTitle))),10);
        driver.findElement(By.xpath(resourceCloseIcon(dialogTitle))).click();
        base.waitForElement(resourceTab,10);
        if(base.isElementPresent(resourceClearSearchButton,5)){
            resourceClearSearchButton.click();
        }
    }

    public void editResourceManually(){

    }

    public void configureAccessControl() throws InterruptedException {
        base.waitForElementToBeClickable(resourceTab, 10);
        driver.get(resourcePage);
        Thread.sleep(500);
        base.waitForElement(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElement(resourceNameSearchTextBox,10);
        resourceNameSearchTextBox.sendKeys(prop.getProperty("resourceName") + Keys.ENTER);
        Thread.sleep(500);
        WebElement resourceSelectCheckbox;
        Thread.sleep(500);
        resourceSelectCheckbox = driver.findElement(By.xpath("//a[text() = '" + prop.getProperty("resourceName") + "']/ancestor::div/div/span/input[@name = 'rowSelection']"));
        base.waitForElement(resourceSelectCheckbox,10);
        resourceSelectCheckbox.click();
        base.waitForElement(bulkResourceActionsDropdown,10);
        bulkResourceActionsDropdown.click();
        actions.moveToElement(base.multipleElements(bulkResourceActionsDropdownList,"Configure")).perform();
        base.multipleElementsWithoutWait(bulkResourceActionsDropdownSubOptionList,"Access Control").click();
        base.waitForElement(accCntlApprovalAdminTab,10);
        if(!prop.getProperty("adminUsers").isEmpty()){
            String[] adminUsersArray = prop.getProperty("adminUsers").split(",");
            accCntlApprovalAdminTab.click();
            base.waitForElement(accCntlApprovalAdminsUsersTab,10);
            accCntlApprovalAdminsUsersTab.click();
            for(String option: adminUsersArray) {
                dropdown= new Select(accCntlAllAdmins);
                dropdown.selectByVisibleText(option);
                addArrowApprovalAdminUsers.click();
            }
        }
        if(!prop.getProperty("adminGroups").isEmpty()){
            String[] adminGroupsArray = prop.getProperty("adminGroups").split(",");
            accCntlApprovalAdminTab.click();
            base.waitForElement(accCntlApprovalAdminsGroupTab,10);
            accCntlApprovalAdminsGroupTab.click();
            for(String option: adminGroupsArray) {
                dropdown= new Select(accCntlallAdminGroups);
                dropdown.selectByVisibleText(option);
                addArrowApprovalAdminGroups.click();
            }
        }
        if(!prop.getProperty("excludedUsers").isEmpty()){
            String[] excludedUsersArray = prop.getProperty("excludedUsers").split(",");
            accCntlExcludedUsersTab.click();
            base.waitForElement(accCntlExcludedUsersUsersTab,10);
            accCntlExcludedUsersUsersTab.click();
            for(String option: excludedUsersArray) {
                dropdown= new Select(accCntlExcludedUsers);
                dropdown.selectByVisibleText(option);
                addArrowExcludeUsers.click();
            }
        }
        if(!prop.getProperty("excludedGroups").isEmpty()){
            String[] excludedGroupsArray = prop.getProperty("excludedGroups").split(",");
            accCntlExcludedUsersTab.click();
            base.waitForElement(accCntlExcludedUsersGroupTab,10);
            accCntlExcludedUsersGroupTab.click();
            for(String option: excludedGroupsArray) {
                dropdown= new Select(accCntlExcludedGroups);
                dropdown.selectByVisibleText(option);
                addArrowExcludeGroups.click();
            }
        }
        resourceSaveAndActivateButton.click();
        Thread.sleep(1000);
        base.waitForElement(resourceTab,10);
        resourceClearSearchButton.click();
    }

    public void takeRdp() throws InterruptedException {
        Thread.sleep(500);
        base.waitForElement(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElement(resourceNameSearchTextBox,10);
        resourceNameSearchTextBox.sendKeys("resource1");
        Thread.sleep(500);
        resourceNameSearchTextBox.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        base.waitForElement(driver.findElement(By.xpath(resource(prop.getProperty("resourceName")))),10);
        driver.findElement(By.xpath(resource(prop.getProperty("resourceName")))).click();
        base.waitForElement(resourceSearchIcon,10);
        resourceSearchIcon.click();
        Thread.sleep(2000);
        accountSearch.sendKeys("aakash",Keys.ENTER);
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

    public void shareResourceTo(String userName) throws InterruptedException {
        base.waitForElementToBeClickable(resourceTab, 10);
        driver.get(resourcePage);
        Thread.sleep(1500);
        base.waitForElement(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElement(resourceNameSearchTextBox,10);
        resourceNameSearchTextBox.sendKeys(prop.getProperty("resourceName") + Keys.ENTER);
        Thread.sleep(500);
        WebElement resourceActionsIcon;
        Thread.sleep(500);
        resourceActionsIcon = driver.findElement(By.xpath("//a[text() = '" + prop.getProperty("resourceName") + "']/ancestor::*[2]/following-sibling::div/span/div/a/span"));
        resourceActionsIcon.click();
        actions.moveToElement(base.multipleElementsWithoutWait(resourceActionMenuList,"Share")).perform();
        Thread.sleep(1000);
        base.multipleElementsWithoutWait(resourceActionMenuList,"With Users").click();
        base.waitForElement(shareSearchTextBox,10);
        shareSearchTextBox.sendKeys(userName + Keys.ENTER);
        Thread.sleep(1000);
        WebElement userGrantButton;
        userGrantButton = driver.findElement(By.xpath("//span[@onmouseover = \"Tip('Login name :" + userName + "',this);\"]/ancestor::*[2]/following-sibling::div/descendant::span[text() = 'Grant']"));
        userGrantButton.click();
        Thread.sleep(500);
        base.multipleElementsWithoutWait(resourceActionMenuList,"View Passwords").click();
        dialogTitle = "Share";
        base.waitForElement(driver.findElement(By.xpath(resourceCloseIcon(dialogTitle))),10);
        driver.findElement(By.xpath(resourceCloseIcon(dialogTitle))).click();
    }

    public void requestPasswordAccess(String timing , int minutes) throws InterruptedException {
        driver.get(resourcePage);
        Thread.sleep(500);
        base.waitForElement(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElement(resourceNameSearchTextBox,10);
        resourceNameSearchTextBox.sendKeys(prop.getProperty("resourceName") + Keys.ENTER);
        Thread.sleep(500);
        base.waitForElement(driver.findElement(By.xpath(resource(prop.getProperty("resourceName")))),10);
        driver.findElement(By.xpath(resource(prop.getProperty("resourceName")))).click();
        base.waitForElement(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElement(accountSearch,10);
        accountSearch.sendKeys(prop.getProperty("accountName") + Keys.ENTER);
        Thread.sleep(500);
        driver.findElement(By.xpath(requestPassword(prop.getProperty("accountName")))).click();
        if (timing.equalsIgnoreCase("Now")) {
            base.waitForElement(passRequestNowButton,10);
            passRequestNowButton.click();

        } else if (timing.equalsIgnoreCase("Later")) {
            base.waitForElement(passRequestLaterButton,10);
            passRequestLaterButton.click();
            base.waitForElement(passRequestStartDate,10);
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
            dropdown = new Select(passRequestStartTimeHour);
            System.out.println(dropdown.getFirstSelectedOption().getText());
            dropdown.selectByVisibleText(setHourString);
            dropdown = new Select(passRequestStartTimeMinute);
            dropdown.selectByVisibleText(setMinuteString);
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
            dropdown = new Select(passRequestEndTimeHour);
            dropdown.selectByVisibleText(setHourString);
            dropdown = new Select(passRequestEndTimeMinute);
            dropdown.selectByVisibleText(setMinuteString);
        }
        passRequestCommentsTextbox.sendKeys(prop.getProperty("passRequestReason"));
        resourceSendButton.click();
        driver.findElement(By.xpath(resourceCloseIcon("Account Details"))).click();
    }

    public void passCheckout() throws InterruptedException {
        driver.get(resourcePage);
        Thread.sleep(500);
        base.waitForElement(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElement(resourceNameSearchTextBox,10);
        resourceNameSearchTextBox.sendKeys(prop.getProperty("resourceName") + Keys.ENTER);
        Thread.sleep(500);
        base.waitForElement(driver.findElement(By.xpath(resource(prop.getProperty("resourceName")))),10);
        driver.findElement(By.xpath(resource(prop.getProperty("resourceName")))).click();
        base.waitForElement(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElement(accountSearch,10);
        accountSearch.sendKeys(prop.getProperty("accountName") + Keys.ENTER);
        Thread.sleep(500);
        driver.findElement(By.xpath(passCheckout(prop.getProperty("accountName")))).click();
        base.waitForElement(driver.findElement((By.xpath(resourceCloseIcon("Password Checkout")))),10);
        if(passCheckoutButton.getAttribute("disabled") != null) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(passCheckoutInstruction.getText());
            if (matcher.find()) {
                Thread.sleep((long) Integer.parseInt(matcher.group()) *60*1000);
            }
            driver.findElement(By.xpath(resourceCloseIcon("Password Checkout"))).click();
            driver.findElement(By.xpath(passCheckout(prop.getProperty("accountName")))).click();
        }
        base.waitForElement(passCheckoutButton,10);
        passCheckoutButton.click();
        Thread.sleep(1000);
        getPassword();
        base.waitForElement(driver.findElement(By.xpath(resourceCloseIcon("Account Details"))),10);
        driver.findElement(By.xpath(resourceCloseIcon("Account Details"))).click();
        Thread.sleep(1000);
        base.waitForElement(resourceTab,10);
        resourceClearSearchButton.click();
    }

    public void getPassword(){
        base.waitForElement(driver.findElement(By.xpath(clickHiddenPassword(prop.getProperty("accountName")))),10);
        driver.findElement(By.xpath(clickHiddenPassword(prop.getProperty("accountName")))).click();
        System.out.println(driver.findElement(By.xpath(getShownPassword(prop.getProperty("accountName")))).getText());
    }

    public void passCheckin() throws InterruptedException {
        driver.get(resourcePage);
        Thread.sleep(500);
        base.waitForElement(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElement(resourceNameSearchTextBox,10);
        resourceNameSearchTextBox.sendKeys(prop.getProperty("resourceName") + Keys.ENTER);
        Thread.sleep(500);
        base.waitForElement(driver.findElement(By.xpath(resource(prop.getProperty("resourceName")))),10);
        driver.findElement(By.xpath(resource(prop.getProperty("resourceName")))).click();
        base.waitForElement(resourceSearchIcon,10);
        resourceSearchIcon.click();
        base.waitForElement(accountSearch,10);
        accountSearch.sendKeys(prop.getProperty("accountName") + Keys.ENTER);
        Thread.sleep(500);
        driver.findElement(By.xpath(passCheckin(prop.getProperty("accountName")))).click();
        base.waitForElement(passCheckinButton,10);
        passCheckinButton.click();
        base.waitForElement(driver.findElement(By.xpath(requestPassword(prop.getProperty("accountName")))),10);
        driver.findElement(By.xpath(resourceCloseIcon("Account Details"))).click();
        Thread.sleep(1000);
        base.waitForElement(resourceTab,30);
        Thread.sleep(1000);
        resourceClearSearchButton.click();
    }

}
