package com.CyberTek.BookIT.Pages;

import com.CyberTek.BookIT.UTILs.ConfigurationReader;
import com.CyberTek.BookIT.UTILs.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(name = "email")
    public WebElement emailBox;

    @FindBy(name = "password")
    public WebElement passWordBox;

    @FindBy(xpath = "(// *[text()='my'])[2]")
    public WebElement myButton;

    @FindBy(xpath = "//*[text()='self']")
    public WebElement selfButton;

    @FindBy(xpath ="//button[@type='submit']" )
    public WebElement signIn;

@FindBy(xpath = "//div[@class='card-content is-transparent']/div[2]/div[2]/p[1]")
    public WebElement roleIndicator;

@FindBy(xpath = "//*[text()='sign out']")
public WebElement signOut;


// method that goes to Page
    public void goTopage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("bookIt.url"));
    }


// Method for student login cred
    public void loginForstudent(){
        emailBox.sendKeys(ConfigurationReader.getProperty("studentEmail"));
        passWordBox.sendKeys(ConfigurationReader.getProperty("studentPass"));
        signIn.click();
    }

    //Method for student teamLeader
    public void loginForTML(){
        emailBox.sendKeys(ConfigurationReader.getProperty("TeamLeaderEmail"));
        passWordBox.sendKeys(ConfigurationReader.getProperty("teamleaderPass"));
        signIn.click();
    }

   // Method for teacher login
    public void loginForTeacher(){
        emailBox.sendKeys(ConfigurationReader.getProperty("TeacherEmail"));
        passWordBox.sendKeys(ConfigurationReader.getProperty("teacherPass"));
        signIn.click();
    }


    //Method to hover over
    public void hoverOver(WebElement elem){
        Actions actions = new Actions(Driver.getDriver());
         actions.moveToElement(elem).perform();

    }

    //Method to click
    public void clickOn(WebElement elem){
        Actions actions = new Actions(Driver.getDriver());
        actions.click(elem);
    }

    public static void Interview(){

                List<String> list1 = new ArrayList<>();
        list1.add("Bake");
        list1.addcamsey
    }


}
