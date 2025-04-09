package com.yahya.day6;

import com.yahya.pojo.Jobs;
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
        Jobs jobs1 = jsonPath.getObject("items[0]", Jobs.class);
        System.out.println("jobs1 = " + jobs1);

        // Save all results into List<Jobs>
    }
}
