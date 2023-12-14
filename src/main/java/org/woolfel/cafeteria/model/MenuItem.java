package org.woolfel.cafeteria.model;

import java.math.BigDecimal;
import java.util.UUID;

public class MenuItem {
    private UUID itemID;
    private UUID menuID;
    private String name;
    private String shortDescription;
    private String longDescription;
    private int itemNumber;
    private String[] ingredients;
    private boolean vegan;
    private boolean vegetarian;
    private boolean nutfree;
    private boolean glutenfree;
    private String[] tags;
    private BigDecimal price;
    private String category;

    public MenuItem() {}

    public UUID getItemID() {
        return itemID;
    }

    public void setItemID(UUID itemID) {
        this.itemID = itemID;
    }

    public UUID getMenuID() {
        return menuID;
    }

    public void setMenuID(UUID menuID) {
        this.menuID = menuID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isNutfree() {
        return nutfree;
    }

    public void setNutfree(boolean nutfree) {
        this.nutfree = nutfree;
    }

    public boolean isGlutenfree() {
        return glutenfree;
    }

    public void setGlutenfree(boolean glutenfree) {
        this.glutenfree = glutenfree;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
