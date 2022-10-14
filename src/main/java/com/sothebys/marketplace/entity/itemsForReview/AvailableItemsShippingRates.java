/**
 * Copyright 2022 bejson.com
 */
package com.sothebys.marketplace.entity.itemsForReview;

import lombok.Data;

import java.util.List;

@Data
public class AvailableItemsShippingRates {

    private List<Items> items;
    private SelectedRate selectedRate;
    private List<ShippingRates> shippingRates;
    private String __typename;

}