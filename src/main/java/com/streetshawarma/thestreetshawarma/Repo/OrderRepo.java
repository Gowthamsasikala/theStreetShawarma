package com.streetshawarma.thestreetshawarma.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.streetshawarma.thestreetshawarma.Entity.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, String>{

	List<Orders> findByOrderPlacedDateContaining(String date);
	
	@Query("select o from Orders o where o.orderPlacedDate like %:month%")
	List<Orders> findByOrderPlacedDateByMonth(String month);
	
}
