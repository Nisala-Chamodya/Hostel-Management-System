package lk.blacky.hostel.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.blacky.hostel.dao.custom.ReservationDAO;
import lk.blacky.hostel.entity.Reservation;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public boolean save(Reservation reservation) {
        return false;
    }

    @Override
    public boolean update(Reservation reservation) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public ObservableList<Reservation> getAllById(String s) {
        return null;
    }

    @Override
    public ObservableList<Reservation> getAll() {
        return null;
    }


}
