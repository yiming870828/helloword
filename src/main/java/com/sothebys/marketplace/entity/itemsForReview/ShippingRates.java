/**
 * Copyright 2022 bejson.com
 */
package com.sothebys.marketplace.entity.itemsForReview;

import lombok.Data;

@Data
public class ShippingRates {

    private String id;
    private String deduplicationId;
    private String approxDelivery;
    private String description;
    private int price;
    private String rateId;
    private String serviceLevel;
    private String information;
    private String providerCode;
    private String serviceCode;
    private String __typename;

}