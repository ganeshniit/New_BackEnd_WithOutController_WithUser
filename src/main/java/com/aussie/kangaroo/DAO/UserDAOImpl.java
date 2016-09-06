package com.aussie.kangaroo.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.aussie.kangaroo.model.User;

@EnableTransactionManagement
@Repository(value="UserDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionfactory;
		public UserDAOImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}
		@Transactional
	public boolean save(User user) {
		sessionfactory.getCurrentSession().save(user);
		return false;
	}

	@Transactional
	public boolean delete(User user) {
		sessionfactory.getCurrentSession().delete(user);
		return false;
	}
   @Transactional
	public boolean update(User user) {
		sessionfactory.getCurrentSession().update(user);
		return false;
	}
   
	public User get(String name) {

		
		String hql="from UserDetails where name="+"'"+name+"'";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		List<User> list=query.list();
		if(list==null){
			return null;
		}
		else{
			return list.get(0);
			
		}
	}
   @Transactional
	public List<User> list() {
		String hql="from User";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		return query.list();
		
	}
   @Transactional
	public User isValidUser(String email, String password) {
		String hql="from User where id='" +email+"' and password='" + password +"'";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		List<User> list=query.list();
		
		if(list==null){
			return null;
		}
		else{
			return list.get(0);
			
		}

	}
	

}
