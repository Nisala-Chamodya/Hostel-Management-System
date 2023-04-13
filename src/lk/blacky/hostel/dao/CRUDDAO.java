package lk.blacky.hostel.dao;

import javafx.collections.ObservableList;
import lk.blacky.hostel.dto.StudentDTO;

public interface CRUDDAO<T,id> extends SuperDAO{
    boolean save(T t );
    boolean update(T t);
    boolean delete(id id);
    ObservableList<T> getAllById(id id);
    ObservableList<T> getAll();



}
