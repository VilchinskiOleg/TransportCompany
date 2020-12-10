package org.teachmeskills.project.controllers;

import org.teachmeskills.project.dao.UsersDBdao;
import org.teachmeskills.project.dao.UsersDao;
import org.teachmeskills.project.entitiy.UsersStatus;
import org.teachmeskills.project.exceptions.DuplicateUserException;
import org.teachmeskills.project.exceptions.NotUserException;

public class AuthorisationController {
    UsersDao usersDao = new UsersDBdao();

    public UsersStatus getUsersStatus(String login, String password) throws NotUserException {
        int statusID = usersDao.getUsersStatusID(login, password);
        if (statusID == 0) throw new NotUserException();
        return UsersStatus.values()[statusID - 1];
    }

    public UsersStatus createNewUser(String login, String password) throws DuplicateUserException {
        usersDao.setUser(login, password);
        return UsersStatus.USER;
    }
}
