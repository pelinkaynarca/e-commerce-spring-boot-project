package java4a.odev.services.dtos.responses.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UpdateUserResponse {

    private int id;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String phone;


}