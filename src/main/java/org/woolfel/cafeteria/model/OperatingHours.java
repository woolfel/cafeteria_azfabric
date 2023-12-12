package org.woolfel.cafeteria.model;

import java.time.LocalTime;

/**
 * Cafeterias aren't open 24/7. They generally are open for breakfast and then
 * stop serving to prepare for lunch service. After lunch, they might close
 * to prepare for dinner service.
 */
public class OperatingHours {
    private LocalTime open;
    private LocalTime close;
    private String name;
    public OperatingHours(){}

    public LocalTime getOpen() {
        return open;
    }

    public void setOpen(LocalTime open) {
        this.open = open;
    }

    public LocalTime getClose() {
        return close;
    }

    public void setClose(LocalTime close) {
        this.close = close;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
