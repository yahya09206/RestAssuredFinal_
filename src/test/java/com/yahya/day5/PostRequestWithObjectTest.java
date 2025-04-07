package com.yahya.day5;

import com.yahya.utility.SpartanTestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Serialization: Converting from Java Object to JSON(Or any other text)
 * De-Serialization: Process of Converting from Json to Java Object
 */


public class PostRequestWithObjectTest extends SpartanTestBase {

    /**
     * POST /spartans
     * content type is json
     * body is
     *  {
     *     "name": "Meade",
     *     "gender": "Male",
     *     "phone": 3584128232
     * }
     *
     * Instead of providing above body in string
     * You want to be able to provide the body as a Java Object like a Map or POJO
     * and let any kind of Serialization library convert that into String format for us while sending the request
     */

    @Test
    public void testPostWithMap(){


    }
}
