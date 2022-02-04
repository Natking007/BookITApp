package com.CyberTek.BookIT.Pages;

import com.CyberTek.BookIT.UTILs.BrowserUtils;
import com.CyberTek.BookIT.UTILs.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalTime;
import java.util.List;

public class HuntPage extends BasePage{

    @FindBy(xpath="//*[@id=\"mat-input-0\"]")
    public WebElement date;

    @FindBy(xpath = "//*[@id=\"mat-select-0\"]")
    public WebElement from;


 // @FindBy(xpath ="/*[@id=\"mat-select-1\"]")
   // @FindBy(xpath = "(//div[@class='mat-select-trigger'])[2]")
    
    @FindBy(xpath = "(//div[@class='mat-form-field-infix'])[3]")
    public WebElement to;

    @FindBy(xpath = "//*[text()='search']")
    public WebElement searchButton;

   // @FindBy(xpath = "//div[@class='mat-form-field-suffix ng-tns-c12-0 ng-star-inserted']/mat-datepicker-toggle/button")
    @FindBy(xpath = "//button[@class='mat-icon-button']")
    public WebElement calendarButton;

    //@FindBy(xpath = "(//table[@class='mat-calendar-table'])//td")
    @FindBy(xpath = "//div[@class='mat-calendar-body-cell-content']")
    public List<WebElement> allDates;

    //@FindBy(xpath = "//div[@class='mat-option-ripple mat-ripple']")
   // @FindBy(xpath = "//div[@class='mat-select-content ng-trigger ng-trigger-fadeInContent']//mat-option")
    @FindBy(xpath = "//span[@class='mat-option-text']")
    //@FindBy(xpath = "//div[@id='cdk-overlay-0']//div//span")
    public List<WebElement> allTimes;

    @FindBy(id="mat-option-0")
    public WebElement sevenOclcok;

    @FindBy(id="mat-option-33")
    public WebElement nineOclock;



    public void dateSelect(int givendate){

        for (WebElement elem : allDates) {
/**
 * Step failed with select
 * org.openqa.selenium.support.ui.UnexpectedTagNameException: Element should have been "select" but was "td"
 *
 *    Select select = new Select(elem);
 *             select.selectByIndex(date);
 *
 *             date = elem.getText();
 *             if(date.equalsIgnoreCase("28")){
 *                 elem.click();
 *             }else{
 *                 continue;
 *             }
 *
 *         }
 *
 *             public void timeSelect(String time){
 *
 *         for (WebElement elem: allTimes) {
 *
 *            // Select select = new Select(elem);
 *             //select.selectByIndex(time);
 *             time = elem.getText();
 *             if(time.equalsIgnoreCase("28")){
 *                 elem.click();
 *             }else{
 *                 continue;
 *             }
 *
 *
 *         }
 *     }
 *
 *
 */

               int actualDate = Integer.parseInt(elem.getText());

               if(actualDate < givendate){
                  continue;
               }else{
                  elem.click();
                  break;
              }

      }


    }

    public void timeSelect(String giventime){//use givenTime!

        for (WebElement elem: allTimes) {

           String actualTIme = elem.getText();

           if(!actualTIme.contains("pm")){
               continue;

           }else{
               BrowserUtils.clickElements(elem);
               break;
           }




        }
    }




}
