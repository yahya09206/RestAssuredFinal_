package com.yahya.day6;

import com.yahya.pojo.Article;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;


public class NewsApiDeserializationTest {

    @BeforeAll
    public static void setUp(){
        baseURI="https://newsapi.org";
        basePath="/v2";
    }

    @AfterAll
    public static void teardown(){
        reset();
    }

    /**
     * GET https://newsapi.org/v2/top-headlines?country=us
     * Header : Authorization = Bearer 0b42f37dd32d4c70911a063c275005b0
     */
    @Test
    public void testNews(){

        JsonPath jsonPath = given().log().all().queryParam("country", "us")
                .header("Authorization", "Bearer = 0b42f37dd32d4c70911a063c275005b0").
                when().get("/top-headlines")
                //.prettyPeek()
                .jsonPath();

        // try to get first Article into POJO
        Article articleOne = jsonPath.getObject("articles[0]", Article.class);
        System.out.println("articleOne = " + articleOne);
    }
}
