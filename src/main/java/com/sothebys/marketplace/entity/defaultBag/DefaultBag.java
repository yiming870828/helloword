/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.defaultBag;
import java.util.List;

/**
 * Auto-generated: 2022-09-02 13:52:34
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class DefaultBag {

    private String id;
    private List<Items> items;
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

}