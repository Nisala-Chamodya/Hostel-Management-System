package lk.blacky.hostel.dao.custom;

import javafx.collections.ObservableList;
import lk.blacky.hostel.dao.SuperDAO;
import lk.blacky.hostel.entity.User;

public interface UserDAO<T,id> extends SuperDAO {
    boolean save(User t);
    ObservableList<T> getAll();
}
