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

    @Test
    public void testJobsWithQueryParam(){

        Response response = given().log().all().queryParam("limit", 5).
                when().get("/jobs");

        response.prettyPrint();

        int actualCount = response.path("count");
        String lastJobTitle = response.path("items.job_id[-1]");

        Assertions.assertEquals(5, actualCount);
        Assertions.assertEquals("AD_VP", lastJobTitle);

        System.out.println("lastJobTitle = " + lastJobTitle);
    }

    @Test
    public void testSingleJobWithParam(){

        Response response = given().log().all().queryParam("job_id", "AD_VP").when().get("jobs/AD_VP");
        String jobTitle = response.path("job_title");

        Assertions.assertEquals(ContentType.JSON.toString(), "application/json");
        Assertions.assertEquals("Administration Vice President", jobTitle);
    }
}
