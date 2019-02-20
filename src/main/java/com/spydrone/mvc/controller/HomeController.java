package com.spydrone.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spydrone.mvc.data.entities.Project;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public String goHomeAgain(Model model, @ModelAttribute("project") Project project) {
		model.addAttribute("currentProject", project);
		return "home";
	}
}
