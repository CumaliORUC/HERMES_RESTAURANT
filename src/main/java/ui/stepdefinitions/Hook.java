package ui.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ui.utulities.Driver;

public class Hook {
    @After public void tearDown(Scenario scenario){
        final byte[] screenshot=((TakesScreenshot)
                Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if(scenario.isFailed()) {
            scenario.attach(screenshot, "image/png","screenshots"); }

        else {scenario.attach(screenshot, "image/png","screenshots");}
      Driver.closeDriver();
    }
}