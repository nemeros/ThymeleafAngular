package com.nemeros.navigation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NavigationController {
	
	@RequestMapping({"/greeting", "/"})
	public String greeting(@RequestParam(name="name", required=false) String name, Model model){
		return "greeting";
	}
	
	@RequestMapping("/login")
	public String login(){
		return"login";
	}
	
	@RequestMapping({"/greetingBis"})
	public String greetingBis(){
		return "greetingBis";
	}
}
