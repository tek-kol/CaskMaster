package com.example.caskmaster.model;

public class Brewery {
    private String id;
    private String name;
    private String brewery_type;
    private String address_1;
    private String address_2;
    private String address_3;
    private String city;
    private String state_province;
    private String postal_code;
    private String country;
    private String longitude;
    private String latitude;
    private String phone;
    private String website_url;
    private String state;
    private String street;

    public Brewery(String id, String name, String brewery_type, String address_1, String address_2, String address_3, String city, String state_province, String postal_code, String country, String longitude, String latitude, String phone, String website_url, String state, String street) {
        this.id = id;
        this.name = name;
        this.brewery_type = brewery_type;
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.address_3 = address_3;
        this.city = city;
        this.state_province = state_province;
        this.postal_code = postal_code;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
        this.phone = phone;
        this.website_url = website_url;
        this.state = state;
        this.street = street;

    }
}




