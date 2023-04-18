package lk.blacky.hostel.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.blacky.hostel.dao.custom.StudentDAO;
import lk.blacky.hostel.entity.Student;
import lk.blacky.hostel.util.FactoryConfiguaration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {


    @Override
    public boolean save(Student student) {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student student) {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student=session.get(Student.class,id);
        session.delete(student);



        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public ObservableList<Student> getAllById(String id) {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();





        System.out.println(id);
        String hql=" FROM Student S WHERE S.studentId = '"+id+"'";
        Query  query = session.createQuery(hql);
        //query.setParameter("sid",id);

        List<Student> list = session.createQuery(hql).list();
        ObservableList<Student> obList = FXCollections.observableArrayList();

        for (Student s : list) {
            obList.add(new Student(

                    s.getName(),
                    s.getAddress(),
                    s.getDob(),
                    s.getGender(),
                    s.getContactNo()
            ));

        }

        transaction.commit();
        session.close();

        return obList;
    }

    @Override
    public ObservableList<Student> getAll() {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="FROM Student";
        List<Student> list = session.createQuery(hql).list();

        ObservableList<Student> obList = FXCollections.observableArrayList();

        for (Student s : list) {
            obList.add(new Student(
                    s.getStudentId(),
                    s.getName(),
                    s.getAddress(),
                    s.getContactNo(),
                    s.getDob(),
                    s.getGender()

            ));

        }

        transaction.commit();
        session.close();

        return obList;
    }


    @Override
    public ObservableList<String> studentIdList() {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        ObservableList<String> idList =FXCollections.observableArrayList();

        String hql="SELECT studentId FROM Student";
        List<String> list = session.createQuery(hql).list();

        for (String id : list) {
            idList.add(id);
        }

        transaction.commit();
        session.close();
        return idList;
    }

    @Override
    public String getName(Object id) {
        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="SELECT name FROM Student WHERE studentId=:id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        List<String> list = query.list();

        String name="";

        for (String s : list) {
            name=s;
        }

        transaction.commit();
        session.close();


        return name;
    }
    }



