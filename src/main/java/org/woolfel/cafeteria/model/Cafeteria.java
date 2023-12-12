package org.woolfel.cafeteria.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cafeteria {
    private UUID cafeteriaID;
    private String name;
    private String locationName;
    private GPS mapLocation;
    private List<Store> cafeStores = new ArrayList<>();
    private List<OperatingHours> hours = new ArrayList<OperatingHours>();

    public Cafeteria(){}

    public UUID getCafeteriaID() {
        return cafeteriaID;
    }

    public void setCafeteriaID(UUID cafeteriaID) {
        this.cafeteriaID = cafeteriaID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public GPS getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(GPS mapLocation) {
        this.mapLocation = mapLocation;
    }

    public List<Store> getCafeStores() {
        return cafeStores;
    }

    public void setCafeStores(List<Store> cafeStores) {
        this.cafeStores = cafeStores;
    }

    public List<OperatingHours> getHours() {
        return hours;
    }

    public void setHours(List<OperatingHours> hours) {
        this.hours = hours;
    }
}
