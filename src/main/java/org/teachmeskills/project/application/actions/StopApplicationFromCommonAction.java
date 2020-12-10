package org.teachmeskills.project.application.actions;

import org.teachmeskills.project.application.actions.authorisationActions.AuthorisationAction;
import org.teachmeskills.project.application.exceptions.StopApplicationException;
import org.teachmeskills.project.entitiy.UsersStatus;
import org.teachmeskills.project.exceptions.DuplicateUserException;
import org.teachmeskills.project.exceptions.NotUserException;

public class StopApplicationFromCommonAction implements CommonAction {
    @Override
    public String getName() {
        return "Выход";
    }

    @Override
    public void action() throws StopApplicationException {
        throw new StopApplicationException();
    }
}
