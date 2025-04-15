package com.yahya.day6;

import com.yahya.pojo.Article;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.path.json.JsonPath;

import java.util.List;

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

        // check if source id is null or not
        // the source id is inside the source Map field
        // we can use getter to private field to get the map
        // the using this map use map get method to get the value of the key
        System.out.println("articleOne.getSource().get(\"id\") = " + articleOne.getSource().get("id"));


        // Storing in a list and printing all articles if not null
        List<Article> allArticles = jsonPath.getList("articles", Article.class);
        for (Article allArticle : allArticles) {
            // check if source is null
            if (allArticle.getSource().get("id") != null) {
                // print out name of author
                System.out.println("allArticle.getAuthor() = " + allArticle.getAuthor());
            }
        }

    }
}
