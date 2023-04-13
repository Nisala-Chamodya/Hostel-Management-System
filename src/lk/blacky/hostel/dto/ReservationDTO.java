package lk.blacky.hostel.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString

public class ReservationDTO {
    private String resId;
    private String date;
    private String studentId;
    private String roomTypeId;
    private String status;
}
