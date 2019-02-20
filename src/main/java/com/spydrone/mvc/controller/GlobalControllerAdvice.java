package com.spydrone.mvc.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(annotations=Controller.class)
public class GlobalControllerAdvice {

	@ModelAttribute("currentDate")
	public Date getCurrentDate() {
		return new Date();
	}

	@ExceptionHandler(NullPointerException.class)
	public String handleError(HttpServletRequest request, Exception ex) {
		System.err.println(ex);
		return "controller_error";
	}
}
