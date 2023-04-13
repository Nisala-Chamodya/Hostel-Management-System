package lk.blacky.hostel.util;


import lk.blacky.hostel.entity.Reservation;
import lk.blacky.hostel.entity.Room;
import lk.blacky.hostel.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public  class FactoryConfiguaration {

   private static FactoryConfiguaration factoryConfiguration;
   private final SessionFactory sessionFactory;

   private FactoryConfiguaration(){

       Properties properties = new Properties();
       Configuration configuration = new Configuration();
       configuration.setProperties(properties)
               .addAnnotatedClass(Student.class)
               .addAnnotatedClass(Room.class)
               .addAnnotatedClass(Reservation.class);


       sessionFactory= configuration.buildSessionFactory();
   }

   public static FactoryConfiguaration getInstance(){
       return factoryConfiguration==null? factoryConfiguration=new FactoryConfiguaration():factoryConfiguration;
   }

   public Session getSession() {
       return sessionFactory.openSession();
   }

}