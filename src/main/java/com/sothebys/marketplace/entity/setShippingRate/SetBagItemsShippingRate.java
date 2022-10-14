/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.setShippingRate;
import java.util.List;

/**
 * Auto-generated: 2022-09-01 15:10:42
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class SetBagItemsShippingRate {

    private String id;
    private List<Items> items;
    private String __typename;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setItems(List<Items> items) {
         this.items = items;
     }
     public List<Items> getItems() {
         return items;
     }

    public void set__typename(String __typename) {
         this.__typename = __typename;
     }
     public String get__typename() {
         return __typename;
     }

}