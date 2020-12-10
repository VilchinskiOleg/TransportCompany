package org.teachmeskills.project.application.actions.updateActions;


import org.teachmeskills.project.application.actions.Action;
import org.teachmeskills.project.application.exceptions.ComeBackApplicationException;

public class ComeBackApplicationAction implements UpdateAction {
    @Override
    public String getName() {
        return "Вернуться в меню";
    }

    @Override
    public void action() throws ComeBackApplicationException {
        throw new ComeBackApplicationException();
    }
}
