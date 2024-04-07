package java4a.odev.controllers;

import jakarta.validation.Valid;
import java4a.odev.services.abstracts.OrderService;
import java4a.odev.services.dtos.requests.orders.AddOrderRequest;
import java4a.odev.services.dtos.requests.orders.UpdateOrderRequest;
import java4a.odev.services.dtos.responses.orders.AddOrderResponse;
import java4a.odev.services.dtos.responses.orders.ListOrderResponse;
import java4a.odev.services.dtos.responses.orders.UpdateOrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/orders")

public class OrdersController {
    private OrderService orderService;

    @GetMapping("/get-all")
    public List<ListOrderResponse> getAll(){
        return orderService.getAll();
    }
    @GetMapping("/{id}")
    public ListOrderResponse getById(@PathVariable int id){
        return orderService.getById(id);
    }

    @PostMapping("/create-order")
    @ResponseStatus(HttpStatus.CREATED)
    public AddOrderResponse add(@RequestBody @Valid AddOrderRequest request) {
        return orderService.add(request);
    }

    @PutMapping("/update-order")
    public UpdateOrderResponse update(@RequestBody @Valid UpdateOrderRequest request) {
        return orderService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        orderService.delete(id);
    }
}
