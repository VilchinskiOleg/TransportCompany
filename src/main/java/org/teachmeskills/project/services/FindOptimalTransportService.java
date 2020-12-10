package org.teachmeskills.project.services;

import org.teachmeskills.project.dao.QueriesResponsesLodDao;
import org.teachmeskills.project.dao.QueriesResponsesLogDBdao;
import org.teachmeskills.project.entitiy.City;
import org.teachmeskills.project.entitiy.QueryOptimalTransport;
import org.teachmeskills.project.entitiy.Transport;
import org.teachmeskills.project.entitiy.TypeTransport;
import org.teachmeskills.project.exceptions.NotOptimalTransportException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.lang.Math.*;

public class FindOptimalTransportService {
    QueryOptimalTransport<City> usersUpdateQuery;
    double distance;

    public FindOptimalTransportService(QueryOptimalTransport<City> usersUpdateQuery) { this.usersUpdateQuery = usersUpdateQuery; }

    public List<String> createListQueryForTransportDB() {
        List<Integer> transportTypeID = new ArrayList<>();
        transportTypeID.add(TypeTransport.LAND_TRANSPORT.getIdType());
        if (usersUpdateQuery.getFromCity().getIsHaveAirport() && usersUpdateQuery.getToCity().getIsHaveAirport())
            transportTypeID.add(TypeTransport.AIR_TRANSPORT.getIdType());
        if (usersUpdateQuery.getFromCity().getIsHaveSeaport() && usersUpdateQuery.getToCity().getIsHaveSeaport())
            transportTypeID.add(TypeTransport.SEA_TRANSPORT.getIdType());
        List<String> sqlQueries = transportTypeID.stream()
                .map( t -> String.format("SELECT * FROM transport WHERE type_id = %d and quantity_people >= %d and quantity_cargo >= %d",
                        t , usersUpdateQuery.getNeededQuantityPeople(), usersUpdateQuery.getNeededQuantityCargo()))
                .collect(Collectors.toList());
        return sqlQueries;
    }

    public String getResultLine() throws NotOptimalTransportException {
        throw new NotOptimalTransportException();
    }

    public String getResultLine(QueriesResponsesLodDao logDao, Transport transport) {
        usersUpdateQuery.setFastestResult(transport);
        usersUpdateQuery.setCheapestResult(transport);
        logDao.createLogLine(usersUpdateQuery);
        return getFirstPartLine() + getSecondPartLine(transport, "Самый быстрый и дешевый");
    }

    public String getResultLine(QueriesResponsesLodDao logDao, Transport fastestTransport, Transport cheapestTransport) {
        if (fastestTransport.equals(cheapestTransport)) return getResultLine(logDao, fastestTransport);
        usersUpdateQuery.setFastestResult(fastestTransport);
        usersUpdateQuery.setCheapestResult(cheapestTransport);
        logDao.createLogLine(usersUpdateQuery);
        return getFirstPartLine() +
                getSecondPartLine(fastestTransport, "Самый быстрый") + getSecondPartLine(cheapestTransport, "Самый дешёвый");
    }

    private double getDistance() {
        if (!(this.distance == 0.0))
            return this.distance;
        double longitude_A = usersUpdateQuery.getFromCity().getLongitude();
        double latitude_A = usersUpdateQuery.getFromCity().getLatitude();
        double longitude_B = usersUpdateQuery.getToCity().getLongitude();
        double latitude_B = usersUpdateQuery.getToCity().getLatitude();
        return this.distance = acos(sin(latitude_A)*sin(latitude_B) + cos(latitude_A)*cos(latitude_B)*cos(longitude_A + longitude_B)) * 6371; //km
    }

    private String getSecondPartLine(Transport transport, String mark) {
        double timeInRoad = getDistance()/transport.getSped();
        double priceOleTrip = getDistance() * transport.getPricePerKilometer();
        return String.format("\n%s транспорт - это %s. Время в пути - %f ч. Стоимость - %f руб.",
                mark, transport.getName(), timeInRoad, priceOleTrip);
    }

    private String getFirstPartLine() {
        return String.format("Для доставки %d человек и %d кг груза из %s в %s :",
                usersUpdateQuery.getNeededQuantityPeople(), usersUpdateQuery.getNeededQuantityCargo(),
                usersUpdateQuery.getFromCity().getName(), usersUpdateQuery.getToCity().getName());
    }
}
