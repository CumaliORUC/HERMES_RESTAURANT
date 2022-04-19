package ui.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin={"html:target\\cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"},

        features="src/test/resources/ui_Features",
        glue= "ui/stepdefinitions",

        tags="@bug-1",   // "@bug-2", "@bug-3"


        dryRun=false

)
public class TestRunner1 {

}