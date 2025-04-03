package com.yahya.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;

public class TestOneSpartan2 {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://127.0.0.1:8080";
        RestAssured.basePath = "/api";
    }


    @Test
    public void testOneSpartan() {

        Response response = get("spartans/1 ");
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

    @Test
    public void testContentType(){

        Response response = get("http://44.211.192.252:8000/api/spartans/1 ");
        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("response.getContentType() = " + response.getContentType());

        Assertions.assertEquals("application/json", response.contentType());

        System.out.println("ContentType.JSON = " + ContentType.JSON);
        System.out.println("ContentType.XML = " + ContentType.XML);
        System.out.println("ContentType.TEXT = " + ContentType.TEXT);
        System.out.println("ContentType.URLENC = " + ContentType.URLENC);

        Assertions.assertEquals(ContentType.JSON.toString(), response.contentType());

    }

    @Test
    public void testJSONBody() {

        Response response = get("http://44.211.192.252:8000/api/spartans/1");
        response.prettyPrint();

        System.out.println("response.path(\"id\") = " + response.path("id"));
        System.out.println("response.path(\"name\") = " + response.path("name"));
        System.out.println("response.path(\"gender\") = " + response.path("gender"));
        System.out.println("response.path(\"phone\") = " + response.path("phone"));

        int myId = response.path("id");
        String myName = response.path("name");
        String myGender = response.path("gender");
        long myPhone = response.path("phone");

        System.out.println("myPhone = " + myPhone);
        System.out.println("myGender = " + myGender);
        System.out.println("myId = " + myId);
        System.out.println("myName = " + myName);

        Assertions.assertEquals(1, myId);
        Assertions.assertEquals("Meade", myName);
        Assertions.assertEquals("Male", myGender);
        Assertions.assertEquals(3584128232L, myPhone);
    }
}
