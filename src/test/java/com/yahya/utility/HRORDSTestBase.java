package com.yahya.utility;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class HRORDSTestBase {

    // set up and teardown
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://44.211.192.252:1000";
        RestAssured.basePath = "/ords/hr";
    }

    @AfterAll
    public static void tearDown() {
        RestAssured.reset();
    }
}
