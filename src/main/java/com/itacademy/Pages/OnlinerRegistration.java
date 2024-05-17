package com.itacademy.Pages;
import com.itacademy.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlinerRegistration extends BasePage {
//@FindBy(xpath = "//*[@class='auth-input auth-input_primary auth-input_base auth-form__input auth-form__input_width_full']")
//@FindBy(xpath = "//*[@data-sider-select-id='59d9970f-c856-4d25-8188-69316d341f7a']")
//private WebElement emailField;
//    @FindBy(xpath = "//*[@type='password']")
//private WebElement passwordField;
    @FindBy(xpath = "//*[@class='auth-button auth-button_primary auth-button_middle auth-form__button auth-form__button_width_full']")
    private WebElement registrationButton;
    public OnlinerRegistration ()
    {
        //super(driver);
        PageFactory.initElements(driver,this);//this
    }
    public void openOnlinerRegistrationURL(){DriverManager.getDriver().get("https://profile.onliner.by/registration");}
//    public void setEmailField(String email){
//        //emailField.sendKeys();
//    }
//    public void setPassword(String password){
////passwordField.sendKeys("12345");
//    }
    public void clickRegistration(){
        registrationButton.click();
    }
}
