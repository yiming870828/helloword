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
public class AvailableShippingRates {

    private String id;
    private String deduplicationId;
    private String approxDelivery;
    private String description;
    private int price;
    private String rateId;
    private String serviceLevel;
    private String information;
    private String __typename;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setDeduplicationId(String deduplicationId) {
         this.deduplicationId = deduplicationId;
     }
     public String getDeduplicationId() {
         return deduplicationId;
     }

    public void setApproxDelivery(String approxDelivery) {
         this.approxDelivery = approxDelivery;
     }
     public String getApproxDelivery() {
         return approxDelivery;
     }

    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    public void setPrice(int price) {
         this.price = price;
     }
     public int getPrice() {
         return price;
     }

    public void setRateId(String rateId) {
         this.rateId = rateId;
     }
     public String getRateId() {
         return rateId;
     }

    public void setServiceLevel(String serviceLevel) {
         this.serviceLevel = serviceLevel;
     }
     public String getServiceLevel() {
         return serviceLevel;
     }

    public void setInformation(String information) {
         this.information = information;
     }
     public String getInformation() {
         return information;
     }

    public void set__typename(String __typename) {
         this.__typename = __typename;
     }
     public String get__typename() {
         return __typename;
     }

}