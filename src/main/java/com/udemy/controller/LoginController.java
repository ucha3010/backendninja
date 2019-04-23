package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String showLogin(Model model,
			@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout){
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return "login";
	}
	
	@GetMapping({"/loginsuccess", "/"})
	public String loginCheck (){
		return "redirect:/user/listusers";
	}

}
