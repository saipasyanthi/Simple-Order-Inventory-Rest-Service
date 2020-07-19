package com.Inventory_order_service.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.Inventory_order_service.model.Inventory;

public interface InventoryRepository  extends JpaRepository<Inventory,Long>{

	Optional<Inventory> findByName(String name);
	
}
