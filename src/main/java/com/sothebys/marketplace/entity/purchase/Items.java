/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.purchase;

import lombok.Data;

@Data
public class Items {

    private Retail_item retail_item;
    private int price;
    private int quantity;
    private Shipping_rate shipping_rate;
    private int subtotal_price;

}