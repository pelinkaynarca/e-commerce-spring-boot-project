package java4a.odev.services.dtos.responses.orderitems;

import java4a.odev.services.dtos.responses.products.ListProductResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddOrderItemResponse {

    private int id;

    private int quantity;

    private double totalPrice;

    private int orderId;

    private ListProductResponse listProductResponse;

    private List<ListOrderItemResponse> orderItems;
}
