package Hooks;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Hooks {

   public static Properties prop;
    public  FileInputStream fis;
    public static String browser;
    public static WebDriver driver;

  @Before (order = 0)
    public void loadPropertiesFile() {
        prop=new Properties();
        try {
            fis=new FileInputStream("./src/test/java/Configuration/Config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        browser=prop.getProperty("browser");
    }

    @Before(order = 1)
   public static void launchBrowser() {
      switch(browser.toLowerCase()){
          case "chrome":
              WebDriverManager.chromedriver().setup();
              ChromeOptions options = new ChromeOptions();
              options.setAcceptInsecureCerts(true);  // Accept insecure certificates
              options.addArguments("--ignore-certificate-errors");
              driver=new ChromeDriver(options);
              break;
          case "firefox":
              WebDriverManager.firefoxdriver().setup(); // Set up FirefoxDriver
              driver = new FirefoxDriver();
              break;
          case "edge":
              WebDriverManager.edgedriver().setup(); // Set up EdgeDriver
              driver = new EdgeDriver();
              break;
          default:
              throw new IllegalArgumentException("Unsupported browser: " + browser);
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
