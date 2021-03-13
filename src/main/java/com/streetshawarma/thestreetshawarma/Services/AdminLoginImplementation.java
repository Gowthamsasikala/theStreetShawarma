package com.streetshawarma.thestreetshawarma.Services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streetshawarma.thestreetshawarma.Entity.AdminLogin;
import com.streetshawarma.thestreetshawarma.Repo.LoginRepo;
import com.streetshawarma.thestreetshawarma.ResponseMessage.ResponseMessage;

@Service
public class AdminLoginImplementation implements AdminLoginInterface{

	@Autowired
	LoginRepo loginRepo;
	
	@Override
	public ResponseMessage loginAuthenticate(Map<String, String> credentials) {
		ResponseMessage response =new ResponseMessage();
		AdminLogin user = loginRepo.findByUserName(credentials.get("userName"));
		
		if(user !=null & (user.getPassword().equals(credentials.get("password")))) {
			
				response.setStatus("Sucess");
				response.setMessage("Logged in Successfully...!");
			
		}else {
			response.setStatus("Falied");
			response.setMessage("Please check the username and password..!");
		}
		
		return response;
	}

}
