/**
 * Copyright 2022 bejson.com
 */
package com.sothebys.marketplace.entity.itemsForReview;

import lombok.Data;

import java.util.List;

@Data
public class Media {

    private List<Images> images;
    private String __typename;

}