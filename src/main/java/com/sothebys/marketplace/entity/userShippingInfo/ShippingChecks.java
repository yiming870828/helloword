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
public class ShippingChecks {

    private String id;
    private boolean incompatibleShippingDestinations;
    private boolean invalidShippingAddressCountry;
    private String __typename;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setIncompatibleShippingDestinations(boolean incompatibleShippingDestinations) {
         this.incompatibleShippingDestinations = incompatibleShippingDestinations;
     }
     public boolean getIncompatibleShippingDestinations() {
         return incompatibleShippingDestinations;
     }

    public void setInvalidShippingAddressCountry(boolean invalidShippingAddressCountry) {
         this.invalidShippingAddressCountry = invalidShippingAddressCountry;
     }
     public boolean getInvalidShippingAddressCountry() {
         return invalidShippingAddressCountry;
     }

    public void set__typename(String __typename) {
         this.__typename = __typename;
     }
     public String get__typename() {
         return __typename;
     }

}