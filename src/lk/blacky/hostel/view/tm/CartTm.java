package lk.blacky.hostel.view.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString

public class CartTm {
    private String resId;
    private String studentId;
    private String roomTypeId;
    private String type;
    private Double keyMoney;
    private Double payingAmount;
    private String dateFrom;
    private String dateTo;



}
