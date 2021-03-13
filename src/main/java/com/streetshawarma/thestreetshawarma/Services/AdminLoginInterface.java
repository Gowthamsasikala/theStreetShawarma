package com.streetshawarma.thestreetshawarma.Services;

import java.util.Map;

import com.streetshawarma.thestreetshawarma.ResponseMessage.ResponseMessage;

public interface AdminLoginInterface {

	public ResponseMessage loginAuthenticate(Map<String, String> credentials);
	
}
