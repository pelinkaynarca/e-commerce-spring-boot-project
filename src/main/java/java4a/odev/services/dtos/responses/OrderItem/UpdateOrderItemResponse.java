package java4a.odev.services.dtos.responses.OrderItem;

import java4a.odev.services.dtos.responses.Product.ListProductResponse;

import java.util.List;

public class UpdateOrderItemResponse {

    private int id;

    private int quantity;

    private double totalPrice;

    private int orderId;

    private ListProductResponse listProductResponse;

    private List<ListOrderItemResponse> orderItems;
}
