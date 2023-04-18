package lk.blacky.hostel.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.hostel.bo.BOFactory;
import lk.blacky.hostel.bo.custom.RoomBO;
import lk.blacky.hostel.bo.custom.StudentBO;
import lk.blacky.hostel.dto.RoomDTO;
import lk.blacky.hostel.dto.StudentDTO;
import lk.blacky.hostel.util.Navigation;
import lk.blacky.hostel.util.Routes;

import java.io.IOException;

import static lk.blacky.hostel.util.Validator.*;

public class ManageRoomFormController {
    public AnchorPane pane;
    public JFXTextField txtRoomTypeId;
    public JFXTextField txtType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtQty;
    RoomBO roomBO = (RoomBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ROOM);
    public void backBtnOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (isRoomIdMatcher(txtRoomTypeId.getText())) {
            if (isTypeMatcher(txtType.getText())) {
                if (isKeyMoneyMatcher(txtKeyMoney.getText())) {
                    if (isQtyMatcher(txtQty.getText())) {




        String roomTypeId = txtRoomTypeId.getText();
        String type = txtType.getText();
        String keyMoney = txtKeyMoney.getText();
        int qty = Integer.parseInt(txtQty.getText());

        RoomDTO roomDTO=new RoomDTO(roomTypeId,type,keyMoney,qty);

        try{
            boolean isAdded = roomBO.saveRoom(roomDTO);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Room Added  Successfully!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
                    } else {
                        new Alert(Alert.AlertType.ERROR, "Please check the Valid QTY \n Enter Integers").show();
                        txtQty.setStyle("-jfx-unfocus-color : red");
                    }
                } else {
                    new Alert(Alert.AlertType.ERROR, "Please check the Valid Valid Ammount . \n 5000.00").show();
                    txtKeyMoney.setStyle("-jfx-unfocus-color : red");
                }
                } else {
                new Alert(Alert.AlertType.ERROR, "Please check the Valid Room Type. \n Non-AC \n Non-AC/Food \n AC \n AC/Food  ").show();
                txtType.setStyle("-jfx-unfocus-color : red");
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Please check the Valid RoomTypeID. \n(RM-001) Like That").show();
            txtRoomTypeId.setStyle("-jfx-unfocus-color : red");
        }


    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        if (isRoomIdMatcher(txtRoomTypeId.getText())) {
            if (isTypeMatcher(txtType.getText())) {
                if (isKeyMoneyMatcher(txtKeyMoney.getText())) {
                    if (isQtyMatcher(txtQty.getText())) {




                        String roomTypeId = txtRoomTypeId.getText();
                        String type = txtType.getText();
                        String keyMoney = txtKeyMoney.getText();
                        int qty = Integer.parseInt(txtQty.getText());

                        RoomDTO roomDTO=new RoomDTO(roomTypeId,type,keyMoney,qty);

                        try{
                            boolean isAdded = roomBO.updateRoom(roomDTO);
                            if (isAdded) {
                                new Alert(Alert.AlertType.CONFIRMATION, "Room Updated  Successfully!").show();
                            } else {
                                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                            }

                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    } else {
                        new Alert(Alert.AlertType.ERROR, "Please check the Valid QTY \n Enter Integers").show();
                        txtQty.setStyle("-jfx-unfocus-color : red");
                    }
                } else {
                    new Alert(Alert.AlertType.ERROR, "Please check the Valid Valid Ammount . \n 5000.00").show();
                    txtKeyMoney.setStyle("-jfx-unfocus-color : red");
                }
            } else {
                new Alert(Alert.AlertType.ERROR, "Please check the Valid Room Type. \n Non-AC \n Non-AC/Food \n AC \n AC/Food  ").show();
                txtType.setStyle("-jfx-unfocus-color : red");
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Please check the Valid RoomTypeID. \n(RM-001) Like That").show();
            txtRoomTypeId.setStyle("-jfx-unfocus-color : red");
        }




    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtRoomTypeId.clear();
        txtType.clear();
        txtKeyMoney.clear();
        txtQty.clear();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        if (roomBO.deleteRoom(txtRoomTypeId.getText())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Room  Delete  Successfully!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        try{
            ObservableList<RoomDTO> allRoomByIdById = roomBO.getAllRoomById(txtRoomTypeId.getText());
            for (RoomDTO roomDTO :allRoomByIdById  ) {

                txtType.setText(roomDTO.getType());
                txtKeyMoney.setText(roomDTO.getKeyMoney());
                txtQty.setText(String.valueOf(roomDTO.getQty()));


            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnSearchIconOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.SEARCHROOM,pane);
    }
}
