package lk.blacky.hostel.dao.custom;

import javafx.collections.ObservableList;
import lk.blacky.hostel.dao.CRUDDAO;
import lk.blacky.hostel.dao.SuperDAO;
import lk.blacky.hostel.dto.StudentDTO;
import lk.blacky.hostel.entity.Student;

public interface StudentDAO extends CRUDDAO<Student,String> {
    ObservableList<String> studentIdList();
    String getName(Object id);


}
