package org.teachmeskills.project.application.actions;

import org.teachmeskills.project.application.exceptions.StopApplicationException;
import org.teachmeskills.project.application.utils.Input;
import org.teachmeskills.project.controllers.FindOptimalTransportController;
import org.teachmeskills.project.exceptions.NotCityException;
import org.teachmeskills.project.exceptions.NotOptimalTransportException;

public class FindOptimalTransportAction extends BaseAction implements CommonAction {
    @Override
    public String getName() {
        return "Подобрать наиболее быстрый и наиболее дешевый транспорт";
    }

    @Override
    public void action() {
        try {
            System.out.println( findOptimalTransportController.getOptimalTransport(getUsersQuery()));
        }catch (NotCityException e){
            System.out.println(e.getMessage());
        }catch (NotOptimalTransportException e){
            System.out.println(e.getMessage());
        }
    }
}
