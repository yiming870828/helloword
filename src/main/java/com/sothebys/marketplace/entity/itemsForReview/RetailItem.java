/**
 * Copyright 2022 bejson.com
 */
package com.sothebys.marketplace.entity.itemsForReview;

import lombok.Data;

import java.util.List;

@Data
public class RetailItem {

    private String id;
    private boolean isOwned;
    private String retailItemId;
    private String sku;
    private String title;
    private String description;
    private Department department;
    private List<Creators> creators;
    private List<Objects> objects;
    private RetailItemPricing pricing;
    private Media media;
    private String slug;
    private Config config;
    private List<Category> category;
    private Shipping shipping;
    private String __typename;

}