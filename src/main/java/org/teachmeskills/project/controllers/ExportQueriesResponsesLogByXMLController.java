package org.teachmeskills.project.controllers;

import org.teachmeskills.project.dao.QueriesResponsesLogDBdao;
import org.teachmeskills.project.services.CreateStoryLogXMLService;

public class ExportQueriesResponsesLogByXMLController {
    QueriesResponsesLogDBdao logDBdao = new QueriesResponsesLogDBdao();

    public void createStoryLogXML() {
        CreateStoryLogXMLService service = new CreateStoryLogXMLService(logDBdao.getAllLogLines());
        new Thread(service).start();
    }
}
