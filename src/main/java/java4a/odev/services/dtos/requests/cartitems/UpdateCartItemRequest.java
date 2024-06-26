package java4a.odev.services.dtos.requests.cartitems;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCartItemRequest {
    @Min(value = 1, message = "Geçerli bir ID numarası girilmelidir.")
    private int id;

    @Min(value = 1, message = "Sepet miktarı 1'den küçük olamaz.")
    private int quantity;

    @Min(value = 1, message = "Geçerli bir ürün ID'si belirtilmelidir.")
    private int productId;

    @Min(value = 1, message = "Geçerli bir kullanıcı ID'si belirtilmelidir.")
    private int userId;

}
