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
public class OriginAddress {

    private String id;
    private String city;
    private String state;
    private CountryISO countryISO;
    private String __typename;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setCity(String city) {
         this.city = city;
     }
     public String getCity() {
         return city;
     }

    public void setState(String state) {
         this.state = state;
     }
     public String getState() {
         return state;
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