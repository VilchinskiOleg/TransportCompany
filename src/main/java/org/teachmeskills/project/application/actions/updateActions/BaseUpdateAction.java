package org.teachmeskills.project.application.actions.updateActions;

import org.teachmeskills.project.controllers.UpdateController;
import org.teachmeskills.project.entitiy.EditableEntity;

public abstract class BaseUpdateAction<T extends EditableEntity> {
    protected UpdateController<T> controller;

    public BaseUpdateAction(UpdateController<T> controller) {
        this.controller = controller;
    }
}
