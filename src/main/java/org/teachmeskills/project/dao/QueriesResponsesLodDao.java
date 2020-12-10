package org.teachmeskills.project.dao;

import org.teachmeskills.project.entitiy.City;
import org.teachmeskills.project.entitiy.QueryOptimalTransport;
import org.teachmeskills.project.entitiy.Transport;
import java.util.List;
import java.util.Map;

public interface QueriesResponsesLodDao {
    void createLogLine(QueryOptimalTransport<City> query);
    List<QueryOptimalTransport<City>> getAllLogLines();
}
