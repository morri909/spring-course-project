package com.spydrone.mvc.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.spydrone.mvc.data.entities.Resource;
import com.spydrone.mvc.data.services.ResourceService;

public class ResourceConverter implements Converter<String, Resource> {

	@Autowired
	private ResourceService service;

	@Override
	public Resource convert(String resourceIdStr) {
		return service.find(Long.valueOf(resourceIdStr));
	}

}
