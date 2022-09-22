package com.example.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	@GetMapping("/greet")
	public String greet()
	{
		return "Have a great day";
	}
	@GetMapping("/sayHello/{username}")
	public String greet(@PathVariable("username") String name)
	{
		return "Welcome to VfiSlk " +name;
	}
	//https://localhost:8080/show?name=priya&salary=1000
	@GetMapping("/show")
	public String show(@RequestParam("name") String name ,@RequestParam("salary") int salary)
	{
	
		return "Hello "+name+"  Your salary is "+salary;
				
				
	}
	@GetMapping("/showFruits")
	public List<String> show()
	{
		return Arrays.asList("Kiwi","Watermelon","Mango");
	}

}
