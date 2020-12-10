package org.teachmeskills.project.application.actions.authorisationActions;

import org.teachmeskills.project.application.exceptions.StopApplicationException;
import org.teachmeskills.project.entitiy.UsersStatus;
import org.teachmeskills.project.exceptions.DuplicateUserException;
import org.teachmeskills.project.exceptions.NotUserException;

public class StopApplicationFromAuthorisationAction implements AuthorisationAction {
    @Override
    public String getName() {
        return "Выход";
    }

    @Override
    public UsersStatus action() throws StopApplicationException {
        throw new StopApplicationException();
    }
}
