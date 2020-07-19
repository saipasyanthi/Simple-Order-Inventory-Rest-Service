package com.Inventory_order_service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.Inventory_order_service.exception.RecordNotFoundException;
import com.Inventory_order_service.model.Inventory;

public interface InventoryService {

	public List<Inventory> getAllInventories();

	public ResponseEntity<Inventory> createInventory(Inventory inventory);

	public Inventory getInventoryById(Long id) throws RecordNotFoundException;

	public Inventory updateInventory(Inventory inventory, Long id);

	public void deleteInventoryById(Long id) throws RecordNotFoundException;

	

}
