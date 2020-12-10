package org.teachmeskills.project.application.config;

import org.teachmeskills.project.application.actions.Action;
import org.teachmeskills.project.application.actions.updateActions.*;
import org.teachmeskills.project.controllers.UpdateController;
import org.teachmeskills.project.entitiy.EditableEntity;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ConfigUpdateActions<T extends EditableEntity> {
    private Map<Integer, UpdateAction> actions = new HashMap<>();

    public ConfigUpdateActions(UpdateController<T> controller, Supplier<T> allFieldsConstructor, Supplier<T> idFieldConstructor) {
        actions.put(1, new GetAllAction<T>(controller));
        actions.put(2, new AddOneAction<T>(controller, allFieldsConstructor));
        actions.put(3, new UpdateOneAction<T>(controller, allFieldsConstructor));
        actions.put(4, new RemoveOneAction<T>(controller, idFieldConstructor));
        actions.put(0, new ComeBackApplicationAction());
    }

    public Map<Integer, UpdateAction> getActions() { return actions; }
}
