package lk.blacky.hostel.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.blacky.hostel.bo.custom.UserBO;
import lk.blacky.hostel.dao.DAOFactory;
import lk.blacky.hostel.dao.custom.UserDAO;
import lk.blacky.hostel.dto.RoomDTO;
import lk.blacky.hostel.dto.StudentDTO;
import lk.blacky.hostel.dto.UserDTO;
import lk.blacky.hostel.entity.Room;
import lk.blacky.hostel.entity.User;

import java.io.IOException;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean saveUser(UserDTO dto) {
        return userDAO.save(new User(dto.getName(),dto.getEMail(),dto.getPassword()));
    }

    @Override
    public ObservableList<UserDTO> getAllUser() {
        ObservableList<User> all = userDAO.getAll();
        ObservableList<UserDTO> list = FXCollections.observableArrayList();

        for (User user : all) {
            list.add(new UserDTO(
                    user.getName(),
                    user.getEMail(),
                    user.getPassword()


            ));
        }


        return list;
    }


}
