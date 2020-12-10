package org.teachmeskills.project.dao;

import org.teachmeskills.project.connections.MySqlConnection;
import org.teachmeskills.project.entitiy.City;
import org.teachmeskills.project.entitiy.QueryOptimalTransport;
import org.teachmeskills.project.entitiy.Transport;
import org.teachmeskills.project.entitiy.TypeTransport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class QueriesResponsesLogDBdao implements QueriesResponsesLodDao{
    @Override
    public void createLogLine(QueryOptimalTransport<City> query) {
        try (Connection connection = MySqlConnection.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(String.format("INSERT INTO queries_responses_log " +
                    "VALUES(null, %d, %d, %d, %d, %d, %d)",
                    query.getFromCity().getId(), query.getToCity().getId(), query.getNeededQuantityPeople(), query.getNeededQuantityCargo(),
                    query.getFastestResult().getId(), query.getCheapestResult().getId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<QueryOptimalTransport<City>> getAllLogLines() {
        List<QueryOptimalTransport<City>> result = new ArrayList<>();
        try (Connection connection = MySqlConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT qrp_c1_c2_t1.id, qrp_c1_c2_t1.from_city_name, qrp_c1_c2_t1.from_city_longitude, qrp_c1_c2_t1.from_city_latitude, qrp_c1_c2_t1.from_city_is_have_airport, qrp_c1_c2_t1.from_city_is_have_seaport," +
                    " qrp_c1_c2_t1.to_city_name, qrp_c1_c2_t1.to_city_longitude, qrp_c1_c2_t1.to_city_latitude, qrp_c1_c2_t1.to_city_is_have_airport, qrp_c1_c2_t1.to_city_is_have_seaport," +
                    " qrp_c1_c2_t1.needed_quantity_people, qrp_c1_c2_t1.needed_quantity_cargo, qrp_c1_c2_t1.f_tr_name, qrp_c1_c2_t1.f_tr_type_id, qrp_c1_c2_t1.f_tr_sped, qrp_c1_c2_t1.f_tr_quantity_people," +
                    " qrp_c1_c2_t1.f_tr_quantity_cargo, qrp_c1_c2_t1.f_tr_price_per_kilometer, ch_t.name ch_tr_name, ch_t.type_id ch_tr_type_id, ch_t.sped ch_tr_sped, ch_t.quantity_people ch_tr_quantity_people," +
                    " ch_t.quantity_cargo ch_tr_quantity_cargo, ch_t.price_per_kilometer ch_tr_price_per_kilometer FROM (SELECT qrp_c1_t1.id, qrp_c1_t1.from_city_name, qrp_c1_t1.from_city_longitude, qrp_c1_t1.from_city_latitude," +
                    " qrp_c1_t1.from_city_is_have_airport, qrp_c1_t1.from_city_is_have_seaport, c2.name to_city_name, c2.longitude to_city_longitude, c2.latitude to_city_latitude, c2.is_have_airport to_city_is_have_airport," +
                    " c2.is_have_seaport to_city_is_have_seaport, qrp_c1_t1.needed_quantity_people, qrp_c1_t1.needed_quantity_cargo, qrp_c1_t1.f_tr_name, qrp_c1_t1.f_tr_type_id, qrp_c1_t1.f_tr_sped, qrp_c1_t1.f_tr_quantity_people," +
                    " qrp_c1_t1.f_tr_quantity_cargo, qrp_c1_t1.f_tr_price_per_kilometer, qrp_c1_t1.cheapest_transport_id FROM (SELECT qrp_t1.id, c1.name from_city_name, c1.longitude from_city_longitude, c1.latitude from_city_latitude," +
                    " c1.is_have_airport from_city_is_have_airport, c1.is_have_seaport from_city_is_have_seaport, qrp_t1.to_city_id, qrp_t1.needed_quantity_people, qrp_t1.needed_quantity_cargo, qrp_t1.f_tr_name, qrp_t1.f_tr_type_id," +
                    " qrp_t1.f_tr_sped, qrp_t1.f_tr_quantity_people, qrp_t1.f_tr_quantity_cargo, qrp_t1.f_tr_price_per_kilometer, qrp_t1.cheapest_transport_id FROM (SELECT qrp.id, qrp.from_city_id, qrp.to_city_id," +
                    " qrp.needed_quantity_people, qrp.needed_quantity_cargo, f_t.name f_tr_name, f_t.type_id f_tr_type_id, f_t.sped f_tr_sped, f_t.quantity_people f_tr_quantity_people, f_t.quantity_cargo f_tr_quantity_cargo," +
                    " f_t.price_per_kilometer f_tr_price_per_kilometer, qrp.cheapest_transport_id FROM queries_responses_log qrp LEFT JOIN transport f_t ON qrp.fastest_transport_id = f_t.id) qrp_t1 LEFT JOIN cities c1 ON" +
                    " qrp_t1.from_city_id = c1.id) qrp_c1_t1 LEFT JOIN cities c2 ON qrp_c1_t1.to_city_id = c2.id) qrp_c1_c2_t1 LEFT JOIN transport ch_t ON qrp_c1_c2_t1.cheapest_transport_id = ch_t.id ORDER BY id");
            while (resultSet.next()) {
                City from_city = new City(
                        resultSet.getString("from_city_name"),
                        resultSet.getDouble("from_city_longitude"),
                        resultSet.getDouble("from_city_latitude"),
                        resultSet.getBoolean("from_city_is_have_airport"),
                        resultSet.getBoolean("from_city_is_have_seaport"));
                City to_city = new City(
                        resultSet.getString("to_city_name"),
                        resultSet.getDouble("to_city_longitude"),
                        resultSet.getDouble("to_city_latitude"),
                        resultSet.getBoolean("to_city_is_have_airport"),
                        resultSet.getBoolean("to_city_is_have_seaport"));
                Transport fastestResult = new Transport(
                        resultSet.getString("f_tr_name"),
                        resultSet.getInt("f_tr_sped"),
                        resultSet.getInt("f_tr_quantity_people"),
                        resultSet.getInt("f_tr_quantity_cargo"),
                        TypeTransport.values()[resultSet.getInt("f_tr_type_id") - 1],
                        resultSet.getInt("f_tr_price_per_kilometer")
                );
                Transport cheapestResult = new Transport(
                        resultSet.getString("ch_tr_name"),
                        resultSet.getInt("ch_tr_sped"),
                        resultSet.getInt("ch_tr_quantity_people"),
                        resultSet.getInt("ch_tr_quantity_cargo"),
                        TypeTransport.values()[resultSet.getInt("ch_tr_type_id") - 1],
                        resultSet.getInt("ch_tr_price_per_kilometer")
                );
                QueryOptimalTransport<City> query = new QueryOptimalTransport<>(
                        resultSet.getInt("id"),
                        from_city,
                        to_city,
                        resultSet.getInt("needed_quantity_people"),
                        resultSet.getInt("needed_quantity_cargo"),
                        fastestResult,
                        cheapestResult);
                result.add(query);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
