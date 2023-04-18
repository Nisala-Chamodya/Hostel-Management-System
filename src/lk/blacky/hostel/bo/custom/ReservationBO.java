package lk.blacky.hostel.bo.custom;

import javafx.collections.ObservableList;
import lk.blacky.hostel.bo.SuperBO;
import lk.blacky.hostel.dto.ReservationDTO;
import lk.blacky.hostel.dto.StudentDTO;

public interface ReservationBO extends SuperBO {
    String getNewId();
    boolean registerNewReservation(ReservationDTO dto);
    boolean updatePayingAmount(double amount,String id);


}
