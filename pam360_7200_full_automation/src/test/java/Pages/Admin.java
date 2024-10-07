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

    @FindBy(xpath = "//button[@id='searchButtonId']")
    static WebElement adminSearchIcon;

    @FindBy(xpath = "//input[@columnname = 'RESOURCENAME']")
    static WebElement adminResourceSearchTextbox;

    @FindBy(xpath = "//input[@columnname = 'LOGINNAME']")
    static WebElement adminAccountSearchTextbox;

    @FindBy(xpath = "//em[text() = 'Approve']")
    static WebElement adminApproveButton;

    @FindBy(xpath = "//em[text() = 'Reject']")
    static WebElement adminRejectButton;

    //PasswordAccessRequest

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

    public Admin (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.base = new BaseClass(this.driver);
        actions = new Actions(this.driver);
        js = (JavascriptExecutor) this.driver;
    }

    public String selectAdminAction(String actionName){
        return "//div[@id = 'adminContainer']/div/ul/li/span[@onmouseover = \"showAdminPageTip('" + actionName + "',this)\"]/a";
    }

    public String passAccessProcessRequestButton(String accountName) {
        return "//span[text() ='" + accountName +"']/ancestor::*[1]/following-sibling::div/descendant::span[text() = 'Process Request']";
    }

    public void approvePasswordRequest(String approval, int approvalMinutes) throws InterruptedException {
        base.waitForElement(adminTab, 10);
        driver.get(adminPage);
        base.waitForElement(adminTab,10);
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(selectAdminAction("Password Access Requests"))));
        driver.findElement((By.xpath(selectAdminAction("Password Access Requests")))).click();
        //base.multipleElementsWithoutWait(adminAction,"Password Access Requests").click();
        Thread.sleep(1000);
        base.waitForElement(adminSearchIcon, 10);
        adminSearchIcon.click();
        base.waitForElement(adminResourceSearchTextbox, 10);
        adminResourceSearchTextbox.sendKeys(prop.getProperty("resourceName"));
        adminAccountSearchTextbox.sendKeys(prop.getProperty("accountName") + Keys.ENTER);
        Thread.sleep(500);
        base.waitForElement(driver.findElement(By.xpath(passAccessProcessRequestButton(prop.getProperty("accountName")))), 10);
        driver.findElement(By.xpath(passAccessProcessRequestButton(prop.getProperty("accountName")))).click();
        base.waitForElement(passAccessApprovalReasonTextbox, 10);
        passAccessApprovalReasonTextbox.sendKeys(prop.getProperty("passApprovalReason"));
        if (approval.equalsIgnoreCase("approve") && approvalMinutes > 0) {
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
            dropdown = new Select(passAccessApprovalStartTimeHour);
            System.out.println(dropdown.getFirstSelectedOption().getText());
            dropdown.selectByVisibleText(setHourString);
            dropdown = new Select(passAccessApprovalStartTimeMinute);
            dropdown.selectByVisibleText(setMinuteString);
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
            dropdown = new Select(passAccessApprovalEndTimeHour);
            dropdown.selectByVisibleText(setHourString);
            dropdown = new Select(passAccessApprovalEndTimeMinute);
            dropdown.selectByVisibleText(setMinuteString);
            adminApproveButton.click();
        } else
            adminRejectButton.click();

    }

}
