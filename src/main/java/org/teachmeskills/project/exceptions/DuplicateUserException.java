package org.teachmeskills.project.exceptions;

public class DuplicateUserException extends Exception {
    @Override
    public String getMessage() {
        return "Пользователь с таким логином и паролем уже зарегестрирован. Придумайте новы логин и пароль.";
    }
}
