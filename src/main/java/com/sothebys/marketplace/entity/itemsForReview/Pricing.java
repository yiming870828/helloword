/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.itemsForReview;

import lombok.Data;

@Data
public class Pricing {

    private String id;
    private String currency;
    private int subtotalPrice;
    private int totalPrice;
    private int tax;
    private int shippingCost;
    private String offerPrice;
    private String __typename;

}