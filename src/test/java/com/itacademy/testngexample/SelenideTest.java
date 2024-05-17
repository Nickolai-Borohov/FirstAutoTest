package com.itacademy.testngexample;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.SelenidePageFactory;
import com.itacademy.Pages.ProductListingPage;
import com.itacademy.utils.DriverManager;
import com.itacademy.utils.ScreenshitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import java.time.Duration;

public class SelenideTest {

    @Test
    public void test1() throws InterruptedException {
        //Configuration.remote="";- мой локалхост 4444
        //SelenidePage selenidePage = open("https://react-shopping-cart-67954.firebaseapp.com");

        Configuration.timeout=5000; //пауза
        Configuration.browser="firefox";

        //$(By.xpath("q")).shouldBe(visible).click(); - должен быть сначала виден потом он только кликнет или disappear для того пока не исчезнет
      //  SelenideElement selenideElement = $(By.xpath("")); значение для переменной
               ElementsCollection list = $$(By.xpath("")); // вернет лист
        //list.should( size(3));// какой должен быть лист или sizeGreaterThan тип должен быть больше какого-то кол-вв
        Configuration.headless=true; // запустит тест под коппотом

        $(By.xpath("//*[@class='sc-124al1g-2 dwOYCh'] //*[@class='sc-124al1g-4 eeXMBo']"));
        WebElement FirstProduct = DriverManager.getDriver().findElement(By.xpath("//*[@class='sc-124al1g-2 dwOYCh'] //*[@class='sc-124al1g-4 eeXMBo']"));
        String FirstProductname = FirstProduct.findElement(By.xpath("//*[@class='sc-124al1g-2 dwOYCh'] //*[@class='sc-124al1g-4 eeXMBo']")).getText();
        FirstProduct.findElement(By.xpath("//*[@class='sc-124al1g-2 dwOYCh'] //*[@class='sc-124al1g-0 jCsgpZ']")).click();
        ScreenshitUtils.takeScreenshot(DriverManager.getDriver());
        WebElement ProductInCart = DriverManager.getDriver().findElement(By.xpath("//*[@class='sc-11uohgb-0 hDmOrM'] //*[@class='sc-11uohgb-2 elbkhN']"));
        String ProductInCartName = ProductInCart.getText();
        //Assert.assertEquals(ProductInCartName,FirstProductname);

        // driver.quit();
    }

//    @Test
//    public void googleTest()
//    {
//        SelenidePage
//    }
}
