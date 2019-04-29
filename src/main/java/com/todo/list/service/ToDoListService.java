package com.todo.list.service;

import java.util.List;

import com.todo.list.model.ToDoList;

public interface ToDoListService {

	public void addToDo(ToDoList p);
	public void updateToDo(ToDoList p);
	public List<ToDoList> listToDo();
	public ToDoList getToDoById(int id);
	public void removeToDo(int id);
	public List<ToDoList> searchToDO(String title);
	public void findDuplicate(ToDoList p);
	public List<ToDoList> listToDopaginated(int start, int max);
}
