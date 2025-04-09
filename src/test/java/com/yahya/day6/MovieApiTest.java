package com.yahya.day6;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

    @Test
    public void testMovies(){

        given().log().uri().queryParam("apikey", "f90e5bb4").
                queryParam("s", "The Mandalorian").
                when().get("").prettyPeek();
    }
}
