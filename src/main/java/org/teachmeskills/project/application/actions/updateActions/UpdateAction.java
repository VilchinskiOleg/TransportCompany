package org.teachmeskills.project.application.actions.updateActions;

import org.teachmeskills.project.application.actions.Action;
import org.teachmeskills.project.application.exceptions.ComeBackApplicationException;

public interface UpdateAction extends Action {
    void action() throws ComeBackApplicationException;
}
