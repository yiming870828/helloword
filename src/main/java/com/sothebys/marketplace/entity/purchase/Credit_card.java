/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.purchase;

import lombok.Data;

@Data
public class Credit_card {

    private String external_id;
    private String last_four;
    private String brand;
    private String name_on_card;
    private String avs_result;


}