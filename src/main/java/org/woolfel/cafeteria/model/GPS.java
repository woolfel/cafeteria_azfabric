package org.woolfel.cafeteria.model;

/**
 * The GPS coordinates at minimum is longitude and latitude. The altitude
 * is optional and in many cases will be 0.0
 */
public class GPS {
    private double longitude;
    private double latitude;
    private double altitude;

    public GPS() {}

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }
}
