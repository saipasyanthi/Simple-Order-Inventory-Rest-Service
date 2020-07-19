package com.Inventory_order_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Inventory_order_service.model.Inventory;
import com.Inventory_order_service.repository.InventoryRepository;
import com.Inventory_order_service.exception.RecordNotFoundException;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
    private InventoryRepository inventoryRepo;
	
	@Override
	public List<Inventory> getAllInventories() {

		  List<Inventory> inventoryList = inventoryRepo.findAll();
	         
	        if(inventoryList.size() > 0) {
	            return inventoryList;
	        } else {
	            return new ArrayList<Inventory>();
	        }
	}

	@Override
	public ResponseEntity<Inventory> createInventory(Inventory inventory) {
		
		
        	inventoryRepo.save(inventory);
        	 return new ResponseEntity<Inventory>(inventoryRepo.save(inventory), new HttpHeaders(), HttpStatus.CREATED);
        
	}

	@Override
	public Inventory getInventoryById(Long id) throws RecordNotFoundException  {
		
		 Optional<Inventory> inventory = inventoryRepo.findById(id);
         
	        if(inventory.isPresent()) {
	            return inventory.get();
	        } else {
	            throw new RecordNotFoundException("No user record exist for given id");
	        }
	}

	@Override
	public Inventory updateInventory(Inventory inventory,Long id) {

		Optional<Inventory> inventorys = inventoryRepo.findById(id);
        
        if(inventorys.isPresent()) {
            
        	Inventory update = inventorys.get();
        	
        	   update.setName(inventory.getName());
        	   update.setPrice(inventory.getPrice());
        	   update.setQuantityAvailable(inventory.getQuantityAvailable());
        	   update.setDescription(inventory.getDescription());
	        
        	   update = inventoryRepo.save(update);
	             
	            return update;
        	
        	
        	
        } else {
        	inventory = inventoryRepo.save(inventory);
            
            return inventory;
        }
		
		
		
	}

	
	@Override
	public void deleteInventoryById(Long id) throws RecordNotFoundException {
		
		 Optional<Inventory> inventory = inventoryRepo.findById(id);
         
	        if(inventory.isPresent()) 
	        {
	        	inventoryRepo.deleteById(id);
	        } else {
	            throw new RecordNotFoundException("No user record exist for given id");
	        }
		
	}

}
