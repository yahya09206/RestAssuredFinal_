package com.yahya.day4;

import com.yahya.utility.SpartanTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanPutPatchTest extends SpartanTestBase {


    @Test
    public void updateSpartanTest() {

        /**
         * PUT /spartans/{id}
         * content type is json
         * body is
         *  {
         *     "name": "Meade",
         *     "gender": "Male",
         *     "phone": 3584128232
         * }
         *
         * expect status to be 204
         */

        String updatedBody = "{\n" +
                "              \"name\": \"New Body\",\n" +
                "              \"gender\": \"Male\",\n" +
                "              \"phone\": 3584128232\n" +
                "          }";

        given().log().all().pathParam("id", 5).contentType(ContentType.JSON).body(updatedBody).
                when().put("/spartans/{id}").
                then().log().all().statusCode(equalTo(204));
    }

    @Test
    public void updateOneSpartanTest() {

        String updatedName = "{\"name\": \"Updated Name\"}";

        given().log().all().pathParam("id", 5).contentType(ContentType.JSON).body(updatedName).
                when().patch("/spartans/{id}").
                then().log().all().statusCode(equalTo(204));
    }

    @Test
    public void deleteSpartanTest() {

        /**
         * send Delete request to /spartans/{id}
         */
        Response response = get("/spartans");
        int lastId = response.path("id[-1]");

        given().log().all().pathParam("id", lastId).
                when().delete("/spartans/{id}").
                then().log().all().statusCode(equalTo(204));



    }

}
