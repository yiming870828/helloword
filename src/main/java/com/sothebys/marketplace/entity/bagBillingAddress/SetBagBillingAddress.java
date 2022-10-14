/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.bagBillingAddress;

/**
 * Auto-generated: 2022-09-01 15:22:26
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class SetBagBillingAddress {

    private String id;
    private BillingAddress billingAddress;
    private String __typename;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
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