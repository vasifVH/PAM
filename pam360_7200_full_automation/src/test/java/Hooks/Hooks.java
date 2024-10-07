package Hooks;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Hooks {

   public static Properties prop;
    public  FileInputStream fis;
    public static String Browser;
    public static WebDriver driver;

  @Before (order = 0)
    public void loadPropertiesFile() {
        prop=new Properties();
        try {
            fis=new FileInputStream("D:/Personal/Selenium/PAM_VASIF/source/PAM/pam360_7200_full_automation/src/test/java/Configuration/Config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Drivers.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Browser=prop.getProperty("browser");


    }

    @Before(order = 1)
   public static void launchBrowser() {
      if(Browser.equals("chrome")) {
          WebDriverManager.chromedriver().setup();
          ChromeOptions options = new ChromeOptions();
          options.setAcceptInsecureCerts(true);  // Accept insecure certificates
          options.addArguments("--ignore-certificate-errors");
          driver=new ChromeDriver(options);
          //url=https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
      } else {
          WebDriverManager.firefoxdriver().setup();
          driver=new FirefoxDriver();
      }


        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
        System.out.println(prop.getProperty("url"));


}
   public static WebDriver getDriver() {
        return driver;
    }
   // @After(order = 1)
   /* public void tearDown() {
        //Drivers.getDriver().quit();

    }*/
}
