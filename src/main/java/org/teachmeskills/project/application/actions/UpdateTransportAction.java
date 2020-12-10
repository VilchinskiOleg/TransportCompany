package org.teachmeskills.project.application.actions;

import org.teachmeskills.project.application.config.ConfigUpdateActions;
import org.teachmeskills.project.application.exceptions.ComeBackApplicationException;
import org.teachmeskills.project.application.exceptions.StopApplicationException;
import org.teachmeskills.project.application.utils.Input;
import org.teachmeskills.project.entitiy.City;
import org.teachmeskills.project.entitiy.Transport;

public class UpdateTransportAction extends BaseAction implements CommonAction {
    @Override
    public String getName() { return "Редактировать транспорт"; }

    @Override
    public void action() {
        try {
            ConfigUpdateActions<Transport> actions = new ConfigUpdateActions<>(
                    transportUpdateController,
                    () -> new Transport(
                            Input.getInt("Введите ID:"),
                            Input.getString("Введите название транспортного средства:"),
                            Input.getInt("Введите скорость (км/ч):"),
                            Input.getInt("Введите количество перевозимых пасажиров (чел.):"),
                            Input.getInt("Введите количество перевозимого груза (кг):"),
                            Input.getTypeTransport(),
                            Input.getInt("Введите стоимость услуги пользования данным транспортом (руб/км):")),
                    () -> new Transport(Input.getInt("Введите ID:")));
            getUpdateAction(actions).action();
        } catch (ComeBackApplicationException e) {
            return;
        }
    }
}
