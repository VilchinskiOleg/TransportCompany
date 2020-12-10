package org.teachmeskills.project.application.config;

import org.teachmeskills.project.application.actions.*;
import java.util.HashMap;
import java.util.Map;

public class ConfigActions {
    public static Map<Integer, CommonAction> administratorsActions = new HashMap<>();
    public static Map<Integer, CommonAction> usersActions = new HashMap<>();

    static {
        administratorsActions.put(0, new StopApplicationFromCommonAction());
        administratorsActions.put(1, new FindOptimalTransportAction());
        administratorsActions.put(2, new UpdateCitiesAction());
        administratorsActions.put(3, new UpdateTransportAction());
        administratorsActions.put(4, new ExportQueriesResponsesLogXMLAction());

        usersActions.put(0, new StopApplicationFromCommonAction());
        usersActions.put(1, new FindOptimalTransportAction());
    }
}
