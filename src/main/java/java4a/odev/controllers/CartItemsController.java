package java4a.odev.controllers;

import jakarta.validation.Valid;

import java4a.odev.services.abstracts.CartItemService;
import java4a.odev.services.dtos.requests.cartitems.AddCartItemsRequest;
import java4a.odev.services.dtos.requests.cartitems.UpdateCartItemsRequest;
import java4a.odev.services.dtos.responses.cartitems.AddCartItemResponse;
import java4a.odev.services.dtos.responses.cartitems.ListCartItemResponse;
import java4a.odev.services.dtos.responses.cartitems.UpdateCartItemResponse;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart-items")
@AllArgsConstructor
public class CartItemsController {
    private CartItemService cartItemService;

    @GetMapping("/get-all")
    public List<ListCartItemResponse> getAll(){
        return cartItemService.getAll();
    }

    @GetMapping("/{id}")
    public ListCartItemResponse getById(@PathVariable int id){
        return cartItemService.getById(id);
    }

    @PostMapping("/create-cart-item")
    @ResponseStatus(HttpStatus.CREATED)
    public AddCartItemResponse add(@RequestBody @Valid AddCartItemsRequest request) {
        return cartItemService.add(request);
    }

    @PutMapping("/update-cart-item")
    public UpdateCartItemResponse update(@RequestBody @Valid UpdateCartItemsRequest request) {
        return cartItemService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        cartItemService.delete(id);
    }
}
