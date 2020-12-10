package org.teachmeskills.project.dao;

import org.teachmeskills.project.exceptions.DuplicateUserException;

public interface UsersDao {
    int getUsersStatusID(String login, String password);
    void setUser(String login, String password) throws DuplicateUserException;
}
