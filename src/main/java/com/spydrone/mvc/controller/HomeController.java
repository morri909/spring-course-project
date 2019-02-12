package com.spydrone.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spydrone.mvc.data.entities.Project;
import com.spydrone.mvc.data.entities.Sponsor;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String goHome(Model model) {
		Project project = new Project();
		project.setName("First Project");
		project.setSponsor(new Sponsor("NASA", null, null));
		project.setDescription("This is a simple project sponsored by NASA");

		model.addAttribute("currentProject", project);

		return "home";
	}
}
