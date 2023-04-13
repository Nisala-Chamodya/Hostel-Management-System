package lk.blacky.hostel.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString

@Entity
public class Reservation {
        @Id
     private String resId;
     private String date;
     private String studentId;
     private String roomTypeId;
     private String status;

     @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(referencedColumnName = "studentId")
     private Student student;

     @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(referencedColumnName = "roomTypeId")
     private Room room;

        }
