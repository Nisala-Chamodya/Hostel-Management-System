package lk.blacky.hostel.controller;


import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.scene.control.behavior.TextFieldBehavior;
import com.sun.javafx.scene.control.skin.TextFieldSkin;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

public class LoginFormController  {
    public AnchorPane pane;
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtPassword;
    public Label lblError;
    public Label lblforgetpw;
    public JFXPasswordField txtHidepw;
    public ImageView imgHideEye;
    public ImageView imgOpenEye;

    UserBO userBO = (UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.USER);

String tempPw;

    public void initialize(){
        lblError.setVisible(false);
        lblforgetpw.setVisible(false);

        /*hide pw*/
        txtPassword.setVisible(false);
        imgOpenEye.setVisible(false);
    }

    public void nxtbtnOnAction(MouseEvent mouseEvent) throws IOException {
        String userName=txtName.getText();
        String password=txtPassword.getText();
        ObservableList<UserDTO> allUser = userBO.getAllUser();
        for (UserDTO userDTO: allUser) {
            if (userName.equals(userDTO.getName()) && password.equals(userDTO.getPassword()) ){
                Navigation.navigate(Routes.DASHBOARD,pane);

            }else {
                lblError.setVisible(true);
                lblError.setText("      Incorrect User Name Or Password ");
                lblforgetpw.setVisible(true);
                lblforgetpw.setText("Forget Password?");

                //Clear();
            }



        }






    }


    private void Clear() {
        txtName.clear();
        txtEmail.clear();
        txtPassword.clear();
    }


    public void areYouNewOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.SIGNUP,pane);
    }

    public void hidePasswordOnAction(KeyEvent keyEvent) {
        tempPw=txtHidepw.getText();
        txtPassword.setText(tempPw);
    }

    public void hideEyeOnClickAction(MouseEvent mouseEvent) {
        txtPassword.setVisible(true);
        imgOpenEye.setVisible(true);
        imgHideEye.setVisible(false);
        txtHidepw.setVisible(false);
    }

    public void showEyeOnClickAction(MouseEvent mouseEvent) {
        txtPassword.setVisible(false);
        imgOpenEye.setVisible(false);
        imgHideEye.setVisible(true);
        txtHidepw.setVisible(true);
    }

    public void showPasswordOnAction(KeyEvent keyEvent) {
        tempPw=txtPassword.getText();
        txtHidepw.setText(tempPw);
    }

    public void txtUpdatePasswordOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.SIGNUP,pane);
    }
}
