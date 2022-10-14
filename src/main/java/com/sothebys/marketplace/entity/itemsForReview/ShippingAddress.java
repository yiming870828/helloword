/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.itemsForReview;

import lombok.Data;

@Data
public class ShippingAddress {

    private String id;
    private String firstName;
    private String lastName;
    private String telephone;
    private String company;
    private String street1;
    private String street2;
    private String floor;
    private CountryISO countryISO;
    private String city;
    private String state;
    private String postalCode;
    private String __typename;

}