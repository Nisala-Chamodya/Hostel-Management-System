package lk.blacky.hostel.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();
        switch (route) {
            case LOGIN:
                window.setTitle("Login Form");
                initUI("LoginForm.fxml");
                break;
            case DASHBOARD:
                window.setTitle("DashBoard");
                initUI("DashBoardForm.fxml");
                break;
            case MANAGESTUDENTS:
                window.setTitle("Manage Students");
                initUI("ManageStudentsForm.fxml");
                break;
            case SEARCHSTUDENT:
                window.setTitle("Search Student");
                initUI("SearchStudentForm.fxml");
                break;




        }
    }

    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/blacky/hostel/view/"+location)));

    }


}
