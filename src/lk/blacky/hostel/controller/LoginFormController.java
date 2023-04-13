package lk.blacky.hostel.controller;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.hostel.util.Navigation;
import lk.blacky.hostel.util.Routes;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane pane;

    public void nxtbtnOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);
    }
}
