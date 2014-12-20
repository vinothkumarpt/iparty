package com.iparty.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView welcome(){
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}

}
