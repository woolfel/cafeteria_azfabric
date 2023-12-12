package org.woolfel.cafeteria.model;

import java.util.UUID;

public class CashRegister {
    private UUID registerID;
    private UUID cafeID;
    private String brand;
    private String model;
    private String version;
    public CashRegister(){}

    public UUID getRegisterID() {
        return registerID;
    }

    public void setRegisterID(UUID registerID) {
        this.registerID = registerID;
    }

    public UUID getCafeID() {
        return cafeID;
    }

    public void setCafeID(UUID cafeID) {
        this.cafeID = cafeID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
