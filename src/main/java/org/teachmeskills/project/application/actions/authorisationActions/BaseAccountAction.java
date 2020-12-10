package org.teachmeskills.project.application.actions.authorisationActions;

import org.teachmeskills.project.application.utils.Input;
import org.teachmeskills.project.controllers.AuthorisationController;

public abstract class BaseAccountAction {
    protected AuthorisationController authorisationController = new AuthorisationController();

    protected String getUsersLogin() { return Input.getString("Введите логин:"); }
    protected String getUsersPassword() { return Input.getString("Введите пароль:"); }
}
