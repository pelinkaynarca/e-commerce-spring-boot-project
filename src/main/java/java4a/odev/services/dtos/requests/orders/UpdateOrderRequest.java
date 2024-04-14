package java4a.odev.services.dtos.requests.orders;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {
    @Min(value = 1, message = "Geçerli bir ID numarası girilmelidir.")
    private int id;

    @Min(value=1, message = "Geçerli bir kullanıcı ID'si belirtilmelidir.")
    private int userId;
}
