package lk.blacky.hostel.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString


public class StudentDTO {
    private String studentId;
    private String name;
    private String address;
    private String contactNo;
    private String dob;
    private String gender;

    public StudentDTO(String name, String address, String contactNo, String dob, String gender) {
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.dob = dob;
        this.gender = gender;
    }
}
