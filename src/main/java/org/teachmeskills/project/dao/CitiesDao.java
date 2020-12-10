package org.teachmeskills.project.dao;

import org.teachmeskills.project.entitiy.City;
import org.teachmeskills.project.exceptions.DuplicateCityException;
import org.teachmeskills.project.exceptions.NotCityException;
import java.util.List;

public interface CitiesDao {
    City getCity(String name) throws NotCityException;
    List<City> getAllCities();
    void addCity(City city);
    void removeCity(City city);
    void updateCity(City city);
}
