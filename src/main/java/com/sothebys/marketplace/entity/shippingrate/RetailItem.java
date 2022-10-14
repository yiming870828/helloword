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
public class RetailItem {

    private String id;
    private String retailItemId;
    private String sku;
    private String title;
    private String description;
    private String slug;
    private boolean isOwned;
    private List<String> creators;
    private Pricing pricing;
    private List<Category> category;
    private Media media;
    private Config config;
    private Department department;
    private List<Objects> objects;
    private Shipping shipping;
    private String __typename;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setRetailItemId(String retailItemId) {
         this.retailItemId = retailItemId;
     }
     public String getRetailItemId() {
         return retailItemId;
     }

    public void setSku(String sku) {
         this.sku = sku;
     }
     public String getSku() {
         return sku;
     }

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    public void setSlug(String slug) {
         this.slug = slug;
     }
     public String getSlug() {
         return slug;
     }

    public void setIsOwned(boolean isOwned) {
         this.isOwned = isOwned;
     }
     public boolean getIsOwned() {
         return isOwned;
     }

    public void setCreators(List<String> creators) {
         this.creators = creators;
     }
     public List<String> getCreators() {
         return creators;
     }

    public void setPricing(Pricing pricing) {
         this.pricing = pricing;
     }
     public Pricing getPricing() {
         return pricing;
     }

    public void setCategory(List<Category> category) {
         this.category = category;
     }
     public List<Category> getCategory() {
         return category;
     }

    public void setMedia(Media media) {
         this.media = media;
     }
     public Media getMedia() {
         return media;
     }

    public void setConfig(Config config) {
         this.config = config;
     }
     public Config getConfig() {
         return config;
     }

    public void setDepartment(Department department) {
         this.department = department;
     }
     public Department getDepartment() {
         return department;
     }

    public void setObjects(List<Objects> objects) {
         this.objects = objects;
     }
     public List<Objects> getObjects() {
         return objects;
     }

    public void setShipping(Shipping shipping) {
         this.shipping = shipping;
     }
     public Shipping getShipping() {
         return shipping;
     }

    public void set__typename(String __typename) {
         this.__typename = __typename;
     }
     public String get__typename() {
         return __typename;
     }

}