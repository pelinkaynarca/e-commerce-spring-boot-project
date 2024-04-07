package java4a.odev.services.abstracts;

import java4a.odev.services.dtos.requests.cartitems.AddCartItemsRequest;
import java4a.odev.services.dtos.requests.cartitems.UpdateCartItemsRequest;
import java4a.odev.services.dtos.responses.cartitems.AddCartItemResponse;
import java4a.odev.services.dtos.responses.cartitems.ListCartItemResponse;
import java4a.odev.services.dtos.responses.cartitems.UpdateCartItemResponse;

import java.util.List;

public interface CartItemService {

    List<ListCartItemResponse> getAll();
    ListCartItemResponse getById(int id);
    AddCartItemResponse add(AddCartItemsRequest request);
    UpdateCartItemResponse update(UpdateCartItemsRequest request);
    void delete(int id);
}
