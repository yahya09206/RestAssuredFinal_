package com.yahya.utility;

import com.github.javafaker.Faker;

import java.util.LinkedHashMap;
import java.util.Map;

public class SpartanUtil {

    public static Map<String, Object> getRandomSpartanBody(){

        Faker faker = new Faker();
        Map<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("name", faker.name().firstName());
        bodyMap.put("gender", faker.demographic().sex());
        bodyMap.put("phone", faker.number().numberBetween(5000000000L,9000000000L));

        return bodyMap;
    }
}
