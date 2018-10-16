package contracts;

import exceptions.DuplicateModelException;
import exceptions.NonExistentModelException;

public interface Repository<T extends Modelable> {
    void add(T item) throws DuplicateModelException;

    T getItem(String model) throws NonExistentModelException;
}
