package com.CyberTek.BookIT.Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // tells the junit this is a cucumber test
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",// rerun.txt is where the failed
                // scenarios are saved
               "json:target/cucumber.json"// this is for generating a html report
                //"json:target/cucumber-reports/CucumberTestReport.json"
        },
        features = "src/test/resources/features",
        glue = "com/CyberTek/BookIT/Step_definition",
       // format= {"pretty","html:test-output_1",
                //"json:target/cucumber-reports/CucumberTestReport.json"},
        dryRun = false,
       tags = "@regression"
)

public class CukesRunner {


}
