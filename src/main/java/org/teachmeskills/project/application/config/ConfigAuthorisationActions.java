package org.teachmeskills.project.application.config;

import org.teachmeskills.project.application.actions.authorisationActions.AuthorisationAction;
import org.teachmeskills.project.application.actions.authorisationActions.CheckAccountAction;
import org.teachmeskills.project.application.actions.authorisationActions.CreateAccountAction;
import org.teachmeskills.project.application.actions.authorisationActions.StopApplicationFromAuthorisationAction;
import java.util.HashMap;
import java.util.Map;

public class ConfigAuthorisationActions {
    public static Map<Integer, AuthorisationAction> actions = new HashMap<>();

    static {
        actions.put(0, new StopApplicationFromAuthorisationAction());
        actions.put(1, new CheckAccountAction());
        actions.put(2, new CreateAccountAction());
    }
}
