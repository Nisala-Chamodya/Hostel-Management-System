package lk.blacky.hostel.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.blacky.hostel.util.Navigation;
import lk.blacky.hostel.util.Routes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class DashBoardFormController {
    public AnchorPane pane;


    public void btnManageStudentOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.MANAGESTUDENTS,pane);
    }
}
