package lk.blacky.hostel.bo.custom;

import javafx.collections.ObservableList;
import lk.blacky.hostel.bo.SuperBO;
import lk.blacky.hostel.dto.RoomDTO;
import lk.blacky.hostel.dto.StudentDTO;

public interface RoomBO extends SuperBO {
    boolean saveRoom(RoomDTO dto);
    boolean updateRoom(RoomDTO dto);
    boolean deleteRoom(String id);
    ObservableList<RoomDTO> getAllRoomById(String id);
    ObservableList<RoomDTO> getAllStudent();
    ObservableList<String> getRoomTypeIds();
    ObservableList<RoomDTO> getRoomsData(Object id);
    boolean updateRoomQty(String id);
}
