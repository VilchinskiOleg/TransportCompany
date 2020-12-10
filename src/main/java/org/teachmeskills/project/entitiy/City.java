package org.teachmeskills.project.entitiy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"name", "longitude", "latitude", "isHaveAirport", "isHaveSeaport"})
public class City implements EditableEntity {
    private int id;
    private String name;
    private double longitude;
    private double latitude;
    private boolean isHaveAirport;
    private boolean isHaveSeaport;

    public City(int id, String name, double longitude, double latitude, boolean isHaveAirport, boolean isHaveSeaport) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.isHaveAirport = isHaveAirport;
        this.isHaveSeaport = isHaveSeaport;
    }

    public City(String name, double longitude, double latitude, boolean isHaveAirport, boolean isHaveSeaport) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.isHaveAirport = isHaveAirport;
        this.isHaveSeaport = isHaveSeaport;
    }

    public City(int id) { this.id = id; }

    public City() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    @XmlElement(name = "is_have_airport")
    public boolean getIsHaveAirport() { return isHaveAirport; }

    public void setIsHaveAirport(boolean haveAirport) { isHaveAirport = haveAirport; }

    @XmlElement(name = "is_have_seaport")
    public boolean getIsHaveSeaport() {
        return isHaveSeaport;
    }

    public void setIsHaveSeaport(boolean haveSeaport) {
        isHaveSeaport = haveSeaport;
    }

    @XmlTransient
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", isHaveAirport=" + isHaveAirport +
                ", isHaveSeaport=" + isHaveSeaport +
                '}';
    }
}

