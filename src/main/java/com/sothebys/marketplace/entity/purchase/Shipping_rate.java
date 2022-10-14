/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.purchase;

import lombok.Data;

@Data
public class Shipping_rate {

    private String id;
    private int price;
    private String carrier_service_level;
    private String carrier_approx_delivery;
    private String carrier_description;
    private boolean is_estimate;
    private boolean is_hand_picked;
    private String provider_code;
    private String service_code;
    private String shipping_service;
    private String deduplication_id;

}