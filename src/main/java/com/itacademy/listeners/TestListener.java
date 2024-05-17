package com.itacademy.listeners;

import com.itacademy.utils.DriverManager;
import com.itacademy.utils.ScreenshitUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.itacademy.utils.DriverManager.getDriver;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("=========================================================");
        System.out.println("Test " + result.getMethod().getMethodName() +  " started");
        System.out.println("=========================================================");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("=========================================================");
        System.out.println("Test " + result.getMethod().getMethodName() +  " success");
        System.out.println("=========================================================");
    }

    @Override
    public void onTestFailure(ITestResult result) {
//        WebDriver driver;
        System.out.println("=========================================================");
        System.out.println("Test " + result.getMethod().getMethodName() +  " failed");
        System.out.println("=========================================================");
        ScreenshitUtils.takeScreenshot(getDriver());
//        System.out.println(getDriver().getPageSource()); // получение кода страницы
//        getDriver().getPageSource();
//         ScreenShotUtils.takeScreenshot(driver);
//        System.out.println(driver.getPageSource());  напечатает html
    }

    @Override
    public void onFinish(ITestContext context) {
        DriverManager.quitDrivrer();
    }
}
