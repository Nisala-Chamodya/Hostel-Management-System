package lk.blacky.hostel.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.blacky.hostel.dao.custom.UserDAO;
import lk.blacky.hostel.entity.Room;
import lk.blacky.hostel.entity.User;
import lk.blacky.hostel.util.FactoryConfiguaration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User user) {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public ObservableList<User> getAll() {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="FROM User ";
        List<User> list = session.createQuery(hql).list();

        ObservableList<User> obList = FXCollections.observableArrayList();

        for (User user: list) {
            obList.add(new User(
                    user.getName(),
                    user.getEMail(),
                    user.getPassword()



            ));

        }

        transaction.commit();
        session.close();

        return obList;
    }
}



