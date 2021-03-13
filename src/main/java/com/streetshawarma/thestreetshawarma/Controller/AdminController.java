package com.streetshawarma.thestreetshawarma.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.streetshawarma.thestreetshawarma.ResponseMessage.ResponseMessage;
import com.streetshawarma.thestreetshawarma.Services.AdminLoginImplementation;

@RestController
@RequestMapping(value = "Admin")
public class AdminController {

	@Autowired
	AdminLoginImplementation adminServ;
	
	@PostMapping(path = "/Login")
	public ResponseEntity<ResponseMessage> authenticateUsernameAndPassword(@RequestBody Map<String, String> credentials){

		return new ResponseEntity<ResponseMessage>(adminServ.loginAuthenticate(credentials),HttpStatus.OK);
	}
	
	
}
