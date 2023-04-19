package lk.blacky.hostel.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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
    public JFXPasswordField txtHidepw;
    public ImageView imgOpenEye;
    public ImageView imgHideEye;
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


    public void btnUpdateOnAction(ActionEvent actionEvent) {
        if (userBO.updatePassword(new UserDTO(txtName.getText(),txtEmail.getText(),txtPassword.getText()))) {
            new Alert(Alert.AlertType.CONFIRMATION,"Updated!!!").show();
        }
    }
    String tempPw;
    public void initialize(){
        txtPassword.setVisible(false);
        imgOpenEye.setVisible(false);
    }

    public void showEyeOnClickAction(MouseEvent mouseEvent) {
        txtPassword.setVisible(false);
        imgOpenEye.setVisible(false);
        imgHideEye.setVisible(true);
        txtHidepw.setVisible(true);
    }

    public void hideEyeOnClickAction(MouseEvent mouseEvent) {
        txtPassword.setVisible(true);
        imgOpenEye.setVisible(true);
        imgHideEye.setVisible(false);
        txtHidepw.setVisible(false);
    }

    public void hidePasswordOnAction(KeyEvent keyEvent) {
        tempPw=txtHidepw.getText();
        txtPassword.setText(tempPw);
    }

    public void showPasswordOnAction(KeyEvent keyEvent) {
        tempPw=txtPassword.getText();
        txtHidepw.setText(tempPw);
    }
}
