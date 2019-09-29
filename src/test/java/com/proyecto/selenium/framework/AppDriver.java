package com.proyecto.selenium.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppDriver {

	// instance of singleton class
	private static AppDriver instanceOfSingletonAppDriverClass = null;
    private WebDriver driver;

    // Constructor
    private AppDriver(){
//			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
    	System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
    	driver = new ChromeDriver();
    	
//    	System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
//		driver = new FirefoxDriver();
    	driver.manage().window().maximize();
    }

    // TO create instance of class
    public static AppDriver getInstance(){
        if(instanceOfSingletonAppDriverClass==null){
        	instanceOfSingletonAppDriverClass = new AppDriver();
        }
        return instanceOfSingletonAppDriverClass;
    }
    
    // To get driver
    public WebDriver getDriver()
    {
    	return driver;
    }
}
