package com.spydrone.mvc.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spydrone.mvc.data.entities.Resource;

@Controller
@RequestMapping("/resource")
public class ResourceController {

	@RequestMapping("/add")
	public String add(Model model) {
		return "resource_add";
	}

	@ModelAttribute("resource")
	public Resource getResource() {
		return new Resource();
	}

	@ModelAttribute("options")
	public List<String> getOptions() {
		return new LinkedList<>(Arrays.asList(new String[] {
				"Materail", "Other", "Staff", "Technical Equipment"
			}));
	}

	@ModelAttribute("radios")
	public List<String> getRadios() {
		return new LinkedList<>(Arrays.asList(new String[] {
				"Hours", "Piece", "Tons"
			}));
	}

	@ModelAttribute("checks")
	public List<String> getChecks() {
		return new LinkedList<>(Arrays.asList(new String[] {
				"Lead Time", "Special Rate", "Requires Approval"
			}));
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute Resource resource) {
		System.out.println(resource.toString());
		return "resource_add";
	}
}
