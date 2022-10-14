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
public class Media {

    private List<Images> images;
    private String __typename;
    public void setImages(List<Images> images) {
         this.images = images;
     }
     public List<Images> getImages() {
         return images;
     }

    public void set__typename(String __typename) {
         this.__typename = __typename;
     }
     public String get__typename() {
         return __typename;
     }

}