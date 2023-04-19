package lk.blacky.hostel.bo.custom;

import javafx.collections.ObservableList;
import lk.blacky.hostel.bo.SuperBO;
import lk.blacky.hostel.dto.RoomDTO;
import lk.blacky.hostel.dto.UserDTO;

public interface UserBO extends SuperBO{
    boolean saveUser(UserDTO dto);
    ObservableList<UserDTO> getAllUser();
}
