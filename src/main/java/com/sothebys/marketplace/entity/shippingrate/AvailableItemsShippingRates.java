/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.shippingrate;
import java.util.List;

/**
 * Auto-generated: 2022-09-01 15:7:5
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class AvailableItemsShippingRates {

    private List<Items> items;
    private SelectedRate selectedRate;
    private List<ShippingRates> shippingRates;
    private String __typename;
    public void setItems(List<Items> items) {
         this.items = items;
     }
     public List<Items> getItems() {
         return items;
     }

    public void setSelectedRate(SelectedRate selectedRate) {
         this.selectedRate = selectedRate;
     }
     public SelectedRate getSelectedRate() {
         return selectedRate;
     }

    public void setShippingRates(List<ShippingRates> shippingRates) {
         this.shippingRates = shippingRates;
     }
     public List<ShippingRates> getShippingRates() {
         return shippingRates;
     }

    public void set__typename(String __typename) {
         this.__typename = __typename;
     }
     public String get__typename() {
         return __typename;
     }

}