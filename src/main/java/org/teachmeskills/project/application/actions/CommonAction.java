package org.teachmeskills.project.application.actions;

import org.teachmeskills.project.application.exceptions.StopApplicationException;

public interface CommonAction extends Action {
    void action() throws StopApplicationException;
}
