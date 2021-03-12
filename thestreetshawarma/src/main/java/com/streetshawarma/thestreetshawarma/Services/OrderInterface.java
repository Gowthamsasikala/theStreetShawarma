package com.streetshawarma.thestreetshawarma.Services;

import java.util.List;


import com.streetshawarma.thestreetshawarma.Entity.Orders;

public interface OrderInterface {

	Orders placeOrder(Orders order);
	List<Orders> getOrdersByDate(String dates);
	List<Integer> getOrdersByDateMonths(String dates,String year);
	List<Integer> getAllOrdersByMonth();
	String deleteByIds(String orderId);
	
}
