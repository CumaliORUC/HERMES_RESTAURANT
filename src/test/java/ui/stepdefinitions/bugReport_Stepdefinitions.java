package ui.stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import ui.pages.hermes_Page;

public class bugReport_Stepdefinitions {

    hermes_Page hermes_page=new hermes_Page();
    Logger log = (Logger) LogManager.getLogger(bugReport_Stepdefinitions.class);

    @When("User clicks to inform checkbox")
    public void user_clicks_to_inform_checkbox() {
        hermes_page.inform_checkbox.click();
        Assert.assertTrue(hermes_page.inform_checkbox.isSelected());
        log.info("Inform box is clicked ");
    }

    @When("User clicks to Contact Us")
    public void user_clicks_to_contact_us() {
        hermes_page.contact_Us_Button.click();
        log.info("Contact Us is clicked");
    }
    @When("User full fill email address and commentbox")
    public void user_full_fill_email_address_and_commentbox() {
        Faker faker=new Faker();
        hermes_page.email_Box.sendKeys(faker.internet().emailAddress());
        hermes_page.comment_Box.sendKeys(faker.lorem().characters(50));
        log.info("email address and commentbox are filled");
    }

    @And("User clicks to agreement checkbox")
    public void userClicksToAgreementCheckbox() {
        hermes_page.agreement_checkbox.click();
        log.info("Agreement checkbox is clicked");
    }

    @When("User clicks to sent feed back")
    public void user_clicks_to_sent_feed_back() {
        hermes_page.send_feedback_button.click();
        log.info("Sent feedbacks button is clicked ");
    }
    @Then("Verify that Successful message is displayed")
    public void verify_successful_message_is_displayed() {
        String expected_succes_message="Thank You! For Your Feedbacks";
        Assert.assertEquals(expected_succes_message,hermes_page.feedBack_alertMessage.getText());
        log.info("Success message is displayed");
    }


    @Then("Verify that discount rate is correct")
    public void verifyThatDiscountRateIsCorrect() {
        String  subTotalPriceNumber=hermes_page.subTotal_Price.getText().substring(0,4);   //exclude €
            subTotalPriceNumber=subTotalPriceNumber.replace(",",".");  //change "," with "." for parseDouble
        System.out.println("Subtotal Price= " +subTotalPriceNumber);

        double totalPrice=Double.parseDouble(subTotalPriceNumber);             //convert to double
        double expected_discount_price_Double=totalPrice*0.1;
        System.out.println("Expected discount is = "+expected_discount_price_Double);

        String expected_Discount_Price_String=(expected_discount_price_Double+"").substring(0,4);

        expected_Discount_Price_String=expected_Discount_Price_String.replace(".",",");  //7.58 to 7,58 for Assertion

        System.out.println("Expected price "+expected_Discount_Price_String);

        String actual_Discount_price=hermes_page.discount_Price.getText().substring(1,5); //exclude €

        System.out.println("Actual Discount price is= "+actual_Discount_price);

        Assert.assertEquals(expected_Discount_Price_String,actual_Discount_price);

        log.info("Discount calculation rate is verified");
    }
}
