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
    @Min(value=1, message = "Lütfen geçerli bir ID numarası girin.")
    private int id;

    @Min(value=1, message = "Kullanıcı Id'si 0'dan küçük değer alamaz.")
    private int userId;
}
