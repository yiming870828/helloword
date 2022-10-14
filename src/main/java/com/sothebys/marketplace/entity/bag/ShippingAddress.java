/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.bag;

/**
 * Auto-generated: 2022-09-01 14:12:42
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ShippingAddress {

    private String id;
    private CountryISO countryISO;
    private String __typename;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setCountryISO(CountryISO countryISO) {
         this.countryISO = countryISO;
     }
     public CountryISO getCountryISO() {
         return countryISO;
     }

    public void set__typename(String __typename) {
         this.__typename = __typename;
     }
     public String get__typename() {
         return __typename;
     }

}