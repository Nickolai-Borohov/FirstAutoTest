package com.itacademy;

import com.itacademy.Pages.ProductListingPage;
import com.itacademy.enums.Capability;
import com.itacademy.listeners.ElementEctionListener;
import com.itacademy.listeners.TestListener;
import com.itacademy.utils.DriverFactory;
import com.itacademy.utils.DriverManager;
import com.itacademy.utils.PropertyReader;
import net.bytebuddy.description.modifier.SynchronizationState;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class BaseTest {
//    protected WebDriver driver;
//
//    @BeforeMethod
//    public void setUp() {
//               driver = DriverManager.getDriver();
//    }
////        System.setProperty("webdriver.chrome.driver", "D://Selenium/chromedriver.exe");
//        driver = DriverManager.getDriver();
    //        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator(new ElementEctionListener());
        //        driver = decorator.decorate(driver);
        //        driver.manage().window().maximize();
    }
//    @AfterMethod
//    public void closeSession() {
//        driver.quit();
//    }

