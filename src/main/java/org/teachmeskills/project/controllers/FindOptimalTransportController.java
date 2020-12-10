package org.teachmeskills.project.controllers;

import org.teachmeskills.project.dao.*;
import org.teachmeskills.project.entitiy.City;
import org.teachmeskills.project.entitiy.QueryOptimalTransport;
import org.teachmeskills.project.entitiy.Transport;
import org.teachmeskills.project.exceptions.NotCityException;
import org.teachmeskills.project.exceptions.NotOptimalTransportException;
import org.teachmeskills.project.services.FindOptimalTransportService;
import java.util.*;
import java.util.stream.Collectors;

public class FindOptimalTransportController {
    private CitiesDao citiesDao = new CitiesDBdao();
    private TransportDao transportDao = new TransportDBdao();
    private QueriesResponsesLogDBdao logDao = new QueriesResponsesLogDBdao();

    private Transport createFastestTransport(List<Transport> transports) {
       return transports.stream().max(Comparator.comparingInt(Transport::getSped)).get();
    }

    private Transport createCheapestTransport(List<Transport> transports) {
        return transports.stream().min(Comparator.comparingInt(Transport::getPricePerKilometer)).get();
    }

    public String getOptimalTransport(QueryOptimalTransport<String> usersQuery) throws NotCityException, NotOptimalTransportException {
        City fromCity = citiesDao.getCity(usersQuery.getFromCity());
        City toCity = citiesDao.getCity(usersQuery.getToCity());
        FindOptimalTransportService service = new FindOptimalTransportService(usersQuery.getCityGenericClone(fromCity, toCity));
        List<Transport> transports = service.createListQueryForTransportDB().stream()
                .flatMap(str -> transportDao.getListTransport(str).stream())
                .collect(Collectors.toList());
        return  transports.size() == 0 ? service.getResultLine() :
                transports.size() == 1 ? service.getResultLine(logDao, createFastestTransport(transports)) :
                service.getResultLine(logDao, createFastestTransport(transports), createCheapestTransport(transports));
    }
}
