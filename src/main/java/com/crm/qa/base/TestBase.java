package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    static Properties prop;

    public TestBase(){

        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream("/Users/aaibedul/IdeaProjects/untitled/src/main/java/com/crm/qa/config/config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void initialisation(){
       String browserName = prop.getProperty("browser");
       if(browserName.equals("chrome")){
           System.setProperty("webdriver.chrome.driver", "/Users/aaibedul/Downloads/chromedriver_mac64");
           driver = new ChromeDriver();
       }else if(browserName.equals("FF")){
           System.setProperty("webdriver.chrome.driver", "/Users/aaibedul/Downloads/geckodriver");
           driver = new FirefoxDriver();
       }

       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
       driver.get(prop.getProperty("url"));
    }


}
