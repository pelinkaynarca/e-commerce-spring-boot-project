package java4a.odev.services.dtos.requests.roles;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoleRequest {
    @Min(value=1, message = "Lütfen geçerli bir ID numarası girin.")
    private int id;

    @Size(min=2, max=10, message = "Ürün adı 2 ile 10 karakter arasında olmalıdır.")
    private String name;

}
