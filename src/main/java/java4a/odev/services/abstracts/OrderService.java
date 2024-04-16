package java4a.odev.services.abstracts;

import java4a.odev.services.dtos.requests.orders.AddOrderRequest;
import java4a.odev.services.dtos.responses.orders.AddOrderResponse;
import java4a.odev.services.dtos.responses.orders.ListOrderResponse;

import java.util.List;

public interface OrderService {
    List<ListOrderResponse> getAll();
    ListOrderResponse getById(int id);
    AddOrderResponse add(AddOrderRequest request);
    void delete(int id);
}
