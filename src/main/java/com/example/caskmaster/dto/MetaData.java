package com.example.caskmaster.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MetaData {
    private String total;
    private String page;
    @JsonProperty("per_page")
    private String perPage;
}


// Todo: I want to call this MetaDto