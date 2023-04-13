package lk.blacky.hostel.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.blacky.hostel.bo.custom.StudentBO;
import lk.blacky.hostel.dao.DAOFactory;
import lk.blacky.hostel.dao.custom.StudentDAO;
import lk.blacky.hostel.dto.StudentDTO;
import lk.blacky.hostel.entity.Student;

import java.io.IOException;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
    @Override
    public boolean saveStudent(StudentDTO dto) throws IOException {
        return studentDAO.save(new Student(
                dto.getStudentId(),
                dto.getName(),
                dto.getAddress(),
                dto.getContactNo(),
                dto.getDob(),
                dto.getGender()



        ));
    }

    @Override
    public boolean updateStudent(StudentDTO dto) {
        return studentDAO.update(new Student(dto.getStudentId(),dto.getName(),dto.getAddress(),dto.getContactNo(),dto.getDob(),dto.getGender()));
    }

    @Override
    public boolean deleteStudent(String id) {
        return studentDAO.delete(id);
    }

    @Override
    public ObservableList<StudentDTO> getAllStudentById(String id) {
        ObservableList<Student> all = studentDAO.getAllById(id);
        ObservableList<StudentDTO> list = FXCollections.observableArrayList();

        for (Student s : all) {
            list.add(new StudentDTO(

                    s.getName(),
                    s.getAddress(),
                    s.getContactNo(),
                    s.getDob(),
                    s.getGender()

            ));
        }


        return list;
    }

    @Override
    public ObservableList<StudentDTO> getAllStudent() {
        ObservableList<Student> all = studentDAO.getAll();
        ObservableList<StudentDTO> list = FXCollections.observableArrayList();

        for (Student s : all) {
            list.add(new StudentDTO(
                    s.getStudentId(),
                    s.getName(),
                    s.getAddress(),
                    s.getContactNo(),
                    s.getDob(),
                    s.getGender()
            ));
        }


        return list;




    }


}
