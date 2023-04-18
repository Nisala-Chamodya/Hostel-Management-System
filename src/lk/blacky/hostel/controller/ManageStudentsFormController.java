package lk.blacky.hostel.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.hostel.bo.BOFactory;
import lk.blacky.hostel.bo.custom.StudentBO;
import lk.blacky.hostel.dto.StudentDTO;
import lk.blacky.hostel.entity.Student;
import lk.blacky.hostel.util.Navigation;
import lk.blacky.hostel.util.Routes;

import javax.persistence.Column;
import java.io.IOException;

import static lk.blacky.hostel.util.Validator.*;


public class ManageStudentsFormController {
    public AnchorPane pane;
    public JFXTextField txtStudentID;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;
    public JFXTextField txtDateOfBirth;
    public JFXTextField txtGender;
    StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENT);

    public void backBtnOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, pane);
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws IOException {
        if (isStudentIdMatcher(txtStudentID.getText())) {
            if (isNameMatch(txtName.getText())) {
                if (isNameMatch(txtAddress.getText())) {
                    if (isContactNoMatcher(txtContactNo.getText())) {
                        if (isBirthdayMatcher(txtDateOfBirth.getText())) {
                            if (isGenderMatcher(txtGender.getText())) {


                                String studentId = txtStudentID.getText();
                                String name = txtName.getText();
                                String address = txtAddress.getText();
                                String contactNo = txtContactNo.getText();
                                String dob = txtDateOfBirth.getText();
                                String gender = txtGender.getText();


                                StudentDTO studentDTO = new StudentDTO(studentId, name, address, contactNo, dob, gender);

                                try {
                                    boolean isAdded = studentBO.saveStudent(studentDTO);
                                    if (isAdded) {
                                        new Alert(Alert.AlertType.CONFIRMATION, "Student Added  Successfully!").show();
                                    } else {
                                        new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Data\n Male or Female").show();
                                txtGender.setStyle("-jfx-unfocus-color : red");
                            }
                        } else {
                            new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Valid Date of birth \n 2002-06-20").show();
                            txtDateOfBirth.setStyle("-jfx-unfocus-color : red");
                        }
                    } else {
                        new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Telephone Number \n (+94) 71 5946623 \n include 10  numbers. ").show();
                        txtContactNo.setStyle("-jfx-unfocus-color : red");

                    }
                } else {
                    new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Address \n consider:Letters Only").show();
                    txtAddress.setStyle("-jfx-unfocus-color : red");
                }
            } else {
                new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Name \n consider:Letters Only").show();
                txtName.setStyle("-jfx-unfocus-color : red");
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Please check the Valid Student-Id. \n(S-001) Like That").show();
            txtStudentID.setStyle("-jfx-unfocus-color : red");
        }

    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtStudentID.clear();
        txtName.clear();
        txtAddress.clear();
        txtContactNo.clear();
        txtDateOfBirth.clear();
        txtGender.clear();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

        if (isStudentIdMatcher(txtStudentID.getText())) {
            if (isNameMatch(txtName.getText())) {
                if (isNameMatch(txtAddress.getText())) {
                    if (isContactNoMatcher(txtContactNo.getText())) {
                        if (isBirthdayMatcher(txtDateOfBirth.getText())) {
                            if (isGenderMatcher(txtGender.getText())) {


                                String studentId = txtStudentID.getText();
                                String name = txtName.getText();
                                String address = txtAddress.getText();
                                String contactNo = txtContactNo.getText();
                                String dob = txtDateOfBirth.getText();
                                String gender = txtGender.getText();


                                StudentDTO studentDTO = new StudentDTO(studentId, name, address, contactNo, dob, gender);

                                try {
                                    boolean isAdded = studentBO.updateStudent(studentDTO);
                                    if (isAdded) {
                                        new Alert(Alert.AlertType.CONFIRMATION, "Student Update  Successfully!").show();
                                    } else {
                                        new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Data\n Male or Female").show();
                                txtGender.setStyle("-jfx-unfocus-color : red");
                            }
                        } else {
                            new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Valid Date of birth \n 2002-06-20").show();
                            txtDateOfBirth.setStyle("-jfx-unfocus-color : red");
                        }
                    } else {
                        new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Telephone Number \n (+94) 71 5946623 \n include 10  numbers. ").show();
                        txtContactNo.setStyle("-jfx-unfocus-color : red");

                    }
                } else {
                    new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Address \n consider:Letters Only").show();
                    txtAddress.setStyle("-jfx-unfocus-color : red");
                }
            } else {
                new Alert(Alert.AlertType.ERROR, "Pleace Insert Valid Name \n consider:Letters Only").show();
                txtName.setStyle("-jfx-unfocus-color : red");
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Please check the Valid Emp_Id. \n(S-001) Like That").show();
            txtStudentID.setStyle("-jfx-unfocus-color : red");
        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        if (studentBO.deleteStudent(txtStudentID.getText())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Student Delete  Successfully!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        try{
            ObservableList<StudentDTO> allStudentById = studentBO.getAllStudentById(txtStudentID.getText());
            for (StudentDTO s :allStudentById  ) {

               txtName.setText(s.getName());
               txtAddress.setText(s.getAddress());

               txtContactNo.setText(s.getGender());

               txtDateOfBirth.setText(s.getContactNo());

               txtGender.setText(s.getDob());

             /*   System.out.println(s.getContactNo() +"con");
                System.out.println(s.getDob()+"dob");
                System.out.println(s.getGender()+"gen");*/
                
            }
        }catch (Exception e){
            e.printStackTrace();
        }





    }

    public void btnSearchBtnOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.SEARCHSTUDENT,pane);
    }
}