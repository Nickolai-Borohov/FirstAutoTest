package com.itacademy.utils;

import com.itacademy.enums.Capability;
import com.itacademy.listeners.ElementEctionListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class DriverManager {
    static ThreadLocal<WebDriver> localDriver =new ThreadLocal();
    static WebDriver driver;
    public static WebDriver getDriver(){
        if (localDriver.get()==null){
            driver= DriverFactory.createDriver(PropertyReader.getConfigProperty(Capability.BROWSER));
            EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator(new ElementEctionListener());
            driver = decorator.decorate(driver);
            driver.manage().window().maximize();
            localDriver.set(driver);
            return driver;
        }
        else {
            return driver;
        }
        }

        public static void quitDrivrer (){
        localDriver.get().quit();
        localDriver.set(null);
        }
    }

