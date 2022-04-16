package ui.stepdefinitions;

import io.cucumber.java.en.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import ui.pages.hermes_Page;
import ui.utulities.Driver;

public class hermes_Minimum_Order_Amoun_Stepdefinitions {

    hermes_Page hermes_page=new hermes_Page();
    Logger log = (Logger) LogManager.getLogger(hermes_Minimum_Order_Amoun_Stepdefinitions.class);

    @When("User selects {string} product from the product list")
    public void userSelectsProductFromTheProductList(String productName) throws InterruptedException {
        String xpath_productName="//*[text()='"+productName+"']";               //This method can click all product
        Driver.getDriver().findElement(By.xpath(xpath_productName)).click();
        log.info(productName +" product is selected");


    }
    @Then("Verify that order is not sufficient for minimum ordering")
    public void verify_that_order_is_not_sufficient_for_minimum_ordering() {

        Assert.assertFalse(hermes_page.order_Price.isEnabled());

        log.info("Since the minimum order amount of 11.00 € has not been reached yet, the order button is not active");
    }

    @Then("Verify that order is sufficient for minimum ordering")
    public void verifyThatOrderIsSufficientForMinimumOrdering() {
        Assert.assertTrue(hermes_page.order_Price.isEnabled());
        log.info("Since the order amount is over 11 €, the Order button is active");
    }
}
