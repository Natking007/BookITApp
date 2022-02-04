package com.CyberTek.BookIT.Step_definition;

import com.CyberTek.BookIT.UTILs.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    // similar to testBase.java in TestNG framework
    // we dont have to inherit the hooks class like we do the
    // test base
    // make sure the annotations come from the io.cucumber



    @Before
    public void setUp(){
        System.out.println("Before - setUp method is running before the scenario");
    }

    @After
    public void tearDownScenario(Scenario scenario) {
        //takes screenShot over here!!

        /**
         * Scenario scenario: represents current running cucumber scenario
         * -cast webdriver to TakesScreenshot interface.(TakesScreenshot)Driver.getDriver()
         * -call getScreenShotAs method and output type as OutputType.BYTES
         * -save the result into byte[] array: byte[] image
         * -attach the image into the scenario html report: scenario.attach(image, "image/png", scenario.getName());
         * -if scenario fails in any reason, it will automatically take a screenshot and attach
         */
        if (scenario.isFailed()) {

            byte[] image = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(image, "image/png", scenario.getName());


            System.out.println("After - tearDown method is running after the scenario");


        }

        // Driver.closeDriver();

    }

    @AfterStep
    public void tearDownStep(Scenario scenario) {
        byte[] image=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(image, "image/png", scenario.getName());


    }


}

