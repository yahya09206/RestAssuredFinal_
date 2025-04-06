package com.yahya.day4;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

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


}
