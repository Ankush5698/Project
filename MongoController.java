package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;


@RestController
@RequestMapping(value = "/api")
public class MongoController {

	UserRepository userRepository;
	UserService userService;
	//List<Object> list = new List<Object>();
	
    @Autowired
    public MongoController(UserService userService , UserRepository userRepository) {
        this.userService = userService;
    	this.userRepository = userRepository;
    }
    
    @GetMapping("/users")
    public List<User> findAll(){
 
    		
    	return userRepository.findAll();
    }
    
    @PostMapping("/users")
    public User addUser(@RequestBody User theUser){
        //theUser.setId(0);
    	
    	theUser.setPassword(userService.encrypt_Password(theUser.getPassword()));
        theUser.setForm(new ArrayList<Object>());
        theUser.setResponse(new ArrayList<Object>());
        userRepository.save(theUser);
        return theUser;
    }
    
    @GetMapping("/users/forms/{id}")
    public Object getForm(@PathVariable String id){
        //theUser.setId(0);
        Optional<User> theUser = userRepository.findById(id);
        User user = theUser.get();
        
        return user.getForm();
    }
    
    @GetMapping("/users/responses/{id}")
    public Object getResponse(@PathVariable String id){
        //theUser.setId(0);
        Optional<User> theUser = userRepository.findById(id);
        User user = theUser.get();
        
        return user.getResponse();
    }
    
    @PostMapping("/users/forms/{id}")
    public Object addForm(@RequestBody Object form , @PathVariable String id ){
        //theUser.setId(0);
    	Optional<User> theUser = userRepository.findById(id);
        User user = theUser.get();
        user.getForm().add(form);
        userRepository.save(user);
        return user.getForm();
    }
    
    @PostMapping("/users/responses/{id}")
    public Object addResponse(@RequestBody Object response , @PathVariable String id ){
        //theUser.setId(0);
    	Optional<User> theUser = userRepository.findById(id);
        User user = theUser.get();
        user.getResponse().add(response);
        userRepository.save(user);
        return user.getResponse();
    }
	
}
