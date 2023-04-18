package lk.blacky.hostel.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.blacky.hostel.bo.custom.ReservationBO;
import lk.blacky.hostel.dao.DAOFactory;
import lk.blacky.hostel.dao.custom.ReservationDAO;
import lk.blacky.hostel.dao.custom.StudentDAO;
import lk.blacky.hostel.dto.ReservationDTO;
import lk.blacky.hostel.dto.StudentDTO;
import lk.blacky.hostel.entity.Reservation;
import lk.blacky.hostel.entity.Student;

public class ReservationBOImpl implements ReservationBO {
    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESERVATION);
    StudentDAO studentDAO=(StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
    @Override
    public String getNewId() {
        return reservationDAO.generateNewId();
    }

    @Override
    public boolean registerNewReservation(ReservationDTO dto) {
        return reservationDAO.save(new Reservation(dto.getResId(),dto.getType(),dto.getKeyMoney(),dto.getPayingAmount(),dto.getDateFrom(),dto.getDateTo(),dto.getStudentId(),dto.getRoomId()));
    }

    @Override
    public boolean updatePayingAmount(double amount, String id) {
        return reservationDAO.updatePayingAmount(amount,id);
    }


}
