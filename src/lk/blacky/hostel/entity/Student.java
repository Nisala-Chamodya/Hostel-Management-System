package lk.blacky.hostel.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString

@Entity
public class Student {
    @Id
    private String studentId;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String address;
    private String contactNo;
    private String dob;
    private String gender;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Reservation> reservation;

    public Student(String studentId, String name, String address, String contactNo, String dob, String gender) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.dob = dob;
        this.gender = gender;

    }

    public Student(String name, String address, String contactNo, String dob, String gender) {
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.dob = dob;
        this.gender = gender;
    }

    public Student(String studentId) {
        this.studentId = studentId;
    }
}

