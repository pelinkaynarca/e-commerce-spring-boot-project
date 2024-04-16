package java4a.odev.services.abstracts;

import java4a.odev.services.dtos.requests.cartitems.AddCartItemRequest;
import java4a.odev.services.dtos.requests.cartitems.UpdateCartItemRequest;
import java4a.odev.services.dtos.responses.cartitems.AddCartItemResponse;
import java4a.odev.services.dtos.responses.cartitems.ListCartItemResponse;
import java4a.odev.services.dtos.responses.cartitems.UpdateCartItemResponse;

import java.util.List;

public interface CartItemService {
    List<ListCartItemResponse> getAll();
    ListCartItemResponse getById(int id);
    AddCartItemResponse add(AddCartItemRequest request);
    UpdateCartItemResponse update(UpdateCartItemRequest request);
    void delete(int id);
}
