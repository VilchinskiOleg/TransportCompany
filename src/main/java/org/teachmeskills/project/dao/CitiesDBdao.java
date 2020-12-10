package org.teachmeskills.project.dao;

import org.teachmeskills.project.connections.MySqlConnection;
import org.teachmeskills.project.entitiy.City;
import org.teachmeskills.project.exceptions.DuplicateCityException;
import org.teachmeskills.project.exceptions.NotCityException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitiesDBdao implements CitiesDao {
    @Override
    public City getCity(String name) throws NotCityException {
        City result = null;
        try (Connection connection = MySqlConnection.getConnection()) {
            String sql = "SELECT * FROM cities WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
                result = new City(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("longitude"),
                        resultSet.getDouble("latitude"),
                        resultSet.getBoolean("is_have_airport"),
                        resultSet.getBoolean("is_have_seaport"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == null)
            throw new NotCityException(name);
        return result;
    }

    @Override
    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        try (Connection connection = MySqlConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cities");
            while (resultSet.next()){
                City city = new City(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("longitude"),
                        resultSet.getDouble("latitude"),
                        resultSet.getBoolean("is_have_airport"),
                        resultSet.getBoolean("is_have_seaport"));
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public void addCity(City city) {
        try (Connection connection = MySqlConnection.getConnection()) {
            String sql = "INSERT INTO cities VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, city.getId());
            statement.setString(2, city.getName());
            statement.setDouble(3, city.getLongitude());
            statement.setDouble(4, city.getLatitude());
            statement.setBoolean(5, city.getIsHaveAirport());
            statement.setBoolean(6, city.getIsHaveSeaport());
            statement.execute();
        } catch (SQLException e) {
            return;
        }
    }

    @Override
    public void removeCity(City city) {
        try (Connection connection = MySqlConnection.getConnection()) {
            String sql = "DELETE FROM cities WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, city.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCity(City city) {
        try (Connection connection = MySqlConnection.getConnection()) {
            String sql = "UPDATE cities SET name = ? , longitude = ?, latitude = ?, is_have_airport = ?, is_have_seaport = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, city.getName());
            statement.setDouble(2, city.getLongitude());
            statement.setDouble(3, city.getLatitude());
            statement.setBoolean(4, city.getIsHaveAirport());
            statement.setBoolean(5, city.getIsHaveSeaport());
            statement.setInt(6, city.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
