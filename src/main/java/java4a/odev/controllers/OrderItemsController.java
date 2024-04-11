package java4a.odev.controllers;

import java4a.odev.services.abstracts.OrderItemService;
import java4a.odev.services.dtos.responses.orderitems.ListOrderItemResponse;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
@AllArgsConstructor
public class OrderItemsController {

	private OrderItemService orderItemService;

	@GetMapping("/get-all")
	public List<ListOrderItemResponse> getAll() {
		return orderItemService.getAll();
	}

	@GetMapping("/{id}")
	public ListOrderItemResponse getById(@PathVariable int id) {
		return orderItemService.getById(id);
	}

//	@PostMapping("/create-order-item")
//	@ResponseStatus(HttpStatus.CREATED)
//	public AddOrderItemResponse add(@RequestBody @Valid AddOrderItemRequest request) {
//		return orderItemService.add(request);
//	}

//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable int id) {
//		orderItemService.delete(id);
//	}
}
