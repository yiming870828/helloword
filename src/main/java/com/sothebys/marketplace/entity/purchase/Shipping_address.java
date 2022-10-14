/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.purchase;

import lombok.Data;

@Data
public class Shipping_address {

    private String first_name;
    private String last_name;
    private String telephone;
    private String street1;
    private String city;
    private String state;
    private String postal_code;
    private String country;

}