/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.purchase;
import com.sothebys.marketplace.entity.BillingAddress;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Data
public class JsonPurchase {

    private String id;
    private long purchase_number;
    private Credit_card credit_card;
    private Shipping_address shipping_address;
    private List<Items> items;
    private Pricing pricing;
    private BillingAddress billing_address;
    private Customer customer;
    private String purchase_number_display;
    private Purchase_date purchase_date;
    private String cart_id;

}