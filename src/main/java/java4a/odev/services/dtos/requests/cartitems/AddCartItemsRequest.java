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
public class AddCartItemsRequest {
    @Min(value=1, message = "Sepet Miktarı 0'dan küçük olamaz.")
    private int quantity;

    @Min(value=1, message = "Sepet ID'si 0'dan küçük değer alamaz.")
    private int cartId;

    @Min(value=1, message = "Ürün ID'si 0'dan küçük değer alamaz.")
    private int productId;

    @Min(value=1, message = "Kullanıcı ID'si 0'dan küçük değer alamaz.")
    private int userId;
}
