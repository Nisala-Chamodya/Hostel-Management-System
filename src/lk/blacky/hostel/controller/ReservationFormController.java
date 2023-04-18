package lk.blacky.hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.hostel.bo.custom.ReservationBO;
import lk.blacky.hostel.bo.custom.RoomBO;
import lk.blacky.hostel.bo.custom.StudentBO;
import lk.blacky.hostel.bo.custom.impl.ReservationBOImpl;
import lk.blacky.hostel.bo.custom.impl.RoomBOImpl;
import lk.blacky.hostel.bo.custom.impl.StudentBOImpl;

import lk.blacky.hostel.dto.ReservationDTO;
import lk.blacky.hostel.dto.RoomDTO;
import lk.blacky.hostel.dto.StudentDTO;
import lk.blacky.hostel.entity.Room;
import lk.blacky.hostel.entity.Student;
import lk.blacky.hostel.util.Navigation;
import lk.blacky.hostel.util.Routes;
import lk.blacky.hostel.view.tm.CartTm;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReservationFormController {
    public AnchorPane pane;
    public JFXTextField txtResId;

    public JFXComboBox cmbStudentIds;

    public JFXTextField txtStudentName;
    public JFXComboBox cmbRoomTypeId;
    public JFXTextField txtType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtQty;
    public JFXTextField txtDateFrom;
    public JFXDatePicker pickerDateTo;

    public TableView tblReserveRoom;
    public TableColumn colResId;
    public TableColumn colRoomTypeId;
    public TableColumn colType;
    public TableColumn colpayingAmount;
    public TableColumn colStudentId;
    public TableColumn colKeyMoney;

    public TableColumn colDateTo;
    public JFXTextField txtPayingAmmount;

    public TableColumn coldateFrom;

    ReservationBO reservationBO = new ReservationBOImpl();
    StudentBO studentBO = new StudentBOImpl();
    RoomBO roomBO = new RoomBOImpl();

    String reservationid="";
    public void initialize(){
        setReservationId();
        setReservationDate();
        setStudentIds();
        setRoomTypeId();
        colResId.setCellValueFactory(new PropertyValueFactory<>("resId"));
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("roomTypeId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colpayingAmount.setCellValueFactory(new PropertyValueFactory<>("payingAmount"));
        coldateFrom.setCellValueFactory(new PropertyValueFactory<>("dateFrom"));
        colDateTo.setCellValueFactory(new PropertyValueFactory<>("dateTo"));






        cmbStudentIds.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setStudentData(newValue);
            }catch (IOException e){
                e.printStackTrace();
            }

        });
        cmbRoomTypeId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setRoomData(newValue);

        });

        


    }


    private void setRoomData(Object id) {
        ObservableList<RoomDTO> roomsData = roomBO.getRoomsData(id);

        for (RoomDTO r : roomsData) {
            txtType.setText(r.getType());
            txtQty.setText(String.valueOf(r.getQty()));
            txtKeyMoney.setText(String.valueOf(r.getKeyMoney()));
        }


    }

    private void setRoomTypeId() {
        ObservableList<String> allStudentIds=roomBO.getRoomTypeIds();
        cmbRoomTypeId.setItems(allStudentIds);

    }

    private void setStudentData(Object studentId)throws IOException {
        txtStudentName.setText(studentBO.getStudentName(studentId));
    }


    private void setStudentIds() {
        ObservableList<String> allStudentIds=studentBO.getStudentIds();
        cmbStudentIds.setItems(allStudentIds);

    }


    private void setReservationDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
        String text = date.format(formatters);
        txtDateFrom.setText(text);




    }

    private void setReservationId() {
        txtResId.setText(reservationBO.getNewId());

    }

    public void backBtnOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);
    }

    public void btnAddToCartOnAction(ActionEvent actionEvent) {
        add();
    }
    ObservableList<CartTm> tm= FXCollections.observableArrayList();
    private void add() {
        tm.add(new CartTm(
                txtResId.getText(),
                String.valueOf(cmbStudentIds.getValue()),
               String.valueOf(cmbRoomTypeId.getValue()) ,
                txtType.getText(),
                Double.parseDouble(txtKeyMoney.getText()),
                Double.parseDouble(txtPayingAmmount.getText()),
                txtDateFrom.getText(),
                String.valueOf(pickerDateTo.getValue())

        ));
        tblReserveRoom.setItems(tm);
        reservationid=txtResId.getText();

    }
    public boolean updateRoomQty(String id)throws IOException{
        return roomBO.updateRoomQty(id);

    }


    public void btnRegisterOnAction(ActionEvent actionEvent) throws IOException {
        Student student=new Student();
        student.setStudentId(String.valueOf(cmbStudentIds.getValue()));

        Room room=new Room();
        room.setRoomTypeId(String.valueOf(cmbRoomTypeId.getValue()));

        ReservationDTO dto= new ReservationDTO(
                reservationid,
                txtType.getText(),
                Double.parseDouble(txtKeyMoney.getText()),
                Double.parseDouble(txtPayingAmmount.getText()),
                txtDateFrom.getText(),
                String.valueOf(pickerDateTo.getValue()),
                student,
                room


        );
        if (reservationBO.registerNewReservation(dto)) {
            new Alert(Alert.AlertType.CONFIRMATION,"Reservation Successful").show();

            if (updateRoomQty(String.valueOf(cmbRoomTypeId.getValue()))){
                clear();
                setReservationId();
                tm.clear();
            }

        }

    }
    public void clear(){
        cmbStudentIds.getSelectionModel().clearSelection();
        txtStudentName.clear();
        cmbRoomTypeId.getSelectionModel().clearSelection();
        txtType.clear();
        txtQty.clear();
        txtKeyMoney.clear();
        txtPayingAmmount.clear();
        txtDateFrom.clear();
        pickerDateTo.setValue(null);

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        if (reservationBO.updatePayingAmount(Double.parseDouble(txtPayingAmmount.getText()),String.valueOf(cmbRoomTypeId.getValue()))) {
            new Alert(Alert.AlertType.CONFIRMATION,"Updated!!!").show();

        }
    }

    public void btnSearchBtnOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.SEARCHRESERVATION,pane);
    }
}
