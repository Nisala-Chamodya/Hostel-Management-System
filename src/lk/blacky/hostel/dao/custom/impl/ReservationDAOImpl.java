package lk.blacky.hostel.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.blacky.hostel.dao.custom.ReservationDAO;
import lk.blacky.hostel.entity.Reservation;
import lk.blacky.hostel.entity.Student;
import lk.blacky.hostel.util.FactoryConfiguaration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public boolean save(Reservation entity) {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();

        return true;
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


    @Override
    public String generateNewId() {
        String newId="R-001";
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String sql="SELECT resId FROM Reservation ORDER BY resId DESC LIMIT 1";
        List<String> list = session.createSQLQuery(sql).list();

        for (String id : list) {
            if (id!=null){
                int num = Integer.valueOf(id.substring(1));
                num++;

                if (num<=9){
                    newId="R00"+num;
                }else if (num>9&&num<100){
                    newId="R0"+num;
                }else if (num>=100){
                    newId="R"+num;
                }
            }
        }

        transaction.commit();
        session.close();

        return newId;

    }

    @Override
    public boolean updatePayingAmount(double amount, String id) {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="UPDATE Reservation SET payingAmount=:amount1 WHERE resId=:rId";
        Query query = session.createQuery(hql);
        query.setParameter("amount1",amount);
        query.setParameter("rId",id);
        query.executeUpdate();

        transaction.commit();
        session.close();

        return true;
    }


}
