package lk.blacky.hostel.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.blacky.hostel.dao.custom.RoomDAO;
import lk.blacky.hostel.entity.Room;
import lk.blacky.hostel.entity.Student;
import lk.blacky.hostel.util.FactoryConfiguaration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RoomDAOImpl implements RoomDAO{
    @Override
    public boolean save(Room room) {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(room);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room room) {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(room);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room room=session.get(Room.class,id);
        session.delete(room);



        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public ObservableList<Room> getAllById(String id) {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();





        System.out.println(id);
        String hql=" FROM Room R WHERE R.roomTypeId = '"+id+"' ";
        Query query = session.createQuery(hql);
        //  query.setParameter("id",id);

        List<Room> list = session.createQuery(hql).list();
        ObservableList<Room> obList = FXCollections.observableArrayList();

        for (Room room : list) {
            obList.add(new Room(


                    room.getType(),
                    room.getKeyMoney(),
                    room.getQty()

            ));

        }

        transaction.commit();
        session.close();

        return obList;
    }

    @Override
    public ObservableList<Room> getAll() {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="FROM Room";
        List<Room> list = session.createQuery(hql).list();

        ObservableList<Room> obList = FXCollections.observableArrayList();

        for (Room room: list) {
            obList.add(new Room(
                    room.getRoomTypeId(),
                    room.getType(),
                    room.getKeyMoney(),
                    room.getQty()


            ));

        }

        transaction.commit();
        session.close();

        return obList;
    }


    @Override
    public ObservableList<String> roomTypeIdList() {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        ObservableList<String> idList =FXCollections.observableArrayList();

        String hql="SELECT roomTypeId FROM Room ";
        List<String> list = session.createQuery(hql).list();

        for (String id : list) {
            idList.add(id);
        }

        transaction.commit();
        session.close();
        return idList;
    }

    @Override
    public ObservableList<Room> getRoomData(Object id) {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="FROM Room WHERE roomTypeId=:typeId";
        Query query = session.createQuery(hql);
        query.setParameter("typeId",id);
        List<Room> list = query.list();

        ObservableList<Room> roomsDataList =FXCollections.observableArrayList();

        for (Room room : list) {
            roomsDataList.add(new Room(room.getRoomTypeId(),room.getType(),room.getKeyMoney(),room.getQty()));
        }

        transaction.commit();
        session.close();

        return roomsDataList;

    }

    @Override
    public boolean updateRoomQty(String id) {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="UPDATE Room SET qty=qty-1 WHERE roomTypeId=:type_id";
        Query query = session.createQuery(hql);
        query.setParameter("type_id",id);
        query.executeUpdate();

        transaction.commit();
        session.close();

        return true;
    }
}
