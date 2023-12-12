package org.woolfel.cafeteria.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Store {
    private UUID storeID;
    private UUID cafeID;
    private String storeName;
    private String storeDescription;
    private List<Menu> menus = new ArrayList<Menu>();
    private String[] tags;
    private List<OperatingHours> hours = new ArrayList<OperatingHours>();
    public Store() {}

    public UUID getStoreID() {
        return storeID;
    }

    public void setStoreID(UUID storeID) {
        this.storeID = storeID;
    }

    public UUID getCafeID() {
        return cafeID;
    }

    public void setCafeID(UUID cafeID) {
        this.cafeID = cafeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreDescription() {
        return storeDescription;
    }

    public void setStoreDescription(String storeDescription) {
        this.storeDescription = storeDescription;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public List<OperatingHours> getHours() {
        return hours;
    }

    public void setHours(List<OperatingHours> hours) {
        this.hours = hours;
    }
}
