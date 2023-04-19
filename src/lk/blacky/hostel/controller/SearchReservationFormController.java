package lk.blacky.hostel.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.hostel.util.Navigation;
import lk.blacky.hostel.util.Routes;

import java.io.IOException;

public class SearchReservationFormController {
    public AnchorPane pane;
    public JFXTextField txtSearch;


    public void backBtnOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.RESERVATION,pane);
    }
}
