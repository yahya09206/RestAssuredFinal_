package com.yahya.day6;

import com.yahya.pojo.Driver;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class FormulaOneApiTest {

    /**
     * Here is the import link for whole collection
     *
     * It's for historical formula one race information
     * In this particular api , it decided to give you ml by default for response type
     * and In this particular api , it decided to give you json if you add .json at the  end of url
     * for example
     * http://ergast.com/api/f1/drivers --->return xml
     * http://ergast.com/api/f1/drivers.json ---> return json
     *
     * Our objective is to practice json path to find the values in json result
     * also practice deserialization by converting single driver json to POJO
     * practice converting driver json array in to List<Driver>
     *
     *
     */
    // SEND GET http://ergast.com/api/f1/drivers.json
    @BeforeAll
    public static void init() {
        baseURI = "http://ergast.com";
        basePath = "/api/f1";
    }

    @AfterAll
    public static void destroy() {
        reset();
    }

    @Test
    public void testDriverDeserialization(){

        JsonPath jsonPath = get("/drivers.json")
                //.prettyPeek()
                .jsonPath();
        System.out.println("jsonPath = " + jsonPath);

        // first driver json path
        Driver driver = jsonPath.getObject("MRData.DriverTable.Drivers[0]", Driver.class);
        System.out.println("driver = " + driver);

        // all driver
        List<Driver> allDrivers = jsonPath.getList("MRData.DriverTable.Drivers");
        System.out.println("allDrivers = " + allDrivers);
    }
}
