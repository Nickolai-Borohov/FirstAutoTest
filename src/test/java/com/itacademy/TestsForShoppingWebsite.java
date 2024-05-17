package com.itacademy;

import com.itacademy.Pages.ProductListingPage;
import com.itacademy.testngexample.LoggetTest;
import com.itacademy.utils.DriverManager;
import com.itacademy.utils.ScreenshitUtils;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class  TestsForShoppingWebsite extends BaseTest {
    private static final Logger LOGGER= LogManager.getLogger(LoggetTest.class);
    //Тест 1
    //1. Найдите название первого продукта
    //2. Добавьте в корзину первый продукт
    //3. Сравните название продукта в корзине с названием продукта из первого пункта
    //___________________________________________________________________________________________

    @Test
    public void test1() throws InterruptedException {

        ProductListingPage productListingPage = new ProductListingPage();
        productListingPage.openURL();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        WebElement FirstProduct = DriverManager.getDriver().findElement(By.xpath("//*[@class='sc-124al1g-2 dwOYCh'] //*[@class='sc-124al1g-4 eeXMBo']"));
        String FirstProductname = FirstProduct.findElement(By.xpath("//*[@class='sc-124al1g-2 dwOYCh'] //*[@class='sc-124al1g-4 eeXMBo']")).getText();
        FirstProduct.findElement(By.xpath("//*[@class='sc-124al1g-2 dwOYCh'] //*[@class='sc-124al1g-0 jCsgpZ']")).click();
        ScreenshitUtils.takeScreenshot(DriverManager.getDriver());
        WebElement ProductInCart = DriverManager.getDriver().findElement(By.xpath("//*[@class='sc-11uohgb-0 hDmOrM'] //*[@class='sc-11uohgb-2 elbkhN']"));
        String ProductInCartName = ProductInCart.getText();
        //Assert.assertEquals(ProductInCartName,FirstProductname);
        if (FirstProductname.equals(ProductInCartName)) {
            LOGGER.info("Строки одинаковые");
        } else {
            LOGGER.info("Строки различаются");
        }
       // driver.quit();
    }

    @Test
    public void test2() throws InterruptedException {
        ////Тест 2.
        //    //1. Получите названия всех продуктов(используйте List)
        //    //2. Добавьте все продукты в корзину
        //    //3. Сравните все названия продуктов в корзине с листом из первого пункта

        ProductListingPage productListingPage = new ProductListingPage();
        productListingPage.openURL();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        List<WebElement> AllProducts = DriverManager.getDriver().findElements(By.xpath("//*[@class='sc-124al1g-4 eeXMBo']"));
        List<String> AllProductsNames = AllProducts.stream().map(x -> x.getText()).toList();
        //AllProductsNames.add(driver.findElement(By.xpath("//*[@class='sc-124al1g-4 eeXMBo']")));
        List<WebElement> AddToCart = DriverManager.getDriver().findElements(By.xpath("//*[text()='Add to cart']"));
        for (WebElement AddToCartAllElem : AddToCart) {
            AddToCartAllElem.click();
            //((JavascriptExecutor)driver).executeScript("arguments[0].click();",AddToCartAllElem);- не помогает если убрать maximize
        }
        List<WebElement> ProductInCart = DriverManager.getDriver().findElements(By.xpath("//*[@class='sc-11uohgb-0 hDmOrM'] //*[@class='sc-11uohgb-2 elbkhN']"));
        List<String> ProductInCartName = ProductInCart.stream().map(x -> x.getText()).toList();
        //ProductInCartName.add(driver.findElement(By.xpath("//*[@class='sc-11uohgb-0 hDmOrM'] //*[@class='sc-11uohgb-2 elbkhN']")));
        if (AllProductsNames.equals(ProductInCartName)) {
            LOGGER.info("Названия продуктов одинаковые");
        } else {
            LOGGER.info("Что-то пошло не так");
        }
        Thread.sleep(5000);
        //driver.quit();


    }
   // @Parameters({"key"})
    @Test
    public void test3() throws InterruptedException {
        //Тест 3
        //1. Получите названия всех продуктов(используйте List)
        //2. Отфильтруйте продукты по любому размеру(сверху слева есть размеры S, M, ML и др)
        //3. Получите лист для текущих продуктов и сравните что его размер меньше листа из первого пункта
        ProductListingPage productListingPage = new ProductListingPage();
        productListingPage.openURL();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        List<WebElement> AllProducts = DriverManager.getDriver().findElements(By.xpath("//*[@class='sc-124al1g-4 eeXMBo']"));
        List<String> AllProductsNames = AllProducts.stream().map(x -> x.getText()).toList();
//        WebElement MFilter = driver.findElement(By.xpath("//*[@class='sc-bj2vay-0 DCKcC'] //*[text()='M']"));
//        MFilter.click();
        productListingPage.mFilter();
        List<WebElement> ProductsWithMFilter = DriverManager.getDriver().findElements(By.xpath("//*[@class='sc-124al1g-2 keuquD'] //*[@class='sc-124al1g-4 eeXMBo']"));
        List<String> ProductNamesWithMFilter = ProductsWithMFilter.stream().map(x -> x.getText()).toList();
        if (ProductNamesWithMFilter.size() < AllProductsNames.size()) {
            LOGGER.info("Продуктов с M фильтром меньше чем на главное странице");
        } else if (ProductNamesWithMFilter.size() > AllProductsNames.size()) {
            LOGGER.info("Ну это странно )");
        } else {
            LOGGER.info("Хз почему так");
        }

        Thread.sleep(5000);
       // driver.quit();
    }

    @Test
    public void test4() throws InterruptedException {
        //Тест 4
        //1. Получите количество продуктов расспарсив сверху стрингу  16 Product(s) found
        //2. Отфильтруйте продукты по любому размеру(сверху слева есть размеры S, M, ML и др)
        //3. Получите количество продуктов после фильтра  расспарсив сверху стрингу   Product(s) found и сравните с числом из первого пункта

        ProductListingPage productListingPage = new ProductListingPage();
        productListingPage.openURL();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        Thread.sleep(5000);
        WebElement FoundResult = DriverManager.getDriver().findElement(By.xpath("//*[@class='sc-ebmerl-4 iliWeY']")); //      //*[text()=' Product(s) found']//*[@class='sc-ebmerl-4 iliWeY']
        String AllFoundproducts = FoundResult.getText();
        int QuantityProducts = Integer.parseInt(AllFoundproducts.split(" ")[0]);
        System.out.println(QuantityProducts);
//        List<WebElement> allProd = new ArrayList<>(driver.findElements(By.xpath("//*[@class='sc-ebmerl-4 iliWeY']")));
        productListingPage.mFilter();
        Thread.sleep(5000);
        WebElement FoundResultMFilter = DriverManager.getDriver().findElement(By.xpath("//*[@class='sc-ebmerl-4 iliWeY']"));
        Thread.sleep(4000);
        String QuantityMFilterProducts = FoundResultMFilter.getText();
        int DigitQuantityMFilterProducts = Integer.parseInt(QuantityMFilterProducts.split(" ")[0]);
        System.out.println(DigitQuantityMFilterProducts);
        DriverManager.getDriver().quit();
        if (QuantityProducts > DigitQuantityMFilterProducts) {
            LOGGER.info("Продуктов больше на Homepage");
        } else {
            LOGGER.info("Возможно что-то пошло не так");
        }


    }


//    @Test(dataProvider = "data")
//    public void firstTest(String name, String password, String errorMessage)
//        homepage.typeusername(name);
//    homepage.typeusername(password);
//    assertEquals(home.getMessage(), error Message);
}

//1. Создайте testng suite, добавьте в него thread-count="3" parallel="methods" и попробуйте запустить тесты локально в несколько потоков
//2. Создайте свой датапровайдер и используйте в тесте
//3. По желанию, добавьте DriverManager
//4. Подключите логгеры к проекту и используйте вместо System.out.println()
