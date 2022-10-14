/**
 * Copyright 2022 bejson.com
 */
package com.sothebys.marketplace.entity.addItemToBag;


import lombok.Data;

@Data
public class Items {

    private int quantity;
    private String retailItemId;
    private RetailItem retailItem;

}