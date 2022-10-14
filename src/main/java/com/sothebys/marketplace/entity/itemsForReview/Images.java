/**
 * Copyright 2022 bejson.com
 */
package com.sothebys.marketplace.entity.itemsForReview;

import lombok.Data;

import java.util.List;

@Data
public class Images {

    private String title;
    private List<Renditions> renditions;
    private String __typename;


}