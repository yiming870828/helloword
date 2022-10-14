/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.purchase;

import lombok.Data;

@Data
public class Pricing {

    private int subtotal;
    private int shipping;
    private int tax;
    private int total;
    private String currency;


}