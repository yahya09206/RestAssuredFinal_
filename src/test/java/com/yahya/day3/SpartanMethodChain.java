package com.yahya.day3;

import com.yahya.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanMethodChain extends SpartanTestBase {

    @Test
    public void getOneSpartanTest(){

        /**
         * in one shot, send request to GET /spartans{id} with id of 1
         * log everything
         * ask for json response header
         * verify status code is 200
         * content type is json
         * json body : id is 1, name Meade
         */
        given().log().all().pathParam("id", 1).accept(ContentType.JSON).
                when().get("/spartans/{id}").
                then().log().all().statusCode(200)
                .header("Content-Type", "application/json")
                .body("id", is(1))
                .body("name", is("Meade"));
    }
}
