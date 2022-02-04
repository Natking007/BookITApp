package com.CyberTek.BookIT.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MapPage extends BasePage {

@FindBy(xpath = "//*[text()='schedule']")
    public WebElement scheduleButton;

@FindBy(xpath = "//*[text()='hunt']")
    public WebElement huntButton;




}
