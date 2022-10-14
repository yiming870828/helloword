/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.userShippingInfo;

/**
 * Auto-generated: 2022-09-06 9:53:55
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Items {

    private String id;
    private int quantity;
    private String alert;
    private RetailItem retailItem;
    private Variant variant;
    private String __typename;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setQuantity(int quantity) {
         this.quantity = quantity;
     }
     public int getQuantity() {
         return quantity;
     }

    public void setAlert(String alert) {
         this.alert = alert;
     }
     public String getAlert() {
         return alert;
     }

    public void setRetailItem(RetailItem retailItem) {
         this.retailItem = retailItem;
     }
     public RetailItem getRetailItem() {
         return retailItem;
     }

    public void setVariant(Variant variant) {
         this.variant = variant;
     }
     public Variant getVariant() {
         return variant;
     }

    public void set__typename(String __typename) {
         this.__typename = __typename;
     }
     public String get__typename() {
         return __typename;
     }

}