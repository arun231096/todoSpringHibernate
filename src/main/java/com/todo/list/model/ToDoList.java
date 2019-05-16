package com.todo.list.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.todo.list.annotate.DateValidator;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author arunkumar
 *
 */
@Entity
@Table(name="todolist")
@JsonAutoDetect
public class ToDoList {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="title")
	private String title;
	@Column(name="estimation")
	private int estimation;	
	@Column(name="startdate")
	private String startdate;
	@Column(name="duedate")
	private String duedate;
	@Column(name="message")
	private String message;
	@Column(name="status")
	private String status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getEstimation() {
		return estimation;
	}
	public void setEstimation(int estimation) {
		this.estimation = estimation;
	}
	@DateValidator
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	@DateValidator
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ToDoList [id=" + id + ", title=" + title + ", estimation=" + estimation + ", startdate=" + startdate
				+ ", duedate=" + duedate + ", message=" + message + ", status=" + status + "]";
	}
	
}
