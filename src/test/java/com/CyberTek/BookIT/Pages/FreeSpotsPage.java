package com.CyberTek.BookIT.Pages;

import com.CyberTek.BookIT.UTILs.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class FreeSpotsPage extends BasePage {

    //@FindBy(xpath = "//button[@class='button is-transparent is-white']")
   //@FindBy(xpath = "//div[@class='column is-one-third ng-star-inserted']")

    @FindBy(xpath = "//p[@class='title is-size-4']")
    public List<WebElement> availableRooms;

    @FindBy(xpath = "//div[@class='card-footer-item']")
    public WebElement bookButton;

    //First locate the buttons for each room
    @FindBy(xpath = "(//button[@class='button is-transparent is-white'])[1]")
    public WebElement kilimanjaroRoom;

    @FindBy(xpath = "(//button[@class='button is-transparent is-white'])[2]")
    public WebElement halfDomeRoom;


    @FindBy(xpath = "(//button[@class='button is-transparent is-white'])[3]")
    public WebElement denaliRoom;


    @FindBy(xpath = "(//button[@class='button is-transparent is-white'])[4]")
    public WebElement meruRoom;


    // I want to iterate through the buttons and choose room based on the room name given
    public void roomPicker(String roomName) {

        for (WebElement each : availableRooms) {

            String actualRooms = each.getText();

            if (!roomName.equalsIgnoreCase(actualRooms)) {

                System.out.println(actualRooms);
            }else{
                BrowserUtils.clickElements(bookButton);
            }
        }
    }
}

