package com.Inventory_order_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Inventory_order_service.exception.RecordNotFoundException;
import com.Inventory_order_service.model.Inventory;
import com.Inventory_order_service.model.Order;
import com.Inventory_order_service.repository.InventoryRepository;
import com.Inventory_order_service.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
    private OrderRepository orderRepo;
		
	@Autowired
    private InventoryRepository inventoryRepo;

	@Override
	public ResponseEntity<Order> createOrder(Order order) {
		
		 Optional<Inventory>  inventory_details = inventoryRepo.findByName(order.getInventory().getName());
   
        if(!inventory_details.isPresent()) {
        	 return new ResponseEntity<Order>(new HttpHeaders(), HttpStatus.BAD_REQUEST);
        } else {  
        	
        	Optional<Inventory> inventorys = inventory_details;
        	Inventory update = inventorys.get();   
        		
        	update.setQuantityAvailable(update.getQuantityAvailable()-1);          
        	 order.setInventory(update);
        	 
        	 Order entity = orderRepo.save(order);
        	 
        	 return new ResponseEntity<Order>(entity, new HttpHeaders(), HttpStatus.CREATED);
        }
	}

	@Override
	public List<Order> getAllOrder() {
		
		 List<Order> orderList = orderRepo.findAll();
         
	        if(orderList.size() > 0) {
	            return orderList;
	        } else {
	            return new ArrayList<Order>();
	        }
	}

	@Override
	public Order getOrderById(Long id) throws RecordNotFoundException {
		Optional<Order> order = orderRepo.findById(id);
        
        if(order.isPresent()) {
            return order.get();
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
	}

	@Override
	public Order updateOrder(Order order, Long id) throws RecordNotFoundException {
		
         Optional<Order> orders = orderRepo.findById(id);
        
           if(orders.isPresent()) {
            
            	Order orderupdate = orders.get();
        	
            	orderupdate.setEmailid(order.getEmailid());
            	
            	orderupdate.setOrderCreated(order.getOrderCreated());
            	
            	orderupdate.setStatus(order.getStatus());
        	   
        	   Optional<Inventory>  inventorydetailAdd = inventoryRepo.findById(order.getInventory().getId());
        	   
        	   Optional<Inventory>  inventorydetailSub = inventoryRepo.findById(orderupdate.getInventory().getId());   
        	   
               if(!inventorydetailAdd.isPresent()) {
            	   
            	   throw new RecordNotFoundException("No inventory added");
               
               } else {                 	
              
               	// subtracting the old inventory to orders
                Optional<Inventory> inventorysub = inventorydetailSub;
               	
               	Inventory updateInvsub = inventorysub.get();   
               	
               	updateInvsub.setQuantityAvailable(updateInvsub.getQuantityAvailable()+1);  
               	
               	order.setInventory(updateInvsub);
               	
               	
            	// adding the new inventory to orders
  	            Optional<Inventory> inventorys = inventorydetailAdd;
               	
               	Inventory updateInvadd = inventorys.get();   
               		
               	updateInvadd.setQuantityAvailable(updateInvadd.getQuantityAvailable()-1); 
               	
               	 order.setInventory(updateInvadd);               
               	 
               	 
               	 Order entity = orderRepo.save(order);
               	 
                 
 	            return entity;
         	
               }       	           	
        	
        	
        } else {
            	 throw new RecordNotFoundException("No user record exist for given id");
        }
		
		
	}

	@Override
	public void deleteOrderById(Long id) throws RecordNotFoundException {
		
		 Optional<Order> order = orderRepo.findById(id);
         
	        if(order.isPresent()) 
	        {
	        
	        	Order orderupdate = order.get();
	        	
	        	Optional<Inventory>  inventorydetailAdd = inventoryRepo.findById(orderupdate.getInventory().getId());
	        	
	        	// updating the old inventory in inventory table
	        	
                Optional<Inventory> inventoryAdd = inventorydetailAdd;
               	
               	Inventory updateInvAdd = inventoryAdd.get();   
               	
               	updateInvAdd.setQuantityAvailable(updateInvAdd.getQuantityAvailable()+1);  
               	
               	orderupdate.setInventory(updateInvAdd);	        	
	        	
	        	
	        	inventoryRepo.deleteById(id);
	        } else {
	            throw new RecordNotFoundException("No user record exist for given id");
	        }
		
	}
		
	}
	
	


