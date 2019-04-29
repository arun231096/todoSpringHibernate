package com.todo.list.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author arunkumar
 *
 */
@Entity
@Table(name="todolist")
@JsonAutoDetect
@Data
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
	private Date startdate;
	@Column(name="duedate")
	private Date duedate;
	@Column(name="message")
	private String message;
	@Column(name="status")
	private String status;
}
