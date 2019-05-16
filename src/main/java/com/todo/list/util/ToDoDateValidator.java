package com.todo.list.util;

import java.lang.reflect.Method;
import java.time.LocalDate;

import com.todo.list.annotate.DateValidator;
import com.todo.list.model.ToDoList;

public class ToDoDateValidator{

	public boolean dateValidation(ToDoList type) {
		
		System.out.println(type.toString());
        Method[] methods = type.getClass().getDeclaredMethods();
        for(Method method : methods) {
        	if(method.isAnnotationPresent(DateValidator.class)) {
        		try {
					LocalDate currentdate = LocalDate.now();
					LocalDate inputdate = LocalDate.parse((CharSequence) method.invoke(type));
					if (currentdate.getDayOfMonth() <= inputdate.getDayOfMonth() && 
						currentdate.getYear() == inputdate.getYear() && 
						currentdate.getMonthValue() <= inputdate.getMonthValue()) {
						return true;
					} else {
						throw new AppException(ErrorCodes.DATE_ERROR);
					}
				} catch (Exception e) {
					throw new AppException(ErrorCodes.DATE_ERROR, e);
				}
        	}
        }
		return true;
	}
}
