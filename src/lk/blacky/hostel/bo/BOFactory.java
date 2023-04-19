package lk.blacky.hostel.bo;

import lk.blacky.hostel.bo.custom.impl.ReservationBOImpl;
import lk.blacky.hostel.bo.custom.impl.RoomBOImpl;
import lk.blacky.hostel.bo.custom.impl.StudentBOImpl;
import lk.blacky.hostel.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        if (boFactory==null){
            boFactory=new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes{
        STUDENT,ROOM,RESERVATION,USER
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case RESERVATION:
                return new ReservationBOImpl();
            case ROOM:
                return new RoomBOImpl();
            case STUDENT:
                return new StudentBOImpl();
            case USER:
                return new UserBOImpl();
            default:
                return null;
        }
    }
}
