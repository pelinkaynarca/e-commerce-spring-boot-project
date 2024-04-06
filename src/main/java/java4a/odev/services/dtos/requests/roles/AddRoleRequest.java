package java4a.odev.services.dtos.requests.roles;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRoleRequest {

    @Size(min=2, max=10, message = "Ürün adı 2 ile 10 karakter arasında olmalıdır.")
    private String name;

}
