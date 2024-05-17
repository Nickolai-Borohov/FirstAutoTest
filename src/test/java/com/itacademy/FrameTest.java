package com.itacademy;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrameTest {
    WebDriver driver ;
    @Test
    public void frametest () throws InterruptedException {
// фреймы там где данные карты можно ввести
        Thread.sleep(5000); // пауза
        WebElement frame = driver.findElement(By.xpath(""));
        driver.switchTo().frame(frame);
        driver.switchTo().defaultContent();
        // когда работаешь во фрейме, нужно в него войти driver.switchTo().frame(frame); когда сделали там все что нужно было , нужно выйти


        Alert alert=driver.switchTo().alert();
        alert.accept(); // принять                  когда какое-то окно падает
        alert.dismiss();// отклонить
        alert.sendKeys("Text"); // ввести текст

        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ожидание к конкретному элеменнту
        wait.until(ExpectedConditions.visibilityOf(frame));
        //wait.until(ExpectedConditions.) там много чего можно проверить )
        FluentWait fluentWait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);

//        WebElement element;
//        element.sendKeys();
    }
}
