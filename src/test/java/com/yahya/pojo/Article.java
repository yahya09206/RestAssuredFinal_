package com.yahya.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Map;

/**
 *             "source": {
 *                 "id": "politico",
 *                 "name": "Politico"
 *             },
 *             "author": "Benjamin Guggenheim, Meredith Lee Hill",
 *             "title": "GOP holdouts headed to White House to talk budget - Politico",
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article {

    private Map<String, Object> source;
    private String author;
    private String title;

}
