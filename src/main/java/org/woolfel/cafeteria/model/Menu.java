package org.woolfel.cafeteria.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A college cafeteria can have multiple stores for different cuisines
 * to give students more variety of choices.
 */
public class Menu {
    private UUID menuID;
    private LocalDate beginDate;
    private LocalDate endDate;
    /**
     * If the menu is for holidays or special occassions
     */
    private String menuType;
    private List<MenuItem> items = new ArrayList<>();
    public Menu(){}

    public UUID getMenuID() {
        return menuID;
    }

    public void setMenuID(UUID menuID) {
        this.menuID = menuID;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }
    public void addItem(MenuItem item) {
        item.setMenuID(this.menuID);
        this.items.add(item);
    }
}