package org.teachmeskills.project.dao;

import org.teachmeskills.project.entitiy.City;
import org.teachmeskills.project.entitiy.Transport;
import java.util.List;

public interface TransportDao {
    List<Transport> getListTransport(String query);
    List<Transport> getAllTransport();
    void addTransport(Transport transport);
    void removeTransport(Transport transport);
    void updateTransport(Transport transport);
}
