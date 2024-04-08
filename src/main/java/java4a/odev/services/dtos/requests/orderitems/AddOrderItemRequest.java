package java4a.odev.services.dtos.requests.orderitems;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderItemRequest {
    @Min(value=1, message = "Ürün miktarı 0'dan küçük değer alamaz.")
    private int quantity;

    @Min(value=1, message = "Sipariş ID'si 0'dan küçük değer alamaz.")
    private int orderId;

    @Min(value=1, message = "Ürün ID'si 0'dan küçük değer alamaz.")
    private int productId;
}
