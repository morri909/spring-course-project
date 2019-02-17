package com.spydrone.mvc.data.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.spydrone.mvc.data.entities.Project;

public class ProjectService {

	private List<Project> projects = new LinkedList<>();

	public ProjectService() {
		Project javaProject = this.createProject("Java Project", "This is a Java Project", Long.valueOf(1));
		Project javascriptProject = this.createProject("Javascript Project", "This is a Javascript Project", Long.valueOf(2));
		Project htmlProject = this.createProject("HTML Project", "This is an HTML Project", Long.valueOf(3));

		this.projects.addAll(Arrays.asList(new Project[] { javaProject, javascriptProject, htmlProject }));
	}

	public List<Project> findAll() {
		return this.projects;
	}

	public Project find(Long projectId) {
		return this.projects.stream().filter(p -> {
			return p.getProjectId().equals(projectId);
		}).collect(Collectors.toList()).get(0);
	}

	public void save(Project project) {
		this.projects.add(project);
	}

	private Project createProject(String title, String description, Long id) {
		Project project = new Project();
		project.setProjectId(id);
		project.setName(title);
		project.setAuthorizedFunds(new BigDecimal("100000"));
		project.setAuthorizedHours(new BigDecimal("1000"));
		project.setDescription(description);
		return project;
	}
}
