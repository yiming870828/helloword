/**
  * Copyright 2022 bejson.com 
  */
package com.sothebys.marketplace.entity.getUserShippingAndBillingInfo;
import java.util.List;

/**
 * Auto-generated: 2022-09-01 15:15:37
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class RetailItem {

    private String id;
    private String retailItemId;
    private String title;
    private String slug;
    private boolean isOwned;
    private List<Objects> objects;
    private List<String> creators;
    private Pricing pricing;
    private Media media;
    private Department department;
    private List<Category> category;
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

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
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

    public void setObjects(List<Objects> objects) {
         this.objects = objects;
     }
     public List<Objects> getObjects() {
         return objects;
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

    public void setMedia(Media media) {
         this.media = media;
     }
     public Media getMedia() {
         return media;
     }

    public void setDepartment(Department department) {
         this.department = department;
     }
     public Department getDepartment() {
         return department;
     }

    public void setCategory(List<Category> category) {
         this.category = category;
     }
     public List<Category> getCategory() {
         return category;
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