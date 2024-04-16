package java4a.odev.services.dtos.requests.orders;

import jakarta.validation.constraints.Min;

import java4a.odev.services.dtos.requests.cartitems.ListCartItemRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {
    @Min(value=1, message = "Geçerli bir kullanıcı ID'si belirtilmelidir.")
    private int userId;

    private List<ListCartItemRequest> cartItems;
}
