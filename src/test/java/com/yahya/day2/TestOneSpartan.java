package com.yahya.day2;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class TestOneSpartan {


    @Test
    public void testOneSpartan() {

        Response response = get("http://44.211.192.252:8000/api/spartans/1 ");
        System.out.println("response.statusCode() = " + response.statusCode());

        response.prettyPrint();

        System.out.println("response.asString() = " + response.asString());

        System.out.println("response.header(\"Content-Type\") = " + response.header("Content-Type"));

        System.out.println("response.getHeader(\"Content-Type\") = " + response.getHeader("Content-Type"));

        System.out.println("response.getHeader(\"Date\") = " + response.getHeader("Date"));

        System.out.println("response.getHeader(\"Keep-Alive\") = " + response.getHeader("Keep-Alive"));

        System.out.println("response.header(\"Connection\") = " + response.header("Connection"));

        Assertions.assertEquals(200, response.statusCode());

    }
}
