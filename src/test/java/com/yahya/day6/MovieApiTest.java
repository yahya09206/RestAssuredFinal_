package com.yahya.day6;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class MovieApiTest {

    @BeforeAll
    public static void setup() {
        baseURI="http://www.omdbapi.com";
    }

    @AfterAll
    public static void teardown() {
        reset();
    }
}
