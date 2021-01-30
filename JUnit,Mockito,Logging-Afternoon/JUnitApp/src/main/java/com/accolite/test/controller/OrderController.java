package com.accolite.test.controller;

import com.accolite.test.entity.Item;
import com.accolite.test.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.accolite.test.service.OrderService;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/create")
	public int createNewOrder(@RequestBody Order order) {

		int response = orderService.createNewOrder(order);
		return response;

	}

	@GetMapping("/get/{orderId}")
	public ResponseEntity<ArrayList<Order>> getOrderById(@PathVariable("orderId") int orderId) {

		Order response = orderService.getOrderById(orderId);
		if (response == null) {
			return ResponseEntity.notFound().build();
		}
		ArrayList<Order> res = new ArrayList<>();
		res.add(response);
		return ResponseEntity.ok(res);
	}

	@PostMapping("/item/add/{orderId}")
	public ResponseEntity<String> addItem(@RequestBody Item item,
										  @PathVariable("orderId") int orderId) {

		String response = orderService.addItem(orderId, item);
		return ResponseEntity.ok(response);

	}

	@GetMapping("/item/get/{orderId}/{itemId}")
	public ResponseEntity<Object> getItem(@PathVariable("orderId") int orderId,
										  @PathVariable("itemId") int itemId) {
		Item response = orderService.getItemById(orderId,itemId);
		if (response == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/item/delete/{orderId}/{itemId}")
	public int deleteItem(@PathVariable("orderId") int orderId,
										  @PathVariable("itemId") int itemId) {
		String response = orderService.deleteItem(orderId,itemId);
		return itemId;
	}

	@PutMapping("/item/update/{orderId}/{itemId}")
	public ResponseEntity<String> updateItem(@PathVariable("orderId") int orderId,
											 @PathVariable("itemId") int itemId,
											 @RequestBody Item item){
		String response = orderService.updateItem(orderId,itemId,item);
		return ResponseEntity.ok(response);
	}
}