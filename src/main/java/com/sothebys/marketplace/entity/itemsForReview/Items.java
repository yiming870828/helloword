/**
 * Copyright 2022 bejson.com
 */
package com.sothebys.marketplace.entity.itemsForReview;

import lombok.Data;

import java.util.List;

@Data
public class Items {

    private String id;
    private String alert;
    private List<AvailableShippingRates> availableShippingRates;
    private Variant variant;
    private RetailItem retailItem;
    private int quantity;
    private String __typename;

}