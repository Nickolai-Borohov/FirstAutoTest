package com.itacademy.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    public static WebDriver createDriver (String browser)
    {
        URL url;
        try {
             url = new URL("http://localhost:4444");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        if (browser.equals("chrome"))
        {
           // System.setProperty("webdriver.chrome.driver", "D://Selenium/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            return new RemoteWebDriver(url,chromeOptions);
        }else if (browser.equals("firefox")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            return new RemoteWebDriver(url,firefoxOptions);
        }
        return null;
    }
}
