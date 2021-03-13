package com.streetshawarma.thestreetshawarma.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.streetshawarma.thestreetshawarma.Entity.Orders;

@Repository
public interface OrderItemsRepo extends JpaRepository<Orders, Long>{
	
	

}
