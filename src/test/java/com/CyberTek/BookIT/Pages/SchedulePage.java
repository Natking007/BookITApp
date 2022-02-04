package com.CyberTek.BookIT.Pages;

import com.CyberTek.BookIT.UTILs.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SchedulePage extends BasePage {

    // @FindBy(xpath = "(//*[text()='schedule'])[2]")
    @FindBy(xpath = "(//a[@class='navbar-link'])[1]")
    public WebElement scheduleOption;

    @FindBy(xpath = "(// *[text()='my'])[1]")
    public WebElement myButton;

    @FindBy(xpath = "//table[@class='table is-fullwidth is-transparent borderless']//tbody//tr")
    public List<WebElement> scheduleTableRow;

    @FindBy(xpath = "//table[@class='table is-fullwidth is-transparent borderless']//thead//tr//th")
    public List<WebElement> scheduleTableColumn;


    @FindBy(xpath = "(//div[@class='media-content'])[4]")
    public WebElement conferenceInfo;

    @FindBy(xpath = "//td[@class='conference ng-star-inserted']")
    public WebElement reservationMarker;





    public void tableInfogetter(){
        //for (WebElement eachRow:scheduleTableRow) {


           if(reservationMarker.isDisplayed()){

               BrowserUtils.waitFor(3);
               BrowserUtils.scrollToElement(reservationMarker);
               BrowserUtils.clickWithJS(reservationMarker);
           }


        }

    //}

    // How do I grab the table info content and assert that a room has been
    //booked?

    public void selectReservedRoom() {
        for (WebElement each : scheduleTableColumn) {
            if (each.isEnabled()) {
                each.click();
            } else {
                continue;
            }

        }
    }
}

//for (WebElement eachColumn: scheduleTableColumn) {


  //      }
