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
    @Min(value = 1, message = "Ürün miktarı 1'den küçük olamaz.")
    private int quantity;

    @Min(value = 1, message = "Geçerli bir sipariş ID'si belirtilmelidir.")
    private int orderId;

    @Min(value = 1, message = "Geçerli bir ürün ID'si belirtilmelidir.")
    private int productId;
}
