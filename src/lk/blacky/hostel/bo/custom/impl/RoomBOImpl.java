package lk.blacky.hostel.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.blacky.hostel.bo.custom.RoomBO;
import lk.blacky.hostel.dao.DAOFactory;
import lk.blacky.hostel.dao.custom.RoomDAO;
import lk.blacky.hostel.dao.custom.StudentDAO;
import lk.blacky.hostel.dto.RoomDTO;
import lk.blacky.hostel.dto.StudentDTO;
import lk.blacky.hostel.entity.Room;
import lk.blacky.hostel.entity.Student;

public class RoomBOImpl implements RoomBO {
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public boolean saveRoom(RoomDTO dto) {
        return roomDAO.save(new Room(
                dto.getRoomTypeId(),
                dto.getType(),
                dto.getKeyMoney(),
                dto.getQty()




        ));
    }

    @Override
    public boolean updateRoom(RoomDTO dto) {
        return roomDAO.update(new Room(dto.getRoomTypeId(),dto.getType(),dto.getKeyMoney(),dto.getQty()));
    }

    @Override
    public boolean deleteRoom(String id) {
        return roomDAO.delete(id);
    }

    @Override
    public ObservableList<RoomDTO> getAllRoomById(String id) {
        ObservableList<Room> all = roomDAO.getAllById(id);
        ObservableList<RoomDTO> list = FXCollections.observableArrayList();

        for (Room room : all) {
            list.add(new RoomDTO(

                    room.getRoomTypeId(),
                    room.getType(),
                    room.getKeyMoney(),
                    room.getQty()


            ));
        }


        return list;
    }

    @Override
    public ObservableList<RoomDTO> getAllStudent() {
        ObservableList<Room> all = roomDAO.getAll();
        ObservableList<RoomDTO> list = FXCollections.observableArrayList();

        for (Room room : all) {
            list.add(new RoomDTO(
                    room.getRoomTypeId(),
                    room.getType(),
                    room.getKeyMoney(),
                    room.getQty()

            ));
        }


        return list;
    }

    @Override
    public ObservableList<String> getRoomTypeIds() {
        return roomDAO.roomTypeIdList();
    }

    @Override
    public ObservableList<RoomDTO> getRoomsData(Object id) {
        ObservableList<Room> roomData = roomDAO.getRoomData(id);

        ObservableList<RoomDTO> roomDataList=FXCollections.observableArrayList();

        for (Room r : roomData) {
            roomDataList.add(new RoomDTO(r.getRoomTypeId(),r.getType(),r.getKeyMoney(),r.getQty()));
        }
        return roomDataList;

    }

    @Override
    public boolean updateRoomQty(String id) {
        return roomDAO.updateRoomQty(id);
    }
}
