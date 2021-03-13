package com.streetshawarma.thestreetshawarma.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.streetshawarma.thestreetshawarma.Entity.Orders;
import com.streetshawarma.thestreetshawarma.Repo.OrderItemsRepo;
import com.streetshawarma.thestreetshawarma.Repo.OrderRepo;

@Service
public class OrderServiceImplementation implements OrderInterface {

	public int totalAmt = 0;
	public int days = 0;
	@Autowired
	OrderRepo orderRepo;

	@Autowired
	OrderItemsRepo orderItemRepo;
	
	@SuppressWarnings("deprecation")
	@Override
	public Orders placeOrder(Orders order) {
		String ordId = "ORD" + new Date().getDate() + new Date().getMonth() + (new Date().getYear())
				+ new Date().getHours() + new Date().getMinutes() + new Date().getSeconds();
		order.setOrderId(ordId);
		for (int i = 0; i < order.getOrderItems().size(); i++) {
			order.getOrderItems().get(i).setOrder(order);
			System.out.println(order.getOrderItems().get(i).getProds());
		}
		System.out.println(ordId);
		Orders ord = orderRepo.saveAndFlush(order);
		return ord;
	}

	@Override
	public List<Orders> getOrdersByDate(String dates) {
		List<Orders> lstOfOrders = orderRepo.findByOrderPlacedDateContaining(dates);
		return lstOfOrders;
	}

	public List<Orders> getOrdersByMonth(String months) {
		List<Orders> listOfOrders = orderRepo.findByOrderPlacedDateByMonth(months);
		return listOfOrders;
	}

	@Override
	public List<Integer> getAllOrdersByMonth() {

		List<Orders> lists = null;
		List<Integer> monthAmt = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			if (Integer.toString(i).length() == 1) {
				String month = "-0" + i + "-";

				lists = orderRepo.findByOrderPlacedDateByMonth(month);

				if (lists.size() == 0) {
					monthAmt.add(0);
				} else {
					int amt = 0;
					for (Orders ord : lists) {
						amt = amt + Integer.parseInt(ord.getOrderTotalAmt());
					}
					totalAmt = amt;
					monthAmt.add(totalAmt);
				}
			} else {
				String month = "-" + i + "-";

				lists = orderRepo.findByOrderPlacedDateByMonth(month);
				if (lists.size() == 0) {
					monthAmt.add(0);
				} else {
					int amt = 0;
					for (Orders ord : lists) {
						amt = amt + Integer.parseInt(ord.getOrderTotalAmt());
					}
					totalAmt = amt;
					monthAmt.add(totalAmt);
				}
			}
		}
		return monthAmt;

	}

	@Override
	public List<Integer> getOrdersByDateMonths(String month, String year) {
		List<Integer> dayWiseOrder = new ArrayList<Integer>();
		int m = Integer.parseInt(month);
		int y = Integer.parseInt(year);
		if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
			days = 31;
		} else if (m == 4 || m == 6 || m == 9 || m == 11) {
			days = 30;
		} else {
			if (m == 2) {
				if (y % 400 == 0 && y % 100 == 0) {
					days = 29;
				} else {
					if (y % 4 == 0 && y % 100 != 0) {
						days = 29;
					} else
						days = 28;
				}
			}
		}
		for(int i=1;i<=days;i++) {
			int amt = 0;
			String monlen = month.length() == 1 ? "0"+month : month;
			String datelen = Integer.toString(i).length() == 1 ? "0"+i : Integer.toString(i);
			String dates = datelen +"-"+monlen+"-"+year;
			 List<Orders> lstOfOrders = orderRepo.findByOrderPlacedDateContaining(dates);
			 for(Orders ord: lstOfOrders) {
				 amt = amt + Integer.parseInt(ord.getOrderTotalAmt()); 
			 }
			 dayWiseOrder.add(amt);
		}
		
		return dayWiseOrder;
	}

	@Override
	public String deleteByIds(String orderId) {
		orderRepo.deleteById(orderId);
		return "Order has been deleted Succesfully";
	}

}
