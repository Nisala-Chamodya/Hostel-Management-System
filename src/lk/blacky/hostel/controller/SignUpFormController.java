package lk.blacky.hostel.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.hostel.bo.BOFactory;
import lk.blacky.hostel.bo.custom.UserBO;
import lk.blacky.hostel.dto.UserDTO;
import lk.blacky.hostel.util.Navigation;
import lk.blacky.hostel.util.Routes;

import java.io.IOException;

public class SignUpFormController {
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtPassword;
    public AnchorPane pane;
    UserBO userBO = (UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.USER);

    public void nextBtnOnClickAction(MouseEvent mouseEvent) {

    }

    public void backBtnOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        UserDTO dto = new UserDTO(txtName.getText(), txtEmail.getText(), txtPassword.getText());
        if (userBO.saveUser(dto)){
            new Alert(Alert.AlertType.CONFIRMATION,"Saved!!!").show();
        }
    }
}
