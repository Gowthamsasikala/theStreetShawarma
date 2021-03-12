package com.streetshawarma.thestreetshawarma.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.streetshawarma.thestreetshawarma.Entity.Products;
import com.streetshawarma.thestreetshawarma.Services.ProductImplementation;

@RestController
@RequestMapping(path = "/Product")
@CrossOrigin("*")
public class ProductsController {

	@Autowired
	ProductImplementation prodImpl;
	
	
	@PostMapping("/addProduct")
	public ResponseEntity<?> addProducts(@RequestBody() Products prod){
		Products prods = prodImpl.addProducts(prod);
		if(prods != null) {
			return new ResponseEntity<Products>(prods,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed adding the product",HttpStatus.BAD_GATEWAY);
	}
	
	@GetMapping("/getProducts")
	public ResponseEntity<List<Products>> getProducts(){
		List<Products> getAllProds = prodImpl.getProducts();
		return new ResponseEntity<List<Products>>(getAllProds,HttpStatus.OK);
	}
	
	 @PutMapping("/updateProducts")
	 public ResponseEntity<?> updateProducts(@RequestBody Products prod){
		 Products updatedProd = prodImpl.updateProducts(prod);
		 return new ResponseEntity<Products>(updatedProd,HttpStatus.OK);
	 }
	
	
}
