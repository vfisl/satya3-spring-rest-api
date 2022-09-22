package com.productapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.AppUser;
import com.productapp.service.AppServiceImpl;

@RestController
public class AppUserController {

	@Autowired
	AppServiceImpl appServiceImpl;
	@Autowired
	private PasswordEncoder encoder;
	@PostMapping("/")
	public String addUser(@RequestBody AppUser appUser)
	{
		String password=appUser.getPassword();
		String newpassword =encoder.encode(password);
		appUser.setPassword(newpassword);
		appServiceImpl.addUser(appUser);
		return "added";
		
	}
}
