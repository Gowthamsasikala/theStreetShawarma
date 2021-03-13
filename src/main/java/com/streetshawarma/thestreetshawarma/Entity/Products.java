package com.streetshawarma.thestreetshawarma.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	private String productName;
	private long productPrice;
	
	@OneToMany(mappedBy = "prods")
	@JsonIgnore
	private List<OrderItems> orderItems;
	
	public Products() {
		
	}
	
	public Products(Long productId, String productName, long productPrice, List<OrderItems> orderItems) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.orderItems = orderItems;
	}

	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
