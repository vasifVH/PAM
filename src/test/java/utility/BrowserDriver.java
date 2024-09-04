package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
 
public class BrowserDriver {
    public static WebDriver driver;

    public ChromeOptions options;

    public BrowserDriver(){
        if(driver==null) {
            System.out.println("Iam inside Browser Setup");
            options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/Drivers/chromedriver.exe");
            BrowserDriver.driver = new ChromeDriver();
            driver.get("https://ragul-20628:9090/");
            driver.manage().window().maximize();
        }
    }

    public void close(){
        this.driver.close();
    }
}
