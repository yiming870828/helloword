/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.bag;
import java.util.List;

/**
 * Auto-generated: 2022-09-01 14:12:42
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Objects {

    private String id;
    private String objectTypeName;
    private List<Metadata> metadata;
    private String __typename;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setObjectTypeName(String objectTypeName) {
         this.objectTypeName = objectTypeName;
     }
     public String getObjectTypeName() {
         return objectTypeName;
     }

    public void setMetadata(List<Metadata> metadata) {
         this.metadata = metadata;
     }
     public List<Metadata> getMetadata() {
         return metadata;
     }

    public void set__typename(String __typename) {
         this.__typename = __typename;
     }
     public String get__typename() {
         return __typename;
     }

}