/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.purchase;

import lombok.Data;

@Data
public class Retail_item {

    private String id;
    private String title;
    private String description;
    private String sku;
    private boolean final_sale;
    private int list_price;
    private long object_ids;
    private String sales_entity;
    private boolean is_owned;

}