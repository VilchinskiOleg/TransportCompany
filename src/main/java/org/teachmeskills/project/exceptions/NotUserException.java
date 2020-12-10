package org.teachmeskills.project.exceptions;

public class NotUserException extends Exception {
    @Override
    public String getMessage() {
        return "Данный пользователь не зарегестрирован. Проверьте логин или пароль.";
    }
}
