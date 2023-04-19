package lk.blacky.hostel.controller;


import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.scene.control.behavior.TextFieldBehavior;
import com.sun.javafx.scene.control.skin.TextFieldSkin;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

    UserBO userBO = (UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.USER);



    public void initialize(){
        lblError.setVisible(false);
        lblforgetpw.setVisible(false);
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

                Clear();
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
}
