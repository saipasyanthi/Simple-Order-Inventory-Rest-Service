package com.Inventory_order_service.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.Inventory_order_service.util.CustomDateAndTimeDeserialize;


@Entity
@Table(name = "TBL_Order")
public class Order  {
	
	@Id
	@Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emailid;
    private String status;
    
    @JsonDeserialize(using=CustomDateAndTimeDeserialize.class)
 	@Temporal(value=TemporalType.TIMESTAMP) 
 	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
 	  private java.util.Date orderCreated;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="inventory_id")
    private Inventory inventory;
    
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public java.util.Date getOrderCreated() {
		return orderCreated;
	}

	public void setOrderCreated(java.util.Date orderCreated) {
		this.orderCreated = orderCreated;
	}
    
    
}
