package com.sothebys.marketplace.entity.itemsForReview;

import lombok.Data;

import java.util.List;

@Data
public class BagById {

    private String id;
    private String bagId;
    private String bagItemsType;
    private String comment;
    private Pricing pricing;
    private List<AvailableItemsShippingRates> availableItemsShippingRates;
    private List<Items> items;
    private ShippingAddress shippingAddress;
    private BillingAddress billingAddress;
    private String __typename;

}