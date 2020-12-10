package org.teachmeskills.project.application.actions;

import org.teachmeskills.project.application.exceptions.ComeBackApplicationException;
import org.teachmeskills.project.application.exceptions.StopApplicationException;
import org.teachmeskills.project.controllers.ExportQueriesResponsesLogByXMLController;

public class ExportQueriesResponsesLogXMLAction implements CommonAction {
    @Override
    public String getName() {
        return "Импортировать историю-лог запросов пользователей в xml-файл";
    }

    @Override
    public void action() {
        new  ExportQueriesResponsesLogByXMLController().createStoryLogXML();
    }
}
