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
import com.Inventory_order_service.model.Order;
import com.Inventory_order_service.service.OrderService;

@RestController
public class OrdersController {
	
	@Autowired
    private OrderService orderService;
	
	  @PostMapping("/orders")
	    public  ResponseEntity<Order> createOrder(@RequestBody Order order)
	                                                    throws RecordNotFoundException {
	            
		 ResponseEntity<Order> orderCreated= orderService.createOrder(order);
	    	return orderCreated;  	    	
	  	    }	   
	  
	  @GetMapping("/orders") 
	       public ResponseEntity<List<Order>> getAllOrder() {
	   
		  List<Order> list = orderService.getAllOrder();
	 
		  if(list.size()>0) {
	    		return new ResponseEntity<List<Order>>(list, new HttpHeaders(), HttpStatus.OK);}
	    	else {
	    		return new ResponseEntity<List<Order>>(new HttpHeaders(), HttpStatus.NOT_FOUND);
	    		}
	    }
	  
	  @GetMapping("/orders/{id}")
	    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) 
	                                                    throws RecordNotFoundException {
		 
		  Order order= orderService.getOrderById(id);
		  
		  return new ResponseEntity<Order>(order, new HttpHeaders(), HttpStatus.OK);
	 
	    }
	  
	  @PutMapping("/orders/{id}") 
	  public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable("id") Long id) 
                                                 throws RecordNotFoundException
	  {		  
		  Order updated =orderService.updateOrder(order,id);			  
		 
		   return new ResponseEntity<Order>(updated, new HttpHeaders(), HttpStatus.OK);
	  
		  }
	  
	  @DeleteMapping("/orders/{id}")
	    public HttpStatus deleteOrderById(@PathVariable("id") Long id) 
	                                                    throws RecordNotFoundException {
		  orderService.deleteOrderById(id);
	        return HttpStatus.ACCEPTED;
	    }
	     
	 

}
