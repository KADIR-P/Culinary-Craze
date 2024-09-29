package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.serviceClass;

@Controller
public class bachelors {

	@Autowired
	serviceClass service;
	
	@GetMapping("/save")
	public ModelAndView save(@RequestParam("name")String name,@RequestParam("email")String email,@RequestParam("password")String password) {
		
		service.usersave(name, email, password);
		
		ModelAndView objmv=new ModelAndView();
		objmv.setViewName("regsuccessfull");
		return objmv;
	}
	
	  @PostMapping("/login")
	    public ModelAndView login(@RequestParam("email") String email, 
	                              @RequestParam("password") String password) { 
	        ModelAndView modelAndView = new ModelAndView();
	        
	        if (service.validateUser(email, password)) {
	            modelAndView.setViewName("Recipehome"); // Redirect to main page if login is successful
	        } else {
	            modelAndView.setViewName("errorlogin"); // Redirect back to login page if authentication fails
	            modelAndView.addObject("error", "Invalid username or password");
	        }
	        
	        return modelAndView;
	    } 
	
	
	
	
	@GetMapping("/login1")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/")
	public String signup() {
		return "signup";
	}
	
	@GetMapping("/regsuccess")
	public String reg() {
		return "regsuccessfull";
	}
	
	@GetMapping("/home")
	public String homepage()
	{
		return "Recipehome";
	}
	
	@GetMapping("/recipe")
	public String recipe() {
		return "recipe";
	}
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/upma")
	public String upma() {
		return "upma";
	}
	
	@GetMapping("/aloo")
	public String aloo() {
		return "aloo gobi";
	}
	
	@GetMapping("/channa")
	public String channa() {
		return "chenna masala";
	}
	
	@GetMapping("/sambar")
	public String sambar() {
		return "sambar";
	}
	@GetMapping("/chicken")
	public String chicken() {
		return "chicken";
	}
	@GetMapping("/samosa")
	public String samosa() {
		return "samosa";
	}
	
	@GetMapping("/error")
	public String error1()
	{
		return "errorlogin";
	}
}