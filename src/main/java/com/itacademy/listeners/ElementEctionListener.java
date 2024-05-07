package com.itacademy.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class ElementEctionListener implements WebDriverListener {
//    @Override
//    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
//        System.out.println(String.valueOf(keysToSend) + "was typed into " + element.toString());
//    }

    @Override
    public void afterClick(WebElement element) {
        WebDriverListener.super.afterClick(element);
        System.out.println("Был Клик)");
    }

    @Override
   public void afterGetText(WebElement element, String result) {
      //  WebDriverListener.super.afterGetText(String (result);
        System.out.println("Был Get");
    }
}
