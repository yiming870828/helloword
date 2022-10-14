/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.userShippingInfo;
import java.util.List;

/**
 * Auto-generated: 2022-09-06 9:53:55
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BagById {

    private String id;
    private String bagId;
    private int itemCount;
    private String bagItemsType;
    private ShippingChecks shippingChecks;
    private Pricing pricing;
    private List<Items> items;
    private ShippingAddress shippingAddress;
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

    public void setBagItemsType(String bagItemsType) {
         this.bagItemsType = bagItemsType;
     }
     public String getBagItemsType() {
         return bagItemsType;
     }

    public void setShippingChecks(ShippingChecks shippingChecks) {
         this.shippingChecks = shippingChecks;
     }
     public ShippingChecks getShippingChecks() {
         return shippingChecks;
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

    public void set__typename(String __typename) {
         this.__typename = __typename;
     }
     public String get__typename() {
         return __typename;
     }

}