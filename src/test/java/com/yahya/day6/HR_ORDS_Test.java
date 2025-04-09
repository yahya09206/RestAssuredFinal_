package com.yahya.day6;

import com.yahya.utility.HRORDSTestBase;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class HR_ORDS_Test extends HRORDSTestBase {

    @Test
    public void testJobs(){

        JsonPath jsonPath = given().log().uri().when().get("/jobs").prettyPeek().jsonPath();

        /**
         * De-Serialize first json object from json array
         * follow java naming convention for pojo fields
         * ignore json field for the links
         */
    }
}
