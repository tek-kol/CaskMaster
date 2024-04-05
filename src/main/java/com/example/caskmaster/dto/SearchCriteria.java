package com.example.caskmaster.dto;


import lombok.Data;

@Data
public class SearchCriteria {
    private String searchTerm;
    private int perPage;
}
