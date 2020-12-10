package org.teachmeskills.project.application.actions.authorisationActions;

import org.teachmeskills.project.entitiy.UsersStatus;
import org.teachmeskills.project.exceptions.DuplicateUserException;

public class CreateAccountAction extends BaseAccountAction implements AuthorisationAction {
    @Override
    public String getName() {
        return "Создать учетную запись";
    }

    @Override
    public UsersStatus action() throws DuplicateUserException {
        return authorisationController.createNewUser(getUsersLogin(), getUsersPassword());
    }
}
