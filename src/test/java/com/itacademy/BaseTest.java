package com.itacademy;

import com.itacademy.Pages.ProductListingPage;
import com.itacademy.enums.Capability;
import com.itacademy.listeners.ElementEctionListener;
import com.itacademy.listeners.TestListener;
import com.itacademy.utils.DriverFactory;
import com.itacademy.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "D://Selenium/chromedriver.exe");
        driver = DriverFactory.createDriver(PropertyReader.getConfigProperty(Capability.BROWSER));
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator(new ElementEctionListener());
        driver = decorator.decorate(driver);
        driver.manage().window().maximize();

    }
    @AfterTest
    public void closeSession() {
        driver.quit();
    }
}
