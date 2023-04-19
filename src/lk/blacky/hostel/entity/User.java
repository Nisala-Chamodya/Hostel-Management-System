package lk.blacky.hostel.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString

@Entity
public class User {
    @Id
    private String name;
    private String eMail;
    private String password;
}
