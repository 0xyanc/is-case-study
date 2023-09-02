package com.instantsystem.casestudy.parkingspot.model;

/**
 * Enum representing all cities supported by this application.
 */
public enum CityEnum {
    POITIERS;

    /**
     * Find the CityEnum corresponding to the name parameter.
     * @param name
     * @return the corresponding CityEnum from the name, or null if not found
     */
    public static CityEnum findByName(String name) {
        CityEnum city = null;
        for (CityEnum c : values()) {
            if (c.name().equalsIgnoreCase(name)) {
                city = c;
                break;
            }
        }
        return city;
    }
}
