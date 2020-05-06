package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@Controller
public class HomeController {
	@Autowired
	UserRepository repo;
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
		return "login";
	}
	@RequestMapping("/signupRedirect")
	public String signupRedirect() {
		return "signup";
	}
	
	@RequestMapping("/getSignUpData")
	public ModelAndView getSignUpData(User user) {
		ModelAndView mv=new ModelAndView();
		repo.save(user);
		mv.addObject("user",user);
		mv.setViewName("end");
		return mv;
	}
	
	
}
