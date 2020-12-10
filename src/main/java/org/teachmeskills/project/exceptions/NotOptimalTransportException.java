package org.teachmeskills.project.exceptions;

public class NotOptimalTransportException extends Exception {
    @Override
    public String getMessage() {
        return "К сожалению подходящего транспорта нет.";
    }
}
