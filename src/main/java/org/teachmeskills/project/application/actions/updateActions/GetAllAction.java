package org.teachmeskills.project.application.actions.updateActions;

import org.teachmeskills.project.application.actions.Action;
import org.teachmeskills.project.controllers.UpdateController;
import org.teachmeskills.project.entitiy.EditableEntity;

public class GetAllAction<T extends EditableEntity> extends BaseUpdateAction<T> implements UpdateAction {

    public GetAllAction(UpdateController<T> controller) {
        super(controller);
    }

    @Override
    public String getName() {
        return "Получить список";
    }

    @Override
    public void action() {
        for (T entity : controller.getAll())
            System.out.println(entity);
    }
}
