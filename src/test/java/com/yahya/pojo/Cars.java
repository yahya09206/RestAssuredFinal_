package com.yahya.pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cars {

    private String model;
    private String make;
    private int year;
    private boolean autopilot;
}
