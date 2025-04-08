package com.yahya.day5;

import com.yahya.pojo.Spartan;
import org.junit.jupiter.api.Test;
import com.yahya.utility.SpartanTestBase;
import com.yahya.utility.SpartanUtil;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class PostPutRequestWithPOJO extends SpartanTestBase {


    /**
     * Another way of representing json data is using special purpose Java Object created from a class that has fields
     * matched to json keys
     * and have getters and setters
     * This type of object's sole purpose is to represent data known as POJO --> plain old java object
     * The class to create POJO known as a POJO class
     */
    @Test
    public void testPostWithPOJO() {

        Spartan spartanOne = new Spartan("Michael Kyle", "Male", 5555555555L);
        System.out.println("spartanOne = " + spartanOne);


        given().log().all().contentType(ContentType.JSON).body(spartanOne).
                when().post("/spartans").
                then().log().all().statusCode(201);
    }


}
