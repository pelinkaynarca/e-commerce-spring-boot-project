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
    @Min(value=0, message = "Kimlik numarası 0'dan küçük değer alamaz.")
    private int id;

    @Min(value=0, message = "Sepet Miktarı 0'dan küçük olamaz.")
    private int quantity;

    @Min(value=0, message = "cartId 0'dan küçük değer alamaz.")
    private int cartId;

    @Min(value=0, message = "productId 0'dan küçük değer alamaz.")
    private int productId;

    @Min(value=0, message = "Kullanıcı numarası 0'dan küçük değer alamaz.")
    private int userId;
}
