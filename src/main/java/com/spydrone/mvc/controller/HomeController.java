package com.spydrone.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spydrone.mvc.data.entities.Project;
import com.spydrone.mvc.data.entities.Sponsor;
import com.spydrone.mvc.data.services.ProjectService;

@Controller
public class HomeController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping("/")
	public String goHome(Model model) {
		Project project = new Project();
		project.setName("First Project");
		project.setSponsor(new Sponsor("NASA", null, null));
		project.setDescription("This is a simple project sponsored by NASA");

		model.addAttribute("currentProject", project);

		return "welcome";
	}

	@RequestMapping(value="/", params="projectId")
	public String goHomeAgain(Model model, @RequestParam("projectId") Long projectId) {
		model.addAttribute("currentProject", this.projectService.find(projectId));
		return "home";
	}
}
