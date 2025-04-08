package com.yahya.day5;

import org.junit.jupiter.api.Test;
import com.yahya.pojo.Spartan;
import com.yahya.utility.SpartanTestBase;
import com.yahya.utility.SpartanUtil;
import io.restassured.http.ContentType;


import static io.restassured.RestAssured.*;

public class RestAssuredJsonPathMethodsTest extends SpartanTestBase {

    /**
     * There are two ways to get the response and extract the json data
     *
     * path("your jsonpath goes here") return type is T(generic) and decided by your variable data type you store
     *  int myId = response.path("id")
     *
     *  There is a type(class) in RestAssured : JsonPath that has lots of methods to extract json body
     *  from the response like
     *          getInt, getString, getDouble, getObject, getList and so on....
     *  In order to get JsonPath object out of response, we call a method called jsonPath() from the response
     *  for example:
     *          JsonPath jp = response.jsonPath("your actual path goes here")
     *          jp.getInt() || jp.getLong() and so on....
     *
     *
     *  The meaning of the word json path when we use in different places
     *  json path : -->> when inside the " " means the actual path to get the value (like xpath)
     *      *  JsonPath  : -->> the RestAssured class that have lots of methods
     *      *  jsonPath() : -->> the method of Response object to obtain JsonPath object out of response
     */

    // Send request to GET /spartans/{id}
    // and extract the data id, name and phone
    @Test
    public void testOneSpartan(){

        // Get the id of the first spartan
        int firstId = get("/spartans").path("id[0]");
        System.out.println("firstId = " + firstId);
    }
}
