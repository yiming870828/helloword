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
public class Items {

    private String id;
    private SelectedShippingRate selectedShippingRate;
    private String __typename;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setSelectedShippingRate(SelectedShippingRate selectedShippingRate) {
         this.selectedShippingRate = selectedShippingRate;
     }
     public SelectedShippingRate getSelectedShippingRate() {
         return selectedShippingRate;
     }

    public void set__typename(String __typename) {
         this.__typename = __typename;
     }
     public String get__typename() {
         return __typename;
     }

}