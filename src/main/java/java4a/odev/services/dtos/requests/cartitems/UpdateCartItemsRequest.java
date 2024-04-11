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
public class UpdateCartItemsRequest {
    @Min(value=1, message = "Lütfen geçerli bir kullanıcı id'si girin.")
    private int userId;

    @Min(value=1, message = "Sepet Miktarı 0'dan küçük olamaz.")
    private int quantity;

    @Min(value=1, message = "productId 0'dan küçük değer alamaz.")
    private int productId;

}
