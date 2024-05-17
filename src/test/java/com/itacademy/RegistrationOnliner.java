package com.itacademy;
import com.itacademy.Pages.OnlinerRegistration;
import com.itacademy.Pages.ProductListingPage;
import com.itacademy.utils.DriverManager;
import com.itacademy.utils.ScreenshitUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import static org.testng.Assert.assertEquals;

public class RegistrationOnliner extends BaseTest{
    int count =0;


    @DataProvider(name="data")
    public Object [][] getData(){
        return new Object[][]{
                {"test@gmai","123","Некорректный e-mail", "Минимум 8 символов"}
               // {"test@gmail.com","12345678","Ненадежный пароль, 8 символов"}
        };
    }
    @Test (dataProvider = "data") //String email, String password, String expectedEmailError, String expectedPasswordError
    public void test1(String email, String password, String expectedEmailError, String expectedPasswordError) throws InterruptedException {
    OnlinerRegistration onlinerRegistration = new OnlinerRegistration();
    onlinerRegistration.openOnlinerRegistrationURL();
    WebElement setEmailField = DriverManager.getDriver().findElement(By.xpath("//*[@type='email']"));
    WebElement setPassword = DriverManager.getDriver().findElement(By.xpath("//*[@placeholder='Придумайте пароль']")); ////*[@type="password"]
    setEmailField.sendKeys(email);
    setPassword.sendKeys(password);
        Thread.sleep(5000);
    //onlinerRegistration.clickRegistration();
       // Thread.sleep(5000);
    WebElement emailError = DriverManager.getDriver().findElement(By.xpath("//*[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']"));
    WebElement passwordError = DriverManager.getDriver().findElement(By.xpath("//*[@class='auth-form__securebox auth-form__securebox_condensed'] //*[@class='auth-form__description auth-form__description_primary auth-form__description_tiny auth-form__description_condensed-other']"));

    assert
            emailError.getText().equals(expectedEmailError): "неверное сообщение об ошибке для поля Email";

//    assert
//            passwordError.getText().equals(expectedPasswordError) : "неверное сообщение об ошибке для поля Password";
//    Thread.sleep(5000);
//    count ++;
//    assertEquals(3,count);
    }
}
