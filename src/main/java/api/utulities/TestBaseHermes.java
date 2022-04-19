package api.utulities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TestBaseHermes {

    //This created for same BaseURI and in case of different query params. But in this test case we have only one URL. So we didn't use it.
    protected RequestSpecification spec;

    public void setUp(){
        spec= new RequestSpecBuilder()
                .setBaseUri("https://dev.delivery-app.app-smart.services/api3/1/products/159").build();
    }
}
