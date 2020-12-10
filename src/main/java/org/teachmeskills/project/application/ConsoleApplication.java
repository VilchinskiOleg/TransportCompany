package org.teachmeskills.project.application;

import org.teachmeskills.project.application.actions.Action;
import org.teachmeskills.project.application.actions.CommonAction;
import org.teachmeskills.project.application.config.ConfigAuthorisationActions;
import org.teachmeskills.project.application.exceptions.StopApplicationException;
import org.teachmeskills.project.application.utils.Input;
import org.teachmeskills.project.exceptions.DuplicateUserException;
import org.teachmeskills.project.exceptions.NotUserException;
import java.util.Map;

public class ConsoleApplication {

    public void start() {
        System.out.println("+++++");
        run();
        System.out.println("+++++");
    }

    private Map<Integer, CommonAction> authorisation() throws StopApplicationException {
        Map<Integer, CommonAction> actionMap;
        try {
            actionMap = getAction(ConfigAuthorisationActions.actions).action().getUsersAction();
        } catch (NotUserException e) {
            System.out.println(e.getMessage());
            return authorisation();
        } catch (DuplicateUserException e) {
            System.out.println(e.getMessage());
            return authorisation();
        }
        return actionMap;
    }

    private void run() {
        Map<Integer, CommonAction> actionMapForUser;
        try {
            actionMapForUser = authorisation();
        } catch (StopApplicationException e) {
            return;
        }
        while (true) {
            CommonAction action = getAction(actionMapForUser);
            try {
                action.action();
            }catch (StopApplicationException e) {
                break;
            }
        }
    }

    private <T extends Action> void showMenu(Map<Integer, T> actionsByUsersStatus) {
        for (Map.Entry<Integer, T> item : actionsByUsersStatus.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue().getName());
        }
    }

    private <T extends Action> T getAction(Map<Integer, T> actionsByUsersStatus) {
        showMenu(actionsByUsersStatus);
        int number = Input.getInt("Выберите действие:");
        T action = actionsByUsersStatus.get(number);
        if (action != null) {
            return action;
        }
        System.out.println("Нет такого действия. Повторите ввод.");
        return getAction(actionsByUsersStatus);
    }
}
