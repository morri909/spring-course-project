package com.spydrone.mvc.data.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.spydrone.mvc.data.entities.Project;

public class ProjectService {

	private List<Project> projects = new LinkedList<>();

	public ProjectService() {
		Project javaProject = this.createProject("Java Project", "This is a Java Project");
		Project javascriptProject = this.createProject("Javascript Project", "This is a Javascript Project");
		Project htmlProject = this.createProject("HTML Project", "This is an HTML Project");

		this.projects.addAll(Arrays.asList(new Project[] { javaProject, javascriptProject, htmlProject }));
	}

	public List<Project> findAll() {
		return this.projects;
	}

	private Project createProject(String title, String description) {
		Project project = new Project();
		project.setName(title);
		project.setAuthorizedFunds(new BigDecimal("100000"));
		project.setAuthorizedHours(new BigDecimal("1000"));
		project.setDescription(description);
		return project;
	}
}
