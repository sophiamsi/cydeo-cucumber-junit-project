package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    //create a private constructor to remove access to the object

    private Driver(){

    }

    /*
   We make the WebDriver private because we want to close access from outside of the class
   We are making it static because we will use it in static method
     */
    private static WebDriver driver;
    //Create a re-usable utility method which will return the same driver instance once we call it
    //If an instance does not exist it will create first and then it will always return same instance
    public static WebDriver getDriver(){
        if(driver==null){
            //we will read iur browserType from configuration.properties file
            // This way we can control which browser is opened from outside our code
            String browserType=ConfigurationReader.getProperty("browser");
            switch (browserType){
                case"chrome":
                  //  WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
                    break;
                case "firefox":
                   // WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
            }

        }
        return  driver;
    }

    public static void closeDriver(){

        if(driver!=null){
            // This line will terminate the currently existing driver completely. It will m=not exist going forward
            driver.quit();
            //We assign the value back to "null" so that my "singleton"can create a newer one if needed
            driver=null;
        }
    }

}
