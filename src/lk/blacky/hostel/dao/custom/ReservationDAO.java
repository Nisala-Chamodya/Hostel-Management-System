package lk.blacky.hostel.dao.custom;

import javafx.collections.ObservableList;
import lk.blacky.hostel.dao.CRUDDAO;
import lk.blacky.hostel.entity.Reservation;
import lk.blacky.hostel.entity.Student;

public interface ReservationDAO  extends CRUDDAO<Reservation,String> {
    public String generateNewId();
    public boolean updatePayingAmount(double amount,String id);

}
