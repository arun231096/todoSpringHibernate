package com.todo.list.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.todo.list.util.AppException;
import com.todo.list.util.ErrorCodes;

@ControllerAdvice
public class GlobalExceptionController {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);
	@ExceptionHandler(AppException.class)
	public ModelAndView handleException(AppException e) {

		ModelAndView model = new ModelAndView("error");
		String errors = "";
		String code = "";
		for (ErrorCodes er : e.getErrorCodes()) {
			code = code + " <br> " +er.getCode();
			errors = errors + " <br> " + er.getErrorMeggage();
			logger.error("ErrorCode: " + er.getCode() +" ErrorMessage: " + er.getErrorMeggage() + " Cause: " + e.getCause().getMessage());
		}
		model.addObject("errCode", code);
		model.addObject("errMsg", errors);
		return model;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("error");
		logger.error(" Cause" + ex.getMessage());
		model.addObject("errMsg", "INTERNAL SERVER ERROR");
		return model;

	}
}
