package com.weborders.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    //reference variable pinter on object
    // if reference variable doesn't point on any object it will hava a null value
    //whenever we type new Class() - we create a new object
    // reference type can be a class parent class or interface implemented by class or parent
    //since WebDriver is an interface implemented by RemoteWebDriver class
    // and RemoteWebDriver is a parent class of ChromeDriver,FireFoxDriver,etc.. classes
    //we can specify reference type as a WebDriver
    //it helps to define object type in a run time (polymorphism)



    private static WebDriver driver;

    private Driver(){}

    public static  WebDriver getDriver(){
        if(driver == null){
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Browser is not implemented yet"+browser);
            }

        }
        return driver;
    }
}
