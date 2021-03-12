package com.streetshawarma.thestreetshawarma.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streetshawarma.thestreetshawarma.Entity.Products;
import com.streetshawarma.thestreetshawarma.Repo.ProductRepo;

@Service
public class ProductImplementation implements ProductInterface{

	@Autowired
	ProductRepo pRepo;
	
	@Override
	public Products addProducts(Products prod) {
		if(prod!= null) {
			return pRepo.saveAndFlush(prod);
		}
		return null;
	}

	@Override
	public List<Products> getProducts() {
		List<Products> allProd = pRepo.findAll();
		return allProd;
	}

	@Override
	public Products updateProducts(Products prod) {
		
		Optional<Products> prods = pRepo.findById(prod.getProductId());
		if(!prods.isEmpty()) {
			prods.get().setProductName(prod.getProductName());
			prods.get().setProductPrice(prod.getProductPrice());	
		}
		return pRepo.saveAndFlush(prods.get());
	}

	
	
}
