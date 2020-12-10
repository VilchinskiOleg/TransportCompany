package org.teachmeskills.project.controllers;

import org.teachmeskills.project.exceptions.DuplicateCityException;
import java.util.List;

public interface UpdateController<T> {
    void add(T t);
    List<T> getAll();
    void remove(T t);
    void update(T t);
}
