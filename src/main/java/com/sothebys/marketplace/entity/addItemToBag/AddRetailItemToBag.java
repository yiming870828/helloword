/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.addItemToBag;
import java.util.List;

/**
 * Auto-generated: 2022-09-01 13:57:27
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class AddRetailItemToBag {

    private String bagId;
    private List<Items> items;
    public void setBagId(String bagId) {
         this.bagId = bagId;
     }
     public String getBagId() {
         return bagId;
     }

    public void setItems(List<Items> items) {
         this.items = items;
     }
     public List<Items> getItems() {
         return items;
     }

}