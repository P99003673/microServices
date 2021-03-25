
package com.ltts.RestAPI.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ltts.RestAPI.model.*;


@Repository
public class userDao {
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private SessionFactory sf;
	
	
	public boolean InsertUser(User m) {
		boolean b=false;
		Session s=null;
		try {
			s=sf.openSession();
			s.beginTransaction();
			
			s.save(m);
			s.getTransaction().commit();
			
		}
		catch(Exception e) {
			System.out.println("Exception "+e);
			b=true;
		}	
		return b;
	}
	
//	
//	public User getMemberByEmpId(String emp_id) {
//		User e = (User)sf.openSession().get(User.class, emp_id);
//		return e;
//	
//	}
//	
	public boolean updateUser(int id, String Name){
	      Session session = sf.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         User user = 
	         (User)session.get(User.class, id); 
	         user.setName(Name);
	         session.update(user); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return false;
	   }
	
	@SuppressWarnings("unchecked")
	public List<User> list() {
		Session session = this.sf.openSession();
		List<User> personList = session.createQuery("from User").list();
		session.close();
		return personList;
	}

	
	public User getMemberByEmpId(Integer emp_id) {
		User e = (User)sf.openSession().get(User.class, emp_id);
		return e;
	
	}
	
}









