/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.shippingrate;

/**
 * Auto-generated: 2022-09-01 15:7:5
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class OriginAddress {

    private String city;
    private String state;
    private CountryISO countryISO;
    private String __typename;
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