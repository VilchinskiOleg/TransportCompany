package org.teachmeskills.project.exceptions;

public class NotCityException extends Exception {
    private String cityName;

    public NotCityException(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String getMessage() {
        return String.format("Города с названием + %s + нет в базе данных.", cityName);
    }
}
