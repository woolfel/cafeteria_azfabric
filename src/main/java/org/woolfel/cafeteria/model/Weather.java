package org.woolfel.cafeteria.model;

import java.time.LocalDate;

/**
 * Weather data maps to US Weather service data, which is public. You can also
 * use the public API to get data. The government makes the data available for
 * machine learning and is free for non-commercial use.
 *
 * For more information the Webpage for the api https://www.weather.gov/documentation/services-web-api
 */
public class Weather {
    private int timezone;
    private LocalDate date;
    private String source;
    private String geographyName;
    private GeographicRegion region;
    /**
     * HDD stands for heating degree day is used to help
     * estimate heating requirements at a given location
     * for a given day. It is defined as the difference
     * between 65 degrees F and the daily mean temperature
     */
    private int hdd = 0;
    /**
     * Cooling Degree Days. (Abbrev. CDD) - A form of Degree
     * Day used to estimate energy requirements for air
     * conditioning
     */
    private int cdd = 0;
    private double precipitation = 0.0;
    private double newSnow = 0.0;
    private double snowDepth = 0.0;
}
