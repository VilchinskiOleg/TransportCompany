package org.teachmeskills.project.application.actions.updateActions;

import org.teachmeskills.project.application.actions.Action;
import org.teachmeskills.project.controllers.UpdateController;
import org.teachmeskills.project.entitiy.EditableEntity;
import java.util.function.Supplier;

public class AddOneAction<T extends EditableEntity> extends BaseUpdateAction<T> implements UpdateAction {
    private Supplier<T> factory;

    public AddOneAction(UpdateController<T> controller, Supplier<T> factory) {
        super(controller);
        this.factory = factory;
    }

    @Override
    public String getName() {
        return "Добавить.";
    }

    @Override
    public void action() { controller.add(factory.get()); }
}
