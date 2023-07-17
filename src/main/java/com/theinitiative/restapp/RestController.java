package com.theinitiative.restapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.ui.Model;

@Controller
public class RestController {
    
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index() {
		  return "index";
	  }
}
