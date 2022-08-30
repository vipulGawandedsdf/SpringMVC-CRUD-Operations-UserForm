package com.app.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.daointerface.IDao;
import com.app.model.User;

@Repository
public class HomeDao implements IDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int saveUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int id = (int) session.save(user);
		tx.commit();
		session.close();
		return id;
	}

	@Override
	public int loginCheck(String uname, String password) {

		int id = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("From User u where u.uname='" + uname + "' and u.password='" + password + "'");

		List<User> list = query.list();
		if (list != null && !list.isEmpty()) {
			id = 1;
		}
		tx.commit();
		session.close();
		return id;
	}

	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("From User u");

		List<User> list = query.list();

		return list;
	}

	@Override
	public List<User> deleteUser(int uid) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("delete from User u where u.uid ='" + uid + "'");
		int id = query.executeUpdate();

		Query query1 = session.createQuery("From User u");

		List<User> list = query1.list();

		tx.commit();
		session.close();
		return list;
	}

	@Override
	public User editUser(int uid) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("from User u where u.uid ='" + uid + "'");
		List<User> list = query.list();

		User user = new User();

		if (list != null && !list.isEmpty()) {
			for (User u1 : list) {
				user = u1;
			}
		}
		return user;
	}

	@Override
	public List<User> updateUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("Update User u set u.name ='"+user.getName()+"', u.uname='"+user.getUname()+"', u.password ='"+user.getPassword()+"'  where u.uid ='" + user.getUid() + "'");
		
		int id = query.executeUpdate();
	
		Query query1 = session.createQuery("From User u");

		List<User> list2 = query1.list();

		tx.commit();
		session.close();
		return list2;
	}

}
