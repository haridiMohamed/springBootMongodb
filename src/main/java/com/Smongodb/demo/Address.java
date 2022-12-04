package com.Smongodb.demo;

import lombok.Data;

@Data
public class Address {
    public Address(String country, String city, String postCode) {
        this.country = country;
        this.city = city;
        this.postCode = postCode;
    }

    private String country;
    private String city;
    private String postCode;
}
