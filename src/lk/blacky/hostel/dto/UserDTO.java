package lk.blacky.hostel.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class UserDTO {

    private String name;
    private String eMail;
    private String password;

    public UserDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
