package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.utulities.Driver;

import java.util.ArrayList;
import java.util.List;

    public class hermes_Page {
        public hermes_Page(){PageFactory.initElements(Driver.getDriver(),this);}

        @FindBy (css = "span.LanguageSwitcher__icon")
        public WebElement languageIcon;

        @FindBy (xpath = "//*[text()='English']")
        public WebElement englishLanguage;

        @FindBy (xpath = "//div[@class='text-mode-title-text']")
        public WebElement selectedCategory;

        @FindBy (xpath = "(//p[@class='Text_Text__2q0SF Tab_text__2YoxB'])[2]")
        public WebElement pickUp_Button;

        @FindBy (css ="div.Tab_Tab__x2cjs")
        public WebElement delivery_Button;

        @FindBy (xpath = "//button[@type='submit']")
        public WebElement deliveryOptions_Confirm_Button;

        @FindBy (xpath = "//button[@data-testid='extras-order-btn']")
        public WebElement product_menu_Confirm_Button;

        @FindBy (css = "button.button-order.positive-action")
        public WebElement ordernow_Button;

        @FindBy (css = "div.heading--name")
        public WebElement address_and_personel_title;

        @FindBy (xpath = "//input[@placeholder='First name']")
        public WebElement firstname_Box;

        @FindBy (xpath = "//*[text()='Checkout']")
        public WebElement checkOut_Button;

        @FindBy (xpath = "//input[@id='payment-method-cash-1']")
        public WebElement cash_Radio_Button;

        @FindBy (xpath = "(//div[@class='value'])[3]")
        public WebElement totalPrice;

        @FindBy (css = "button.button-order.positive-action")
        public WebElement order_Price;

        @FindBy (css = "p.title")
        public WebElement successMessage;

        @FindBy (css = "div.count-label-wrapper")
        public WebElement order_Number;

        @FindBy (xpath = "//div[@data-testid='basket-plus']")
        public WebElement plusIcon;

        @FindBy (xpath = "//i[@class='fas fa-minus-circle']")
        public WebElement minus_Icon;

        @FindBy (xpath = "//input[@type='checkbox']")
        public WebElement inform_checkbox;

        @FindBy (linkText = "Contact us")
        public WebElement contact_Us_Button;

        @FindBy (xpath = "//input[@placeholder='Your email address']")
        public WebElement email_Box;

        @FindBy (xpath = "//textarea[@placeholder='Your message']")
        public WebElement comment_Box;

        @FindBy (xpath = "//input[@data-testid='checkbox-contact']")
        public WebElement agreement_checkbox;

        @FindBy (xpath = "//button[@data-testid='send-btn-contact']")
        public WebElement send_feedback_button;

        @FindBy (css = "span.ant-alert-message")
        public WebElement feedBack_alertMessage;

        @FindBy (xpath = "(//div[@class='value'])[1]")
        public WebElement subTotal_Price;

        @FindBy (xpath = "(//div[@class='value'])[2]")
        public WebElement discount_Price;

        @FindBy (css = "div.Select2_Select2__1sdnK")
        public WebElement delivery_address_dropdown_box;

        @FindBy (xpath = "//li")
        public WebElement augsburg_ZipCode;

        @FindBy (css = "div.min-order-value")
        public WebElement minimumOrderAmountMessage;

        @FindBy (xpath = "//*[text()='Delivery']")
        public WebElement delivery_ButtonHomePage;

        @FindBy (css ="span.active")
        public WebElement deliveryButton_Active;


        public List<WebElement> productPricesList() {
           List<WebElement> allPriceList=Driver.getDriver().findElements(By.cssSelector("div.total-price"));
           List <WebElement>cart_productPriceList=new ArrayList<>();
            for (int i=0; i<allPriceList.size()-1; i++) {   //these lines for exclude subtotal price
                cart_productPriceList.add(allPriceList.get(i));
            }
           return cart_productPriceList;
        }

        public void select_Category (String categoryName){
            Driver.getDriver().findElement(By.linkText(categoryName)).click();
        }


        public List<WebElement> selected_product_list() {
            List<WebElement> product_list=new ArrayList<>();

           product_list=Driver.getDriver().findElements(By.xpath("//h5[@class='Heading_Heading__2JCuX productName']"));
           return product_list;
        }

        public List<String> productList_at_Cart() {
            List<WebElement> product_List_Webelement=new ArrayList<>();
            List<String> product_Name_List=new ArrayList<>();
            product_List_Webelement=Driver.getDriver().findElements(By.cssSelector("div.product-name"));

            for (WebElement each: product_List_Webelement) {
                product_Name_List.add(each.getText());
            }
            return product_Name_List;
        }



}

