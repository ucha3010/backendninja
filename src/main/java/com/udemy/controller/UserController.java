package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.model.UserModel;
import com.udemy.service.UserService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
@RequestMapping("/user")
public class UserController {
	
	private static final String USERS_LIST_VIEW = "userslist";
	private static final String USER_FORM_VIEW = "userForm";
	
	private static final Log LOG = LogFactory.getLog(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/listusers")
	public ModelAndView listAllUsers() {
		LOG.info("Controlador " + "listAllUsers");
		ModelAndView mav = new ModelAndView(USERS_LIST_VIEW);
		
		org.springframework.security.core.userdetails.User user;
		user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		mav.addObject("users", userService.listAllUsers());
		return mav;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/userform")
	public String userForm(@ModelAttribute(name = "userModel") UserModel userModel, Model model) {
		LOG.info("Controlador " + "userForm" + " -- Parámetro: " + userModel + " - ");
		model.addAttribute("userModel", new UserModel());
		
		return USER_FORM_VIEW;
	}
	
	@PostMapping("/adduser")
	public String addUser(@ModelAttribute(name = "userModel") UserModel userModel, Model model) {
		LOG.info("Controlador " + "addUser" + " -- Parámetro: " + userModel.toString());		
		if(null != userService.addUser(userModel)){
			model.addAttribute("result",1);
		} else {
			model.addAttribute("result",0);
		}
		
		
		return "redirect:/user/listusers";
	}
	

}
