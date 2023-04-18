package lk.blacky.hostel.bo.custom;

import javafx.collections.ObservableList;
import lk.blacky.hostel.bo.SuperBO;
import lk.blacky.hostel.dto.StudentDTO;
import lk.blacky.hostel.entity.Student;

import java.io.IOException;

public interface StudentBO extends SuperBO {
    boolean saveStudent(StudentDTO dto) throws IOException;
    boolean updateStudent(StudentDTO dto);
    boolean deleteStudent(String id);
    ObservableList<StudentDTO> getAllStudentById(String id);
    ObservableList<StudentDTO> getAllStudent();
    ObservableList<String> getStudentIds();
    String getStudentName(Object id);




}
