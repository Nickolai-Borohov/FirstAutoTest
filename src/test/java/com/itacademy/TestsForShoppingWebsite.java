package com.itacademy;

import com.itacademy.Pages.ProductListingPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestsForShoppingWebsite extends BaseTest {

    //Тест 1
    //1. Найдите название первого продукта
    //2. Добавьте в корзину первый продукт
    //3. Сравните название продукта в корзине с названием продукта из первого пункта
    //___________________________________________________________________________________________

    @Test
    public void test1() throws InterruptedException {

        ProductListingPage productListingPage = new ProductListingPage(driver);
        productListingPage.openURL();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        WebElement FirstProduct = driver.findElement(By.xpath("//*[@class='sc-124al1g-2 dwOYCh'] //*[@class='sc-124al1g-4 eeXMBo']"));
        String FirstProductname = FirstProduct.findElement(By.xpath("//*[@class='sc-124al1g-2 dwOYCh'] //*[@class='sc-124al1g-4 eeXMBo']")).getText();
        FirstProduct.findElement(By.xpath("//*[@class='sc-124al1g-2 dwOYCh'] //*[@class='sc-124al1g-0 jCsgpZ']")).click();
        WebElement ProductInCart = driver.findElement(By.xpath("//*[@class='sc-11uohgb-0 hDmOrM'] //*[@class='sc-11uohgb-2 elbkhN']"));
        String ProductInCartName = ProductInCart.getText();
        //Assert.assertEquals(ProductInCartName,FirstProductname);
        if (FirstProductname.equals(ProductInCartName)) {
            System.out.println("Строки одинаковые");
        } else {
            System.out.println("Строки различаются");
        }
       // driver.quit();
    }


    //_____________________________________________________________________________________
    @Test
    public void test2() throws InterruptedException {
        ////Тест 2.
        //    //1. Получите названия всех продуктов(используйте List)
        //    //2. Добавьте все продукты в корзину
        //    //3. Сравните все названия продуктов в корзине с листом из первого пункта

        ProductListingPage productListingPage = new ProductListingPage(driver);
        productListingPage.openURL();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        List<WebElement> AllProducts = driver.findElements(By.xpath("//*[@class='sc-124al1g-4 eeXMBo']"));
        List<String> AllProductsNames = AllProducts.stream().map(x -> x.getText()).toList();
        //AllProductsNames.add(driver.findElement(By.xpath("//*[@class='sc-124al1g-4 eeXMBo']")));
        List<WebElement> AddToCart = driver.findElements(By.xpath("//*[text()='Add to cart']"));
        for (WebElement AddToCartAllElem : AddToCart) {
            AddToCartAllElem.click();
            //((JavascriptExecutor)driver).executeScript("arguments[0].click();",AddToCartAllElem);- не помогает если убрать maximize
        }
        List<WebElement> ProductInCart = driver.findElements(By.xpath("//*[@class='sc-11uohgb-0 hDmOrM'] //*[@class='sc-11uohgb-2 elbkhN']"));
        List<String> ProductInCartName = ProductInCart.stream().map(x -> x.getText()).toList();
        //ProductInCartName.add(driver.findElement(By.xpath("//*[@class='sc-11uohgb-0 hDmOrM'] //*[@class='sc-11uohgb-2 elbkhN']")));
        if (AllProductsNames.equals(ProductInCartName)) {
            System.out.println("Названия продуктов одинаковые");
        } else {
            System.out.println("Что-то пошло не так");
        }
        Thread.sleep(5000);
        //driver.quit();


    }

    //_________________________________________________________________
    //_________________________________________________________________
    @Test
    public void test3() throws InterruptedException {
        //Тест 3
        //1. Получите названия всех продуктов(используйте List)
        //2. Отфильтруйте продукты по любому размеру(сверху слева есть размеры S, M, ML и др)
        //3. Получите лист для текущих продуктов и сравните что его размер меньше листа из первого пункта
        ProductListingPage productListingPage = new ProductListingPage(driver);
        productListingPage.openURL();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        List<WebElement> AllProducts = driver.findElements(By.xpath("//*[@class='sc-124al1g-4 eeXMBo']"));
        List<String> AllProductsNames = AllProducts.stream().map(x -> x.getText()).toList();
//        WebElement MFilter = driver.findElement(By.xpath("//*[@class='sc-bj2vay-0 DCKcC'] //*[text()='M']"));
//        MFilter.click();
        productListingPage.mFilter();
        List<WebElement> ProductsWithMFilter = driver.findElements(By.xpath("//*[@class='sc-124al1g-2 keuquD'] //*[@class='sc-124al1g-4 eeXMBo']"));
        List<String> ProductNamesWithMFilter = ProductsWithMFilter.stream().map(x -> x.getText()).toList();
        if (ProductNamesWithMFilter.size() < AllProductsNames.size()) {
            System.out.println("Продуктов с M фильтром меньше чем на главное странице");
        } else if (ProductNamesWithMFilter.size() > AllProductsNames.size()) {
            System.out.println("Ну это странно )");
        } else {
            System.out.println("Хз почему так");
        }

        Thread.sleep(5000);
       // driver.quit();
    }
    //}
    //______________________________________________________

    @Test
    public void test4() throws InterruptedException {
        //Тест 4
        //1. Получите количество продуктов расспарсив сверху стрингу  16 Product(s) found
        //2. Отфильтруйте продукты по любому размеру(сверху слева есть размеры S, M, ML и др)
        //3. Получите количество продуктов после фильтра  расспарсив сверху стрингу   Product(s) found и сравните с числом из первого пункта

        driver.get("https://react-shopping-cart-67954.firebaseapp.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        Thread.sleep(5000);
        WebElement FoundResult = driver.findElement(By.xpath("//*[@class='sc-ebmerl-4 iliWeY']")); //      //*[text()=' Product(s) found']//*[@class='sc-ebmerl-4 iliWeY']
        String AllFoundproducts = FoundResult.getText();
        int QuantityProducts = Integer.parseInt(AllFoundproducts.split(" ")[0]);
        System.out.println(QuantityProducts);
//        List<WebElement> allProd = new ArrayList<>(driver.findElements(By.xpath("//*[@class='sc-ebmerl-4 iliWeY']")));


        WebElement MFilter = driver.findElement(By.xpath("//*[@class='sc-bj2vay-0 DCKcC'] //*[text()='M']"));
        MFilter.click();
        Thread.sleep(5000);
        WebElement FoundResultMFilter = driver.findElement(By.xpath("//*[@class='sc-ebmerl-4 iliWeY']"));
        Thread.sleep(4000);
        String QuantityMFilterProducts = FoundResultMFilter.getText();
        int DigitQuantityMFilterProducts = Integer.parseInt(QuantityMFilterProducts.split(" ")[0]);
        System.out.println(DigitQuantityMFilterProducts);
        driver.quit();
        if (QuantityProducts > DigitQuantityMFilterProducts) {
            System.out.println("Продуктов больше на Homepage");
        } else {
            System.out.println("Возможно что-то пошло не так");
        }
    }
}



//_________________________________________________________________________________________________________

//WebElement ProductInCart = driver.findElement(By.xpath("//*[@class='sc-11uohgb-2 elbkhN']"));
// String ProductInCartName = ProductInCart.getText();
//Thread.sleep(5000);

//Assert.assertTrue();
// WebElement addtoCartButton = driver.findElement(By.xpath("//*[text()='Add to cart']")).click();

//  //*[@class='sc-124al1g-2 dwOYCh']
//  //*[@]- ищем по какому-то атрибуту
//  //*[text()='Add to cart']- поиск по тексту add to cart
//   //*[@class='sc-124al1g-2 dwOYCh'] /*[@class='sc-124al1g-4 eeXMBo']


////*[@class='sc-124al1g-2 dwOYCh'] //*[@class='sc-124al1g-4 eeXMBo']

//        driver.quit();
//        setUp(); //???????????????

//    @Test
//    public void test2 () {
//        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
//        List<WebElement> productsFromlisting = driver.findElements(By.xpath("//*[@ class=/'sc-124al1g-4 eeXMBo/']"));
//        List<WebElement> productsToCart = driver.findElements(By.xpath("//*[text()='Add to cart']"));
//        for (WebElement webElement1: productsToCart)
//        {
//            webElement1.click();
//            ((JavascriptExecutor)driver).executeScript("arguments[0].click();",webElement1);
//        }
//        List<WebElement> names = driver.findElements(By.cssSelector(".sc-124al1g-4.eeXMBo")); //Если класс идет с пробелами, тогда нужно писать .
//        List<String> namesStr = names.stream().map(x->x.getText()).toList();
//
//        //   //*[text()='Add to cart']
//    }
