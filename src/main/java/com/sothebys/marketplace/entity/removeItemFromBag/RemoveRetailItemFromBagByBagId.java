/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.removeItemFromBag;
import java.util.List;

/**
 * Auto-generated: 2022-09-05 17:38:47
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class RemoveRetailItemFromBagByBagId {

    private String id;
    private String bagId;
    private ShippingChecks shippingChecks;
    private List<String> items;
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

    public void setShippingChecks(ShippingChecks shippingChecks) {
         this.shippingChecks = shippingChecks;
     }
     public ShippingChecks getShippingChecks() {
         return shippingChecks;
     }

    public void setItems(List<String> items) {
         this.items = items;
     }
     public List<String> getItems() {
         return items;
     }

    public void set__typename(String __typename) {
         this.__typename = __typename;
     }
     public String get__typename() {
         return __typename;
     }

}