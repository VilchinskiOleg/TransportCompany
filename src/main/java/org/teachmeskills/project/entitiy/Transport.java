package org.teachmeskills.project.entitiy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlType(propOrder = {"name", "type", "sped", "quantityPeople", "quantityCargo", "pricePerKilometer"})
public class Transport implements EditableEntity {
    private int id;
    private String name;
    private int sped;
    private int quantityPeople;
    private int quantityCargo;
    private TypeTransport type;
    private int pricePerKilometer;

    public Transport(int id, String name, int sped, int quantityPeople, int quantityCargo, TypeTransport type, int pricePerKilometer) {
        this.id = id;
        this.name = name;
        this.sped = sped;
        this.quantityPeople = quantityPeople;
        this.quantityCargo = quantityCargo;
        this.type = type;
        this.pricePerKilometer = pricePerKilometer;
    }

    public Transport(String name, int sped, int quantityPeople, int quantityCargo, TypeTransport type, int pricePerKilometer) {
        this.name = name;
        this.sped = sped;
        this.quantityPeople = quantityPeople;
        this.quantityCargo = quantityCargo;
        this.type = type;
        this.pricePerKilometer = pricePerKilometer;
    }

    public Transport(String name, int sped, int pricePerKilometer) {
        this.name = name;
        this.sped = sped;
        this.pricePerKilometer = pricePerKilometer;
    }

    public Transport(int id) {
        this.id = id;
    }

    public Transport() { }

    @XmlTransient
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSped() { return sped; }

    public void setSped(int sped) {
        this.sped = sped;
    }

    @XmlElement(name = "transported_quantity_people")
    public int getQuantityPeople() {
        return quantityPeople;
    }

    public void setQuantityPeople(int quantityPeople) {
        this.quantityPeople = quantityPeople;
    }

    @XmlElement(name = "transported_quantity_cargo")
    public int getQuantityCargo() {
        return quantityCargo;
    }

    public void setQuantityCargo(int quantityCargo) {
        this.quantityCargo = quantityCargo;
    }

    @XmlElement(name = "transport_type")
    public TypeTransport getType() {
        return type;
    }

    public void setType(TypeTransport type) {
        this.type = type;
    }

    @XmlElement(name = "price_per_kilometer")
    public int getPricePerKilometer() { return pricePerKilometer; }

    public void setPricePerKilometer(int pricePerKilometer) {
        this.pricePerKilometer = pricePerKilometer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return getId() == transport.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", name='" + name +
                ", sped=" + sped +
                ", quantityPeople=" + quantityPeople +
                ", quantityCargo=" + quantityCargo +
                ", type=" + type.getType() +
                ", pricePerKilometer=" + pricePerKilometer +
                '}';
    }
}
