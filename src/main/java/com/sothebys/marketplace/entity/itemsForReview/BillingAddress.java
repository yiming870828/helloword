/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.itemsForReview;

import lombok.Data;

@Data
public class BillingAddress {

    private String street;
    private String city;
    private String stateOrProvince;
    private String postalCode;
    private CountryISO countryISO;
    private String __typename;

}