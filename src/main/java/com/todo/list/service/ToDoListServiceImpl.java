package com.todo.list.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.list.dao.ToDoListDAO;
import com.todo.list.model.ToDoList;
import com.todo.list.util.AppException;
import com.todo.list.util.ErrorCodes;
import com.todo.list.util.Validator;

/**
 * @author Arunkumar Angappan
 * @since Apr 29, 2019
 */
@Service
public class ToDoListServiceImpl implements ToDoListService {
	
	private ToDoListDAO ToDoDAO;
	private MailService mailService;

	public void setToDoDAO(ToDoListDAO personDAO) {
		this.ToDoDAO = personDAO;
	}

	@Autowired(required=true)
	@Qualifier(value="mailService")
	public void setMailService (MailService mailService) {
		this.mailService = mailService;
	}
	
	@Override
	@Transactional
	public void addToDo(ToDoList p) {
		new Validator().validateToDo(p);
		findDuplicate(p);
		this.ToDoDAO.addToDo(p);
		String message = messageBuilder(p, "created");
		mailService.sendMail("arunak283933@gmail.com", "arunak283938@gmail.com", p.getTitle(), message);
	}

	@Override
	@Transactional
	public void updateToDo(ToDoList p) {	
		new Validator().validateToDo(p);
		this.ToDoDAO.updateToDo(p);
		String message = messageBuilder(p, "Updated");
		mailService.sendMail("arunak283933@gmail.com", "arunak283938@gmail.com", p.getTitle(), message);
	}

	@Override
	@Transactional
	public List<ToDoList> listToDo() {
		return this.ToDoDAO.listToDo();
	}

	@Override
	@Transactional
	public ToDoList getToDoById(int id) {
		return this.ToDoDAO.getToDoById(id);
	}

	@Override
	@Transactional
	public void removeToDo(int id) {
		ToDoList p = this.ToDoDAO.getToDoById(id);
		this.ToDoDAO.removeToDo(id);
		String message = messageBuilder(p, "Deleted");
		mailService.sendMail("arunak283933@gmail.com", "arunak283938@gmail.com", p.getTitle(), message);
	}

	@Override
	@Transactional
	public List<ToDoList> searchToDO(String title) {
		return this.ToDoDAO.searchToDO(title);
	}

	@Override
	@Transactional
	public void findDuplicate(ToDoList p) {
		if (!this.ToDoDAO.findDuplicate(p)) {
			throw new AppException(ErrorCodes.DUPLICATE_ENTRY);
		}
		
	}

	@Override
	@Transactional
	public List<ToDoList> listToDopaginated(int start, int max) {
		return this.ToDoDAO.listToDopaginated(start, max);
	}

	public String messageBuilder(ToDoList p, String update) {
		return new StringBuilder()
				   .append(update)
				   .append("\nTitle: - "+p.getTitle())
				   .append("\nStart Date: - "+p.getStartdate())
				   .append("\nDue Date:- "+p.getDuedate())
				   .append("\nEstimation: - "+p.getEstimation())
				   .append("\nStatus: - "+p.getStatus())
				   .append("\nMessage:- "+p.getMessage()).toString();
	}
}
