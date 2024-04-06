package java4a.odev.services.dtos.requests.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String phone;
    private String password;
}
