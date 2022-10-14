/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.setShippingRate;

/**
 * Auto-generated: 2022-09-01 15:10:42
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class SelectedShippingRate {

    private String id;
    private String deduplicationId;
    private String pickupDate;
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

    public void setPickupDate(String pickupDate) {
         this.pickupDate = pickupDate;
     }
     public String getPickupDate() {
         return pickupDate;
     }

    public void set__typename(String __typename) {
         this.__typename = __typename;
     }
     public String get__typename() {
         return __typename;
     }

}