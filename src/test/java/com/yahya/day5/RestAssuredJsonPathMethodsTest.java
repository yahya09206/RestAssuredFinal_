package com.yahya.day5;

import com.yahya.pojo.SpartanWithID;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import com.yahya.pojo.Spartan;
import com.yahya.utility.SpartanTestBase;
import com.yahya.utility.SpartanUtil;
import io.restassured.http.ContentType;


import java.util.List;
import java.util.Map;

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

        // Send request to GET /spartan/{id}
        // Only log the requested url
        Response response = given().log().uri().pathParam("id", firstId).
                when().get("/spartans/{id}").prettyPeek();

        // Save the id from the response
        // int myId = response.path("id");

        // Get JsonPath object out of response
        JsonPath jsonPath = response.jsonPath();
        // Get id using getInt()
        int myId = jsonPath.getInt("id");
        String myName = jsonPath.getString("name");
        String myGender = jsonPath.getString("gender");
        long phoneNumber = jsonPath.getLong("phone");
        System.out.println("myId = " + myId);
        System.out.println("myName = " + myName);
        System.out.println("myGender = " + myGender);
        System.out.println("phoneNumber = " + phoneNumber);

        /**
         * Store json result into Map object
         * The path to get the entire body is an empty string because the response is already a json object
         * No need to navigate
         */
        Map<String, Object> responseBodyAsMap = jsonPath.getMap("");
        System.out.println("responseBodyAsMap = " + responseBodyAsMap);

    }

    // Send Request GET /spartans/search?nameContains=Ea&gender=Male
    // get JsonPath object out of response so you can use specialized methods
    // get totalElement field value using getX method
    // get 3rd element phone using getX method
    // get last element name using getX method
    // save first json in json array into Map using getX method
    // Get the name of all the spartans and save it into a list : content.name
    // remember getX("your path to the element goes here just like xpath")
    @Test
    public void testSearchExtractData(){

        Response response = given().log().uri().queryParams("nameContains", "Ea").
                queryParams("gender", "Male").
                when().get("/spartans/search")
                //.prettyPeek()
                ;

        // Get jsonpath object out of response
        JsonPath jsonPath = response.jsonPath();
        int myTotal = jsonPath.getInt("totalElement");
        System.out.println("myTotal = " + myTotal);
        long myPhone = jsonPath.getLong("content[2].phone");
        System.out.println("myPhone = " + myPhone);

        String lastName = jsonPath.getString("content[-1].name");
        System.out.println("lastName = " + lastName);

        Map<String, Object> firstJsonAsMap = jsonPath.getMap("content[0]");
        System.out.println("getSecond = " + firstJsonAsMap);

        // Get the name of all the spartans and save it into a list of strings : content.name
        // List<String> allNames = jsonPath.getList("content.name");
        // in this version of getList method , you have option to make it obvious
        // to specify the class type you want each item to have as List item data type
        List<String> allNames = jsonPath.getList("content.name", String.class);
        System.out.println("allNames = " + allNames);

        // save all phone number into the list and make it obvious what kind of list you want to get
        List<Long> allNumbers = jsonPath.getList("content.phone", Long.class);
        System.out.println("allNumbers = " + allNumbers);

        // continue from this task : now try to match this json objects into POJO
        // in order to match json result with 4 fields , you need to have POJO class with 4 matching fields
        // create a class called SpartanWithID
        // add encapsulated fields id, name , gender, phone
        // add no arg constructor (no need for 4 args constructor because we don't create object ourselves)
        // optionally add toString method so we can print it worked.
        // now we can use  jp.getObject("the path here" , SpartanWithID.class)
        // to save it into  SpartanWithID object  --> another de-serialization!

        // store first json in the result as SpartanWithID POJO  : content[0]
        // getObject method accept jsonPath to the jsonObject to be converted
        // and the class type you want to convert to and return object of that type
        // with all the field value already filled up by matching the key value
        SpartanWithID spartanWithID1 = jsonPath.getObject("content[0]", SpartanWithID.class);
        System.out.println("spartanWithID1 = " + spartanWithID1);


        List<SpartanWithID> allSpartanWithIDs = jsonPath.getList("content", SpartanWithID.class);
        System.out.println("allSpartanWithIDs = " + allSpartanWithIDs);
    }
}
