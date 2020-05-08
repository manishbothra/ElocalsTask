package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;

@Controller
public class HomeController {
	
	
	@Autowired
	UserService service;
	
	User user;
	
	@RequestMapping("")
	public String start() {
		return "home";
	}
	
	@RequestMapping("/start")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/loginRedirect")
	public String loginRedirect() {
		return "loginPage";
	}
	
	@RequestMapping("/signupRedirect")
	public String signupRedirect() {
		return "signupPage";
	}
	
	@RequestMapping("/signup")
	public ModelAndView getSignUpData(User user) {
		ModelAndView mv=new ModelAndView();
		service.save(user);
		mv.addObject("user",user);
		mv.setViewName("end");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView getLoginData(@RequestParam("email") String email,@RequestParam("password") String password) {
		
		ModelAndView mv=new ModelAndView();
		if(email.length()==0) {
			mv.setViewName("invalidEmail");
			return mv;
		}
		if(password.length()==0) {
			mv.setViewName("invalidPassword");
			return mv;
		}
		int x=service.checkUser(email, password);
		if(x==0) {
			mv.setViewName("loginSuccessful");
			user=service.getUser(email);
			mv.addObject("user",user);
			
		}
		else if(x==1)mv.setViewName("invalidPassword");
		else mv.setViewName("invalidEmail");
		return mv;
	}
	
	
}
