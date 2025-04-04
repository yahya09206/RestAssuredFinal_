package com.yahya.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;


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

        List<Integer> idList = response.path("id");
        System.out.println("idList = " + idList);
    }

    @Test
    public void testGetXMLResponse(){

        Response response = given().header("Accept", "application/xml").
                when().get("/spartans");
        response.prettyPrint();

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals(ContentType.XML.toString(), response.getContentType());
    }

    @Test
    public void testSearch(){

        Response response = given()
                .queryParam("nameContains", "Ea")
                .queryParam("gender", "Male").
                when().get("/spartans/search");

        response.prettyPrint();

        System.out.println("response.path(\"totalElement\") = " + response.path("totalElement"));
        System.out.println("response.path(\"content[0].name\") = " + response.path("content[0].name"));
        System.out.println("response.path(\"content[1].name\") = " + response.path("content[1].name"));
        List<String> allNames = response.path("content.name");
        System.out.println("allNames = " + allNames);
    }

    // GET http://44.211.192.252:8000/api/spartans/1
    // GET /api/spartans/{id}
    @Test
    public void testOneSpartanPathParam(){

        Response response = given()
                .pathParam("id", 1).log().all().
                when().get("/spartans/{id}");

        response.prettyPrint();
    }
}
