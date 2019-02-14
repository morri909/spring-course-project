package com.spydrone.mvc.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spydrone.mvc.data.entities.Resource;

@Controller
@RequestMapping("/resource")
@SessionAttributes("resource")
public class ResourceController {

	@RequestMapping("/add")
	public String add(Model model) {
		return "resource_add";
	}

	@RequestMapping("/request")
	@ResponseBody
	public String request(@ModelAttribute("resource") Resource resource) {
		return "The request has been sent for approval";
	}

	@RequestMapping("/review")
	public String review(@ModelAttribute Resource resource) {
		return "resource_review";
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute Resource resource, SessionStatus status) {
		System.out.println(resource.toString());
		status.setComplete();
		return "redirect:/resource/add";
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
}
