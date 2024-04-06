package java4a.odev.services.dtos.requests.OrderItems;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderItemRequest {
    @Min(value=0, message = "Kimlik numarası 0'dan küçük değer alamaz.")
    private int id;

    @Min(value=0, message = "Sipariş miktarı 0'dan küçük değer alamaz.")
    private int quantity;

    @Min(value=0, message = "Toplam fiyat 0'dan küçük değer alamaz.")
    private double totalPrice;

    @Min(value=0, message = "Sipariş numarası 0'dan küçük değer alamaz.")
    private int orderId;

    @Min(value=0, message = "Ürün numarası 0'dan küçük değer alamaz.")
    private int productId;
}
