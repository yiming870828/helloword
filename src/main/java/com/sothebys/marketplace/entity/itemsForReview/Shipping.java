/**
 * Copyright 2022 bejson.com
 */
package com.sothebys.marketplace.entity.itemsForReview;

import lombok.Data;

import java.util.List;

@Data
public class Shipping {

    private List<String> offeredServiceTypes;
    private OriginAddress originAddress;
    private String __typename;
    private boolean shipsInternationally;

}