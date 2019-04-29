package com.todo.list.service;

import java.util.List;

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

	public void setToDoDAO(ToDoListDAO personDAO) {
		this.ToDoDAO = personDAO;
	}

	@Override
	@Transactional
	public void addToDo(ToDoList p) {
		new Validator().validateToDo(p);
		findDuplicate(p);
		this.ToDoDAO.addToDo(p);
	}

	@Override
	@Transactional
	public void updateToDo(ToDoList p) {	
		new Validator().validateToDo(p);
		this.ToDoDAO.updateToDo(p);
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
		this.ToDoDAO.removeToDo(id);
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

}
