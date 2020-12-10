package org.teachmeskills.project.application.actions;

import org.teachmeskills.project.application.actions.updateActions.UpdateAction;
import org.teachmeskills.project.application.config.ConfigUpdateActions;
import org.teachmeskills.project.application.utils.Input;
import org.teachmeskills.project.controllers.ExportQueriesResponsesLogByXMLController;
import org.teachmeskills.project.controllers.CitiesUpdateController;
import org.teachmeskills.project.controllers.FindOptimalTransportController;
import org.teachmeskills.project.controllers.TransportUpdateController;
import org.teachmeskills.project.entitiy.EditableEntity;
import org.teachmeskills.project.entitiy.QueryOptimalTransport;
import java.util.Map;

public abstract class BaseAction {
    protected FindOptimalTransportController findOptimalTransportController = new FindOptimalTransportController();
    protected CitiesUpdateController updateCitiesController = new CitiesUpdateController();
    protected TransportUpdateController transportUpdateController = new TransportUpdateController();

    // These are methods for Actions on EditableEntities :

    private <T extends EditableEntity> void showNestedMenu(ConfigUpdateActions<T> actions) {
        for (Map.Entry<Integer, UpdateAction> item : actions.getActions().entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue().getName());
        }
    }

    protected <T extends EditableEntity> UpdateAction getUpdateAction(ConfigUpdateActions<T> actions) {
        showNestedMenu(actions);
        int number = Input.getInt("Выберите действие:");
        UpdateAction action = actions.getActions().get(number);
        if (action != null) {
            return action;
        }
        System.out.println("Нет такого действия. Повторите ввод.");
        return getUpdateAction(actions);
    }

    protected QueryOptimalTransport<String> getUsersQuery() {
        String fromCityLine = Input.getString("Введите города, из которого отправляемся:");
        String toCityLine = Input.getString("Введите города, в который нужно попасть:");
        int quantityPeople = Input.getInt("Введите необходимаое колличество пасадочных мест:");
        int quantityCargo = Input.getInt("Введите необхлдимый объём перевозимого груза:");
        return new QueryOptimalTransport<>(fromCityLine, toCityLine, quantityPeople, quantityCargo);
    }
}
