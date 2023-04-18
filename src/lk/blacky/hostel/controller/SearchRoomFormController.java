package lk.blacky.hostel.controller;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.hostel.bo.BOFactory;
import lk.blacky.hostel.bo.custom.RoomBO;
import lk.blacky.hostel.bo.custom.StudentBO;
import lk.blacky.hostel.dto.RoomDTO;
import lk.blacky.hostel.util.Navigation;
import lk.blacky.hostel.util.Routes;

import java.io.IOException;

public class SearchRoomFormController {
    public AnchorPane pane;
    public TableView<RoomDTO> tblRoom;
    public TableColumn colRoomTypeId;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colQty;

    RoomBO roomBO = (RoomBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ROOM);

    public void initialize(){
        loadAllData();
        colRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("roomTypeId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }

    private void loadAllData() {
        tblRoom.setItems(roomBO.getAllStudent());
    }


    public void backBtnOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.MANAGEROOM,pane);
    }
}
