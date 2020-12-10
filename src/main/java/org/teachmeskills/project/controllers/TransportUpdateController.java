package org.teachmeskills.project.controllers;

import org.teachmeskills.project.dao.TransportDBdao;
import org.teachmeskills.project.dao.TransportDao;
import org.teachmeskills.project.entitiy.Transport;
import java.util.List;

public class TransportUpdateController implements UpdateController<Transport> {
    TransportDao transportDao = new TransportDBdao();

    @Override
    public void add(Transport transport) { transportDao.addTransport(transport); }

    @Override
    public List<Transport> getAll() { return transportDao.getAllTransport(); }

    @Override
    public void remove(Transport transport) { transportDao.removeTransport(transport); }

    @Override
    public void update(Transport transport) { transportDao.updateTransport(transport); }
}
