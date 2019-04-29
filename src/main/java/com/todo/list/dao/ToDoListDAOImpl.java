package com.todo.list.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.todo.list.model.ToDoList;

/**
 * @author Arunkumar Angappan
 * @since Apr 29, 2019
 */
@Repository
public class ToDoListDAOImpl implements ToDoListDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ToDoListDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addToDo(ToDoList p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("todolist saved successfully, todolist Details="+p);
	}

	@Override
	public void updateToDo(ToDoList p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("todolist updated successfully, todolist Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ToDoList> listToDo() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ToDoList> todolistsList = session.createCriteria(ToDoList.class).list();
		for(ToDoList p : todolistsList){
			logger.info("todolist List::"+p);
		}
		return todolistsList;
	}

	@Override
	public ToDoList getToDoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		ToDoList p = (ToDoList) session.load(ToDoList.class, new Long(id));
		logger.info("todolist loaded successfully, todolist details="+p);
		return p;
	}

	@Override
	public void removeToDo(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ToDoList p = (ToDoList) session.load(ToDoList.class, new Long(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("todolist deleted successfully, todolist details="+p);
	}

	@Cacheable("todolists")
	@SuppressWarnings("unchecked")
	@Override
	public List<ToDoList> searchToDO(String title) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createCriteria(ToDoList.class).add(Restrictions.like("title", title, MatchMode.START))
													 .list();
	}

	@Override
	public boolean findDuplicate(ToDoList p) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createCriteria(ToDoList.class).add(Restrictions.like("title", p.getTitle(), MatchMode.START))
											  		 .add(Restrictions.like("message", p.getMessage(), MatchMode.START))
											  		 .list().isEmpty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ToDoList> listToDopaginated(int start, int max) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createCriteria(ToDoList.class).setFirstResult(start).setMaxResults(max).list();
	}

}
