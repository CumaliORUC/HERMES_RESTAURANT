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

        tags="@e2e",    // We can use these tags for scenarios;
                        //"@issue-03" "@issue-04", "@@issue-05", "@e2e", "@cart_Scenarios", "@min_amount"

        publish = true,

        dryRun=false

)
public class ui_Runner {

}
