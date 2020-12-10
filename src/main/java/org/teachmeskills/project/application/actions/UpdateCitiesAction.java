package org.teachmeskills.project.application.actions;

import org.teachmeskills.project.application.actions.updateActions.AddOneAction;
import org.teachmeskills.project.application.actions.updateActions.UpdateOneAction;
import org.teachmeskills.project.application.config.ConfigUpdateActions;
import org.teachmeskills.project.application.exceptions.ComeBackApplicationException;
import org.teachmeskills.project.application.exceptions.StopApplicationException;
import org.teachmeskills.project.application.utils.Input;
import org.teachmeskills.project.entitiy.City;

public class UpdateCitiesAction extends BaseAction implements CommonAction {
    @Override
    public String getName() {
        return "Редактировать города";
    }

    @Override
    public void action() {
        try {
            ConfigUpdateActions<City> actions = new ConfigUpdateActions<>(
                    updateCitiesController,
                    () -> new City(
                            Input.getInt("Введите ID:"),
                            Input.getString("Введите название города:"),
                            Input.getDouble("Введите координату долготы:"),
                            Input.getDouble("Введите координату широты:"),
                            Input.getBoolean("Есть ли в городе аэропорт:"),
                            Input.getBoolean("Есть ли в городе морской порт:")),
                    () -> new City(Input.getInt("Введите ID:")));
            getUpdateAction(actions).action();
        } catch (ComeBackApplicationException e) {
            return;
        }
    }
}
