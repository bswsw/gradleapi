package com.ggmsoft.gradleapi.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ggmsoft.gradleapi.model.UserModel;
import com.ggmsoft.gradleapi.service.UserService;

@RestController
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService service;

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public HashMap<String, Object> create(@ModelAttribute @Valid UserModel model, BindingResult result) {
		HashMap<String, Object> returnMap = new HashMap<>();
		
		logger.info("create user : " + model.getName());
		
		if (result.hasErrors()) {
			returnMap.put("status", "Failure");
			returnMap.put("errorCount", result.getErrorCount());
			return returnMap;
		}

		try {
			service.create(model);
			
			returnMap.put("status", "Success");
			returnMap.put("name", model.getName());
			
		} catch (Exception e) {
			e.printStackTrace();
			
			returnMap.put("status", "Failure");
			returnMap.put("error", e.getMessage());
		}
		
		return returnMap;
	}
	
	@RequestMapping(value = "get/{seq}", method = RequestMethod.GET)
	public HashMap<String, Object> get(@PathVariable int seq) {
		HashMap<String, Object> returnMap = new HashMap<>();
		
		logger.info("get user info : " + seq);
		
		UserModel model = service.findBySeq(seq);
		
		returnMap.put("status", "Success");
		returnMap.put("item", model);
		
		return returnMap;
	}
	
	@RequestMapping(value = "get_all", method = RequestMethod.GET)
	public HashMap<String, Object> getAll() {
		HashMap<String, Object> returnMap = new HashMap<>();
		
		logger.info("get all user info");
		
		List<UserModel> modelList = service.findAll();
		
		returnMap.put("status", "Success");
		returnMap.put("item", modelList);
		
		return returnMap;
	}
	
	@RequestMapping(value = "update/{seq}", method = RequestMethod.GET)
	public HashMap<String, Object> update(@PathVariable int seq, @RequestParam String id, 
			@RequestParam String name, @RequestParam String addressDefault, @RequestParam String addressDetail) {
		HashMap<String, Object> returnMap = new HashMap<>();
		
		logger.info("update user info : " + seq);
		
		UserModel model = new UserModel(seq, id, name, addressDefault, addressDetail);
		
		try {
			model = service.update(model);
			
			returnMap.put("status", "Success");
			returnMap.put("seq", seq);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			returnMap.put("status", "Failure");
			returnMap.put("error", e.getMessage());
		}
		
		return returnMap;
	}
	
	@RequestMapping(value = "delete/{seq}")
	public HashMap<String, Object> delete(@PathVariable int seq) {
		HashMap<String, Object> returnMap = new HashMap<>();
		
		logger.info("delete user : " + seq);
		
		try {
			service.delete(seq);
			
			returnMap.put("status", "Success");
			returnMap.put("seq", seq);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			returnMap.put("status", "Failure");
			returnMap.put("error", e.getMessage());
		}
		
		return returnMap;
	}
}
