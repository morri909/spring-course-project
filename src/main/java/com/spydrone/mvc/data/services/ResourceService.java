package com.spydrone.mvc.data.services;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spydrone.mvc.data.entities.Resource;

@Service
public class ResourceService {

	private List<Resource> resources = new LinkedList<>();

	public ResourceService() {
		this.resources.add(this.createResource(Long.valueOf(1), "Coder", "Staff", BigDecimal.valueOf(100)));
		this.resources.add(this.createResource(Long.valueOf(2), "Analyst", "Staff", BigDecimal.valueOf(50)));
		this.resources.add(this.createResource(Long.valueOf(3), "Tester", "Staff", BigDecimal.valueOf(70)));
	}

	public List<Resource> findAll() {
		return this.resources;
	}

	public Resource find(Long id) {
		return this.resources.stream()
			.filter(r ->  {
				return id.equals(r.getResourceId());
			}).collect(Collectors.toList())
			.get(0);
	}

	public void save(Resource resource) {
		this.resources.add(resource);
	}

	private Resource createResource(Long id, String name, String type, BigDecimal cost) {
		Resource resource = new Resource();
		resource.setResourceId(id);
		resource.setName(name);
		resource.setType(type);
		resource.setCost(cost);
		return resource;
	}
}
