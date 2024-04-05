package com.example.caskmaster.dto;


import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class SearchCriteria {
    private String searchTerm;
    private int perPage;
}
