package ui.stepdefinitions;

import io.cucumber.java.en.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import ui.pages.hermes_Page;

import java.util.ArrayList;
import java.util.List;

public class hermes_Cart_Stepdefinitions {
    hermes_Page hermes_page=new hermes_Page();
    Logger log = (Logger) LogManager.getLogger(hermes_Cart_Stepdefinitions.class);
    String previousOrderNumber;
    int count_plus=0;
    int count_minus=0;
    @When("User clicks to plus icon")
    public void user_clicks_to_plus_icon() throws InterruptedException {

        previousOrderNumber=hermes_page.order_Number.getText();

        for (int i=1; i<=3; i++) {                //3 times click to plus icon
            hermes_page.plusIcon.click();
            count_plus++;
        }
        System.out.println("Count Plus Number= "+count_plus);
        System.out.println("Previous Order Number= "+previousOrderNumber);

        Thread.sleep(3000);
        System.out.println("Current Order Number= "+hermes_page.order_Number.getText());
        log.info("The Plus Icon is clicked (3)");
    }

    @Then("Verify that the order number has increased")
    public void verify_That_The_Order_Number_Has_Increased() {

        Assert.assertNotEquals(previousOrderNumber, hermes_page.order_Number.getText());

        int currentOrderNumber=Integer.parseInt(previousOrderNumber)+count_plus;

        System.out.println("Current Order Number= "+currentOrderNumber);

        Assert.assertEquals(String.valueOf(currentOrderNumber),hermes_page.order_Number.getText());

        log.info("The order number has increased");
    }

    @And("User clicks to minus icon")
    public void userClicksToMinusIcon() {

        previousOrderNumber=hermes_page.order_Number.getText();
        System.out.println("Minus previous number "+previousOrderNumber);
        for (int i=1; i<=2; i++) {                //2 times click to plus icon
            hermes_page.minus_Icon.click();
            count_minus++;
        }
        log.info("The Minus Icon is clicked");
    }

    @Then("Verify that the order number has decreased")
    public void verifyThatTheOrderNumberHasDecreased() {

        Assert.assertNotEquals(previousOrderNumber, hermes_page.order_Number.getText());

        int currentOrderNumber=Integer.parseInt(previousOrderNumber)-count_minus;

        System.out.println("Current Order Number= "+currentOrderNumber);
        System.out.println("Count Minus Number= "+count_minus);

        Assert.assertEquals(String.valueOf(currentOrderNumber),hermes_page.order_Number.getText());

        log.info("The order number has decreased");
    }


    @Then("Verify subtotal price same with total product price")
    public void verifySubtotalPriceSameWithProductPrice() {
        List<String> priceList_SubString=new ArrayList<>();

        double total_price=0;
        for (WebElement each:hermes_page.productPricesList()) {
            priceList_SubString.add((each.getText().substring(0,4)).replace(",","."));  //Euro exclude and "." change with ","
        }
        List<Double>price_double_List=new ArrayList<>();

        for (int i=0; i<=priceList_SubString.size()-1; i++) {           //A double list created.And String data converted to double. And added in the Double list
            System.out.println("Product "+(i+1)+ " Price is " + priceList_SubString.get(i));
            price_double_List.add(Double.parseDouble(priceList_SubString.get(i)));

        }

        for (int i=0; i<=price_double_List.size()-1; i++) {
            total_price+=price_double_List.get(i);              //In this method; All product prices are added together to find the total price
        }

        //System.out.println("This total price is double = "+total_price );  //this is double now for Assertion we will convert to String
        String expected_total_Price=(total_price+"").substring(0,4).replace(".",",");   // and we will replace "." to "," for matching structure.
        System.out.println("Total price should be= "+expected_total_Price);

        String actual_total_price=hermes_page.subTotal_Price.getText().substring(0,4);

        Assert.assertEquals(expected_total_Price,actual_total_price);

        log.info("Subtotal Price and Product Total price is same");

    }
    @When("User clicks to minus icon for remove the product")
    public void userClicksToMinusIconForRemoveTheProduct() {
        hermes_page.minus_Icon.click();
        log.info(" Minus Icon is clicked for removing the product");
    }

    @Then("User verify that {string} message appeared")
    public void userVerifyThatMessageAppeared(String remove_Message) {

        Assert.assertTrue(hermes_page.delete_Message.isDisplayed());
        log.info(remove_Message+ " message is displayed");
    }

    @When("User clicks to remove confirm button")
    public void userClicksToRemoveConfirmButton() {
        hermes_page.delete_Confirm_Button.click();
    }

    @Then("User verify that item removed from cart and {string} message is shown on cart")
    public void userVerifyThatItemRemovedFromCartAndMessageIsShownOnCart(String empty_Message) {
        Assert.assertTrue(hermes_page.cart_empty_Message.isDisplayed());
        log.info(empty_Message + "message is displayed");
    }

}
