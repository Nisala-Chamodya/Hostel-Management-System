package lk.blacky.hostel.dao;

import lk.blacky.hostel.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        if (daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        STUDENT,ROOM,RESERVATION,QUERY,USER
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case ROOM:
                return new RoomDAOImpl();
            case STUDENT:
                return new StudentDAOImpl();
            case RESERVATION:
                return new ReservationDAOImpl();
            case QUERY:
                return  new QueryDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return  null;
        }
    }

}
