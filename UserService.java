package com.example.demo.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	public BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public String encrypt_Password(String unencryptedString) {
	    	
	    	String encryptedString = null;
	        try {
	            
	        	encryptedString = passwordEncoder.encode(unencryptedString);
	        	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return encryptedString;
	    }
}
