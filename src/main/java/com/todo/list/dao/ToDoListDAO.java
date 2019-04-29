package com.todo.list.dao;

import java.util.List;

import com.todo.list.model.ToDoList;

public interface ToDoListDAO {

	public void addToDo(ToDoList p);
	public void updateToDo(ToDoList p);
	public List<ToDoList> listToDo();
	public List<ToDoList> listToDopaginated(int start, int max);
	public ToDoList getToDoById(int id);
	public void removeToDo(int id);
	public List<ToDoList> searchToDO(String title);
	public boolean findDuplicate(ToDoList p);
}
