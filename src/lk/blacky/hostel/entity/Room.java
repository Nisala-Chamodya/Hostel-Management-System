package lk.blacky.hostel.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString

@Entity
public class Room {
    @Id
    private String roomTypeId;
    private String type;
    private String keyMoney;
    private int qty;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private List<Reservation> roomDetail;
}
