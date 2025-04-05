package com.yahya.day1;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class TestSpartanApi {

    @Test
    public void testHello(){
        System.out.println("Hello World");

        // Send request to below url and save the response
        // GET method is coming from RestAssured class to send get request to the url defined
        // Store request in response object

        // Save result of url into Response object
        Response response = get("http://44.211.192.252:8000/api/hello");
        // Print out statusCode from response object -- should return 200(ok)
        System.out.println("response.statusCode() = " + response.statusCode());

        // Use prettyPrint to print from what's inside payload
        response.prettyPrint();

        // Assert that response code is indeed a 200 using Assertions class
        Assertions.assertEquals(200, response.statusCode());


    }
}
