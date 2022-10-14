/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.bagBillingAddress;



public class BillingAddress {

    private String id;
    private String street;
    private String city;
    private String stateOrProvince;
    private String postalCode;
    private CountryISO countryISO;
    private String __typename;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setStreet(String street) {
         this.street = street;
     }
     public String getStreet() {
         return street;
     }

    public void setCity(String city) {
         this.city = city;
     }
     public String getCity() {
         return city;
     }

    public void setStateOrProvince(String stateOrProvince) {
         this.stateOrProvince = stateOrProvince;
     }
     public String getStateOrProvince() {
         return stateOrProvince;
     }

    public void setPostalCode(String postalCode) {
         this.postalCode = postalCode;
     }
     public String getPostalCode() {
         return postalCode;
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