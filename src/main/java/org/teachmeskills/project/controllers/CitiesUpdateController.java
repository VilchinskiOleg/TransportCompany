package org.teachmeskills.project.controllers;

import org.teachmeskills.project.dao.CitiesDBdao;
import org.teachmeskills.project.dao.CitiesDao;
import org.teachmeskills.project.entitiy.City;
import org.teachmeskills.project.exceptions.DuplicateCityException;
import java.util.List;

public class CitiesUpdateController implements UpdateController<City> {
    CitiesDao citiesDao = new CitiesDBdao();

    public void add(City city) { citiesDao.addCity(city);}

    public List<City> getAll() { return citiesDao.getAllCities(); }

    public void remove(City city) { citiesDao.removeCity(city); }

    public void update(City city) { citiesDao.updateCity(city); }
}
