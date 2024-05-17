package com.itacademy.Pages;

import com.itacademy.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage extends  BasePage {
    @FindBy(xpath = "//*[@class='sc-bj2vay-0 DCKcC'] //*[text()='M']")
    private WebElement mFilter;

public ProductListingPage ()
{

    PageFactory.initElements(DriverManager.getDriver(),this);//this

}
    public void openURL (){
        DriverManager.getDriver().get("https://react-shopping-cart-67954.firebaseapp.com");
    }

    public void mFilter (){
    mFilter.click();
    }

}
//*[@class='sc-bj2vay-0 DCKcC'] //*[text()='M']