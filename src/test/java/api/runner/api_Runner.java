package api.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target\\cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"},

        features="src/test/resources/api_Feautures",
        glue= "api/stepdefinitions",


        tags="@american_url", // @american_url, @bremen_Url

        publish=true,
        dryRun=false
)
public class ApiRunner {
}
