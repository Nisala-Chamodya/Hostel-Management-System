package lk.blacky.hostel.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.blacky.hostel.dao.custom.RoomDAO;
import lk.blacky.hostel.entity.Room;

public class RoomDAOImpl implements RoomDAO{
    @Override
    public boolean save(Room room) {
        return false;
    }

    @Override
    public boolean update(Room room) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public ObservableList<Room> getAllById(String s) {
        return null;
    }

    @Override
    public ObservableList<Room> getAll() {
        return null;
    }


}
