package com.Inventory_order_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Inventory_order_service.model.Inventory;
import com.Inventory_order_service.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{
	


}
