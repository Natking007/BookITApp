package com.CyberTek.BookIT.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class confirmationPage extends BasePage{

    @FindBy(xpath = "//button[@class='button is-dark']")
    public WebElement confirmButton;

    @FindBy(xpath ="//*[text()='yey, you got it']")
    public WebElement bookingStatus;
}
