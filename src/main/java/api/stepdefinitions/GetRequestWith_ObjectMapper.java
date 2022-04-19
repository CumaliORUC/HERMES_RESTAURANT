package api.stepdefinitions;

import api.utulities.JsonUtil;
import api.utulities.TestBaseHermes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequestWith_ObjectMapper extends TestBaseHermes {

    Logger log = (Logger) LogManager.getLogger(GetRequestWith_ObjectMapper.class);
    /*
    https://dev.delivery-app.app-smart.services/api2.5/cdMiu0eNA2OJ58Z3/get-single-product/159/25448 url
status kodun 200 ve response body test
{
  {
    "success": true,
    "checksum": "63103a1b8bb4684e57649297523a2134",
    "branch_id": 159,
    "product_id": 25448,
    "d": {
        "id": 25448,
        "collective_order": 1,
        "pos": 2,
        "name": "American Burger",
        "description": "Rinderhacksteak, Mayo, Salat, Tomaten, Essiggurken, Zwiebel, Ketchup",
        "picurl": "http://delivery-app.app-smart.services/uploads/iQ6Q3ABf1W2V3bAX/4e7b2a3234cc728644b7540f6f027b9f.jpg",
        "mbw": 1,
        "display": 1,
        "no": "5",
        "category_ids": [
            2898
        ],
        "sub_category_ids": [

        ],
        "isCombo": false,
        "additives": [
            "1563",
            "1574"
        ],
   }
}
     */
    @Test
    public void test01() {

        String baseUrl="https://dev.delivery-app.app-smart.services/api2.5/cdMiu0eNA2OJ58Z3/get-single-product/159/25448";

        String JsonObject="{\n" +
                "    \"success\": true,\n" +
                "    \"checksum\": \"63103a1b8bb4684e57649297523a2134\",\n" +
                "    \"branch_id\": 159,\n" +
                "    \"product_id\": 25448,\n" +
                "    \"d\": {\n" +
                "        \"id\": 25448,\n" +
                "        \"collective_order\": 1,\n" +
                "        \"pos\": 2,\n" +
                "        \"name\": \"American Burger\",\n" +
                "        \"description\": \"Rinderhacksteak, Mayo, Salat, Tomaten, Essiggurken, Zwiebel, Ketchup\",\n" +
                "        \"picurl\": \"http://delivery-app.app-smart.services/uploads/iQ6Q3ABf1W2V3bAX/4e7b2a3234cc728644b7540f6f027b9f.jpg\",\n" +
                "        \"mbw\": 1,\n" +
                "        \"display\": 1,\n" +
                "        \"no\": \"5\",\n" +
                "        \"category_ids\": [\n" +
                "            2898\n" +
                "        ],\n" +
                "        \"sub_category_ids\": [\n" +
                "            \n" +
                "        ],\n" +
                "        \"isCombo\": false,\n" +
                "        \"additives\": [\n" +
                "            \"1563\",\n" +
                "            \"1574\"\n" +
                "        ]" +
                "}" +
                "}";

        //datayı koyacağımız map oluştur.
        HashMap<String,Object> expectedData=JsonUtil.convertJsonToJava(JsonObject,HashMap.class);
            log.info("Expected Data is convert to Java with JsonUtil Class");
        System.out.println("Expected Data========"+expectedData);

        //Response oluşturalım.
        Response response=given().
                contentType(ContentType.JSON).
                when().get(baseUrl);
            log.info("Response is received");

        response.prettyPrint();

       HashMap<String,Object> actualData=JsonUtil.convertJsonToJava(response.asString(),HashMap.class);

            log.info("Actual Data is created ");

        System.out.println("Actual Data==="+actualData);

        Assert.assertEquals(expectedData.get("success"),actualData.get("success"));
            log.info("Verified the success is same data");

        Assert.assertEquals(expectedData.get("checksum"),actualData.get("checksum"));
            log.info("Verified the checksum is same data");

        Assert.assertEquals(expectedData.get("branch_id"),actualData.get("branch_id"));
            log.info("Verified the branch_id is same data");

        Assert.assertEquals(expectedData.get("product_id"),actualData.get("product_id"));
            log.info("Verified the product_id is same data");

            Assert.assertEquals(((Map)expectedData.get("d")).get("id"),
             ((Map)actualData.get("d")).get("id"));
            log.info("Verified the d body id is same data");

        System.out.println("Additives Data ==> "+((Map)expectedData.get("d")).get("additives"));  //Additives


        //extra_ingredients_groups
        System.out.println("Extra_ingredients_groups Data ==> "+((Map)actualData.get("d")).get("extra_ingredients_groups"));

        //Assertions for additives
       Assert.assertEquals(((Map)expectedData.get("d")).get("additives"),((Map)actualData.get("d")).get("additives"));
            log.info("Verified the d body additives is same data");
    }

}
