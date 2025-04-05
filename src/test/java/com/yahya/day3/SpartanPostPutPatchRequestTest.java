package com.yahya.day3;

import com.yahya.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanPostPutPatchRequestTest extends SpartanTestBase {

    @Test
    public void testAddOneSpartanStringBody(){

        /**
         * Post /spartans
         * content type is json
         * body is
         *  {
         *     "id": 1,
         *     "name": "Meade",
         *     "gender": "Male",
         *     "phone": 3584128232
         * }
         *
         * expect status to be 201
         * body json format
         * response body
         *
         * {
         * "success": "A Spartan is Born!"
         * "data": {
         *     "id": 1,
         *     "name": "Meade",
         *     "gender": "Male",
         *     "phone": 3584128232
         *  }
         * }
         */
        String body = "{\n" +
                "    \"name\": \"Meade2\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"phone\": 5554128232\n" +
                "}";
        given().log().all().contentType(ContentType.JSON)
                .body(body).
                when().post("/spartans").
                then().log().all().statusCode(201)
                .contentType(ContentType.JSON)
                .body("success", is("A Spartan is Born!"))
                .body("data.name", is("Meade2"));
    }
}
