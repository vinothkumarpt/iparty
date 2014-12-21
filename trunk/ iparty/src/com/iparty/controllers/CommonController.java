package com.iparty.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {
	
	// Define a static logger variable so that it references the
    // Logger instance named "MyApp".
	private final static Logger logger = Logger.getLogger(CommonController.class);
    
    @RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView welcome(){
    	logger.debug("Start welcome");
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		logger.debug("End welcome");
		return model;
	}

}
