package com.streetshawarma.thestreetshawarma.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "OrderItems")
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderItemId;
	private String orderItemQuantity;
	private String orderTotalPrice;
	
	@ManyToOne
	@JsonIgnore
	private Orders order;
	
    @ManyToOne
	private Products produs;

    public OrderItems() {
    	
    }
    
	
	public OrderItems(Long orderItemId, String orderItemQuantity, String orderTotalPrice, Orders order,
			Products prods) {
		super();
		this.orderItemId = orderItemId;
		this.orderItemQuantity = orderItemQuantity;
		this.orderTotalPrice = orderTotalPrice;
		this.order = order;
		this.produs = prods;
	}


	public Products getProds() {
		return produs;
	}

	public void setProds(Products prods) {
		this.produs = prods;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public String getOrderItemQuantity() {
		return orderItemQuantity;
	}

	public void setOrderItemQuantity(String orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
	}

	public String getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(String orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	
	
	
	
	
}
