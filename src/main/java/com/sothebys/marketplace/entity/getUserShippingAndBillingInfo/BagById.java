/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.getUserShippingAndBillingInfo;
import java.util.List;

/**
 * Auto-generated: 2022-09-01 15:15:37
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BagById {

    private String id;
    private String bagId;
    private int itemCount;
    private Pricing pricing;
    private List<Items> items;
    private ShippingAddress shippingAddress;
    private BillingAddress billingAddress;
    private String __typename;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setBagId(String bagId) {
         this.bagId = bagId;
     }
     public String getBagId() {
         return bagId;
     }

    public void setItemCount(int itemCount) {
         this.itemCount = itemCount;
     }
     public int getItemCount() {
         return itemCount;
     }

    public void setPricing(Pricing pricing) {
         this.pricing = pricing;
     }
     public Pricing getPricing() {
         return pricing;
     }

    public void setItems(List<Items> items) {
         this.items = items;
     }
     public List<Items> getItems() {
         return items;
     }

    public void setShippingAddress(ShippingAddress shippingAddress) {
         this.shippingAddress = shippingAddress;
     }
     public ShippingAddress getShippingAddress() {
         return shippingAddress;
     }

    public void setBillingAddress(BillingAddress billingAddress) {
         this.billingAddress = billingAddress;
     }
     public BillingAddress getBillingAddress() {
         return billingAddress;
     }

    public void set__typename(String __typename) {
         this.__typename = __typename;
     }
     public String get__typename() {
         return __typename;
     }

}