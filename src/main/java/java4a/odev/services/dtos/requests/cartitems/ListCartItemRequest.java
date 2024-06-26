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
public class ListCartItemRequest {

    @Min(value = 1, message = "Geçerli bir ürün ID'si belirtilmelidir.")
    private int productId;
}
