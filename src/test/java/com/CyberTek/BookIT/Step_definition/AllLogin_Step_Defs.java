package com.CyberTek.BookIT.Step_definition;

import com.CyberTek.BookIT.Pages.LoginPage;
import com.CyberTek.BookIT.UTILs.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AllLogin_Step_Defs  {

    LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {

        loginPage.goTopage();
    }


    @When("I login as student")
    public void i_login_as_student() {

        loginPage.loginForstudent();

    }

    @When("I click on My")
    public void i_click_on_my() {

        BrowserUtils.waitForClickability(loginPage.myButton,5);
       loginPage.hoverOver(loginPage.myButton);

    }

    @And("I click on Self")
    public void iClickOnSelf() {

        //loginPage.clickOn(loginPage.selfButton);//figure out why this no working
        loginPage.selfButton.click();
    }


    @Then("Role should be student-team-member")
    public void role_should_be_student_team_member() {

       Assert.assertEquals("student-team-member" ,loginPage.roleIndicator.getText());

    }


    @When("I login as team leader")
    public void iLoginAsTeamLeader() {

        loginPage.loginForTML();

    }

    @Then("Role should be student-team-leader")
    public void roleShouldBeStudentTeamLeader() {
        BrowserUtils.waitForPageToLoad(3);
        Assert.assertEquals("student-team-leader" ,loginPage.roleIndicator.getText());
    }

    @When("I login as teacher")
    public void iLoginAsTeacher() {
        loginPage.loginForTeacher();

    }

    @Then("Role should be teacher")
    public void roleShouldBeTeacher() {
       // BrowserUtils.waitForPageToLoad(3);
        Assert.assertEquals("teacher" ,loginPage.roleIndicator.getText());
    }

    @And("click sign out")
    public void clickSignOut() {
        loginPage.signOut.click();
    }
}
