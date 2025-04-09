package com.yahya.day6;

import com.yahya.pojo.OMDB;
import io.restassured.path.json.JsonPath;
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

        JsonPath jsonPath = given().log().uri().queryParam("apikey", "f90e5bb4").
                queryParam("s", "The Mandalorian").
                when().get("").prettyPeek().jsonPath();

        // Get first movie object saved inside "Search" array Search[0]
        OMDB omdb1 = jsonPath.getObject("Search[0]", OMDB.class);
        System.out.println("omdb1 = " + omdb1);
    }
}
