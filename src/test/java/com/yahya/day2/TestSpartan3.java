package com.yahya.day2;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

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

}
