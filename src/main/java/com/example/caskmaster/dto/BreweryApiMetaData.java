package com.example.caskmaster.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BreweryApiMetaData {
    private String total;
    private String page;
    @JsonProperty("per_page")
    private String perPage;
}