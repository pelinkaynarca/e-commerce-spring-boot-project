package java4a.odev.controllers;

import jakarta.validation.Valid;

import java4a.odev.services.dtos.requests.cartitems.AddCartItemsRequest;
import java4a.odev.services.dtos.requests.cartitems.UpdateCartItemsRequest;
import java4a.odev.services.dtos.responses.cartitems.AddCartItemResponse;
import java4a.odev.services.dtos.responses.cartitems.ListCartItemResponse;
import java4a.odev.services.dtos.responses.cartitems.UpdateCartItemResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartItems")
public class CartItemsController {

    private CartItemsController cartItemService;

    @GetMapping("/getAll")
    public List<ListCartItemResponse> getAll(){
        return cartItemService.getAll();
    }

    @GetMapping("/{id}")
    public ListCartItemResponse getById(@PathVariable int id){
        return cartItemService.getById(id);
    }

    @PostMapping("/createCartItem")
    @ResponseStatus(HttpStatus.CREATED)
    public AddCartItemResponse add(@RequestBody @Valid AddCartItemsRequest request) {
        return cartItemService.add(request);
    }

    @PutMapping("/updateCartItem")
    public UpdateCartItemResponse update(@RequestBody @Valid UpdateCartItemsRequest request) {
        return cartItemService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        cartItemService.delete(id);
    }
}
