package com.streetshawarma.thestreetshawarma.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.streetshawarma.thestreetshawarma.Entity.Orders;
import com.streetshawarma.thestreetshawarma.Entity.ResponseMsg;
import com.streetshawarma.thestreetshawarma.Services.OrderServiceImplementation;

@RestController
@RequestMapping("/Order")
@CrossOrigin("*")
public class OrderController {

	@Autowired
	OrderServiceImplementation ordImpl;
	
	@GetMapping("/check")
	public ResponseEntity<?> checking(){	
		return new ResponseEntity<String>("Its working maan..!",HttpStatus.OK);
	}
	
	@PostMapping("/placeOrder")
	public ResponseEntity<?> placeOrder(@RequestBody Orders order){
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String dates = format.format(new Date());
		System.out.println(dates);
		order.setOrderPlacedDate(dates);
		 Orders orders = ordImpl.placeOrder(order);
		return new ResponseEntity<Orders>(orders,HttpStatus.OK);
	}
	
	
	@GetMapping("/getOrderByDate/{date}")
	public ResponseEntity<?> getListOfOrdersByDate(@PathVariable("date") String date ){
		List<Orders> listOfOrders = ordImpl.getOrdersByDate(date);		
		return new ResponseEntity<List<Orders>>(listOfOrders,HttpStatus.OK);
	}
	
	@GetMapping("/getOrderByMonth/{month}")
	public ResponseEntity<?> getListOfOrdersByMonth(@PathVariable("month") String months ){
		List<Orders> listOfOrders = ordImpl.getOrdersByMonth(months);		
		return new ResponseEntity<List<Orders>>(listOfOrders,HttpStatus.OK);
	}
	
	@GetMapping("/getAllOrdersByMonth")
	public ResponseEntity<?> getListOfAllOrdersByMonth(){
		List<Integer> listOfOrders = ordImpl.getAllOrdersByMonth();		
		return new ResponseEntity<List<Integer>>(listOfOrders,HttpStatus.OK);
	}
	
	@GetMapping("/getAllOrdersByMonthAndDates/{month}/{year}")
	public ResponseEntity<?> getListOfAllOrdersByMonthAndDates(@PathVariable("month") String months,@PathVariable("year") String year){
		List<Integer> listOfOrders = ordImpl.getOrdersByDateMonths(months,year);		
		return new ResponseEntity<List<Integer>>(listOfOrders,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteByOrderId/{orderId}")
	public ResponseEntity<?> deleteByOrderId(@PathVariable("orderId") String orderId){
		String ord ;
		ResponseMsg respon = new ResponseMsg();
		if(orderId != null) {
			 ord = ordImpl.deleteByIds(orderId);
			 respon.setStatus("Success");
			 respon.setResponseMsg(ord);
		}else {
			ord = "Order Id is null";
			 respon.setStatus("Failed");
			 respon.setResponseMsg(ord);
		}
		return new ResponseEntity<ResponseMsg>(respon,HttpStatus.OK);
	}
	
	
}
