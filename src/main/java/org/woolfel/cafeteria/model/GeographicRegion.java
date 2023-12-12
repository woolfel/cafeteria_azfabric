package org.woolfel.cafeteria.model;

import java.util.UUID;

/**
 * Geographic region can be china, east asia or something
 * generic. The geographic center doesn't mean it is the
 * actual center, just an arbitrary longitude and latitude
 * to represent the region.
 */
public class GeographicRegion {
    private UUID regionID;
    private String name;
    private String description;
    private GPS geographyCenter;

    public GeographicRegion() {}

    public UUID getRegionID() {
        return regionID;
    }

    public void setRegionID(UUID regionID) {
        this.regionID = regionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GPS getGeographyCenter() {
        return geographyCenter;
    }

    public void setGeographyCenter(GPS geographyCenter) {
        this.geographyCenter = geographyCenter;
    }
}
