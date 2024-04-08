package java4a.odev.services.abstracts;

import java4a.odev.services.dtos.requests.orderitems.AddOrderItemRequest;
import java4a.odev.services.dtos.responses.orderitems.AddOrderItemResponse;
import java4a.odev.services.dtos.responses.orderitems.ListOrderItemResponse;

import java.util.List;

public interface OrderItemService {
    List<ListOrderItemResponse> getAll();
    ListOrderItemResponse getById(int id);
    AddOrderItemResponse add(AddOrderItemRequest request);
    void delete(int id);
}
