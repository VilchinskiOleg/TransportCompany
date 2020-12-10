package org.teachmeskills.project.application.actions.authorisationActions;

import org.teachmeskills.project.entitiy.UsersStatus;
import org.teachmeskills.project.exceptions.NotUserException;

public class CheckAccountAction extends BaseAccountAction implements AuthorisationAction {
    @Override
    public String getName() {
        return "Войти в программу под своим учетным именем";
    }

    @Override
    public UsersStatus action() throws NotUserException {
        return authorisationController.getUsersStatus(getUsersLogin(), getUsersPassword());
    }
}
