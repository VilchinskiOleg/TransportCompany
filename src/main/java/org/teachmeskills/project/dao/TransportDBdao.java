package org.teachmeskills.project.dao;

import org.teachmeskills.project.connections.MySqlConnection;
import org.teachmeskills.project.entitiy.Transport;
import org.teachmeskills.project.entitiy.TypeTransport;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransportDBdao implements TransportDao {
    @Override
    public List<Transport> getListTransport(String sql) {
        List<Transport> transports = new ArrayList<>();
        try (Connection connection = MySqlConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet transportLineList = statement.executeQuery(sql);
            while (transportLineList.next())
                transports.add(new Transport(
                        transportLineList.getInt("id"),
                        transportLineList.getString("name"),
                        transportLineList.getInt("sped"),
                        transportLineList.getInt("quantity_people"),
                        transportLineList.getInt("quantity_cargo"),
                        TypeTransport.values()[transportLineList.getInt("type_id") - 1],
                        transportLineList.getInt("price_per_kilometer")
                ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transports;
    }

    @Override
    public List<Transport> getAllTransport() {
        List<Transport> transports = new ArrayList<>();
        try (Connection connection = MySqlConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM transport");
            while (resultSet.next()){
                Transport transport = new Transport(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("sped"),
                        resultSet.getInt("quantity_people"),
                        resultSet.getInt("quantity_cargo"),
                        TypeTransport.values()[resultSet.getInt("type_id") - 1],
                        resultSet.getInt("price_per_kilometer"));
                transports.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transports;
    }

    @Override
    public void addTransport(Transport transport) {
        try (Connection connection = MySqlConnection.getConnection()) {
            String sql = "INSERT INTO transport VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, transport.getId());
            statement.setString(2, transport.getName());
            statement.setInt(3, transport.getType().getIdType());
            statement.setInt(4, transport.getSped());
            statement.setInt(5, transport.getQuantityPeople());
            statement.setInt(6, transport.getQuantityCargo());
            statement.setInt(7, transport.getPricePerKilometer());
            statement.execute();
        } catch (SQLException e) {
            return;
        }
    }

    @Override
    public void removeTransport(Transport transport) {
        try (Connection connection = MySqlConnection.getConnection()) {
            String sql = "DELETE FROM transport WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, transport.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTransport(Transport transport) {
        try (Connection connection = MySqlConnection.getConnection()) {
            String sql = "UPDATE transport SET name = ? , type_id = ?, sped = ?, quantity_people = ?, quantity_cargo = ?, price_per_kilometer = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,transport.getName());
            statement.setInt(2, transport.getType().getIdType());
            statement.setInt(3, transport.getSped());
            statement.setInt(4, transport.getQuantityPeople());
            statement.setInt(5, transport.getQuantityCargo());
            statement.setInt(6, transport.getPricePerKilometer());
            statement.setInt(7, transport.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
