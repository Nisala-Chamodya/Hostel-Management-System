package lk.blacky.hostel.dto;

import lk.blacky.hostel.entity.Room;
import lk.blacky.hostel.entity.Student;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString

public class ReservationDTO {
    String resId;
    String type;
    Double keyMoney;
    Double payingAmount;
    String dateFrom;
    String dateTo;
    Student studentId;
    Room roomId;

    String sId;
    String rId;

    public ReservationDTO(String resId, String type, Double keyMoney, Double payingAmount, String dateFrom, String dateTo, Student studentId, Room roomId) {
        this.resId = resId;
        this.type = type;
        this.keyMoney = keyMoney;
        this.payingAmount = payingAmount;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.studentId = studentId;
        this.roomId = roomId;
    }
}
