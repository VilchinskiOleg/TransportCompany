package org.teachmeskills.project.application.actions.authorisationActions;

import org.teachmeskills.project.application.actions.Action;
import org.teachmeskills.project.application.exceptions.StopApplicationException;
import org.teachmeskills.project.entitiy.UsersStatus;
import org.teachmeskills.project.exceptions.DuplicateUserException;
import org.teachmeskills.project.exceptions.NotUserException;

public interface AuthorisationAction extends Action {
    UsersStatus action() throws NotUserException, DuplicateUserException, StopApplicationException;
}
