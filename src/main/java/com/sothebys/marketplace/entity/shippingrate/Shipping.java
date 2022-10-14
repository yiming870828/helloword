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
public class Shipping {

    private String id;
    private boolean shipsInternationally;
    private List<String> offeredServiceTypes;
    private OriginAddress originAddress;
    private String __typename;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setShipsInternationally(boolean shipsInternationally) {
         this.shipsInternationally = shipsInternationally;
     }
     public boolean getShipsInternationally() {
         return shipsInternationally;
     }

    public void setOfferedServiceTypes(List<String> offeredServiceTypes) {
         this.offeredServiceTypes = offeredServiceTypes;
     }
     public List<String> getOfferedServiceTypes() {
         return offeredServiceTypes;
     }

    public void setOriginAddress(OriginAddress originAddress) {
         this.originAddress = originAddress;
     }
     public OriginAddress getOriginAddress() {
         return originAddress;
     }

    public void set__typename(String __typename) {
         this.__typename = __typename;
     }
     public String get__typename() {
         return __typename;
     }

}