package api.utulities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TestBaseTrello {
    protected RequestSpecification spec;

    public void setUp(){
        spec= new RequestSpecBuilder()
                .setBaseUri("https://api.trello.com").build();
    }
}
