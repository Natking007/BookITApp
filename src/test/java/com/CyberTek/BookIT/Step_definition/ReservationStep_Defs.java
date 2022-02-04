package com.CyberTek.BookIT.Step_definition;

import com.CyberTek.BookIT.Pages.*;
import com.CyberTek.BookIT.UTILs.BrowserUtils;
import com.CyberTek.BookIT.UTILs.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ReservationStep_Defs {

    MapPage maps = new MapPage();
    HuntPage hunt = new HuntPage();

    confirmationPage confirmationPage = new confirmationPage();
    LoginPage loginPage = new LoginPage();
    SchedulePage schedulePage = new SchedulePage();


    @When("User clicks Hunt button")
    public void user_clicks_hunt_button() {
        maps.huntButton.click();
    }


    @When("User picks a date and time")
    public void user_picks_a_date_and_time() {

        BrowserUtils.waitFor(3);

        hunt.calendarButton.click();

        BrowserUtils.waitFor(3);
        hunt.dateSelect(9);

        hunt.from.click();
        BrowserUtils.waitFor(3);
        hunt.timeSelect("8:00pm");


        hunt.to.click();
        BrowserUtils.waitFor(3);
        hunt.timeSelect("10:00pm");

    }


    @When("User clicks search")
    public void user_clicks_search() {
        hunt.searchButton.click();

    }

    @When("User goes to Free Spots page and Book a room")
    public void user_goes_to_free_spots_page_and_book_a_room() {

        FreeSpotsPage freeSpotsPage = new FreeSpotsPage();

        freeSpotsPage.roomPicker("denali");

        BrowserUtils.clickElements(freeSpotsPage.bookButton);

        BrowserUtils.waitFor(3);
        confirmationPage.confirmButton.click();

    }

    @Then("User should see {string} message")
    public void user_should_see_message(String string) {

        Assert.assertEquals(confirmationPage.bookingStatus.getText(), "yey, you got it");

    }





    //Scenario 2

    @When("user click on email")
    public void userClickOnEmail() {
        loginPage.emailBox.click();

    }

    @And("User enters email {string}")
    public void userEntersEmail(String email) {

        loginPage.emailBox.sendKeys(email);
    }

    @And("user click on password")
    public void userClickOnPassword() {

        loginPage.passWordBox.click();

    }

    @And("user enters password {string}")
    public void userEntersPassword(String password) {

        loginPage.passWordBox.sendKeys(password);
    }


    @And("user clicks sign in button")
    public void userClicksSignInButton() {

        loginPage.signIn.click();
    }


    @And("user click's on My section")
    public void userClickSOnMySection() {

     BrowserUtils.clickElements(schedulePage.scheduleOption);
         schedulePage.myButton.click();

    }

    @Then("user should view current schedule")
    public void userShouldViewCurrentSchedule() {

        schedulePage.selectReservedRoom();

        BrowserUtils.waitFor(3);

        schedulePage.tableInfogetter();


    }
}

    /**
     *
    @When("User selects time")
    public void user_selects_time() {

        for(WebElement each: hunt.allTimes){
            System.out.println(each.getText());
        }

    }

     **/