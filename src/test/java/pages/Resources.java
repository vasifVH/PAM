package pages;

import BasePackage.BaseFunctionsClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Resources {

    WebDriver driver;
    BaseFunctionsClass base;

    @FindBy(xpath = "/span[text() = 'Resources']")
    static WebElement resourcesTab;

    @FindBy(xpath = "//div[@pmpqaattr='AddResourceMenu']")
    static WebElement addResourceDropdown;

    @FindBy(xpath = "//div[@pmpqaattr='AddResourceMenu']/following-sibling::div/child::ul/li/a")
    List<WebElement> addResourceDropdownList;

    @FindBy(xpath = "//button[@id='details-button']")
    static WebElement advancedButton;

    @FindBy(xpath = "//a[@id='proceed-link']")
    static WebElement unsafeButton;

    public Resources (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.base = new BaseFunctionsClass(this.driver);
    }

//    public void addResourceManually() {
//        base.waitForElementToBeClickable(resourcesTab, 10);
//        resourcesTab.click();
//        base.multipleElements(addResourceDropdownList, 10);
//
//
//
//    }
}
