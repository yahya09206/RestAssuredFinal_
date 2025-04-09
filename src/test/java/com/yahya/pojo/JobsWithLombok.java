package com.yahya.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobsWithLombok {

    @JsonProperty("job_id")
    private String jobId;
    @JsonProperty("job_title")
    private String jobTitle;
    @JsonProperty("min_salary")
    private String minSalary;
    @JsonProperty("max_salary")
    private String maxSalary;
}
