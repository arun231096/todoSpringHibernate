package com.todo.list.util;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.todo.list.model.ToDoList;

public class Validator {

	private List<ErrorCodes> execption = new ArrayList<ErrorCodes>();

	public void validateToDo(ToDoList list) {
		Date cuurentDate = Date.from(Instant.now());
		if ( list.getTitle() == null || "".equals(list.getTitle().trim())) {
			execption.add(ErrorCodes.TITLE_FILED_EMPTY);
		}
		if (list.getMessage() == null || "".equals(list.getMessage().trim())) {
			execption.add(ErrorCodes.MESSAGE_ERROR);
		}
		if (list.getStatus() == null || "".equals(list.getStatus().trim())) {
			execption.add(ErrorCodes.STATUS_ERROR);
		}
		if (list.getStartdate() == null || cuurentDate.compareTo(new Date(list.getStartdate().getTime())) > 1) {
			execption.add(ErrorCodes.START_DATE_ERROR);
		}
		if (list.getDuedate() == null || cuurentDate.compareTo(new Date(list.getDuedate().getTime())) > 1) {
			execption.add(ErrorCodes.DUE_DATE_ERROR);
		} 
		if (!execption.isEmpty()) {
			throw new AppException(execption);
		}
	}
}
