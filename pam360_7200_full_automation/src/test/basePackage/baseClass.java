package test.basePackage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class baseClass {
   /* public static String Browser;
    public static Properties prop;
    public  FileInputStream fis;
    public void loadPropertiesFile() {
        prop=new Properties();
        try {
            fis=new FileInputStream("D:/IntelliJ/PamProject/pamautomation/src/test/Configuration/config.properties");
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


    }*/
    }

