/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.addItemToBag;

/**
 * Auto-generated: 2022-09-01 13:57:27
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class RetailItem {

    private String id;
    private boolean itemInLoggedInCart;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setItemInLoggedInCart(boolean itemInLoggedInCart) {
         this.itemInLoggedInCart = itemInLoggedInCart;
     }
     public boolean getItemInLoggedInCart() {
         return itemInLoggedInCart;
     }

}