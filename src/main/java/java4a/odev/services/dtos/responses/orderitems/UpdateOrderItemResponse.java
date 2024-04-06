package java4a.odev.services.dtos.responses.orderitems;

import java4a.odev.services.dtos.responses.products.ListProductResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderItemResponse {

    private int id;

    private int quantity;

    private double totalPrice;

    private int orderId;

    private ListProductResponse listProductResponse;
}
