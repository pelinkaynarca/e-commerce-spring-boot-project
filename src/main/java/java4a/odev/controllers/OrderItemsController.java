package java4a.odev.controllers;

import jakarta.validation.Valid;
import java4a.odev.services.abstracts.OrderItemService;
import java4a.odev.services.dtos.requests.orderitems.AddOrderItemRequest;
import java4a.odev.services.dtos.requests.orderitems.UpdateOrderItemRequest;
import java4a.odev.services.dtos.responses.orderitems.AddOrderItemResponse;
import java4a.odev.services.dtos.responses.orderitems.ListOrderItemResponse;
import java4a.odev.services.dtos.responses.orderitems.UpdateOrderItemResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/orderItems")

public class OrderItemsController {
    private OrderItemService orderItemService;

    @GetMapping("/get-all")
    public List<ListOrderItemResponse> getAll(){
        return orderItemService.getAll();
    }

    @GetMapping("/{id}")
    public ListOrderItemResponse getById(@PathVariable int id){
        return orderItemService.getById(id);
    }

    @PostMapping("/create-order-item")
    @ResponseStatus(HttpStatus.CREATED)
    public AddOrderItemResponse add(@RequestBody @Valid AddOrderItemRequest request) {
        return orderItemService.add(request);
    }

    @PutMapping("/update-order-item")
    public UpdateOrderItemResponse update(@RequestBody @Valid UpdateOrderItemRequest request) {
        return orderItemService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        orderItemService.delete(id);
    }
}
