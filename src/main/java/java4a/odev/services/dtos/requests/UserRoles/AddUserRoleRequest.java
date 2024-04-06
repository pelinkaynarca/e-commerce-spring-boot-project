package java4a.odev.services.dtos.requests.UserRoles;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRoleRequest {

    @Min(value=0, message = "Kullanıcı numarası 0'dan küçük değer alamaz.")
    private int userId;

    @Min(value=0, message = "Role numarası 0'dan küçük değer alamaz.")
    private int roleId;
}
