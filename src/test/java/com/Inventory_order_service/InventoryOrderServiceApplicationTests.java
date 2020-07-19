package com.Inventory_order_service;

import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Inventory_order_service.model.Inventory;
import com.Inventory_order_service.model.Order;


@SpringBootTest
class InventoryOrderServiceApplicationTests extends AbstractTest{

	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void getInventoryList() throws Exception {
	   String uri = "/inventory";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   Inventory[] Inventorylist = super.mapFromJson(content, Inventory[].class);
	   assertTrue(Inventorylist.length > 0);
	}
	
	
	
	@Test
	public void createInventory() throws Exception {
	   String uri = "/inventory";
	   Inventory inv = new Inventory();
	   inv.setId(3L);
	   inv.setName("Ginger");
	   
	   String inputJson = super.mapToJson(inv);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(201, status);
	}
	
	
	@Test
	public void updateInv() throws Exception {
	   String uri = "/inventory/2";
	   Inventory inv = new Inventory();
	   inv.setName("Lemon");
	   
	   String inputJson = super.mapToJson(inv);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	}
	
	
	@Test
	public void deleteInventory() throws Exception {
	   String uri = "/inventory/2";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(202, status);
	}
	
	@Test
	public void getOrderList() throws Exception {
	   String uri = "/order";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   Order[] Orderlist = super.mapFromJson(content, Order[].class);
	   assertTrue(Orderlist.length > 0);
	}
	
	@Test
	public void createOrder() throws Exception {
	   String uri = "/order";
	   Order order = new Order();
	   order.setId(3L);
	   order.setEmailid("Ginger");
	   
	   String inputJson = super.mapToJson(order);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(201, status);
	}
	
	@Test
	public void updateOrder() throws Exception {
	   String uri = "/order/2";
	   Order order = new Order();
	   order.setEmailid("Lemon");
	   
	   String inputJson = super.mapToJson(order);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	}
	
	@Test
	public void deleteOrder() throws Exception {
	   String uri = "/order/2";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(202, status);
	}

}
