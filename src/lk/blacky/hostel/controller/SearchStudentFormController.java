package lk.blacky.hostel.controller;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.hostel.bo.BOFactory;
import lk.blacky.hostel.bo.custom.StudentBO;
import lk.blacky.hostel.dto.StudentDTO;
import lk.blacky.hostel.util.Navigation;
import lk.blacky.hostel.util.Routes;

import java.io.IOException;

public class SearchStudentFormController {
    public TableView<StudentDTO> tblStudent;
    public TableColumn colStudentId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContatNo;
    public TableColumn colDOB;
    public TableColumn colGender;
    public AnchorPane pane;

    StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENT);


    public void initialize(){

        loadAllData();
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContatNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));


    }


    private void loadAllData() {
        tblStudent.setItems(studentBO.getAllStudent());
    }

    public void backBtnOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.MANAGESTUDENTS,pane);
    }
}
