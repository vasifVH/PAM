package test.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import test.Hooks.hooks;
import test.basePackage.baseClass;

import java.util.concurrent.TimeUnit;

import static test.Hooks.hooks.Browser;


public class driverManagerClass  {

/*

    public static WebDriver driver;
    public static void launchBrowser() {
        if(Browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);  // Accept insecure certificates
            options.addArguments("--ignore-certificate-errors");
            driver=new ChromeDriver(options);
            //url=https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

        }
        else
        {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();

        }
       */
/* public static WebDriver getDriver() {
            return driver;
        }*//*


        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
        System.out.println(prop.getProperty("url"));


    }

    public static WebDriver getDriver() {
        return driver;
    }
*/

}
