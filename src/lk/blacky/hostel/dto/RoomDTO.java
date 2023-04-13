package lk.blacky.hostel.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class RoomDTO {
    private String roomTypeId;
    private String type;
    private String keyMoney;
    private int qty;
}
