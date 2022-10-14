package com.sothebys.marketplace.entity;

import com.sothebys.marketplace.entity.itemsForReview.JsonItemsForReview;
import com.sothebys.marketplace.entity.purchase.Credit_card;
import com.sothebys.marketplace.entity.purchase.Customer;
import com.sothebys.marketplace.entity.purchase.Purchase_date;
import lombok.Data;

@Data
public class PurchaseData {

    private String id;
    private Long purchase_number;
    private Credit_card credit_card;
    private Customer customer;
    private String purchase_number_display;
    private Purchase_date purchase_date;
    private String cart_id;
    private JsonItemsForReview jsonItemsForReview;

}
