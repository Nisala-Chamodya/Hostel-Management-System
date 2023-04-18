package lk.blacky.hostel.dao.custom;

import javafx.collections.ObservableList;
import lk.blacky.hostel.dao.CRUDDAO;
import lk.blacky.hostel.dao.SuperDAO;
import lk.blacky.hostel.entity.Room;

public interface RoomDAO extends CRUDDAO<Room,String> {
    ObservableList<String> roomTypeIdList();
    ObservableList<Room> getRoomData(Object id);
    boolean updateRoomQty(String id);
}
