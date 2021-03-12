package com.streetshawarma.thestreetshawarma.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name =  "orders")
public class Orders {

	@Id
	private String orderId;
	private String orderPlacedDate;

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "order",cascade = CascadeType.ALL)
	private List<OrderItems> orderItems;

	private String orderTotalAmt;
	 
	
	public String getOrderTotalAmt() {
		return orderTotalAmt;
	}

	public void setOrderTotalAmt(String orderTotalAmt) {
		this.orderTotalAmt = orderTotalAmt;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderPlacedDate() {
		return orderPlacedDate;
	}

	public void setOrderPlacedDate(String orderPlacedDate) {
		this.orderPlacedDate = orderPlacedDate;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	
	
	
}
