package com.mkyong.common.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@ControllerAdvice
public class ErrorController {

	@RequestMapping(value = "/error")
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	protected ModelAndView errorPage(Exception exception) throws Exception {
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("exception", exception);
		modelAndView.addObject("message", Arrays.toString(exception.getStackTrace()).replaceAll(", ", "\n"));
		return modelAndView;
	}
}
