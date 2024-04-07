package java4a.odev.services.dtos.responses.cartitems;

import java4a.odev.services.dtos.responses.products.ListProductResponse;
import java4a.odev.services.dtos.responses.users.ListUserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListCartItemResponse {

    private int id;

    private String name;

    private int quantity;

    private ListUserResponse listUserResponse;

    private ListProductResponse listProductResponse;
}


