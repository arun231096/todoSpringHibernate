package com.todo.list.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.todo.list.model.ToDoList;
import com.todo.list.service.ToDoListService;

/**
 * @author Arunkumar Angappan
 * @since Apr 29, 2019
 */
@Controller
public class ToDoListController {
	
	private ToDoListService toDoService;
	private ToDoList p;

	@Autowired(required=true) 
	@Qualifier(value="toDoModel")
	public void setToDoModel(ToDoList ps){
		this.p = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="toDoService")
	public void setToDoService(ToDoListService ps){
		this.toDoService = ps;
	}

	// Jsp loader for UI
	@RequestMapping(value="/todo/{var}", method =  RequestMethod.GET)
	public ModelAndView redirect(@PathVariable String var) {
		ModelAndView model = new ModelAndView(var);
		return model;
	}

	// returning the index of the todo Service
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	// returning the list of todo list into the table
	@RequestMapping(value="/readAll", method =  RequestMethod.GET)
	public String listToDo(Model model) {
		model.addAttribute("lists", this.toDoService.listToDo());
		return "list";
	}

	// returning the paginated list of todo
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public String listToDoPage(Model model, @RequestParam int start, @RequestParam int max) {
		model.addAttribute("lists", this.toDoService.listToDopaginated(start, max));
		return "list";
	}
	
	//For create TodoList
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addToDo(
			@RequestParam long id,
			@RequestParam String title,
			@RequestParam String message,
			@RequestParam int estimation,
			@RequestParam String status,
			@RequestParam Date startdate,
			@RequestParam Date duedate
			){

		p.setId(id);
		p.setTitle(title);
		p.setDuedate(duedate);
		p.setEstimation(estimation);
		p.setMessage(message);
		p.setStartdate(startdate);
		p.setStatus(status);
		this.toDoService.addToDo(p);
		return "redirect:/readAll";
	}

	//For update TodoList
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String addUpdate(
			@RequestParam long id,
			@RequestParam String title,
			@RequestParam String message,
			@RequestParam int estimation,
			@RequestParam String status,
			@RequestParam Date startdate,
			@RequestParam Date duedate
			){

		p.setId(id);
		p.setTitle(title);
		p.setDuedate(duedate);
		p.setEstimation(estimation);
		p.setMessage(message);
		p.setStartdate(startdate);
		p.setStatus(status);
		this.toDoService.updateToDo(p);
		return "redirect:/readAll";
	}
	
	// deleting the todo from database
	@RequestMapping("/delete")
    public String removePerson(@RequestParam int id){
		
        this.toDoService.removeToDo(id);
        return "redirect:/readAll";
    }
 
	// read the todo from database based on id
    @RequestMapping("/read")
    public String readToDO(@RequestParam int id, Model model){
        model.addAttribute("todolist", this.toDoService.getToDoById(id));
        return "edit";
    }

    // search the list of todo available in database based on title
    @RequestMapping("/search")
    public String search(@RequestParam String title, Model model) {
    	model.addAttribute("lists", this.toDoService.searchToDO(title));
    	return "list";
    }
}
