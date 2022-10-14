/**
 * Copyright 2022 bejson.com
 */
package com.sothebys.marketplace.entity.itemsForReview;

import lombok.Data;

@Data
public class SelectedRate {

    private String id;
    private String rateId;
    private String deduplicationId;
    private String serviceLevel;
    private String approxDelivery;
    private int price;
    private String description;
    private String __typename;

}