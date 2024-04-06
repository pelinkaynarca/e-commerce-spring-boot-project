package java4a.odev.services.dtos.responses.CartItem;

import java4a.odev.services.dtos.responses.Product.ListProductResponse;
import java4a.odev.services.dtos.responses.User.ListUserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UpdateCartItemResponse {

    private int id;

    private String name;

    private int quantity;

    private ListUserResponse listUserResponse;

    private ListProductResponse listProductResponse;
}
