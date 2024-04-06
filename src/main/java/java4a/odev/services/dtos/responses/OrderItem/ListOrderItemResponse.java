package java4a.odev.services.dtos.responses.OrderItem;

import java4a.odev.services.dtos.responses.Product.ListProductResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ListOrderItemResponse {

    private int id;

    private int quantity;

    private double totalPrice;

    private int orderId;

    private ListProductResponse listProductResponse;

    private List<ListOrderItemResponse> orderItems;
}
