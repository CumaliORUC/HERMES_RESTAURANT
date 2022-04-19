package api.stepdefinitions;

import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest_MatcherClass {
    Logger log = (Logger) LogManager.getLogger(GetRequest_MatcherClass.class);

    @Test
    public void test01(){
        String baseUrl = "https://dev.delivery-app.app-smart.services/api2.5/cdMiu0eNA2OJ58Z3/get-single-product/159/25448";

        Response response = given()
                .accept("application/json")
                .when()
                .get(baseUrl);
            log.info("Response is received");

        response.prettyPrint();
        response.then().assertThat().statusCode(200); // status code assertions
            log.info("Status code 200 is verified");


        response.then().body("success", equalTo(true),
                        "checksum", equalTo("63103a1b8bb4684e57649297523a2134")
                        ,"product_id", equalTo(25448)
                        ,"d.id", equalTo(25448)
                        ,"d.name", equalTo("American Burger")
                        ,"d.description", equalTo("Rinderhacksteak, Mayo, Salat, Tomaten, Essiggurken, Zwiebel, Ketchup")
                        ,"d.picurl", equalTo("http://delivery-app.app-smart.services/uploads/iQ6Q3ABf1W2V3bAX/4e7b2a3234cc728644b7540f6f027b9f.jpg")
                        ,"d.category_ids[0]", equalTo(2898)
                        ,"d.sub_category_ids[0]", equalTo(null)
                        ,"d.sub_category_ids", is(empty())
                        ,"d.isCombo", is(false)
                        ,"d.additives[0]", equalTo("1563")
                        ,"d.additives[1]", equalTo("1574")
                        ,"d.additives[0,1]", hasItems("1563","1574")
                        ,"d.additives", hasItems("1563","1574")
                        ,"d.basic_ingredients_groups", is(anEmptyMap())
                        ,"d.extra_ingredients_groups.235.description", equalTo("Auf Wunsch")
                        ,"d.extra_ingredients_groups.235.ingredients.731.name", equalTo("extra Fleisch")
                        ,"d.extra_ingredients_groups.235.ingredients.731.price_diff.1691.price", equalTo(2.19F)
                        ,"d.extra_ingredients_groups.235.ingredients.731.price_diff.2280.price", equalTo(2.19F)
                        ,"d.extra_ingredients_groups.235.ingredients.2617.name", equalTo("Extra Käse (2 Scheiben)")
                        ,"d.extra_ingredients_groups.235.ingredients.2618.name", equalTo("Ei-Patty")
                        ,"d.extra_ingredients_groups.235.ingredients.2619.name", equalTo("Extra Turkey Bacon")
                        ,"d.extra_ingredients_groups.430.description", equalTo("Beilage auf Wunsch")
                        ,"d.extra_ingredients_groups.430.ingredients.858.name", equalTo("Pommes + Coca Cola")
                        ,"d.extra_ingredients_groups.430.ingredients.859.name", equalTo("Pommes + Cola light")
                        ,"d.extra_ingredients_groups.430.ingredients.860.name", equalTo("Pommes + Fanta")
                        ,"d.extra_ingredients_groups.430.ingredients.861.name", equalTo("Pommes + Mezzo Mix")
                        ,"d.extra_ingredients_groups.430.ingredients.862.name", equalTo("Pommes + Sprite")
                        ,"d.extra_ingredients_groups.430.ingredients.863.name", equalTo("Pommes + Wasser")
                        ,"d.extra_ingredients_groups.430.ingredients.864.name", equalTo("Pommes + Dunkles Weizen")
                        ,"d.extra_ingredients_groups.430.ingredients.865.name", equalTo("Pommes + Helles Bier")
                        ,"d.extra_ingredients_groups.430.ingredients.866.name", equalTo("Pommes + Helles Weizen")
                        ,"d.extra_ingredients_groups.430.ingredients.867.name", equalTo("Pommes + Pils")
                );
        log.info("Body data assertion is verified with MatcherClass");
    }
}
