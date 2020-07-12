/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharemy10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP PC
 */
@Controller
public class MainController {
    
    @RequestMapping("/privacidad")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		
		
		mav.setViewName("privacidad");
		
		return mav;
	}
    
}
