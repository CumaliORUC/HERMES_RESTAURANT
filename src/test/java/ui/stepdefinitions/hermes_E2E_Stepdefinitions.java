package ui.stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import ui.pages.hermes_Page;
import ui.utulities.ConfigReader;
import ui.utulities.Driver;

import java.util.Random;

public class hermes_E2E_Stepdefinitions {

 hermes_Page hermes_page=new hermes_Page();
 Logger log = (Logger) LogManager.getLogger(hermes_E2E_Stepdefinitions.class);

   Random random=new Random();
    String selected_Product_Name;


    @Given("User Goes to Hermes American Burger Pizza House home page")
    public void user_goes_to_hermes_american_burger_pizza_house_home_page() {

        Driver.getDriver().get(ConfigReader.getProperty("hermes_home_page"));
         hermes_page.languageIcon.click();
         hermes_page.englishLanguage.click();

    }

    @Then("Verify that page is American Burger Pizza House Home page")
      public void verifyThatPageTitleIsContainsAmericanBurger() {

       String expected_title="American Burger";
       String actual_title=Driver.getDriver().getTitle();

       Assert.assertTrue(actual_title.contains(expected_title));
       log.info("It has gone to the Hermes Home Page");

    }

    @When("User selects {string} category in the category menu")
    public void userSelectsInTheCategoryMenu(String selectedCategory) {

       hermes_page.select_Category(selectedCategory);
       log.info(selectedCategory+" is selected");
    }

    @Then("Verify product list with category {string}")
    public void verify_product_list_with_category(String selectedCategory) {

       String actualCategory=hermes_page.selectedCategory.getText();

       Assert.assertEquals(selectedCategory,actualCategory);

       log.info(selectedCategory+" category is verified");

    }
    @When("User selects random a product from the product list")
    public void user_selects_random_a_product_from_the_product_list() {

       WebElement selected_Product=hermes_page.selected_product_list().get(random.nextInt(hermes_page.selected_product_list().size()));
       selected_Product_Name=selected_Product.getText();

       if(selected_Product_Name.equals("American Knobi Burger")) {  //American Knobi Burger order is deactivate. if this selected, It will select a new one

          selected_Product=hermes_page.selected_product_list().get(random.nextInt(hermes_page.selected_product_list().size()));
          selected_Product_Name=selected_Product.getText();
       }
       log.info(selected_Product_Name+ " product selected random");
       selected_Product.click();
    }

    @When("User select Delivery type as {string}")
    public void user_select_delivery_type_as(String deliveryOption) {

       if (deliveryOption.equals("Pickup")) {
          hermes_page.pickUp_Button.click();
       }
       else { hermes_page.delivery_Button.click();
          hermes_page.delivery_address_dropdown_box.click();
          hermes_page.augsburg_ZipCode.click();
       }
       hermes_page.deliveryOptions_Confirm_Button.click();
       log.info(deliveryOption+" Options is selected");
    }
    @When("User clicks to Confirm")
    public void user_clicks_to_confirm() {

       if (hermes_page.product_menu_Confirm_Button.isDisplayed()) {
          hermes_page.product_menu_Confirm_Button.click();
       }
        log.info(" Product order is confirmed ");
    }
    @Then("Verify that the selected product is in the cart")
    public void verify_that_the_selected_product_is_in_the_cart() {

       Assert.assertTrue(hermes_page.productList_at_Cart().contains(selected_Product_Name));
       log.info(selected_Product_Name +" is  added to the cart");
    }
    @Then("User clicks to Order now")
    public void user_clicks_to_order_now() {
       hermes_page.ordernow_Button.click();
       log.info("Order Now button is clicked");
    }
    @Then("Verify that address page is displayed")
    public void verify_that_address_page_is_displayed() {

       Assert.assertTrue(hermes_page.address_and_personel_title.isDisplayed());
       log.info("Address page is displayed");

    }
    @When("User full fills the address boxes")
    public void user_full_fills_the_address_boxes() {

       Actions action=new Actions(Driver.getDriver());
       Faker faker=new Faker();

       action.sendKeys(hermes_page.firstname_Box,faker.name().firstName()).sendKeys(Keys.TAB)
               .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
               .sendKeys(faker.name().name()).sendKeys(Keys.TAB)
               .sendKeys(faker.address().streetAddress()).sendKeys(Keys.TAB)
               .sendKeys(faker.number().digit()).sendKeys(Keys.TAB)
               .sendKeys(faker.number().digits(5)).sendKeys(Keys.TAB)
               .sendKeys(faker.address().city()).sendKeys(Keys.TAB)
               .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB)
               .sendKeys(faker.number().digits(6)).sendKeys(Keys.TAB) //some times faker cellphone cant match with
               .sendKeys(faker.lorem().characters(100)).perform();

       log.info("Address boxes is full filled");
    }

    @And("User clicks to Checkout")
    public void user_clicks_to_checkout() {
       hermes_page.checkOut_Button.click();
       log.info("CheckOut button is clicked");
    }
    @Then("Verify that the Cash Button is selected")
    public void verify_that_the_cash_button_is_selected() {

       hermes_page.cash_Radio_Button.click();
       log.info("Cash button is selected");
    }
    @Then("Verify that the Order price is the same as the Total price")
    public void verify_that_the_order_price_is_the_same_as_the_total_price() {
       System.out.println("Totat Price  == "+hermes_page.totalPrice.getText());
       System.out.println("Order Price == "+hermes_page.order_Price.getText());
       Assert.assertTrue(hermes_page.order_Price.getText().contains(hermes_page.totalPrice.getText()));
       log.info("Prices are same");
    }
    @When("User clicks to Place My Order for")
    public void user_clicks_to_place_my_order_for() {

       hermes_page.order_Price.click();
       log.info("Place My Order button is clicked");
    }
    @Then("Verify that {string} message is displayed")
    public void verify_that_message_is_displayed(String successMessage) {

       Assert.assertEquals(successMessage,hermes_page.successMessage.getText());
       log.info(successMessage+ " is displayed");
    }

}
