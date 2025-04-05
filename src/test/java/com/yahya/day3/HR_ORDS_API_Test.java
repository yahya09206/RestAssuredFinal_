package com.yahya.day3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;


public class HR_ORDS_API_Test {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://44.211.192.252:1000";
        RestAssured.basePath = "/ords/hr/";
    }

    @AfterAll
    public static void tearDown() {
        RestAssured.reset();
    }

    @Test
    public void testGetAllJobs(){

        Response response = given().when().get("/jobs");
        response.prettyPrint();
        int countValue = response.path("count");
        String secondJobID = response.path("items.job_id[1]");
        List<String> allJobIDs = response.path("items.job_title");

        Assertions.assertEquals(ContentType.JSON.toString(), "application/json");
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(19, countValue);

        System.out.println("secondJobID = " + secondJobID);
        System.out.println("response.path(\"items.min_salary[3]\") = " + response.path("items.min_salary[3]"));
        System.out.println("allJobIDs = " + allJobIDs);
    }
}
