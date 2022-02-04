package com.CyberTek.BookIT.Pages;

import com.CyberTek.BookIT.UTILs.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

     public BasePage(){
        PageFactory.initElements(
                Driver.getDriver(),this);
    }



}
