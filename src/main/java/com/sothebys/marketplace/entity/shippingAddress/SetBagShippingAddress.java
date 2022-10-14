/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.shippingAddress;

/**
 * Auto-generated: 2022-09-01 14:56:57
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class SetBagShippingAddress {

    private String id;
    private ShippingChecks shippingChecks;
    private ShippingAddress shippingAddress;
    private String __typename;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setShippingChecks(ShippingChecks shippingChecks) {
         this.shippingChecks = shippingChecks;
     }
     public ShippingChecks getShippingChecks() {
         return shippingChecks;
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