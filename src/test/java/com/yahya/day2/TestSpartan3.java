package com.yahya.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;

public class TestSpartan3 {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://44.211.192.252:8000";
        RestAssured.basePath = "/api";
    }

    @AfterAll
    public static void tearDown() {
        RestAssured.reset();
    }

    @Test
    public void testAllSpartan() {

        Response response = get("/spartans");
        //response.prettyPrint();

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals(ContentType.JSON.toString(), response.getContentType());

        System.out.println("response.path(\"[0].gender\") = " + response.path("[0].gender"));

        System.out.println("response.path(\"gender[0]\") = " + response.path("gender[0]"));
    }

}
