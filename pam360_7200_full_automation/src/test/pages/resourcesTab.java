package test.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class resourcesTab {
    WebDriver ldriver;

    @FindBy(xpath = "//span[normalize-space()='Resources']")
    static WebElement resourceTab;

    @FindBy(xpath = "//a[normalize-space()='msp2k19']")
    static WebElement rdpResource;

    @FindBy(xpath = "//button[@id='searchButtonId']")
    static WebElement searchIcon;

    @FindBy(xpath = "//input[@columnname='PTRX_RNAME'][@name='searchValues']")
    static WebElement rdpResourceSearch;

    @FindBy(xpath = "//input[@columnname='PTRX_LNAME'][position()=1]")
    static WebElement rdpAccountSearch;



    @FindBy(xpath = "(//div[@class='antiscroll-inner'])[3]/div/div/div[2]/div/div[7]/span/a/span[@divtype='popUp']")
    static WebElement rdpConnectIcon;

    @FindBy(xpath = "//a[normalize-space()='Windows Remote Desktop']")
    static WebElement rdpwindowsLaunch;






    public resourcesTab(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }

    public void takeRdp() throws InterruptedException {
        resourceTab.click();
        searchIcon.click();
        rdpResourceSearch.sendKeys("msp2k19", Keys.ENTER);
        Thread.sleep(3000);
        rdpResource.click();
        Thread.sleep(2000);

        searchIcon.click();
        Thread.sleep(2000);

        rdpAccountSearch.sendKeys("aakash",Keys.ENTER);
        Thread.sleep(2000);

        rdpConnectIcon.click();
        rdpwindowsLaunch.click();
        System.out.println("HI");
        Set<String> allTabs = ldriver.getWindowHandles();
        String originalTab = ldriver.getWindowHandle();

        for (String tab : allTabs) {
            if (!tab.equals(originalTab)) {
                // Switch to the newly opened tab
                ldriver.switchTo().window(tab);

                // Validate the RDP session (e.g., check the URL contains "rdp")
                if (ldriver.getCurrentUrl().contains("rdp.ma")) {
                    System.out.println("RDP session established successfully.");
                } else {
                    System.out.println("Failed to establish RDP session.");
                }
                System.out.println(ldriver.getPageSource());
                System.out.println(ldriver.getTitle());
                System.out.println(ldriver.getClass());


                // Close the RDP tab and switch back to the original
                //driver.close();
                ldriver.switchTo().window(originalTab);
            }
        }
    }
}
