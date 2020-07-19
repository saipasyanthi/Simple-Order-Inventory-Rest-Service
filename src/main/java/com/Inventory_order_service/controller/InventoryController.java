package com.Inventory_order_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory_order_service.exception.RecordNotFoundException;
import com.Inventory_order_service.model.Inventory;
import com.Inventory_order_service.service.InventoryService;

@RestController
public class InventoryController {
	
	@Autowired
    private InventoryService inventoryService;

     	@GetMapping("/inventories") 
	    public ResponseEntity<List<Inventory>> getAllInventories() {
	        List<Inventory> list = inventoryService.getAllInventories();
	 
	        return new ResponseEntity<List<Inventory>>(list, new HttpHeaders(), HttpStatus.OK);
	    }	    
	     
	    @PostMapping("/inventories")
	    public  ResponseEntity<Inventory> createTrade(@RequestBody Inventory inventory)
	                                                    throws RecordNotFoundException {
	            
		 ResponseEntity<Inventory> Trade= inventoryService.createInventory(inventory);
	    	return Trade;  	    	
	  	    }	    
	 
	    @GetMapping("/inventories/{id}")
	    public ResponseEntity<Inventory> getInventoryById(@PathVariable("id") Long id) 
	                                                    throws RecordNotFoundException {
	    	Inventory entity = inventoryService.getInventoryById(id);
	 
	        return new ResponseEntity<Inventory>(entity, new HttpHeaders(), HttpStatus.OK);
	    }
	     
	    @PutMapping("/inventories/{id}") 
		  public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory, @PathVariable("id") Long id) 
                                                     throws RecordNotFoundException
		  {		  
	    	Inventory updated =inventoryService.updateInventory(inventory,id);			 
			   return new ResponseEntity<Inventory>(updated, new HttpHeaders(), HttpStatus.OK);
		  }
	 
	    @DeleteMapping("/inventories/{id}")
	    public HttpStatus deleteInventoryById(@PathVariable("id") Long id) 
	                                                    throws RecordNotFoundException {
	    	inventoryService.deleteInventoryById(id);
	        return HttpStatus.ACCEPTED;
	    }
}
