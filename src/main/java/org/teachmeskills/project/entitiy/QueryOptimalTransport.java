package org.teachmeskills.project.entitiy;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"id", "fromCity", "toCity", "neededQuantityPeople", "neededQuantityCargo", "fastestResult", "cheapestResult"})
public class QueryOptimalTransport<T> {
    private int id;
    private T fromCity;
    private T toCity;
    private int neededQuantityPeople;
    private int neededQuantityCargo;
    private Transport fastestResult;
    private Transport cheapestResult;

    public QueryOptimalTransport(int id, T fromCity, T toCity, int neededQuantityPeople, int neededQuantityCargo, Transport fastestResult, Transport cheapestResult) {
        this.id = id;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.neededQuantityPeople = neededQuantityPeople;
        this.neededQuantityCargo = neededQuantityCargo;
        this.fastestResult = fastestResult;
        this.cheapestResult = cheapestResult;
    }

    public QueryOptimalTransport(T fromCity, T toCity, int neededQuantityPeople, int neededQuantityCargo) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.neededQuantityPeople = neededQuantityPeople;
        this.neededQuantityCargo = neededQuantityCargo;
    }

    public QueryOptimalTransport() { }

    @XmlAttribute(name = "query_id")
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @XmlElement(name = "from_city")
    public T getFromCity() {
        return fromCity;
    }

    public void setFromCity(T fromCity) {
        this.fromCity = fromCity;
    }

    @XmlElement(name = "to_city")
    public T getToCity() { return toCity; }

    public void setToCity(T toCity) { this.toCity = toCity; }

    @XmlElement(name = "needed_quantity_people")
    public int getNeededQuantityPeople() {
        return neededQuantityPeople;
    }

    public void setNeededQuantityPeople(int neededQuantityPeople) {
        this.neededQuantityPeople = neededQuantityPeople;
    }

    @XmlElement(name = "needed_quantity_cargo")
    public int getNeededQuantityCargo() {
        return neededQuantityCargo;
    }

    public void setNeededQuantityCargo(int neededQuantityCargo) { this.neededQuantityCargo = neededQuantityCargo; }

    @XmlElement(name = "fastest_transport_result")
    public Transport getFastestResult() { return fastestResult; }

    public void setFastestResult(Transport fastestResult) { this.fastestResult = fastestResult; }

    @XmlElement(name = "cheapest_transport_result")
    public Transport getCheapestResult() { return cheapestResult; }

    public void setCheapestResult(Transport cheapestResult) { this.cheapestResult = cheapestResult; }

    public QueryOptimalTransport<City> getCityGenericClone(City fromCity, City toCity) {
        return new QueryOptimalTransport<>(this.id, fromCity, toCity, this.neededQuantityPeople, this.neededQuantityCargo, this.fastestResult, this.cheapestResult);
    }

    @Override
    public String toString() {
        return "QueryOptimalTransport{" +
                "id=" + id +
                ", fromCity=" + fromCity +
                ", toCity=" + toCity +
                ", neededQuantityPeople=" + neededQuantityPeople +
                ", neededQuantityCargo=" + neededQuantityCargo +
                ", fastestResult=" + fastestResult +
                ", cheapestResult=" + cheapestResult +
                '}';
    }
}
