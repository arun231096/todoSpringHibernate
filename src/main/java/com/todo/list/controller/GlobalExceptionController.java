package com.todo.list.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.todo.list.util.AppException;
import com.todo.list.util.ErrorCodes;

@ControllerAdvice
public class GlobalExceptionController {


	@ExceptionHandler(AppException.class)
	public ModelAndView handleException(AppException e) {

		ModelAndView model = new ModelAndView("error");
		String errors = "";
		String code = "";
		for (ErrorCodes er : e.getErrorCodes()) {
			code = code + " <br> " +er.getCode();
			errors = errors + " <br> " + er.getErrorMeggage();
		}
		model.addObject("errCode", code);
		model.addObject("errMsg", errors);
		return model;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("error");
		model.addObject("errMsg", "INTERNAL SERVER ERROR");
		return model;

	}
}
