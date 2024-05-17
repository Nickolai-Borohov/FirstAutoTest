package com.itacademy.testngexample;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestNgTest {
//    @Test(priority = 1)
//    public void firstTest() {
//        System.out.println("First test");
//    }

    @Test(dependsOnMethods = {"firstTest"}) // зависимое тесты, но лучше их не использовать
    public void secondTest() {
        System.out.println("Second test");
    }

    @Test(priority = -10)
    public void threadndTest() {
        System.out.println("3 test");
    }
    @Test(testName = "Buty Test Name") // для красоты и возможно удобства ))
    public void fourTest() {
        System.out.println("3 test");
    }

    @BeforeMethod               // если он будет в родительском, тогда будет применяться для каждого метода в дочернем
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }
    //@AfterMethod
    @Test//пример
    public void firstTest(){
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertTrue(element.isDisplayed(),"Message"); // для проверки элементов на странице
//        softAssert.assertTrue(element2.isDisplayed(),"Message");// тип если не будет элемента, тогда выведюет сообщение
//        softAssert.assertAll();
    }
    @DataProvider(name="date")
    public Object[][] getData(){
        return new Object[][]{//массив двухмерный
                {"Ivan","123","Password short"}, // массив1
                {"","12345678w", "UserNameIsEmpty"}, // массив2
                {"Ivan","", "Password is Empty"} // массив3
        };
    }
    @Test(dataProvider = "data")// пример
    public void firstTest(String name, String password, String errorMessage) throws Exception{
//        homePage.typeUsersname(name);
//        homePage.typeUsersname(password);
//        assertEquals(home.getMessage(),errorMessage);

    }
    @Test(testName = "Buty Test Name") // для красоты и возможно удобства ))
    public void fiveTest() {
        System.out.println("3 test");
    }

    @Test(testName = "Buty Test Name") // для красоты и возможно удобства ))
    public void sixTest() {
        System.out.println("3 test");
    }


}

