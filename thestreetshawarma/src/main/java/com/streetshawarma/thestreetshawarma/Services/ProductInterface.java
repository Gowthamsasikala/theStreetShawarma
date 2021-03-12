package com.streetshawarma.thestreetshawarma.Services;

import java.util.List;

import com.streetshawarma.thestreetshawarma.Entity.Products;

public interface ProductInterface {

	Products addProducts(Products prod);
	List<Products> getProducts();
	Products updateProducts(Products prod);
	
}

