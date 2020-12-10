package org.teachmeskills.project.entitiy;

import org.teachmeskills.project.application.actions.Action;
import org.teachmeskills.project.application.actions.CommonAction;
import org.teachmeskills.project.application.config.ConfigActions;
import java.util.Map;

public enum UsersStatus {
    ADMIN {
        @Override
        public String getUsersType() { return "Администратор"; }

        @Override
        public Map<Integer, CommonAction> getUsersAction() { return ConfigActions.administratorsActions; }
    },

    USER {
        @Override
        public String getUsersType() { return "Ползователь"; }

        @Override
        public Map<Integer, CommonAction> getUsersAction() { return ConfigActions.usersActions; }
    };

    public abstract String getUsersType();
    public abstract Map<Integer, CommonAction> getUsersAction();
}
