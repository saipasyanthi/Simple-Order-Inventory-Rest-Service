package com.Inventory_order_service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.Inventory_order_service.exception.RecordNotFoundException;
import com.Inventory_order_service.model.Order;

public interface OrderService {

	public ResponseEntity<Order> createOrder(Order order);

	public List<Order> getAllOrder();

	public Order getOrderById(Long id) throws RecordNotFoundException;

	public Order updateOrder(Order order, Long id) throws RecordNotFoundException;

	public void deleteOrderById(Long id) throws RecordNotFoundException;;

}
