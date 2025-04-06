package com.yahya.day4;

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

public class LibraryAppTest {

    @BeforeAll
    public static void setup(){

        RestAssured.baseURI = "https://library2.cydeo.com";
        RestAssured.basePath = "rest/v1";
    }

    @AfterAll
    public static void teardown(){
        reset();
    }

    /**
     * POST /login
     * content type: application/x-www-form-urlencoded
     * body:
     *  email: librarian5@library
     *  password: libraryUser
     */

    @Test
    public void testLogin(){

        given().log().all().contentType(ContentType.URLENC).
                formParam("email", "librarian5@library").
                formParam("password", "libraryUser").
                when().post("login")
                .then().log().all().statusCode(200);
    }

    @Test
    public void testDashboardStats(){

        Response response = given().log().all().contentType(ContentType.URLENC).
                formParam("email", "librarian5@library").
                formParam("password", "libraryUser").
                when().post("login");

        String tokenFromResponse = response.path("token");
        System.out.println("tokenFromResponse = " + tokenFromResponse);

        /*
        Send request to GET /dashboard_stat
        provide header with the name x-library-token, value is the value you saved from response request
        Verify status code is 200
         */
        given().log().all().header("x-library-token", tokenFromResponse).
                when().get("/dashboard-stats")
                .then().log().all().statusCode(200);
    }
}
